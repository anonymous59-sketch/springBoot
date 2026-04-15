package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class DITest {
	
	@Autowired
	TV tv;
	
	@Autowired
	ApplicationContext context;
	
//	@Autowired
//	Restaurant restaurant;
	
	@Test
	@DisplayName("lazy 테스트")
	public void test3() {
		System.out.println("레스토랑 주입");
		Restaurant restaurant = context.getBean(Restaurant.class);
		System.out.println(restaurant);
	}
	
	
//	@Test
	public void test2() {
		Restaurant restaurant = context.getBean(Restaurant.class);
		Restaurant restaurant2 = context.getBean(Restaurant.class);
		System.out.println(restaurant == restaurant2);
		restaurant.getChef().toString();
	}
	
//	@Test
	public void test1() {
		tv.powerOn();
		tv.volumeUp();
		tv.powerOff();
	}
}
