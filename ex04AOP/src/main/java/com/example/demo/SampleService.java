package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SampleService {
	
	@Autowired SampleMapper sampleMapper;
	
	@Transactional
	public void insert(String title) {
		sampleMapper.sample2(title); 
		sampleMapper.sample(title); // error가 나면 모두 롤백해야됨
		
	}
	
	//@PrintExecutionTime // AOP 어드바이스 실행
	public void test1(String name) {
		log.info("test1 실행");
	}
	
	public void test2() {
		log.info("test2 실행");
	}
}
