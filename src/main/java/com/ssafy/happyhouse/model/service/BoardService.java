package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.BoardDto;

public interface BoardService {
	
	// 1. 공지사항 리스트
	public List<BoardDto> list();

	// 2. 공지사항 보기 
	public BoardDto view(int boardNo);

	// 2-1. 공지사항 조회수 1 증가
	public int increase(int boardNo);

	// 3. 게시판 글쓰기
	public int write(BoardDto vo);
	
	// 4. 게시판 글수정
	public int update(BoardDto vo);
	
	// 5. 게시판 글삭제
	public int delete(int boardNo);
}
