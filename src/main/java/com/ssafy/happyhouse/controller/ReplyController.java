package com.ssafy.happyhouse.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.BoardDto;
import com.ssafy.happyhouse.model.dto.ReplyDto;
import com.ssafy.happyhouse.model.service.BoardService;
import com.ssafy.happyhouse.model.service.ReplyService;

@RequestMapping("/reply")
@RestController
public class ReplyController {
	
	private ReplyService replyService;
	@Autowired
	public void setBoardService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	@GetMapping("/{boardNo}")
	public ResponseEntity<List<ReplyDto>> list(int boardNo) throws Exception {
		return ResponseEntity.ok(replyService.list(boardNo));
	}
	
	@PostMapping("/")
	public ResponseEntity<Integer> write(ReplyDto dto) throws Exception {
		return ResponseEntity.ok(replyService.write(dto));
	}
	
	@PutMapping("/")
	public ResponseEntity<Integer> update(ReplyDto vo) throws Exception {
		return ResponseEntity.ok(replyService.update(vo));
	}
	
	@DeleteMapping("/{ReplyNo}")
	public ResponseEntity<Integer> delete(@PathVariable int ReplyNo) throws Exception {
		return ResponseEntity.ok(replyService.delete(ReplyNo));
	}
	
	
}
