package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.HouseRentDAO;
import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.HouseInfoRequestDto;
import com.ssafy.happyhouse.model.dto.HouseRentDealInsertDto;

@Service
public class HouseRentServiceImpl implements HouseRentService{

	private HouseRentDAO houseRentDAO;
	@Autowired
	public void setHouseDAO(HouseRentDAO houseRentDAO) {
		this.houseRentDAO = houseRentDAO;
	}
	@Override
	public int getAptCode(HouseRentDealInsertDto dto) {
		Integer result = houseRentDAO.getAptCode(dto);
		return result == null ? 0 : result;
	}
	@Override
	public int insert(HouseRentDealInsertDto dto) {
		return houseRentDAO.insert(dto);
	}
	@Override
	public List<HouseInfoDto> getApt(HouseInfoRequestDto dto) {
		return houseRentDAO.getApt(dto);
	}
	@Override
	public List<HouseInfoDto> getNotApt(HouseInfoRequestDto dto) {
		return houseRentDAO.getNotApt(dto);
	}
}
