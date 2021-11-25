package com.ssafy.happyhouse.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.dto.HouseRentDealInsertDto;

@Repository
public interface HouseRentDealDAO {
	int insert(HouseRentDealInsertDto dto);
	List<HouseDealDto> searchByAptCode(int aptCode);
}
