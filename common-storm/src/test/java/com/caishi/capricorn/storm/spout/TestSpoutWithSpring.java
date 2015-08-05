package com.caishi.capricorn.storm.spout;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Random;

import static com.caishi.capricorn.common.spring.environment.BeanPropertyholderConfigurer.PRODUCTION_MODE;

/**
 * Created by apple on 15/8/5.
 */
public class TestSpoutWithSpring extends AbstractSpoutWithSpring {

	private static final Logger LOG = LoggerFactory.getLogger(TestSpoutWithSpring.class);

	private SpoutOutputCollector _collector;

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		super.open(conf, context, collector);
		this._collector = collector;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("word"));
	}

	@Override
	public void nextTuple() {
		Utils.sleep(100);
		final String[] words = new String[]{"nathan", "mike", "jackson", "golda", "bertels"};
		final Random rand = new Random();
		final String word = words[rand.nextInt(words.length)];
		LOG.info("mode {}, emit message {}", System.getProperty(PRODUCTION_MODE), word);
		_collector.emit(new Values(word));
	}
}
