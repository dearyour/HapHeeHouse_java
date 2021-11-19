package com.ssafy.happyhouse.model.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MemberDto {
	
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String tel;
	private String email;
	private String address;
}
