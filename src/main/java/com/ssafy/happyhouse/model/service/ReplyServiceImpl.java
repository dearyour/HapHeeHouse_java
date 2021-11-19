package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.ReplyDao;
import com.ssafy.happyhouse.model.dto.ReplyDto;
@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyDao replyDao;


	@Override
	public List<ReplyDto> list(int BoardNo) throws Exception {
		// TODO Auto-generated method stub
		return replyDao.list(BoardNo);
	}

	@Override
	public int write(ReplyDto ro) throws Exception {
		return replyDao.write(ro);
	}

	@Override
	public int update(ReplyDto ro) throws Exception {
		// TODO Auto-generated method stub
		return replyDao.update(ro);
	}

	@Override
	public int delete(int ro) throws Exception {
		// TODO Auto-generated method stub
		return replyDao.delete(ro);
	}

}
