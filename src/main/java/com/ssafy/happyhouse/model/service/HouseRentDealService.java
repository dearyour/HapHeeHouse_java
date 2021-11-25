package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.dto.HouseRentDealInsertDto;
import java.util.List;

public interface HouseRentDealService {
	int inserDeal(HouseRentDealInsertDto dto);
	List<HouseDealDto> searchRentDealInfoByAptCode(int aptCode);
}
