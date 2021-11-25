package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.HouseRentDealDAO;
import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.dto.HouseRentDealInsertDto;

@Service
public class HouseRentDealServiceImpl implements HouseRentDealService {

	private HouseRentDealDAO houseRentDealDAO;
	@Autowired
	public void setHouseInfoDealDAO(HouseRentDealDAO houseRentDealDAO) {
		this.houseRentDealDAO = houseRentDealDAO;
	}
	
	@Override
	public int inserDeal(HouseRentDealInsertDto dto) {
		return houseRentDealDAO.insert(dto);
	}
	
	@Override
	public List<HouseDealDto> searchRentDealInfoByAptCode(int aptCode) {
		return houseRentDealDAO.searchByAptCode(aptCode);
	}

}
