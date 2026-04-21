package com.example.demo.slip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.slip.mapper.SlipMapper;
import com.example.demo.slip.service.SlipVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/slip")
public class SlipController {
	final SlipMapper slipMapper;
	
	@GetMapping({"/list", "/"})
	public String slipList(SlipVO vo, Model model) {
		model.addAttribute("list", slipMapper.selectAll(vo));
		return "slip/list";
	}
	
	@GetMapping("/insert")
	public void register(@ModelAttribute("list") SlipVO vo, Model model) {
	}
	
	@PostMapping("/insert")
	public String insertPorc(SlipVO vo) {
		slipMapper.insert(vo);
		return "redirect:/slip/";
	}
	
	
}
