package com.caishi.capricorn.common.spring.environment;

import com.caishi.capricorn.common.utils.PropertiesUtil;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * 可以按照不同的运行模式启用相应的配置
 */
public class BeanPropertyholderConfigurer extends PropertyPlaceholderConfigurer implements FactoryBean<Properties>, InitializingBean {

    public static final String ONLINE = "ONLINE";
    public static final String TEST = "TEST";
    public static final String DEV = "DEV";
    public static final String STAGE = "STAGE";

    public static final Set<String> support_modes = Sets.newHashSet(ONLINE, TEST, DEV, STAGE);
    public static final String SEPARATOR = "_";
    public static final String PRODUCTION_MODE = "production.mode";
    private static final Logger logger = LoggerFactory.getLogger(BeanPropertyholderConfigurer.class);
    /**
     * working directory config : production mode
     */
    private static final String WORK_DIR_CONFIG = System.getProperty("user.dir") + "/config/production.properties";
    /**
     * classpath directory config : production mode
     */
    private static final String CLASSPATH_DIR_CONFIG = "config/production.properties";

    private boolean singleton = true;

    //设置运行程序的模式，默认是开发模式，当进入测试或者发布上线就修改为其他模式
    private String mode = DEV;
    //缓存所有的属性配置
    private Properties properties;
    //配置文件存放路径
    private String pathPattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
            + "/config/%s/*.properties";

    // 是否打开本地config配置, 会对引入的jar包中的配置做覆盖
    public static final String ENABLE_LOCAL_CONFIG = "local.config.enabled";

    /**
     * @return the path
     */
    public String getPathPattern() {
        return pathPattern;
    }

    /**
     * @param pathPattern the path to set
     */
    public void setPathPattern(String pathPattern) {
        this.pathPattern = pathPattern;
    }

    /**
     * @return the mode
     */
    public String getMode() {
        return mode;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws Exception {
        if (this.singleton) {
            this.properties = createProperties();
        }
    }

    private Properties createProperties() {
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        try {

            mode = detectMode();

            pathPattern = generatePath(pathPattern, mode);
            Resource[] userResources = resourcePatternResolver.getResources(pathPattern);

            List<Resource> resourceList = new ArrayList<Resource>();
            if (userResources != null) {
                resourceList.addAll(Arrays.asList(userResources));
            }

            super.setLocations(resourceList.toArray(new Resource[]{}));

            Properties result = this.mergeProperties();

            // loaded local configs
            String localConfigEnabled = System.getProperty(ENABLE_LOCAL_CONFIG);
            if ("true".equalsIgnoreCase(localConfigEnabled)) {
                logger.debug("local configuration enabled, try merge local properties");
                result = mergeLocalProperties(result);
            }

            if (logger.isDebugEnabled()) {
                logger.debug("finished property configuration file initialization for production mode " + mode);
            }
            return result;
        } catch (IOException e) {
            logger.error("load resource error ", e);
            throw new RuntimeException(e);
        }
    }

    private Properties mergeLocalProperties(Properties result) throws IOException {
        // could suppress hardcoded properties defined in classpath (jars) by working directory config files
        try {
            File configFolder = new File(System.getProperty("user.dir") + "/config");
            if (configFolder.exists() && configFolder.listFiles().length > 0) {
                for (String configFile : configFolder.list()) {
                    // TODO: make it alphabetical sorted
                    logger.debug("process local config file '" + configFile + "'");

                    Properties customizedProperties = new Properties();
                    customizedProperties.load(new FileInputStream(configFolder.getAbsolutePath() + "/" + configFile));
                    result = PropertiesUtil.mergeProperties(result, customizedProperties);
                }
            }
        } catch (Exception exp) {
            logger.warn("exception to load and process local properties under config dir, would using defaults", exp);
        }

        return result;
    }

    private String detectMode() throws IOException {
        //系统属性优先
        String mode = System.getProperty(PRODUCTION_MODE);

        if (StringUtils.isNotBlank(mode) && support_modes.contains(mode)) {
            logger.debug("loading production config for {} env", mode);
            return mode;
        }

        //work directory config
        Properties workConfigProperties = PropertiesLoaderUtils.loadAllProperties(WORK_DIR_CONFIG);
        mode = workConfigProperties.getProperty(PRODUCTION_MODE);
        if (StringUtils.isNotBlank(mode) && support_modes.contains(mode)) {
            return mode;
        }

        // class path config
        Properties classpathProperties = PropertiesLoaderUtils.loadAllProperties(CLASSPATH_DIR_CONFIG);
        mode = classpathProperties.getProperty(PRODUCTION_MODE);
        if (StringUtils.isNotBlank(mode) && support_modes.contains(mode)) {
            return mode;
        }

        if (!support_modes.contains(mode)) {
            mode = DEV;
        }
        return mode;
    }


    private String generatePath(String pathPattern, String mode) {
        return String.format(pathPattern, StringUtils.lowerCase(mode));
    }

    public String getProperty(String key) {
        return resolvePlaceholder(key, properties);
    }

    @Override
    public Properties getObject() throws Exception {
        if (this.singleton) {
            return this.properties;
        } else {
            return createProperties();
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            Properties ex = this.mergeProperties();

            String localConfigEnabled = System.getProperty(ENABLE_LOCAL_CONFIG);
            if ("true".equalsIgnoreCase(localConfigEnabled)) {
                logger.debug("local configuration enabled, try merge local properties");
                ex = mergeLocalProperties(ex);
            }

            this.convertProperties(ex);
            this.processProperties(beanFactory, ex);
        } catch (IOException var3) {
            throw new BeanInitializationException("Could not load properties", var3);
        } catch (Exception exp) {
            new BeanInitializationException("Could not load properties", exp);
        }
    }

    @Override
    public Class<?> getObjectType() {
        return Properties.class;
    }

    @Override
    public boolean isSingleton() {
        return this.singleton;
    }
}
