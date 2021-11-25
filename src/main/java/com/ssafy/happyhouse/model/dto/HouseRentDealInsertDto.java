package com.ssafy.happyhouse.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HouseRentDealInsertDto {
	private int aptCode;
	// 법정동코드
	private String dongCode;
	// 자치구명
	private String gugunName;
	// 건물명
	private String aptName;
	// 법정동명
	private String dongName;
	// 건축년도
	private int buildYear;
	// 본번
	private String jibun;

	// 임대건물코드
	private int houseTypeCode;
	// 임대건물명
	private String houseTypeName;
	// 계약금액
	private String dealAmount;
	// 계약일자
	private int dealYear;
	private int dealMonth;
	private int dealDay;
	// 층수
	private String floor;
	// 면적
	private String area;
	// 전월세코드
	private int rentTypeCode;
	// 전월세구분
	private String rentTypeName;
	//보증금
	private String deposit;
	// 임대료
	private String rentMoney;

}
