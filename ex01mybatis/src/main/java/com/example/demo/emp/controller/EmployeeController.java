package com.example.demo.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.emp.mapper.EmployeeMapper;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeMapper employeeMapper;
	
	@GetMapping("/emp")
	public String empList(Model model) {
		model.addAttribute("list", employeeMapper.selectAll(null));
		return "emp";
	}
}
