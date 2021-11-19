package com.ssafy.happyhouse.model.dao;

import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseDealDto;

public interface HouseDealDAO {

	void searchAll();

	// 시 기준 검색
	void searchDealInfoBySido(String sido);

	// 구 기준 검색
	void searchDealInfoByGugun(String gugun);

	// 동 기준 검색
	void searchDealInfoByDong(String dong);

	// 아파트 코드 기준 검색
	List<HouseDealDto> searchDealInfoByAptCode(int aptCode);

	// 금액 범위 기준 검색
	void searchDealInfoByDealAmount(int min, int max);

	// 준공년도 범위 기준 검색
	void searchDealInfoByBuildYear(int min, int max);

	// 거래일자 범위 기준 검색
	void searchDealInfoByDealDate(int minYear, int minMonth, int minDay, int maxYear, int maxMonth, int maxDay);

	// 너비 범위 기준 검색
	void searchDealInfoByArea(double min, double max);

}