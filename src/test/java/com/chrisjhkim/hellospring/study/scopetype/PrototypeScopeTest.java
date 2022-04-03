package com.chrisjhkim.hellospring.study.scopetype;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeScopeTest {

	@Test
	public void protoTypeScope() {
		ApplicationContext ac = new AnnotationConfigApplicationContext( PrototypeBean.class, PrototypeClientBean.class);
		
		Set<PrototypeBean> beans = new HashSet<>();
		beans.add(ac.getBean(PrototypeBean.class));
		assertThat(beans.size(), is(1));
		beans.add(ac.getBean(PrototypeBean.class));
		assertThat(beans.size(), is(2));
		
		
		beans.add(ac.getBean(PrototypeClientBean.class).bean1);
		assertThat(beans.size(), is(3));
		beans.add(ac.getBean(PrototypeClientBean.class).bean2);
		assertThat(beans.size(), is(4));
	}
	
//	@Scope("application")
//	@Scope("globalSession")
	/* spring-junit �׽�Ʈ �Ҷ� ServerConfig ���� singleton bean�� DI�ؾߵǴ� �ν��Ͻ� ��ü�� ������� 
	 * ������ �޼ҵ�� @Before ������ �־���� �ϴµ� �״�� �ش� �ν��Ͻ��� prototype scope ���� ����� �����ϴ�.
	 * �� �ش� �ν��Ͻ� ���� @Autowired �� ���� ������ �ȴ� ( DI �۾��� �� ������Ʈ�� ó�� ��������� �� �ѹ��� ����Ǳ� ������)
	 * �׷��� �̸� APplicationContext�� DI �޾Ƶ� �ڿ� �ڵ忡�� .getBean() �޼ҵ带 ���� ȣ���ϴ� ������� �ؾ���
	 * 
	 * 
	 */
	@Scope("prototype")	
//	@Scope("request")
//	@Scope("session")
//	@Scope("singleton")
//	@Scope("websocket")
//	@Scope("websocket")
	static class PrototypeBean{}
	static class PrototypeClientBean{
		@Autowired 
		PrototypeBean bean1;
		@Autowired 
		PrototypeBean bean2;
	}


}
