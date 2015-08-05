package com.caishi.capricorn.storm.topology;

import backtype.storm.Config;
import backtype.storm.topology.TopologyBuilder;
import com.caishi.capricorn.storm.utils.StormRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by apple on 15/8/5.
 * <p/>
 * 抽象拓扑
 */
public abstract class AbstractTopology {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractTopology.class);

	private static final int DEFAULT_RUNTIME_IN_SECONDS = 600;
	protected TopologyBuilder builder;
	protected Config topologyConfig;
	private String topologyName;
	private boolean runLocally;
	private int runtimeInSeconds;

	/**
	 * 默认本地运行
	 *
	 * @param topologyName
	 */
	public AbstractTopology(String topologyName) {
		this(topologyName, true, DEFAULT_RUNTIME_IN_SECONDS);
	}

	public AbstractTopology(String topologyName, boolean runLocally) {
		this(topologyName, runLocally, DEFAULT_RUNTIME_IN_SECONDS);
	}

	public AbstractTopology(String topologyName, boolean runLocally, int runtimeInSeconds) {
		this.builder = new TopologyBuilder();
		this.topologyName = topologyName;
		this.runLocally = runLocally;
		this.runtimeInSeconds = runtimeInSeconds;

		if (runLocally && runtimeInSeconds <= 0) {
			throw new IllegalArgumentException(String.format(
					"The runtimeInSeconds should be more than zero when the runLocally is true. The runtimeInSeconds is %d", runtimeInSeconds));
		}
	}


	/**
	 * 1.组装topology
	 * 2.执行任务
	 *
	 * @param properites
	 * @throws Exception
	 */
	public final void runTopology(Map<String, Object> properites) throws Exception {
		this.topologyConfig = createTopologyConfig(properites);
		configEnvInfo(properites);
		wireTopology(properites);
		submitTopology();
	}

	/**
	 * 配置topology configuration
	 *
	 * @param properties
	 * @return
	 */
	protected Config createTopologyConfig(Map<String, Object> properties) {
		Config conf = new Config();
		conf.setDebug(true);
		return conf;
	}

	/**
	 * 配置环境信息
	 *
	 * @param properties
	 */
	protected void configEnvInfo(Map<String, Object> properties) {

	}

	/**
	 * 组装topology: 重写该方法组装topology
	 *
	 * @param propertis
	 */
	protected abstract void wireTopology(Map<String, Object> propertis);

	/**
	 * 提交任务执行
	 *
	 * @throws Exception
	 */
	protected final void submitTopology() throws Exception {
		if (runLocally) {
			LOG.info("Running in local mode");
			this.runLocally();
		} else {
			LOG.info("Running in remote (cluster) mode");
			this.runRemotely();
		}
	}

	private void runLocally() throws InterruptedException {
		StormRunner.runTopologyLocally(builder.createTopology(), topologyName, topologyConfig, runtimeInSeconds);
	}

	private void runRemotely() throws Exception {
		StormRunner.runTopologyRemotely(builder.createTopology(), topologyName, topologyConfig);
	}

}
