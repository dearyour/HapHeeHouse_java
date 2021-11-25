//package com.ssafy.happyhouse.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ssafy.happyhouse.model.dto.HouseRentDealInsertDto;
//import com.ssafy.happyhouse.model.service.HouseRentDealService;
//import com.ssafy.happyhouse.model.service.HouseRentService;
//
//@RequestMapping("/houseInfoDeal")
//@RestController
//public class HouseInfoDealController {
//	
//	private HouseRentDealService houseRentDealService;
//	@Autowired
//	public void setHouseInfoDealService(HouseRentDealService houseInfoDealService) {
//		this.houseRentDealService = houseInfoDealService;
//	}
//	
//	private HouseRentService houseService;
//	@Autowired
//	public void setHouseInfoService(HouseRentService houseService) {
//		this.houseService = houseService;
//	}
//	@PostMapping("/")
//	public ResponseEntity<Integer> insertDeal(@ModelAttribute HouseRentDealInsertDto dto) {
//		int aptCode = houseService.getAptCode(dto);
//		if (aptCode == 0) {
//			aptCode = houseService.insert(dto);
//		}
//		dto.setAptCode(aptCode);
//		return ResponseEntity.ok(houseRentDealService.inserDeal(dto));
//	}
//}
