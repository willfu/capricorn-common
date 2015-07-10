package com.caishi.capricorn.common.remote.model;


import com.caishi.capricorn.common.remote.constants.OperationStatus;

import java.io.Serializable;

/**
 * Created by apple on 15/7/1.
 * <p/>
 * 操作结果信息
 */
public class OperationResult implements Serializable{

	/**
	 * 操作结果状态
	 */
	private OperationStatus status;

	/**
	 * 结果消息
	 */
	private String msg;

	public OperationResult() {
	}

	public OperationResult(OperationStatus status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public OperationStatus getStatus() {
		return status;
	}

	public void setStatus(OperationStatus status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
