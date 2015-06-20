package com.caishi.capricorn.common.login.dto;

public class UserAgentInfo {
	
	/**
	 * 软件版本
	 */
	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * 请求代理对象
	 */
	private String agent;

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}
	
	/**
	 * 用户凭证
	 */
	private String credential;

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}
	
	/**
	 * 下载渠道
	 */
	private String channel;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	/**
	 * 终端设备
	 */
	private DeviceInfo deviceInfo = new DeviceInfo();

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
}
