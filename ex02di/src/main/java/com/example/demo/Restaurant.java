package com.example.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Getter;

//@RequiredArgsConstructor	
//@Scope("prototype")
@Lazy  // 최초로 사용할 때 bean 컨테이너에 넣어서 생성
@Component
@Getter
public class Restaurant {
//	@Autowired
	
	
	
//	@Setter(onMethod_ = {@Autowired})
	private Chef chef;

	public Restaurant(Chef chef) {
		this.chef = chef;
		System.out.println("레스토랑 생성");
	}
	
	
	
	
}
