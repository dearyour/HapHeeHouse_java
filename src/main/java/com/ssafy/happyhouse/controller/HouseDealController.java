package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.service.HouseDealService;
import com.ssafy.happyhouse.model.service.HouseRentDealService;

@RequestMapping("/history")
@RestController
public class HouseDealController {
	
	private HouseDealService houseDealService;
	@Autowired
	public void setHouseDealService(HouseDealService houseDealService) {
		this.houseDealService = houseDealService;
	}
	
	private HouseRentDealService houseRentDealService;
	@Autowired
	public void setHouseRentDealService(HouseRentDealService houseRentDealService) {
		this.houseRentDealService = houseRentDealService;
	}
	
	@GetMapping("/deal")
	public ResponseEntity<List<HouseDealDto>> searchForSaleByAptCode(@RequestParam("aptCode") int aptCode) {
		System.out.println("for-sale");
		return ResponseEntity.ok(houseDealService.searchDealInfoByAptCode(aptCode));
	}
	
	@GetMapping("/rent")
	public ResponseEntity<List<HouseDealDto>> searchToLetByAptCode(@RequestParam("aptCode") int aptCode) {
		System.out.println("to-let");
		return ResponseEntity.ok(houseRentDealService.searchRentDealInfoByAptCode(aptCode));
	}
	
//	@GetMapping("/all")
//	public ResponseEntity<List<HouseDealDto>> searchAllByAptCode(@RequestParam("aptCode") int aptCode) {
//		System.out.println("all");
//		return ResponseEntity.ok(Stream.concat(houseRentDealService.searchRentDealInfoByAptCode(aptCode).stream()
//				, houseDealService.searchDealInfoByAptCode(aptCode).stream())
//				.collect(Collectors.toList()));
//	}
	
//	@GetMapping("/login-check")
//	public ResponseEntity<Integer> login(HttpSession session) {
//		System.out.println(session.getAttribute("userInfo"));
//		if (session.getAttribute("userInfo") != null)
//			return ResponseEntity.ok(1);
//		else
//			return ResponseEntity.ok(0);
//	}
}
