package com.caishi.capricorn.storm.utils;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.generated.StormTopology;

/**
 * Created by apple on 15/7/9.
 * <p/>
 * storm topology runner
 */
public final class StormRunner {

	private static final int MILLIS_IN_SEC = 1000;

	private StormRunner() {
	}

	public static void runTopologyLocally(StormTopology topology, String topologyName, Config conf, int runtimeInSeconds)
			throws InterruptedException {
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology(topologyName, conf, topology);
		Thread.sleep((long) runtimeInSeconds * MILLIS_IN_SEC);
		cluster.killTopology(topologyName);
		cluster.shutdown();
	}

	public static void runTopologyRemotely(StormTopology topology, String topologyName, Config conf)
			throws AlreadyAliveException, InvalidTopologyException {
		StormSubmitter.submitTopology(topologyName, conf, topology);
	}
}