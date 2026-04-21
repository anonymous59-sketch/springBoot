package com.example.demo.department.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.department.service.DepartmentVO;

@Mapper
public interface DepartmentMapper {
	List<DepartmentVO> selectAll(DepartmentVO dept);
	DepartmentVO selectOne(int deptid);
	int insert(DepartmentVO dept);
	int update(DepartmentVO dept);
	int delete(int id);	
}
