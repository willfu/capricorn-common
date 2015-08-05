package com.caishi.capricorn.storm.utils;

import com.caishi.capricorn.common.spring.environment.BeanPropertyholderConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static com.caishi.capricorn.common.spring.environment.BeanPropertyholderConfigurer.PRODUCTION_MODE;

/**
 * Created by apple on 15/8/5.
 * <p/>
 * 配置spring 环境信息
 */
public class ProductionModeUtils {

	private static final Logger LOG = LoggerFactory.getLogger(ProductionModeUtils.class);

	public static final String configProductionMode(Map config, String target) {
		String mode = null;
		if (config == null ||
				!config.containsKey(PRODUCTION_MODE) ||
				!BeanPropertyholderConfigurer.support_modes.contains(config.get(PRODUCTION_MODE))) {
			mode = BeanPropertyholderConfigurer.DEV;
			LOG.info("config {} production mode is default: DEV", target);
		} else {
			mode = (String) config.get(PRODUCTION_MODE);
			LOG.info("config {} production mode {}", target, mode);
		}

		/**
		 * 设置系统环境变量
		 */
		System.setProperty(PRODUCTION_MODE, mode);
		return mode;
	}
}
