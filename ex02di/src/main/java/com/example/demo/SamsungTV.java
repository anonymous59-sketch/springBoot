package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;

//@RequiredArgsConstructor
@Component // 컨테이너에 빈 등록
public class SamsungTV implements TV {
	
	//@Autowired // 1. 필드 주입 방법
	@Setter(onMethod_ = {@Autowired})
	Speaker speaker;
	
	// 2. 생성자 주입방법
//	public SamsungTV(Speaker speaker) {
//		super();
//		this.speaker = speaker;
//	}
	
//	// 3. setter 주입방법
//	public Speaker getSpeaker() {
//		return speaker;
//	}
//	
////	@Autowired
//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker;
//	}
	
	@Override
	public void powerOn() {
		System.out.println("삼성 TV--전원 on");
	}
	@Override
	public void powerOff() {
		System.out.println("삼성 TV--전원 off");
	}
	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
}
