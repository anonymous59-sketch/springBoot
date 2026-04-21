package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@MapperScan(basePackages = "com.example.demo.**.mapper")
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
