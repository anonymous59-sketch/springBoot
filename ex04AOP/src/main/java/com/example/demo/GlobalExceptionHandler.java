package com.example.demo;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InternalServerError.class)
	public String error1() {
		return "error500";
	}
	@ExceptionHandler(NullPointerException.class)
	public String error2() {
		return "error500";
	}
	@ExceptionHandler(Exception.class)
	public String error3() {
		return "error";
	}
}
