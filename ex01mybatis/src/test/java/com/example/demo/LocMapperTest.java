package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.location.mapper.LocationMapper;
import com.example.demo.location.service.LocationVO;

@SpringBootTest
public class LocMapperTest {
	
	@Autowired
	LocationMapper mapper;
	
	@Test
	public void delete() {
		int cnt = mapper.delete(3000);
		System.out.println(cnt + "건이 삭제되었습니다.");
	}
	
//	@Test
	public void insert() {
		LocationVO param = new LocationVO();
		param.setLocationId(3000);
		param.setCity("Seattle");
		int cnt = mapper.insert(param);
		System.out.println(cnt + "건이 추가되었습니다.");
	}
	
//	@Test
	public void selectOne() {
		LocationVO locVO = mapper.selectOne(3000);
		System.out.println(locVO.getStreetAddress());
	}
	
	
//	@Test
	public void selectAll() {
		LocationVO param = new LocationVO();
		param.setCity("TEST");
		List<LocationVO> list = mapper.selectAll(param);
		for(LocationVO loc : list) {
			System.out.println(loc.getStreetAddress());
		}
	}
}
