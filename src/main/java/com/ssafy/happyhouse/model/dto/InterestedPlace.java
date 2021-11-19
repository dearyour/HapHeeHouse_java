package com.ssafy.happyhouse.model.dto;

// 관심지역 (동)
public class InterestedPlace {
	// 회원 ID
	private String userId;
	
	// 관심지역 동 코드
	private String dongcode;

	public InterestedPlace(String userid, String dongcode) {
		super();
		this.userId = userid;
		this.dongcode = dongcode;
	}

	public String getUserid() {
		return userId;
	}

	public void setUserid(String userid) {
		this.userId = userid;
	}

	public String getDongcode() {
		return dongcode;
	}

	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}

	@Override
	public String toString() {
		return "InterestedPlace [userid=" + userId + ", dongcode=" + dongcode + "]";
	}	
}
