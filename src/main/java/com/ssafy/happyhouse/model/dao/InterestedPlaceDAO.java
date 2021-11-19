package com.ssafy.happyhouse.model.dao;

public interface InterestedPlaceDAO {

	// 모든 관심장소 조회
	void selectAllPlace();

	// 이미 존재하는 회원인지 중복확인
	boolean isExistingUser(String id);

	// 구군코드 찾아라 
	void placeUp(String userid, String gugunCode);

	// 
	void modifyPlaceInfo(String userid, String oldGugunCode, String newGugunCode);

	// 동코드 삭제 삭제
	void deletePlaceInfo(String userid, String guguncode);

}