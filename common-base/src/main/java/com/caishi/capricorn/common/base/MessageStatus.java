package com.caishi.capricorn.common.base;

/**
 * Created by apple on 15/9/10.
 * 新闻消息状态
 */
public enum MessageStatus {
	ONLINE("online", "上架"), OFFLINE("offline", "下架"),
	COLLECTSHOW("collectShow", "收藏可见"), UNKNOWN("unknown", "未知");

	private String status;
	private String desc;

	MessageStatus(String status, String desc) {
		this.status = status;
		this.desc = desc;
	}

	public String getStatus() {
		return status;
	}

	public String getDesc() {
		return desc;
	}
}
