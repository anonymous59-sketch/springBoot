package com.example.demo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.board.BoardVO;
import com.example.demo.board.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	final BoardMapper boardMapper;	
	
	// 전체조회
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", boardMapper.selectAll());
	}
	
	// 단건조회
	@GetMapping("/info")
	public void info(@RequestParam int bno, Model model) {
		model.addAttribute("board", boardMapper.selectOne(bno));
	}
	
	// 등록 페이지
	@GetMapping("/register")
	public void register(@ModelAttribute("bd") BoardVO vo, Model model) {
	}
	
	// 등록 처리
	@PostMapping("/register")
	public String registerProc(BoardVO vo, Model model) {
		boardMapper.insert(vo);
		model.addAttribute("result", vo.getBno());
		return "redirect:/board/list";
	}
	
	// 수정 페이지
	@GetMapping("/update")
	public String update(int bno, Model model) {
		model.addAttribute("bd", boardMapper.selectOne(bno));
		return "board/register";
	}
	
	// 수정 처리
	@PostMapping("/update")
	public String updateProc(BoardVO vo, Model model) {
		boardMapper.update(vo);
		model.addAttribute("result", vo.getBno());
		return "redirect:/board/list";
	}
	
	// 삭제 처리
	@GetMapping("/delete")
	public String delete(int bno, Model model) {
		boardMapper.delete(bno);
		model.addAttribute("result", bno);
		return "redirect:/board/list";
	}
}
