package com.chrisjhkim.hellospring.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.chrisjhkim.hellospring.service.StudyService;

@Service
@Primary
public class StudyServiceImpl implements StudyService {

	@Override
	public void print(String text) {
		System.out.println("call from studyServiceImpl "+text);
		
	}

}
