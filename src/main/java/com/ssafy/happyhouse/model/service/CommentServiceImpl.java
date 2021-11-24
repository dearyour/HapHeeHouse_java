package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.CommentDao;
import com.ssafy.happyhouse.model.dto.CommentDto;
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDao commentDao;


	@Override
	public List<CommentDto> list(int BoardNo) throws Exception {
		// TODO Auto-generated method stub
		return commentDao.list(BoardNo);
	}

	@Override
	public int write(CommentDto commentDto) throws Exception {
		return commentDao.write(commentDto);
	}

	@Override
	public int update(CommentDto commentDto) throws Exception {
		// TODO Auto-generated method stub
		return commentDao.update(commentDto);
	}

	@Override
	public int delete(int ro) throws Exception {
		// TODO Auto-generated method stub
		return commentDao.delete(ro);
	}

}
