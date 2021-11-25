package com.ssafy.happyhouse.model.dto;
public class BookmarkDto {
	private int userSeq;
	private int dealNo;

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public int getDealNo() {
		return dealNo;
	}

	public void setDealNo(int dealNo) {
		this.dealNo = dealNo;
	}

	@Override
	public String toString() {
		return "BookmarkDto [userSeq=" + userSeq + ", dealNo=" + dealNo + "]";
	}
}
