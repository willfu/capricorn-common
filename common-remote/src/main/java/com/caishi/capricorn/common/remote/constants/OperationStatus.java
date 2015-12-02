package com.caishi.capricorn.common.remote.constants;

import java.io.Serializable;

/**
 * Created by apple on 15/7/1.
 */
public enum OperationStatus implements Serializable {

	SUCC("succeed", "operation is successed"), FAILED("failed", "operation is failed"),
	ERROR("error", "errors occur in operation"),
	BAD_REQUEST("bad_request", "request is invalid or input data is invalid"),
	UNAUTHORIZED("unauthorized", "operation is unauthorized"),
	FORBIDDEN("forbidden", "operation is forbidden"),
	NOT_FOUND("not_found", "result not found"),
	NOT_SUPPORTED("not_supported", "operation is not supported"),
	UNAVAILABLE("unavailable", "operation is unavailable"),
	TIMEOUT("timeout", "operation timed out");

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
