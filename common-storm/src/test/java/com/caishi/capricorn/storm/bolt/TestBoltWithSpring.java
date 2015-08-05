package com.caishi.capricorn.storm.bolt;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;
import com.caishi.capricorn.common.spring.environment.BeanPropertyholderConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by apple on 15/8/5.
 */
public class TestBoltWithSpring extends AbstractBoltWithSpring {
	private static final Logger LOG = LoggerFactory.getLogger(TestBoltWithSpring.class);

	private OutputCollector _collector;

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		super.prepare(stormConf, context, collector);
		this._collector = collector;
	}

	@Override
	public void execute(Tuple input) {
		System.out.printf("mode %s, message %s%n", System.getProperty(BeanPropertyholderConfigurer.PRODUCTION_MODE), input.getString(0));
		this._collector.ack(input);
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {

	}
}
