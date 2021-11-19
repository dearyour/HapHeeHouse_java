package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dao.HouseInfoDAO;
import com.ssafy.happyhouse.model.dto.House;

public class HouseInfoServiceImpl implements HouseInfoService {
	private static HouseInfoService houseInfoService = new HouseInfoServiceImpl();
	private HouseInfoDAO houseinfoDao;
	
	public HouseInfoServiceImpl() {
		
	}

	@Override
	public void searchAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchHouseInfoBySido(String sido) {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchHouseInfoByGugun(String gugun) {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchHouseInfoByDong(String dong) {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchHouseInfoByAptName(String aptName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchHouseInfoByBuildYear(double min, double max) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertHouseInfo(House h) {
		// TODO Auto-generated method stub

	}

}
