package com.ssafy.happyhouse.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.HouseInfoRequestDto;
import com.ssafy.happyhouse.model.dto.HouseRentDealInsertDto;

@Repository
public interface HouseRentDAO {
	Integer getAptCode(HouseRentDealInsertDto dto);
	int insert(HouseRentDealInsertDto dto);
	List<HouseInfoDto> getApt(HouseInfoRequestDto dto);
	List<HouseInfoDto> getNotApt(HouseInfoRequestDto dto);
}
