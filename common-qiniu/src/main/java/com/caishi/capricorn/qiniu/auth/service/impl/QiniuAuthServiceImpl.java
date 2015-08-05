package com.caishi.capricorn.qiniu.auth.service.impl;

import com.caishi.capricorn.qiniu.auth.service.QiniuAuthService;
import com.caishi.capricorn.qiniu.auth.service.constants.BucketEnum;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by apple on 15/7/30.
 */
public class QiniuAuthServiceImpl implements QiniuAuthService {

	private static final Logger LOGGER = LoggerFactory.getLogger(QiniuAuthServiceImpl.class);

	private String accessKey;
	private String secretKey;

	private Auth auth;

	private Map<BucketEnum, String> bucketMap;

	public QiniuAuthServiceImpl(String accessKey, String secretKey, Map<BucketEnum, String> bucketMap) {
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		this.auth = Auth.create(accessKey, secretKey);
		this.bucketMap = bucketMap;
	}

	@Override
	public String createUploadToken(BucketEnum bucket, String key, long ttl, Map<String, Object> policyMap, boolean strict) {
		if (bucket == null) {
			LOGGER.warn("Bucket is null.");
			throw new RuntimeException("Bucket is null.");
		}
		String bucketName = bucketMap.get(bucket);
		if (StringUtils.isBlank(bucketName)) {
			String msg = String.format("There is no bucket for %s", bucket);
			LOGGER.warn(msg);
			throw new RuntimeException(msg);
		}
		if (StringUtils.isBlank(key)) {
			LOGGER.warn("source key  is null.");
			throw new RuntimeException("source key is null.");
		}
		StringMap policy = new StringMap();
		if (policyMap != null) {
			policy.putAll(policyMap);
		}
		return auth.uploadToken(bucketName, key, ttl, policy, strict);
	}
}
