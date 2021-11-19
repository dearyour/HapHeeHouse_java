package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.HouseDealDto;
import com.ssafy.happyhouse.model.service.HouseDealService;

@RequestMapping("/deal")
@RestController
public class HouseDealController {
	
	private HouseDealService houseDealService;
	@Autowired
	public void setHouseDealService(HouseDealService houseDealService) {
		this.houseDealService = houseDealService;
	}
	
	@GetMapping("/apt")
	public ResponseEntity<List<HouseDealDto>> searchDealInfoByAptCode(@RequestParam("aptCode") int aptCode) {
		System.out.println("apt");
		return ResponseEntity.ok(houseDealService.searchDealInfoByAptCode(aptCode));
	}
	
//	@GetMapping("/login-check")
//	public ResponseEntity<Integer> login(HttpSession session) {
//		System.out.println(session.getAttribute("userInfo"));
//		if (session.getAttribute("userInfo") != null)
//			return ResponseEntity.ok(1);
//		else
//			return ResponseEntity.ok(0);
//	}
}
