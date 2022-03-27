package com.chrisjhkim.hellospring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.chrisjhkim.hellospring.service.StudyService;

@Service
@Qualifier("studyFirst")
public class StudyServiceImpl implements StudyService {
	private static final Logger logger = LoggerFactory.getLogger(StudyServiceImpl.class);
	
	@Override
	public void print(String text) {
		System.out.println("call from studyServiceImpl "+text);
	}				
}
