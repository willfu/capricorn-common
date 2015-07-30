package com.caishi.capricorn.qiniu.auth.service;

import com.caishi.capricorn.qiniu.auth.service.constants.BucketEnum;

import java.util.Map;

/**
 * Created by apple on 15/7/30.
 * <p/>
 * 七牛授权服务
 */
public interface QiniuAuthService {

	/**
	 * 资源生成上传token
	 *
	 * @param bucket
	 * @param key
	 * @param ttl    有效时长 seconds :  deadline = current + ttl
	 * @param policy
	 * @param strict
	 * @return
	 */
	String createUploadToken(BucketEnum bucket, String key, long ttl, Map<String, Object> policy, boolean strict);
}
