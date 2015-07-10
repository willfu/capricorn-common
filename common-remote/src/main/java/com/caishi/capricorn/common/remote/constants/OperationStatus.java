package com.caishi.capricorn.common.remote.constants;

import java.io.Serializable;

/**
 * Created by apple on 15/7/1.
 */
public enum OperationStatus implements Serializable {

	SUCC("succeed", "operation is successed"), FAILED("failed", "operation is failed"),
	ERROR("error", "errors occur in operation");

	private String status;

	private String desc;

	OperationStatus(String status, String desc) {
		this.status = status;
		this.desc = desc;
	}

	public String getStatus() {
		return status;
	}

	public String getDesc() {
		return desc;
	}

	@Override
	public String toString() {
		return status;
	}
}
