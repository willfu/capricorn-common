package com.caishi.capricorn.common.login.dto;

import java.sql.Timestamp;

public class DeviceInfo {
	
	/**
	 * 终端设备唯一编号
	 */
	private String deviceId;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	/**
	 * 终端设备搭载的操作系统类型
	 */
	public String osTypeId;

	public String getOsTypeId() {
		return osTypeId;
	}

	public void setOsTypeId(String osTypeId) {
		this.osTypeId = osTypeId;
	}
	
	/**
	 * 操作系统版本
	 */
	private String osVersion;

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	
	/**
	 * 网络运营商标识码
	 */
	private String simTypeId;
	
	public String getSimTypeId() {
		return simTypeId;
	}

	public void setSimTypeId(String simTypeId) {
		this.simTypeId = simTypeId;
	}
	
	/**
	 * 广告标识符
	 */
	private String idfa;
	
	public String getIdfa() {
		return idfa;
	}

	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}
	
	/**
	 * 网络类型标识码
	 */
	private String netTypeId;
	
	public String getNetTypeId() {
		return netTypeId;
	}

	public void setNetTypeId(String netTypeId) {
		this.netTypeId = netTypeId;
	}
	
	/**
	 * 设备详情信息
	 */
	private String detailInfo;
	
	public String getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}

	/**
	 * 终端设备类型
	 */
	private String deviceTypeId;

	public String getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 是否可用识别码
	 */
	private short enable;

	public short getEnable() {
		return enable;
	}

	public void setEnable(short enable) {
		this.enable = enable;
	}
}
