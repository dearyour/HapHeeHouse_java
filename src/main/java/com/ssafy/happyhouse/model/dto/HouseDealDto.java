package com.ssafy.happyhouse.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HouseDealDto {
	private int no;
	@NonNull
	private int aptCode;
	private String aptName;
	private String dealAmount;
	private int dealYear;
	private int dealMonth;
	private int dealDay;
	private String area;
	private String floor;
	private String type;	
	
	// HouseRent에만 있는 column
	private String rentMoney;
	private String deposit;
	private int rentTypeCode;
	private String rentTypeName;
}
