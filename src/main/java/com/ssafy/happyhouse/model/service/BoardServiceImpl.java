package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.BoardDao;
import com.ssafy.happyhouse.model.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao;
	@Autowired
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<BoardDto> list() {
		return boardDao.list();
	}

	@Override
	public BoardDto view(int BoardNo) {
		return boardDao.view(BoardNo);
	}

	@Override
	public int write(BoardDto vo) {
		return boardDao.write(vo);
	}

	@Override
	public int update(BoardDto vo) {
		return boardDao.update(vo);
	}

	@Override
	public int delete(int boardNo) {
		return boardDao.delete(boardNo);
	}

	@Override
	public int increase(int boardNo) {
		return boardDao.increase(boardNo);
	}
}
