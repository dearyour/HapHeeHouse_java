package com.ssafy.happyhouse.model.dto;

public class QnaRegistDto {
	private String userid;
	private String qnaName;
	private String content;
	public String getUserid() {
		return userid;
	}
	public void setUser_id(String userid) {
		this.userid = userid;
	}
	public String getQnaName() {
		return qnaName;
	}
	public void setQnaName(String qnaName) {
		this.qnaName = qnaName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
