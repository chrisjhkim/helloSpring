package com.chrisjhkim.hellospring.study.scopetype;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonScopeTest {
	
	@Test
	public void singletonScope() {
		System.out.println("HO");
		
		ApplicationContext ac = new AnnotationConfigApplicationContext( SingletonBean.class, SingletonClientBean.class);
		
		Set<SingletonBean> beans = new HashSet<>();
		beans.add(ac.getBean(SingletonBean.class));
		beans.add(ac.getBean(SingletonBean.class));
		assertThat(beans.size(), is(1));
		
		
		beans.add(ac.getBean(SingletonClientBean.class).bean1);
		beans.add(ac.getBean(SingletonClientBean.class).bean2);
		assertThat(beans.size(), is(1));
	}
	
	static class SingletonBean{}
	static class SingletonClientBean{
		@Autowired 
		SingletonBean bean1;
		@Autowired 
		SingletonBean bean2;
	}
}
