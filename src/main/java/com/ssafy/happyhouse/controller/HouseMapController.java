package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.HouseInfoMinMaxAreaDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.service.HouseMapService;

@RequestMapping("/map")
@RestController
public class HouseMapController{
	
	private HouseMapService houseMapService;
	@Autowired
	public void setHouseMapService(HouseMapService houseMapService) {
		this.houseMapService = houseMapService;
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
	
	@GetMapping("/apt")
	public ResponseEntity<List<HouseInfoDto>> getAptInDong(@RequestParam("dong") String dong, @RequestParam("min") int minArea, @RequestParam("max") int maxArea) throws Exception {
		return ResponseEntity.ok(houseMapService.getAptInDong(new HouseInfoMinMaxAreaDto(dong, minArea, maxArea)));
	}
	
	@GetMapping("/apt-gugun")
	public ResponseEntity<List<HouseInfoDto>> getAptInGugun(@RequestParam("gugun") String gugun) throws Exception {
		return ResponseEntity.ok(houseMapService.getAptInGugun(gugun));
	}

}