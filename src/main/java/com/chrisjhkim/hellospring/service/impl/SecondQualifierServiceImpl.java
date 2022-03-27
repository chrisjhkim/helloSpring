package com.chrisjhkim.hellospring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chrisjhkim.hellospring.service.QualifierService;


public class SecondQualifierServiceImpl implements QualifierService {
	private static final Logger logger = LoggerFactory.getLogger(SecondQualifierServiceImpl.class);
	
	@Override
	public void printClass() {
		logger.info("class = {}", this.getClass());
		
	}

}
