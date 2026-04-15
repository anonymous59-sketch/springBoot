package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Ex02diApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Ex02diApplication.class, args);
		
		TV tv = context.getBean(TV.class);
		tv.powerOn();
		
	}// end of main

}
