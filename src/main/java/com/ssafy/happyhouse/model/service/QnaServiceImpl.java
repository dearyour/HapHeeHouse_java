package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.QnaDao;
import com.ssafy.happyhouse.model.dto.QnaDto;

@Service
public class QnaServiceImpl implements QnaService {

	private QnaDao qnaDao;
	@Autowired
	public void setQnaDao(QnaDao qnaDao) {
		this.qnaDao = qnaDao;
	}
	
	@Override
	public List<QnaDto> list() {
		return qnaDao.list();
	}

	@Override
	public QnaDto view(int qnaId) {
		return qnaDao.view(qnaId);
	}

	@Override
	public int increase(int qnaId) {
		return qnaDao.increase(qnaId);
	}

	@Override
	public int write(QnaDto qnaDto) {
		return qnaDao.write(qnaDto);
	}

	@Override
	public int update(QnaDto qnaDto) {
		return qnaDao.update(qnaDto);
	}

	@Override
	public int delete(int qnaId) {
		return qnaDao.delete(qnaId);
	}
	
	@Override
	public int writeReply(QnaDto dto) {
		return qnaDao.writeReply(dto);
	}

	@Override
	public int updateReply(QnaDto dto) {
		return qnaDao.updateReply(dto);
	}

	@Override
	public int deleteReply(int no) {
		return qnaDao.deleteReply(no);
	}

}
