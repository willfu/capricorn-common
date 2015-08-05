package com.caishi.capricorn.storm.topology;

import com.caishi.capricorn.common.spring.environment.BeanPropertyholderConfigurer;
import com.caishi.capricorn.storm.bolt.TestBoltWithSpring;
import com.caishi.capricorn.storm.spout.TestSpoutWithSpring;
import com.caishi.capricorn.storm.topology.spring.AbstractTopologyWithSpring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 15/8/5.
 */
public class TestTopologyWithSpring extends AbstractTopologyWithSpring {

	private static final Logger LOG = LoggerFactory.getLogger(TestTopologyWithSpring.class);

	public TestTopologyWithSpring(String topologyName) {
		super(topologyName);
	}

	public TestTopologyWithSpring(String topologyName, boolean runLocally) {
		super(topologyName, runLocally);
	}

	public TestTopologyWithSpring(String topologyName, boolean runLocally, int runtimeInSeconds) {
		super(topologyName, runLocally, runtimeInSeconds);
	}

	/**
	 * local mode : mvnDebug compile exec:java -Dstorm.topology=com.caishi.capricorn.storm.topology.TestTopologyWithSpring -Dproduction.mode="TEST" -Drunning.mode=local
	 * remote mode :  storm jar target/common-storm-1.0-SNAPSHOT.jar com.caishi.capricorn.storm.topology.TestTopologyWithSpring TEST remote
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String topologyName = "testTopology";
		boolean runLocally = true;

		String mode = BeanPropertyholderConfigurer.DEV;
		if (args.length >= 1 && BeanPropertyholderConfigurer.support_modes.contains(args[0])) {
			mode = args[0];
		}

		LOG.info("production mode : " + mode);

		if (args.length >= 2 && args[1].equalsIgnoreCase("remote")) {
			runLocally = false;
		}

		LOG.info("Topology name: " + topologyName);

		TestTopologyWithSpring topology = new TestTopologyWithSpring(topologyName, runLocally);

		Map<String, Object> properties = new HashMap<>();
		properties.put(BeanPropertyholderConfigurer.PRODUCTION_MODE, mode);

		topology.runTopology(properties);
	}

	@Override
	protected void wireTopology(Map<String, Object> propertis) {
		String spoutId = "wordSpout";
		String boltId = "outputBolt";

		this.builder.setSpout(spoutId, new TestSpoutWithSpring(), 2);
		this.builder.setBolt(boltId, new TestBoltWithSpring(), 2).shuffleGrouping(spoutId);
	}
}
