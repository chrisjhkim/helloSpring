package com.chrisjhkim.hellospring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chrisjhkim.hellospring.service.QualifierService;

//@Service
//@Qualifier("mainQService")
//위의 내용을 Annotation 으로 bean 등록하지 않고 root-context.xml 에서 등록한다.
public class FirstQualifierServiceImpl implements QualifierService {
	private static final Logger logger = LoggerFactory.getLogger(FirstQualifierServiceImpl.class);
	
	@Override
	public void printClass() {
		logger.info("class = {}", this.getClass());
		
	}
	
}
