package com.chrisjhkim.hellospring.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chrisjhkim.hellospring.dao.UserInfoDao;
import com.chrisjhkim.hellospring.service.EmailService;
import com.chrisjhkim.hellospring.service.impl.EmailServiceImpl.NotificationMethod;

@Component
/* spring-junit 테스트 할때 ServerConfig 같은 singleton bean을 DI해야되는 인스턴스 객체를 만들려면 
 * 수정자 메소드로 @Before 등으로 넣어줘야 하는데 그대신 해당 인스턴스를 prototype scope 으로 만들면 유용하다.
 * 단 해당 인스턴스 내에 @Autowired 를 쓰면 문제가 된다 ( DI 작업은 빈 오브젝트가 처음 만들어질때 단 한번만 진행되기 때문에)
 * 그래서 이를 APplicationContext를 DI 받아둔 뒤에 코드에서 .getBean() 메소드를 직접 호출하는 방법으로 해야함
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
			this.emailService.sendEmail(userInfo.getEmail(), "접수가 완료되었습니다.");
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
