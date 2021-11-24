package com.ssafy.happyhouse.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.CommentDto;
import com.ssafy.happyhouse.model.service.CommentService;

@RequestMapping("/comment")
@RestController
public class CommentController {
	
	private CommentService commentService;
	@Autowired
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping("/{articleno}")
	public ResponseEntity<List<CommentDto>> list(@PathVariable int articleno) throws Exception {
		return ResponseEntity.ok(commentService.list(articleno));
	}
	
	@PostMapping("/")
	public ResponseEntity<Integer> write(@RequestBody CommentDto dto) throws Exception {
		System.out.println("writecomment - dto");
		return ResponseEntity.ok(commentService.write(dto));
	}
	
	@PutMapping("/{isbn}")
	public ResponseEntity<Integer> update(@RequestBody CommentDto dto ,@PathVariable int isbn) throws Exception {
		return ResponseEntity.ok(commentService.update(dto));
	}
	
	@DeleteMapping("/{isbn}")
	public ResponseEntity<Integer> delete(@PathVariable int isbn) throws Exception {
		return ResponseEntity.ok(commentService.delete(isbn));
	}
	
	
}
