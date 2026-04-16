package com.example.demo.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.emp.EmployeeVO;
import com.example.demo.emp.mapper.EmployeeMapper;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeMapper employeeMapper;
	
	@GetMapping("/emp/list")
	public String empList(Model model) {
		model.addAttribute("list", employeeMapper.selectAll(null));
		return "emp/list";
	}
	
	@GetMapping("/emp/info") // /emp/info?id=100
	public void info(@RequestParam int id, Model model) {
		model.addAttribute("emp", employeeMapper.selectOne(id));
	}
	
	// 등록페이지로 이동
	@GetMapping("/emp/register")
	public void register(@ModelAttribute("emp") EmployeeVO vo, Model model) {
	}
	
	// 등록 처리
	@PostMapping("/emp/register")
	public String registerProc(EmployeeVO vo) {
		employeeMapper.insert(vo);
		return "redirect:/emp/list";
	}
	
	// 수정페이지로 이동
	@GetMapping("/emp/update")
	public String update(int id, Model model) {
		// 단건조회
		model.addAttribute("emp", employeeMapper.selectOne(id));
		return "emp/register";
	}
	
	// 수정 처리
	@PostMapping("/emp/update")
	public String updateProc(EmployeeVO vo) {
		employeeMapper.update(vo);
		return "redirect:/emp/list";
	}
	
	// 삭제처리
	@GetMapping("/emp/delete")
	public String delete(int id) {
		employeeMapper.delete(id);
		return "redirect:/emp/list";
	}
	
}
