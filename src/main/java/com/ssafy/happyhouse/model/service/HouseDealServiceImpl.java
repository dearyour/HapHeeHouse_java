package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.HouseDealDAO;
import com.ssafy.happyhouse.model.dto.HouseDealDto;

@Service
public class HouseDealServiceImpl implements HouseDealService {
	
	private HouseDealDAO houseDealDAO; 
	@Autowired
	public void setHouseDealDAO(HouseDealDAO houseDealDAO) {
		this.houseDealDAO = houseDealDAO;
	}

	@Override
	public void searchAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchDealInfoBySido(String sido) {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchDealInfoByGugun(String gugun) {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchDealInfoByDong(String dong) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<HouseDealDto> searchDealInfoByAptCode(int aptCode) {
		return houseDealDAO.searchDealInfoByAptCode(aptCode);
	}

	@Override
	public void searchDealInfoByDealAmount(int min, int max) {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchDealInfoByBuildYear(int min, int max) {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchDealInfoByDealDate(int minYear, int minMonth, int minDay, int maxYear, int maxMonth, int maxDay) {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchDealInfoByArea(double min, double max) {
		// TODO Auto-generated method stub

	}

}
