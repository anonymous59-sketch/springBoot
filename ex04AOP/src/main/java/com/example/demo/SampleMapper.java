package com.example.demo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {

	@Insert("INSERT INTO sample (title) VALUES (#{title})")
	void sample(String title);
	
	@Insert("INSERT INTO sample2 (title) VALUES (#{title})")
	void sample2(String title);
}
