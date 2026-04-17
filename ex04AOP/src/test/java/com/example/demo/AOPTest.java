package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AOPTest {
	
	@Autowired SampleService sampleService;

	
	@Test
	public void test1() {
		sampleService.insert("hong");
	}
}
