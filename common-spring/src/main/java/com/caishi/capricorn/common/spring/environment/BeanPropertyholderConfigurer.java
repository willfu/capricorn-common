package com.caishi.capricorn.common.spring.environment;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.*;

/**
 * 可以按照不同的运行模式启用相应的配置
 */
public class BeanPropertyholderConfigurer extends PropertyPlaceholderConfigurer implements InitializingBean {

	public static final String ONLINE = "ONLINE";
	public static final String TEST = "TEST";
	public static final String DEV = "DEV";

	public static final Set<String> support_modes = Sets.newHashSet(ONLINE, TEST, DEV);

	public static final String SEPARATOR = "_";

	private static final String PRODUCTION_MODE = "production.mode";
	private static final Logger logger = LoggerFactory.getLogger(BeanPropertyholderConfigurer.class);
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
		PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		try {
			//系统属性优先
			mode = System.getProperty(PRODUCTION_MODE);
			if (StringUtils.isBlank(mode)) {
				mode = DEV;
			}

			if (!support_modes.contains(mode)) {
				mode = DEV;
			}

			pathPattern = generatePath(pathPattern, mode);
			Resource[] userResources = resourcePatternResolver.getResources(pathPattern);

			List<Resource> resourceList = new ArrayList<Resource>();
			if (userResources != null) {
				resourceList.addAll(Arrays.asList(userResources));
			}

			super.setLocations(resourceList.toArray(new Resource[]{}));

			Properties result = this.mergeProperties();
			this.properties = result;
			if (logger.isDebugEnabled()) {
				logger.debug("production model is " + mode);
			}
		} catch (IOException e) {
			logger.error("load resource error ", e);
			throw new RuntimeException(e);
		}
	}

	private String generatePath(String pathPattern, String mode) {
		if (StringUtils.equals(mode, ONLINE)) {
			return String.format(pathPattern, StringUtils.lowerCase(mode));
		}
		if (StringUtils.equals(mode, TEST)) {
			return String.format(pathPattern, StringUtils.lowerCase(mode));
		}
		if (StringUtils.equals(mode, DEV)) {
			return String.format(pathPattern, StringUtils.lowerCase(mode));
		}
		return String.format(pathPattern, StringUtils.lowerCase(DEV));
	}

	public String getProperty(String key) {
		return resolvePlaceholder(key, properties);
	}
}
