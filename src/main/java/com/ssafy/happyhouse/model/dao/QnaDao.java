package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.QnaDto;
import com.ssafy.happyhouse.model.dto.QnaParameterDto;

public interface QnaDao {

	public int writeArticle(QnaDto qnaDto) throws SQLException;
	public List<QnaDto> listArticle(QnaParameterDto qnaParameterDto) throws SQLException;
	public int getTotalCount(QnaParameterDto qnaParameterDto) throws SQLException;
	public QnaDto getArticle(int articleno) throws SQLException;
	public void updateHit(int articleno) throws SQLException;
	public int modifyArticle(QnaDto qnaDto) throws SQLException;
	public void deleteMemo(int articleno) throws SQLException;
	public int deleteArticle(int articleno) throws SQLException;
//	public List<QnaDto> QnaListSearchWord(QnaDto qnaDto);
	
	
	public List<QnaDto> qnaList(QnaParameterDto qnaParamDto);
	public int qnaListTotalCount();
	
	public List<QnaDto> qnaListSearchWord(QnaParameterDto qnaParamDto);
	public int qnaListSearchWordTotalCount(QnaParameterDto qnaParamDto);
}
