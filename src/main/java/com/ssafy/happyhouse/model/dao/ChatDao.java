package com.ssafy.happyhouse.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.ChatDto;

@Mapper
public interface ChatDao {

	boolean chatWrite(ChatDto chat)throws Exception;
	List<ChatDto> chatList(String userid)throws Exception;
}
