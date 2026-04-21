package com.example.demo.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.emp.mapper.EmployeeMapper;
import com.example.demo.emp.service.EmployeeVO;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class EmployeeRestController {
	
	@Autowired EmployeeMapper employeeMapper;
	
	// 전체 조회
	@GetMapping("/emp")
	public List<EmployeeVO> selectAll(){
		return employeeMapper.selectAll(null);
	}
	
	// 단건 조회
	@GetMapping("/emp/{id}")
	public EmployeeVO selectone(@PathVariable int id) {
		return employeeMapper.selectOne(id);
	}
	
	// 등록
	@PostMapping("/emp")
	public @ResponseBody EmployeeVO insert (@RequestBody EmployeeVO vo) {
		employeeMapper.insert(vo);
		return vo;
	}
	
	// 수정
	@PutMapping("/emp")
	public @ResponseBody EmployeeVO update (@RequestBody EmployeeVO vo) {
		employeeMapper.update(vo);
		return vo;
	}
	
	// 삭제
	@DeleteMapping("/emp/{id}")
	public EmployeeVO Delete (@PathVariable int id) {
		EmployeeVO vo = employeeMapper.selectOne(id);
		int cnt = employeeMapper.delete(id);
		System.out.println(cnt + "건 삭제되었습니다.");
		return vo;
	}
}
