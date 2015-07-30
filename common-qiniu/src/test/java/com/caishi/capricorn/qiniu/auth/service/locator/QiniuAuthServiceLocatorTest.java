package com.caishi.capricorn.qiniu.auth.service.locator;

import com.caishi.capricorn.qiniu.auth.service.QiniuAuthService;
import com.caishi.capricorn.qiniu.auth.service.constants.BucketEnum;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by apple on 15/7/30.
 */
public class QiniuAuthServiceLocatorTest {

	@Test
	public void testGetQiniuAuthService() throws Exception {
		BucketEnum bucket = BucketEnum.share;
		String key = "share/2015/07/08";
		long expires = 1438239551;
		QiniuAuthService qiniuAuthService = QiniuAuthServiceLocator.getQiniuAuthService();
		String uploadToken = qiniuAuthService.createUploadToken(bucket, key, expires, null, true);

		assertNotNull(uploadToken);
		System.out.println(uploadToken);

	}
}
