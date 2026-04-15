package com.example.demo;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import tools.jackson.databind.ObjectMapper;

public class ObjectMapperTest {
	
	@Test
	@DisplayName("객체를 JSON변환")
	public void test1() {
		UserVO vo = UserVO.builder()
					.firstName("길동")
					.lastName("홍")
					.regdate(new Date())
					.build();
		
		ObjectMapper mapper = new ObjectMapper();
		
		String str = mapper.writeValueAsString(vo);
		System.out.println(str);
	}
	
	@Test
	@DisplayName("JSON을 객체로 변환")
	public void test2() {
		String str = "{\"name\":\"홍길동\",\"age\":20}";

		ObjectMapper mapper = new ObjectMapper();
		
		SampleVO vo = mapper.readValue(str, SampleVO.class);
		System.out.println(vo.getName());
	}
	
	
	
}
