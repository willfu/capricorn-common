package com.caishi.capricorn.qiniu.auth.service.locator;

import com.caishi.capricorn.qiniu.auth.service.QiniuAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by apple on 15/7/30.
 */
public class QiniuAuthServiceLocator {

	private static final Logger LOGGER = LoggerFactory.getLogger(QiniuAuthServiceLocator.class);

	public static String contextPath = "spring/common-qiniu-context.xml";

	public static ApplicationContext context;

	static {
		init();
	}

	private static void init() {
		context = new ClassPathXmlApplicationContext(contextPath);
	}

	public static QiniuAuthService getQiniuAuthService() {
		return (QiniuAuthService) context.getBean("qiniuAuthService");
	}

}
