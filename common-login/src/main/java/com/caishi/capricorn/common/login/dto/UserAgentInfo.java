package com.caishi.capricorn.common.login.dto;

public class UserAgentInfo {
	
	/**
	 * ����汾
	 */
	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * ����������
	 */
	private String agent;

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}
	
	/**
	 * �û�ƾ֤
	 */
	private String credential;

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}
	
	/**
	 * ��������
	 */
	private String channel;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	/**
	 * �ն��豸
	 */
	private DeviceInfo deviceInfo = new DeviceInfo();

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
}
