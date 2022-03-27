package com.chrisjhkim.hellospring.study.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.chrisjhkim.hellospring.study.service.PropertyTestWithJavaService;


@Service
public class PropertyTestWithJavaServiceImpl implements PropertyTestWithJavaService {
	private static final Logger logger = LoggerFactory.getLogger(PropertyTestWithJavaServiceImpl.class);
	private String osName = "param ������ �����Ǵ� ��";
	private String databaseUserName;
	
	/*
	 * �ܼ��� value �� �����ϴ°Ÿ� param�� �����Ҷ� ���� ������ �Ǳ⿡ ���������� ����
	 * systemProperties (os.name) ���� ������ ��⿡�� �����ϴ�.(setOsName)
	 * 
	 */
//	@Value("java ���Ͽ��� ������ value��")
	@Value("#{systemProperties['os.name']}")
	public void setOsName(String osName) {
		this.osName = osName;
	}

	/*
	 *  database.username �Ӽ��� ���ǵǾ� �ִٸ� �Ʒ��� ���� �ҷ��� ���� �ִ�.
	 *  database.properties ������ xml���� �����ص־� �Ѵ�. 
	 */
//	@Value("#{database.username}") // TODO : database ���� �� �ٽ� �غ���
	public void setDatabaseUserName(String databaseUserName) {
		this.databaseUserName = databaseUserName;
	}
	
	
	@Override
	public void printInfos() {
		logger.info("osName value={}", this.osName);
		logger.info("databaseUserName value={}", this.databaseUserName);
		
	}
	

}
