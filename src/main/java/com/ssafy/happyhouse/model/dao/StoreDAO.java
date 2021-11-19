package com.ssafy.happyhouse.model.dao;

import com.ssafy.happyhouse.model.dto.UserDto;

public interface StoreDAO {

	// 구, 군 기준 검색
	void getStoreInfoByGugun(UserDto user);

	// 동 기준 검색
	void getStoreInfoByDong(UserDto user);

}