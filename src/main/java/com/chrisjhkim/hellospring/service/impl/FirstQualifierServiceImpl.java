package com.chrisjhkim.hellospring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chrisjhkim.hellospring.service.QualifierService;

//@Service
//@Qualifier("mainQService")
//���� ������ Annotation ���� bean ������� �ʰ� root-context.xml ���� ����Ѵ�.
public class FirstQualifierServiceImpl implements QualifierService {
	private static final Logger logger = LoggerFactory.getLogger(FirstQualifierServiceImpl.class);
	
	@Override
	public void printClass() {
		logger.info("class = {}", this.getClass());
		
	}
	
}
