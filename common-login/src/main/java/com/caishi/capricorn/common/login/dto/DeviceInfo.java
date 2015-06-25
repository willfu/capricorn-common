package com.caishi.capricorn.common.login.dto;

import java.sql.Timestamp;

public class DeviceInfo {
	
	private String deviceId;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	public String osTypeId;

	public String getOsTypeId() {
		return osTypeId;
	}

	public void setOsTypeId(String osTypeId) {
		this.osTypeId = osTypeId;
	}
	
	private String osVersion;

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	
	private String simTypeId;
	
	public String getSimTypeId() {
		return simTypeId;
	}

	public void setSimTypeId(String simTypeId) {
		this.simTypeId = simTypeId;
	}
	
	private String idfa;
	
	public String getIdfa() {
		return idfa;
	}

	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}
	
	private String netTypeId;
	
	public String getNetTypeId() {
		return netTypeId;
	}

	public void setNetTypeId(String netTypeId) {
		this.netTypeId = netTypeId;
	}
	
	private String detailInfo;
	
	public String getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}

	private String deviceTypeId;

	public String getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}
	
	private Timestamp createTime;

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	private short enable;

	public short getEnable() {
		return enable;
	}

	public void setEnable(short enable) {
		this.enable = enable;
	}
}
