package com.chrisjhkim.hellospring.study.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.chrisjhkim.hellospring.service.impl.FirstQualifierServiceImpl;
import com.chrisjhkim.hellospring.study.service.PropertyTestWithXmlService;

public class PropertyTestWithXmlServiceImpl implements PropertyTestWithXmlService {
	private static final Logger logger = LoggerFactory.getLogger(PropertyTestWithXmlServiceImpl.class);
	// default �� ���� �����ϴ�. ���� xml���� property setting �ϸ� �޶���
	private String paramWithPublicSetter = "default��";
	
	private boolean paramBoolean;
	private int[] paramIntArray;
	
	private List<String> paramList;
	private Map<String,String> paramMap;
	private Properties paramProperties;
	
	
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
		
		logger.info("paramBoolean value={}", this.paramBoolean);
		logger.info("paramIntArray value={}", this.paramIntArray);

		logger.info("paramList value={}", this.paramList);
		logger.info("paramMap value={}", this.paramMap);
		logger.info("paramProperties value={}", this.paramProperties);
		
		
	}
	public void setParamWithPublicSetter(String paramWithPublicSetter) {
		this.paramWithPublicSetter = paramWithPublicSetter;
	}
//	private void setParamWithPrivateSetter(String paramWithPrivateSetter) {
//		this.paramWithPrivateSetter = paramWithPrivateSetter;
//	}
	public void setParamBoolean(boolean paramBoolean) {
		this.paramBoolean = paramBoolean;
	}
	public void setParamIntArray(int[] paramIntArray) {
		this.paramIntArray = paramIntArray;
	}
	public void setParamList(List<String> paramList) {
		this.paramList = paramList;
	}
	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}
	public void setParamProperties(Properties paramProperties) {
		this.paramProperties = paramProperties;
	}
	
	
	
	
	

	
}
