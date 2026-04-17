package com.example.demo.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.emp.EmployeeVO;

//@Component + 프록시(대향)클래스 구현
@Mapper

public interface EmployeeMapper {
	
	int selectAll_COUNT(EmployeeVO emp);
	
	List<EmployeeVO> selectAll(EmployeeVO emp);
	EmployeeVO selectOne(int empid);
	int insert(EmployeeVO emp);
	int update(EmployeeVO emp);
	int delete(int id);
	
}
