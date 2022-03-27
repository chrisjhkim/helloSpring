package com.chrisjhkim.hellospring.study.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.chrisjhkim.hellospring.study.service.PropertyTestWithJavaService;


@Service
public class PropertyTestWithJavaServiceImpl implements PropertyTestWithJavaService {
	private static final Logger logger = LoggerFactory.getLogger(PropertyTestWithJavaServiceImpl.class);
	private String osName = "param 생성때 설정되는 값";
	private String databaseUserName;
	
	/*
	 * 단순한 value 를 세팅하는거면 param을 생성할때 값을 넣으면 되기에 유용한점이 없고
	 * systemProperties (os.name) 같은 정보를 담기에는 유용하다.(setOsName)
	 * 
	 */
//	@Value("java 파일에서 설정한 value값")
	@Value("#{systemProperties['os.name']}")
	public void setOsName(String osName) {
		this.osName = osName;
	}

	/*
	 *  database.username 속성이 정의되어 있다면 아래와 같이 불러올 수도 있다.
	 *  database.properties 파일을 xml에서 지정해둬야 한다. 
	 */
//	@Value("#{database.username}") // TODO : database 연동 후 다시 해보자
	public void setDatabaseUserName(String databaseUserName) {
		this.databaseUserName = databaseUserName;
	}
	
	
	@Override
	public void printInfos() {
		logger.info("osName value={}", this.osName);
		logger.info("databaseUserName value={}", this.databaseUserName);
		
	}
	

}
