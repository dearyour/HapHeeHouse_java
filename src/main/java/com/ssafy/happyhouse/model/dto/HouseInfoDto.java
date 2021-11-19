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
public class HouseInfoDto {
	@NonNull
	private String aptCode;
	private String aptName;
	private int buildYear;
	private String dongCode;
	private String dongName;
	private String jibun;
	private String lat;
	private String lng;
	private String sidoName;
	private String gugunName;
	private String recentPrice;
	private String img;
}
