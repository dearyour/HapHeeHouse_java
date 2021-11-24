package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.ChatDao;
import com.ssafy.happyhouse.model.dto.ChatDto;

@Service
public class ChatServiceImpl implements ChatService{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean chatWrite(ChatDto chat) throws Exception {
		return sqlSession.getMapper(ChatDao.class).chatWrite(chat);
	}

	@Override
	public List<ChatDto> chatList(String userid) throws Exception {
		return sqlSession.getMapper(ChatDao.class).chatList(userid);
	}

	
}
