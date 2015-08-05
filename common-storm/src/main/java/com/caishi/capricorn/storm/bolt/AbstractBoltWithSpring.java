package com.caishi.capricorn.storm.bolt;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.base.BaseRichBolt;
import com.caishi.capricorn.storm.utils.ProductionModeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by apple on 15/8/5.
 * <p/>
 * 配置spring环境信息
 */
public abstract class AbstractBoltWithSpring extends BaseRichBolt {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractBoltWithSpring.class);

	/**
	 * subclass should invoke this method to config spring production mode
	 *
	 * @param stormConf
	 * @param context
	 * @param collector
	 */
	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		ProductionModeUtils.configProductionMode(stormConf, this.getClass().getCanonicalName());

	}
}
