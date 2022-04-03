package com.chrisjhkim.hellospring.vo;

import com.chrisjhkim.hellospring.service.impl.EmailServiceImpl.NotificationMethod;

public class UserInfo {

	private String email;
	private NotificationMethod notificationMethod;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public NotificationMethod getNotificationMethod() {
		return notificationMethod;
	}
	public void setNotificationMethod(NotificationMethod notificationMethod) {
		this.notificationMethod = notificationMethod;
	}
	
	
}
