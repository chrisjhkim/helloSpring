package com.chrisjhkim.hellospring.study.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.chrisjhkim.hellospring.service.impl.FirstQualifierServiceImpl;
import com.chrisjhkim.hellospring.study.service.PropertyTestWithXmlService;

public class PropertyTestWithXmlServiceImpl implements PropertyTestWithXmlService {
	private static final Logger logger = LoggerFactory.getLogger(PropertyTestWithXmlServiceImpl.class);
	// default �� ���� �����ϴ�. ���� xml���� property setting �ϸ� �޶���
	private String paramWithPublicSetter = "default��";
//	private String paramWithPrivateSetter;
	
	/*
	 *  xml ���� bean property ������ setter �� ������ �� �� ����. (privateParamWithoutSetter)
	 *  parameter �� public �̿��� setter method �� ������ �ȵ� ( publicParamWithoutSetter)
	 *	  
	 * parmeter setter method �� public �̿��� �Ѵ�. (paramWithPrivateSetter) 
	 */
//	private String privateParamWithoutSetter;
//	public String publicParamWithoutSetter;
	@Override
	public void printInfos() {
		logger.info("paramWithPublicSetter value = {}", this.paramWithPublicSetter);
//		logger.info("paramWithPrivateSetter value = {}", this.paramWithPrivateSetter);
//		logger.info("privateParamWithoutSetter value = {}", this.privateParamWithoutSetter);
//		logger.info("publicParamWithoutSetter value = {}", this.publicParamWithoutSetter);
		
	}
	public void setParamWithPublicSetter(String paramWithPublicSetter) {
		this.paramWithPublicSetter = paramWithPublicSetter;
	}
//	private void setParamWithPrivateSetter(String paramWithPrivateSetter) {
//		this.paramWithPrivateSetter = paramWithPrivateSetter;
//	}
	
	
	
	
	

	
}
