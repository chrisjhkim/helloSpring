package com.chrisjhkim.hellospring.learntest;

import java.util.Properties;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemClassTest {
	private static final Logger logger = LoggerFactory.getLogger(SystemClassTest.class);
	@Test
	public void testJunit() {
		logger.info("HO!");
		Properties properties = System.getProperties();
		for ( Object key : properties.keySet() ) {
			logger.info(" {} : {}", key , properties.get(key));
		}
	}

}
