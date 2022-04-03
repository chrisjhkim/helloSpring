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
	 * ������, �ʵ�, ������ �޼ҵ�, �Ϲ� �޼ҵ� ��� ����
	 * @Resources�� �ٸ��� �̸� ��� �ʵ峪 ������Ƽ Ÿ���� �̿��ؼ� �ĺ��� ã��
	 * �����ڴ� �ϳ��� �����ڿ��� ��� ���� 
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
