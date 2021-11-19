package com.ssafy.happyhouse.model.dao;

import com.ssafy.happyhouse.model.dto.House;

public interface HouseInfoDAO {

	// 전체 검색
	void searchAll();

	// 시, 도 기준 검색
	void searchHouseInfoBySido(String sido);

	// 구 기준 검색
	void searchHouseInfoByGugun(String gugun);

	// 동 기준 검색
	void searchHouseInfoByDong(String dong);

	// 아파트 이름 기준 검색
	void searchHouseInfoByAptName(String aptName);

	void searchHouseInfoByBuildYear(double min, double max);

	void insertHouseInfo(House h);

}