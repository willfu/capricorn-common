package com.caishi.capricorn.storm.spout;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.base.BaseRichSpout;
import com.caishi.capricorn.storm.utils.ProductionModeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by apple on 15/8/5.
 * <p/>
 * 配置spring环境信息
 */
public abstract class AbstractSpoutWithSpring extends BaseRichSpout {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractSpoutWithSpring.class);

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		ProductionModeUtils.configProductionMode(conf,this.getClass().getCanonicalName());
	}
}
