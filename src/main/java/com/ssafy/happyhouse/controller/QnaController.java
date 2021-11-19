package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.ssafy.happyhouse.model.dto.QnaDto;
import com.ssafy.happyhouse.model.dto.QnaRegistDto;
import com.ssafy.happyhouse.model.dto.QnaReplyDto;
import com.ssafy.happyhouse.model.service.QnaService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/qna")
@RestController
public class QnaController {
	
	private QnaService qnaService;
	@Autowired
	public void setQnaService(QnaService qnaService) {
		this.qnaService = qnaService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<QnaDto>> list() {
		log.info("list");
		return ResponseEntity.ok(qnaService.list());
	}
	
	@GetMapping("/{qnaId}")
	public ResponseEntity<QnaDto> view(@PathVariable int qnaId) {
		log.info("view");
		return ResponseEntity.ok(qnaService.view(qnaId));
	}
	
	@PutMapping("/{qnaId}")
	public ResponseEntity<Integer> increase(@PathVariable int qnaId) {
		log.info("increase");
		return ResponseEntity.ok(qnaService.increase(qnaId));
	}
	
	@PostMapping("/")
	public ResponseEntity<Integer> write(@RequestBody QnaRegistDto dto) {
//		String userId = (String)session.getAttribute("userInfo");
//		if (userId == null) return ResponseEntity.ok(0);
		log.info("write");
		System.out.println(dto.getUserid() + ", " + dto.getQnaName() + ", " + dto.getContent());
		QnaDto qnaDto = new QnaDto();
		qnaDto.setQnaName(dto.getQnaName());
		qnaDto.setContent(dto.getContent());
		qnaDto.setUserid(dto.getUserid());
		return ResponseEntity.ok(qnaService.write(qnaDto));
	}
	
	@PutMapping("/increase/{qnaId}")
	public ResponseEntity<Integer> update(@PathVariable int qnaId, String qnaName, String content) {
		log.info("update");
		System.out.println(qnaId + ", " + qnaName + " ," +content);
		QnaDto dto = new QnaDto(qnaId);
		dto.setQnaName(qnaName);
		dto.setContent(content);
		return ResponseEntity.ok(qnaService.update(dto));
	}
	
	@DeleteMapping("/{qnaId}")
	public ResponseEntity<Integer> delete(@PathVariable int qnaId) {
		log.info("delete");
		return ResponseEntity.ok(qnaService.delete(qnaId));
	}
	
	 /* Reply */
	@PostMapping("/reply/{qnaId}")
	public ResponseEntity<Integer> writeReply(@PathVariable int qnaId, @RequestBody QnaReplyDto reply,HttpSession session) {
		String userid = (String)session.getAttribute("userInfo");
		
		QnaDto dto = new QnaDto();
		dto.setQnaNo(qnaId);
		dto.setReplyUserid(userid);
		dto.setReplyContent(reply.getReplyContent());
		return ResponseEntity.ok(qnaService.writeReply(dto));
	}
    
	@PutMapping("/reply/{qnaId}")
	public ResponseEntity<Integer> updateReply(@PathVariable int qnaId, @RequestBody QnaReplyDto reply,HttpSession session) {
		String userid = (String)session.getAttribute("userInfo");
		
		QnaDto dto = new QnaDto();
		dto.setQnaNo(qnaId);
		dto.setReplyUserid(userid);
		dto.setReplyContent(reply.getReplyContent());
		return ResponseEntity.ok(qnaService.updateReply(dto));
	}
    
	@DeleteMapping("/reply/{qnaId}")
	public ResponseEntity<Integer> deleteReply(@PathVariable int qnaId,HttpSession session) {
		return ResponseEntity.ok(qnaService.deleteReply(qnaId));
	}
}
