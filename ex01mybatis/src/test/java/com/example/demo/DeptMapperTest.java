package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.DepartmentVO;
import com.example.demo.emp.mapper.DepartmentMapper;

@SpringBootTest
public class DeptMapperTest {
	
	@Autowired
	DepartmentMapper mapper;
	
//	@Test
	public void selectOne() {
		DepartmentVO empVO = mapper.selectOne(50);
		System.out.println(empVO.getDepartmentName());
	}
	
	
	@Test
	public void selectAll() {
		DepartmentVO param = new DepartmentVO();
		param.setDepartmentName("TRAINING");
		List<DepartmentVO> list = mapper.selectAll(param);
		for(DepartmentVO dept : list) {
			System.out.println(dept.getDepartmentName());
		}
	}
}
