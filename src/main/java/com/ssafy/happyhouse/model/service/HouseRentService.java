package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.HouseInfoRequestDto;
import com.ssafy.happyhouse.model.dto.HouseRentDealInsertDto;

public interface HouseRentService {
	int getAptCode(HouseRentDealInsertDto dto);
	int insert(HouseRentDealInsertDto dto);
	List<HouseInfoDto> getApt(HouseInfoRequestDto dto);
	List<HouseInfoDto> getNotApt(HouseInfoRequestDto dto);
}
