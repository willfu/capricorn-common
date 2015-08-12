package com.caishi.capricorn.common.remote.dto;

import com.caishi.capricorn.common.remote.constants.OperationStatus;

import java.io.Serializable;

/**
 * Created by apple on 15/8/12.
 * <p/>
 * remote rpc 响应报文
 */
public class RemoteResponse<R extends Serializable> implements Serializable {
	private OperationStatus status;
	private String msg;

	private R data;

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

	public R getData() {
		return data;
	}

	public void setData(R data) {
		this.data = data;
	}
}
