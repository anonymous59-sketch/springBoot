package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@EnableSpringDataWebSupport
@SpringBootApplication
public class Ex01mybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex01mybatisApplication.class, args);
	}
	
	@Bean
	public LayoutDialect layoutDialect() {
	  return new LayoutDialect();
	}
}
