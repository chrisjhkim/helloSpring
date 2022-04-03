package com.chrisjhkim.hellospring.service.impl;

import com.chrisjhkim.hellospring.service.EmailService;

public class EmailServiceImpl implements EmailService {

	@Override
	public void sendEmail(String email, String message) {
		// TODO Auto-generated method stub

		
	}

	
	public enum NotificationMethod{
		EMAIL, SMS
	}
}
