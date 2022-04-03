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
	/* spring-junit 테스트 할때 ServerConfig 같은 singleton bean을 DI해야되는 인스턴스 객체를 만들려면 
	 * 수정자 메소드로 @Before 등으로 넣어줘야 하는데 그대신 해당 인스턴스를 prototype scope 으로 만들면 유용하다.
	 * 단 해당 인스턴스 내에 @Autowired 를 쓰면 문제가 된다 ( DI 작업은 빈 오브젝트가 처음 만들어질때 단 한번만 진행되기 때문에)
	 * 그래서 이를 APplicationContext를 DI 받아둔 뒤에 코드에서 .getBean() 메소드를 직접 호출하는 방법으로 해야함
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
