package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.ChatDto;
import com.ssafy.happyhouse.model.service.ChatService;

import io.swagger.annotations.ApiOperation;

//http://localhost:8888/happyhouse/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class ChatController {
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private ChatService chatService;

    @ApiOperation(value = "채팅 리스트 반환", response = List.class)
	@GetMapping(value = "/chat/{userid}")
	public ResponseEntity<List<ChatDto>> chatList(@PathVariable("userid") String userid) throws Exception {
		logger.debug("chatList - 호출");
		return new ResponseEntity<List<ChatDto>>(chatService.chatList(userid), HttpStatus.OK);
	}
    
    
    @ApiOperation(value = "요청 처리결과 반환", response = ResponseEntity.class)
   	@PostMapping(value = "/chat")
	public ResponseEntity<String> chatWrite(@RequestBody ChatDto chat) throws Exception {
		logger.debug("chatWrite - 호출 : "+ chat );
		if(chat.getUserid().equals("admin")) {
			chat.setSend("sent");
			chat.setColor("primary");
			chat.setAvatar("https://cdn.quasar.dev/img/avatar4.jpg");
		}
		else {
			chat.setSend("");
			chat.setColor("amber");
			chat.setAvatar("https://cdn.quasar.dev/img/avatar2.jpg");
		}
		
		if (chatService.chatWrite(chat)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
