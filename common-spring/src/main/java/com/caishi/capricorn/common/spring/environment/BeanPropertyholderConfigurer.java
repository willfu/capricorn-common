package com.caishi.capricorn.common.spring.environment;

import com.caishi.capricorn.common.utils.PropertiesUtil;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
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

            // loaded files
            ArrayList<String> loadedConfigs = new ArrayList<>();
            for (Resource resource : resourceList) {
                String resourceURLPath = resource.getURL().getFile();
                loadedConfigs.add(resourceURLPath.substring(resourceURLPath.lastIndexOf("/") + 1));
            }

            // suppress hardcoded properties defined in classpath (jars) by working directory config files
            try {
                File configFolder = new File(System.getProperty("user.dir") + "/config");
                if (loadedConfigs.size() > 0 && configFolder.exists() && configFolder.listFiles().length > 0) {
                    for (String configFile : configFolder.list()) {
                        if (loadedConfigs.contains(configFile)) {
                            logger.debug("process customized config file '" + configFile + "'");

                            Properties customizedProperties = new Properties();
                            customizedProperties.load(new FileInputStream(configFolder.getAbsolutePath() + "/" + configFile));
                            result = PropertiesUtil.mergeProperties(result, customizedProperties);
                        }
                    }
                }
            } catch (Exception exp) {
                logger.warn("exception to load and process customized properties under config dir, would using defaults", exp);
            }


            if (logger.isDebugEnabled()) {
                logger.debug("production model is " + mode);
            }
            return result;
        } catch (IOException e) {
            logger.error("load resource error ", e);
            throw new RuntimeException(e);
        }
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
    public Class<?> getObjectType() {
        return Properties.class;
    }

    @Override
    public boolean isSingleton() {
        return this.singleton;
    }
}
