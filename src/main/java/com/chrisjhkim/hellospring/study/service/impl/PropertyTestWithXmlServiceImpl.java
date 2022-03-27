package com.chrisjhkim.hellospring.study.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.chrisjhkim.hellospring.service.impl.FirstQualifierServiceImpl;
import com.chrisjhkim.hellospring.study.service.PropertyTestWithXmlService;

public class PropertyTestWithXmlServiceImpl implements PropertyTestWithXmlService {
	private static final Logger logger = LoggerFactory.getLogger(PropertyTestWithXmlServiceImpl.class);
	// default 값 설정 가능하다. 물론 xml에서 property setting 하면 달라짐
	private String paramWithPublicSetter = "default값";
//	private String paramWithPrivateSetter;
	
	/*
	 *  xml 에서 bean property 넣을떄 setter 가 없으면 들어갈 수 없다. (privateParamWithoutSetter)
	 *  parameter 가 public 이여도 setter method 가 없으면 안됨 ( publicParamWithoutSetter)
	 *	  
	 * parmeter setter method 는 public 이여야 한다. (paramWithPrivateSetter) 
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
