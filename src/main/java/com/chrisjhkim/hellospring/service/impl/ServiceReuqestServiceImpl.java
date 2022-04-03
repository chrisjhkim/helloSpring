package com.chrisjhkim.hellospring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.chrisjhkim.hellospring.dao.ServiceRequestDao;
import com.chrisjhkim.hellospring.dao.UserInfoDao;
import com.chrisjhkim.hellospring.service.EmailService;
import com.chrisjhkim.hellospring.service.ServiceReuqestService;
import com.chrisjhkim.hellospring.vo.ServiceRequest;

public class ServiceReuqestServiceImpl implements ServiceReuqestService {
	

	@Autowired private UserInfoDao userInfoDao;
	@Autowired private ServiceRequestDao serviceRequestDao;
	@Autowired private EmailService emailService;
	
	@Override
	public void requestProcess(ServiceRequest serviceRequest) {
//		UserInfo userInfo = this.userInfoDao.findUserInfoByNo(serviceRequest.getCustomerNo());
		
		this.serviceRequestDao.save(serviceRequest);
		this.emailService.sendEmail(serviceRequest.getUserInfo().getEmail(), "처리가 완료되었습니다.");
	}
}
