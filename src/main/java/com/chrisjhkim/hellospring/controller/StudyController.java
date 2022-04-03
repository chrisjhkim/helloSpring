package com.chrisjhkim.hellospring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import com.chrisjhkim.hellospring.dao.UserInfoDao;
import com.chrisjhkim.hellospring.service.ServiceReuqestService;
import com.chrisjhkim.hellospring.vo.ServiceRequest;

@Controller
public class StudyController {
	
	@Autowired private UserInfoDao userInfoDao;
	@Autowired private ServiceReuqestService serviceReuqestService;
	@Autowired private ApplicationContext context;
	
	/*
	 * @Autowired
	 * 
	 * 생성자, 필드, 수정자 메소드, 일반 메소드 모두 가능
	 * @Resources와 다르게 이름 대신 필드나 프로퍼티 타입을 이용해서 후보를 찾음
	 * 생성자는 하나의 생성자에만 사용 가능 
	 * 
	 */
//	@Autowired private StudyService studyService;
	
//	@Resource private ObjectFactory<ServiceRequest>
	
	
	
	
	public void serviceRequestFormSubmit(HttpServletRequest request) {
		ServiceRequest serviceRequest = this.context.getBean(ServiceRequest.class);
		serviceRequest.setUserInfoByCustomerNo(request.getParameter("custNo"));
		
//		ServiceRequest serviceRequest = new ServiceRequest();
//		serviceRequest.setCustomerNo(request.getParameter("custNo"));
		
		this.serviceReuqestService.requestProcess(serviceRequest);
	}
	
}
