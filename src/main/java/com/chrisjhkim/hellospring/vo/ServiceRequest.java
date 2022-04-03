package com.chrisjhkim.hellospring.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chrisjhkim.hellospring.dao.UserInfoDao;
import com.chrisjhkim.hellospring.service.EmailService;
import com.chrisjhkim.hellospring.service.impl.EmailServiceImpl.NotificationMethod;

@Component
/* spring-junit �׽�Ʈ �Ҷ� ServerConfig ���� singleton bean�� DI�ؾߵǴ� �ν��Ͻ� ��ü�� ������� 
 * ������ �޼ҵ�� @Before ������ �־���� �ϴµ� �״�� �ش� �ν��Ͻ��� prototype scope ���� ����� �����ϴ�.
 * �� �ش� �ν��Ͻ� ���� @Autowired �� ���� ������ �ȴ� ( DI �۾��� �� ������Ʈ�� ó�� ��������� �� �ѹ��� ����Ǳ� ������)
 * �׷��� �̸� APplicationContext�� DI �޾Ƶ� �ڿ� �ڵ忡�� .getBean() �޼ҵ带 ���� ȣ���ϴ� ������� �ؾ���
 */
@Scope("prototype")
public class ServiceRequest {
	private UserInfo userInfo;
	
	private String customerNo;
	private String productNo;
	private String description;
	
	@Autowired private UserInfoDao userInfoDao;
	@Autowired private EmailService emailService;

	public void notifyServiceRequestRegistaration() {
		if ( this.userInfo.getNotificationMethod() == NotificationMethod.EMAIL ) {
			this.emailService.sendEmail(userInfo.getEmail(), "������ �Ϸ�Ǿ����ϴ�.");
		}
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfoByCustomerNo(String customerNo) {
		this.userInfo = userInfoDao.findUserInfoByNo(customerNo);
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
