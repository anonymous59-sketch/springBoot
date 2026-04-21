package com.example.demo.emp.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.emp.mapper.EmployeeMapper;
import com.example.demo.emp.service.EmployeeService;
import com.example.demo.emp.service.EmployeeVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j // 로그 lombok
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeMapper employeeMapper;

	@Override
	public PageInfo<EmployeeVO> selectAll(EmployeeVO emp, int pageNum) {
		
		PageInfo<EmployeeVO> page = PageHelper.startPage(pageNum, 5)
				.doSelectPageInfo(() -> employeeMapper.selectAll(emp));
		
		log.info("TotalCount : {}, CurrentPage : {}, PageSize : {}, IsNextPage : {}, IsPrevPage : {}, getPrePage : {}, getNextPage : {}, NavigatepageNums : {}"
				   , page.getTotal()
				   , page.getPageNum()
				   , page.getPageSize()
				   , page.isHasNextPage() 
				   , page.isHasPreviousPage()
				   , page.getPrePage()
				   , page.getNextPage()
				   , page.getNavigatepageNums());
		
		return page;
	}

	@Override
	public EmployeeVO selectOne(int empid) {
		return employeeMapper.selectOne(empid);
	}

	@Override
	public int insert(EmployeeVO emp) {
		return employeeMapper.insert(emp);
	}

	@Override
	public int update(EmployeeVO emp) {
		return employeeMapper.update(emp);
	}

	@Override
	public int delete(int id) {
		return employeeMapper.delete(id);
	}
	
}
