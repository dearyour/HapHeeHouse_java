package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.HouseInfoRequestDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.service.HouseMapService;
import com.ssafy.happyhouse.model.service.HouseRentService;

@RequestMapping("/map")
@RestController
public class HouseMapController{
	
	private HouseMapService houseMapService;
	@Autowired
	public void setHouseMapService(HouseMapService houseMapService) {
		this.houseMapService = houseMapService;
	}
	
	private HouseRentService houseRentService;
	@Autowired
	public void setHouseRentService(HouseRentService houseRentService) {
		this.houseRentService = houseRentService;
	}
	
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> getSido() throws Exception{
		System.out.println("sido");
		return ResponseEntity.ok(houseMapService.getSido());
	}
	
	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunCodeDto>> getGugunInSido(@RequestParam("sido") String sido) throws Exception {
		return ResponseEntity.ok(houseMapService.getGugunInSido(sido));
	}
	
	@GetMapping("/dong")
	public ResponseEntity<List<HouseInfoDto>> getDongInGugun(@RequestParam("gugun") String gugun) throws Exception {
		return ResponseEntity.ok(houseMapService.getDongInGugun(gugun));
	}
	
	@GetMapping("/{type}/{deal_type}")
	public ResponseEntity<List<HouseInfoDto>> getAptInDong(@PathVariable String type, @PathVariable String deal_type, @ModelAttribute HouseInfoRequestDto requestDto) throws Exception {
		if ("deal".equals(type))
			return ResponseEntity.ok(houseMapService.getApt(requestDto));
		else if ("apartment".equals(deal_type)){
			return ResponseEntity.ok(houseRentService.getApt(requestDto));
		} else {
			return ResponseEntity.ok(houseRentService.getNotApt(requestDto));
		}
	}
	
	@GetMapping("/apt-gugun")
	public ResponseEntity<List<HouseInfoDto>> getAptInGugun(@RequestParam("gugun") String gugun) throws Exception {
		return ResponseEntity.ok(houseMapService.getAptInGugun(gugun));
	}

}