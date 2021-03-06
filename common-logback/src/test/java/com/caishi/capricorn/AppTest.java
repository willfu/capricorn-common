package com.caishi.capricorn;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {


	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("debug", "true");
	}

	@Test
	public void testDefaultLog() throws Exception {
		Logger LOGGER = LoggerFactory.getLogger(AppTest.class);
		LOGGER.info("default logging");
	}

	@Test
	public void testConsoleLog() throws Exception {

		System.setProperty("appenderSelction", "console");
		Logger LOGGER = LoggerFactory.getLogger(AppTest.class);
		LOGGER.info("console logging");
	}

	@Test
	public void testRolling() throws Exception {
		System.setProperty("appenderSelction", "rolling");

		Logger LOGGER = LoggerFactory.getLogger(AppTest.class);

		LOGGER.info("rolling logging");
	}

	@Test
	public void testAll() throws Exception {
		System.setProperty("appenderSelction", "all");

		Logger LOGGER = LoggerFactory.getLogger(AppTest.class);
		LOGGER.info("all logging");
	}

	@Test
	public void testPropertiesConfig() throws Exception {
		Logger LOGGER = LoggerFactory.getLogger(AppTest.class);

		for (int i = 0; i < 100000; i++) {
			LOGGER.info("properties config logging");
			TimeUnit.SECONDS.sleep(1);
		}

	}
}
