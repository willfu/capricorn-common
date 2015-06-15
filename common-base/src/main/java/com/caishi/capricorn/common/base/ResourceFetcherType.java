package com.caishi.capricorn.common.base;

/**
 * Created by apple on 15/6/16.
 */
public enum ResourceFetcherType {
	QINIUFETCHER("qiniuFetcher"), HTTPFETCHER("httpFetcher");

	private String value;

	ResourceFetcherType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
