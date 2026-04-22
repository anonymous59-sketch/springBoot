package com.example.demo.user.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.user.service.UserVO;

@Controller
public class UserController {


	@GetMapping("/")
	public String main() {
		// 시큐리티 컨텍스트 객체를 얻습니다.
		SecurityContext context = SecurityContextHolder.getContext();

		// 인증 객체를 얻습니다.
		Authentication authentication = context.getAuthentication();

		// 로그인한 사용자정보를 가진 객체를 얻습니다.
		UserVO principal = (UserVO) authentication.getPrincipal();
		System.out.println(principal.getFullName());
		
		
		return "home";
	}
}
