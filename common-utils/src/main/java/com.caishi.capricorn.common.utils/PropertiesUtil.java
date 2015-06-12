package com.caishi.capricorn.common.utils;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

/**
 * Property utility. Could be used to load and merge properties.
 *
 * @author humphrey.han@9icaishi.net
 * @since 0.0.1
 */
public class PropertiesUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
    // class loader
    private static final ClassLoader classLoader = PropertiesUtil.class.getClassLoader();

    /**
     * load Properties from source
     * @param source property file path
     * @return key-value properties
     */
    public static Properties loadProperties (String source) {
        if (null == source || "".equals(source.trim())) {
            return null;
        }
        Properties prop = new Properties();
        InputStream is = null;
        if (logger.isDebugEnabled()) {
            logger.debug("Try to load properties from source " + source);
        }
        try {
            is = classLoader.getResourceAsStream(source);
            if (is != null) {
                prop.load(is);
            }
        } catch (Exception e) {
            logger.error("Failed to load configs of " + source + " due to " + e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(is);
        }
        return prop;
    }

    /**
     * merge properties into one.
     * usage: mergeProperties(prop1, prop2, prop3, ...)
     *        mergeProperties(new Properties[] {prop1, prop2, prop3, ...})
     * the latter is preferred.
     * if there's same key in  prop1 and prop3, setting in prop3 will take effect.
     *
     * @param props array of property file path
     * @return merged key-value properties
     */
    public static Properties mergeProperties (Properties... props) {
        if (null == props || props.length == 0) {
            return null;
        }
        Properties merged = new Properties();
        for (Properties prop : props) {
            if (null != prop && !prop.isEmpty()) {
                for (Object key : prop.keySet()) {
                    merged.setProperty(key.toString(), prop.getProperty(key.toString()));
                }
            }
        }
        if (logger.isDebugEnabled()) {
            for (Object key : merged.keySet()) {
                logger.debug("Merged property. " + key + " = " + merged.get(key));
            }
        }
        return merged;
    }
}
