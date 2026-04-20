package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyRestController {
	@Autowired
	ReplyRepository replyRepo;
	
	// 전체조회
	@GetMapping("/reply")
	public List<Reply> selectAll() {
		return replyRepo.findAll();
	}
	
	// 단건조회
	@GetMapping("/reply/{id}")
	public Reply selectOne(@PathVariable long id) {
		return replyRepo.findById(id).get();
	}
	
	// 등록
	@PostMapping("/reply")
	public String insert (@RequestBody Reply rp) {
		Reply result = replyRepo.save(rp);
		return result.getRno() + "번 으로 글 등록 되었습니다.";
	}
	
	// 수정
	@PutMapping("/reply")
	public String update (@RequestBody Reply rp) {
		Reply result = replyRepo.save(rp);
		return result.getRno() + "번 글이 수정 되었습니다.";
	}
	
	
	// 삭제
	@DeleteMapping("/reply/{id}")
	public String delete (@PathVariable long id) {
		Reply delReply = replyRepo.findById(id).get();
		replyRepo.delete(delReply);
		return delReply.getRno() + "번 글이 삭제되었습니다.";
	}

}
