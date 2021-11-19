package com.ssafy.happyhouse.model.service;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.dto.BoardDto;
import com.ssafy.happyhouse.model.dto.ReplyDto;
public interface ReplyService {

	public List<ReplyDto> list(int BoardNo) throws Exception;
	
	// 3. 댓글쓰기
	public int write(ReplyDto ro) throws Exception;
	
	// 4. 댓글 수정
	public int update(ReplyDto ro) throws Exception;
	
	// 5. 댓글 삭제
	public int delete(int ro) throws Exception;

}

