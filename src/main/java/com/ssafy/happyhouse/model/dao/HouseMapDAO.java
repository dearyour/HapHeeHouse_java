package com.ssafy.happyhouse.model.dao;

import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.HouseInfoRequestDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;

public interface HouseMapDAO {

	List<SidoGugunCodeDto> getSido();
	List<SidoGugunCodeDto> getGugunInSido(String sido);
	List<HouseInfoDto> getDongInGugun(String gugun);
	List<HouseInfoDto> getApt(HouseInfoRequestDto dto);
	
	List<HouseInfoDto> searchHouseInfoBySido(String sido);
	List<HouseInfoDto> searchHouseInfoByGugun(String gugun);
	List<HouseInfoDto> searchHouseInfoByBuildYear(double min, double max);
	List<HouseInfoDto> insertHouseInfo(HouseInfoDto h);
}
