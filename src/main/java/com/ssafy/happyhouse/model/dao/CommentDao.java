package com.ssafy.happyhouse.model.dao;

import java.util.List;

import com.ssafy.happyhouse.model.dto.CommentDto;

public interface CommentDao {
	public List<CommentDto> list(int articleno) throws Exception; 
	
	// 3. 댓글쓰기
	public int write(CommentDto commentDto) throws Exception;
	
	// 4. 댓글 수정
	public int update(CommentDto commentDto) throws Exception;
	
	// 5. 댓글 삭제
	public int delete(int ro) throws Exception;

}
