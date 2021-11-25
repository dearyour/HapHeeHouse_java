package com.ssafy.happyhouse.model.dto;

public class BookmarkAreaDto {
	private int userSeq;
	private int dongCode;

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public int getDongCode() {
		return dongCode;
	}

	public void setDongCode(int dongCode) {
		this.dongCode = dongCode;
	}

	@Override
	public String toString() {
		return "BookmarkAreaDto [userSeq=" + userSeq + ", dongCode=" + dongCode + "]";
	}
}
