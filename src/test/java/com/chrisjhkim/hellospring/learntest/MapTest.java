package com.chrisjhkim.hellospring.learntest;

import java.util.HashMap;

import org.junit.Test;

public class MapTest {
	
	@Test
	public void testInsertNullValue() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("11", "aa");
		map.put("22", null);
		
		System.out.println(map);
	}

}
