package com.caishi.capricorn.qiniu.auth.service.constants;

/**
 * Created by apple on 15/7/30.
 * <p/>
 * 七牛bucket枚举值
 */
public enum BucketEnum {
	/**
	 * 图片分享bucket
	 */
	share("share");

	private String bucket;

	BucketEnum(String bucket) {
		this.bucket = bucket;
	}

	public String getBucket() {
		return bucket;
	}
}
