package com.ssafy.happyhouse.model.dto;

import java.util.List;

public class QnaResultDto {
	private int result;
	private QnaDto dto;
	private List<QnaDto> list;
	private int count;
	
	private boolean isOwner;
	
	public boolean isOwner() {
		return isOwner;
	}
	public void setOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public QnaDto getDto() {
		return dto;
	}
	public void setDto(QnaDto dto) {
		this.dto = dto;
	}

	public List<QnaDto> getList() {
		return list;
	}
	public void setList(List<QnaDto> list) {
		this.list = list;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	

}
