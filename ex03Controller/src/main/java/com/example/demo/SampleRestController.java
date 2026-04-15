package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Sample API", description = "샘플 테스트")
@RestController
public class SampleRestController {

	@GetMapping("/api/ex1")
	public SampleVO ex1() {
		return new SampleVO("홍길동", 20);
	}

	@GetMapping("/api/ex2")
	public List<SampleVO> ex2() {
		List<SampleVO> list = Arrays.asList(new SampleVO("홍길동", 20), new SampleVO("김길동", 24), new SampleVO("박길동", 27));
		return list;
	}

	// VO(메서드 = 커멘드핸들러, VO = 커멘드 객체)
	@PostMapping("/api/ex3")
	public SampleVO ex3(SampleVO vo) {

		return vo;
	}

	@GetMapping("/api/ex4")
	public Map<String, Object> ex4(@RequestParam Map<String, Object> map) {
		return map;
	}

	@GetMapping("/api/ex5")
	public String ex5(String name,
			@RequestParam(required = false, defaultValue = "15") int age) {
		System.out.println(name + ": " + age);
		return name;
	}

	@GetMapping("/api/ex6/{name}/{age}")
	public String ex6(@PathVariable String name, 
					  @PathVariable Integer age) {
		System.out.println(name + ": " + age);
		return name;
	}

	// json string 파라미터 받기
	@GetMapping("/api/ex7")
	public SampleVO ex7(@RequestBody SampleVO vo) {
		
		return vo;
	}
	
	@Tag(name= "사용자 등록")
	@Operation(summary = "사용자등록테스트", description = "일반 사용자 등록.",
             responses = {
              @ApiResponse(responseCode = "200", description = "등록 성공"),
              @ApiResponse(responseCode = "400", description = "잘못된 요청")
        })
	//유효성 체크
	@PostMapping("/api/ex8")
	public ResponseEntity<?> ex8(@Valid @RequestBody UserVO vo, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			Map<String, String> errors = new HashMap<>();
	        
	        // 필드 에러 메시지 수집
	        bindingResult.getFieldErrors().forEach(error -> 
	            errors.put(error.getField(), error.getDefaultMessage())
	        );
	        
	        // 에러 목록과 함께 400 Bad Request 응답
	        return ResponseEntity.badRequest().body(errors);
		}
		return ResponseEntity.ok("success");
	}
	
}// end of class
