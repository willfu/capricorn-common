package com.caishi.capricorn.common.spring.environment;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * Created by apple on 15/7/14.
 */
public class BeanPropertyholderConfigurerTest extends TestCase {

	@Test
	public void testClassPathConfig() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/test.xml");
		BeanPropertyholderConfigurer propertyConfigurer = context.getBean("propertyConfigurer",BeanPropertyholderConfigurer.class);
		assertEquals(propertyConfigurer.getMode(), BeanPropertyholderConfigurer.TEST);
	}
}
