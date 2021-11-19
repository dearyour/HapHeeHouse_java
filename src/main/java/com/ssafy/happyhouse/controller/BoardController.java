package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.BoardDto;
import com.ssafy.happyhouse.model.service.BoardService;

@RequestMapping("/board")
@RestController
public class BoardController {

	private BoardService boardService;
	@Autowired
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<BoardDto>> list() {
		return ResponseEntity.ok(boardService.list());
	}
	
	@GetMapping("/{boardNo}")
	public ResponseEntity<BoardDto> view(@PathVariable int boardNo) {
		return ResponseEntity.ok(boardService.view(boardNo));
	}
	
	@PostMapping("/{boardNo}")
	public ResponseEntity<Integer> increase(@PathVariable int boardNo) {
		return ResponseEntity.ok(boardService.increase(boardNo));
	}
	
	@PostMapping("/")
	public ResponseEntity<Integer> write(String boardName, String content, HttpSession session) {
		String userId = (String)session.getAttribute("userInfo");
		if (userId == null) return ResponseEntity.ok(0);
		BoardDto dto = new BoardDto();
		dto.setBoardName(boardName);
		dto.setContent(content);
		dto.setUser_id(userId);
		return ResponseEntity.ok(boardService.write(dto));
	}
	
	@PutMapping("/{boardNo}")
	public ResponseEntity<Integer> update(@PathVariable int boardNo, String boardName, String content) {
		System.out.println(boardNo + ", " + boardName + " ," +content);
		BoardDto dto = new BoardDto(boardNo);
		dto.setBoardName(boardName);
		dto.setContent(content);
		return ResponseEntity.ok(boardService.update(dto));
	}
	
	@DeleteMapping("/{boardNo}")
	public ResponseEntity<Integer> delete(@PathVariable int boardNo) {
		return ResponseEntity.ok(boardService.delete(boardNo));
	}
}
