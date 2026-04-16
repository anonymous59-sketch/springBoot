package com.example.demo;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/api")
public class SampleController {

	@GetMapping({ "/", "/main" })
	public String page1(Model model) {
		model.addAttribute("today", new Date());
		model.addAttribute("name", "홍길동");
		return "main";
	}

//	@GetMapping("/main")
//	public void page2() {
//	}
	// 컨트롤러로 호출하는건 String해서 template 파일명을 리턴 또는
	// void를 하고 GetMapping에 template의 파일명을 주소로 둔다.

}
