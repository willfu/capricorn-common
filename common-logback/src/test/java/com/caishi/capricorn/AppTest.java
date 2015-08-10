package com.caishi.capricorn;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
