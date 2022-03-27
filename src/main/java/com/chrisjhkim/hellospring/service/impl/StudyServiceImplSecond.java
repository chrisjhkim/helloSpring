package com.chrisjhkim.hellospring.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chrisjhkim.hellospring.service.StudyService;

@Service
//@Service("second")
@Qualifier("studySecond")
public class StudyServiceImplSecond implements StudyService{

	@Override
	public void print(String text) {
		System.out.println("call from StudyServiceImplSecond "+ text );
		
	}
	
	
	

}
