package com.caishi.capricorn.storm.topology.spring;

import com.caishi.capricorn.storm.topology.AbstractTopology;
import com.caishi.capricorn.storm.utils.ProductionModeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static com.caishi.capricorn.common.spring.environment.BeanPropertyholderConfigurer.PRODUCTION_MODE;

/**
 * Created by apple on 15/8/5.
 * <p/>
 * 基于BeanPropertyholderConfigurer配置spring环境信息
 */
public abstract class AbstractTopologyWithSpring extends AbstractTopology {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractTopologyWithSpring.class);

	/**
	 * 配置spring环境 : BeanPropertyholderConfigurer  ONLINE/TEST/DEV
	 */
	private String mode;

	public AbstractTopologyWithSpring(String topologyName) {
		super(topologyName);
	}

	public AbstractTopologyWithSpring(String topologyName, boolean runLocally) {
		super(topologyName, runLocally);
	}

	public AbstractTopologyWithSpring(String topologyName, boolean runLocally, int runtimeInSeconds) {
		super(topologyName, runLocally, runtimeInSeconds);
	}

	/**
	 * 配置spring 环境信息
	 *
	 * @param properties
	 */
	protected void configEnvInfo(Map<String, Object> properties) {
		this.mode = ProductionModeUtils.configProductionMode(properties, this.getClass().getCanonicalName());
		this.topologyConfig.put(PRODUCTION_MODE, mode);
	}


}
