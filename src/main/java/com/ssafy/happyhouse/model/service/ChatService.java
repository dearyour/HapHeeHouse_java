package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.ChatDto;

public interface ChatService {
	boolean chatWrite(ChatDto chat)throws Exception;
	List<ChatDto> chatList(String userid)throws Exception;
	
}
