package com.caishi.capricorn.common.login.dto;

import java.sql.Timestamp;

public class DeviceInfo {
	
	/**
	 * �ն��豸Ψһ���
	 */
	private String deviceId;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	/**
	 * �ն��豸���صĲ���ϵͳ����
	 */
	public String osTypeId;

	public String getOsTypeId() {
		return osTypeId;
	}

	public void setOsTypeId(String osTypeId) {
		this.osTypeId = osTypeId;
	}
	
	/**
	 * ����ϵͳ�汾
	 */
	private String osVersion;

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	
	/**
	 * ������Ӫ�̱�ʶ��
	 */
	private String simTypeId;
	
	public String getSimTypeId() {
		return simTypeId;
	}

	public void setSimTypeId(String simTypeId) {
		this.simTypeId = simTypeId;
	}
	
	/**
	 * ����ʶ��
	 */
	private String idfa;
	
	public String getIdfa() {
		return idfa;
	}

	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}
	
	/**
	 * �������ͱ�ʶ��
	 */
	private String netTypeId;
	
	public String getNetTypeId() {
		return netTypeId;
	}

	public void setNetTypeId(String netTypeId) {
		this.netTypeId = netTypeId;
	}
	
	/**
	 * �豸������Ϣ
	 */
	private String detailInfo;
	
	public String getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}

	/**
	 * �ն��豸����
	 */
	private String deviceTypeId;

	public String getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}
	
	/**
	 * ����ʱ��
	 */
	private Timestamp createTime;

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * �Ƿ����ʶ����
	 */
	private short enable;

	public short getEnable() {
		return enable;
	}

	public void setEnable(short enable) {
		this.enable = enable;
	}
}
