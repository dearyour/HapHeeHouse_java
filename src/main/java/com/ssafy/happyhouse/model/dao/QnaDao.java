package com.ssafy.happyhouse.model.dao;

import java.util.List;

import com.ssafy.happyhouse.model.dto.QnaDto;

public interface QnaDao {
	// 1. 공지사항 리스트
	public List<QnaDto> list();

	// 2. 공지사항 보기
	public QnaDto view(int qnaNo);

	// 2-1. 공지사항 조회수 1 증가
	public int increase(int qnaNo);

	// 3. 게시판 글쓰기
	public int write(QnaDto vo);

	// 4. 게시판 글수정
	public int update(QnaDto vo);

	// 5. 게시판 글삭제
	public int delete(int qnaNo);
	
	/* Reply */
	
	public int writeReply(QnaDto dto);
	public int updateReply(QnaDto dto);
	public int deleteReply(int no);
}
