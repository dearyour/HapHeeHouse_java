package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.QnaDto;
import com.ssafy.happyhouse.model.dto.QnaReplyDto;

public interface QnaService {
	// 1. 공지사항 리스트
	public List<QnaDto> list();

	// 2. 공지사항 보기 
	public QnaDto view(int qnaId);

	// 2-1. 공지사항 조회수 1 증가
	public int increase(int qnaId);

	// 3. 게시판 글쓰기
	public int write(QnaDto qnaDto);
	
	// 4. 게시판 글수정
	public int update(QnaDto qnaDto);
	
	// 5. 게시판 글삭제
	public int delete(int qnaId);
	
	public int writeReply(QnaDto dto);
	
	public int updateReply(QnaDto dto);
	
	public int deleteReply(int no);	//게시물의 번호
}
