package com.example.demo.emp.service;

import com.github.pagehelper.PageInfo;

public interface EmployeeService {

	PageInfo<EmployeeVO> selectAll(EmployeeVO emp, int pageNum);

	EmployeeVO selectOne(int empid);

	int insert(EmployeeVO emp);

	int update(EmployeeVO emp);

	int delete(int id);

}
