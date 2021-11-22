package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.HouseInfoRequestDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;

public interface HouseMapService {
	 
	List<SidoGugunCodeDto> getSido();
	List<SidoGugunCodeDto> getGugunInSido(String sido);
	List<HouseInfoDto> getDongInGugun(String gugun);
	List<HouseInfoDto> getApt(HouseInfoRequestDto dto);
	List<HouseInfoDto> getAptInGugun(String gugun);
}
