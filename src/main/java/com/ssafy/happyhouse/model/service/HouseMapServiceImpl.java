package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.HouseMapDAO;
import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.HouseInfoMinMaxAreaDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;

@Service
public class HouseMapServiceImpl implements HouseMapService {
	
	private HouseMapDAO houseMapDao;
	@Autowired
	public void setHouseMapDao(HouseMapDAO houseMapDao) {
		this.houseMapDao = houseMapDao;
	}

	@Override
	public List<SidoGugunCodeDto> getSido() {
		return houseMapDao.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) {
		return houseMapDao.getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) {
		return houseMapDao.getDongInGugun(gugun);
	}
 
	@Override
	public List<HouseInfoDto> getAptInDong(HouseInfoMinMaxAreaDto dto) {
//		return houseMapDao.getAptInDong(dong);
		return houseMapDao.getAptInDongAndArea(dto);
	}
	
	@Override
	public List<HouseInfoDto> getAptInGugun(String gugun) {
		return houseMapDao.searchHouseInfoByGugun(gugun);
	}

}
