package com.ssafy.happyhouse.model.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDto {
	
	private String userid;
	private String userpwd;
	private String name;
	private String email;
	private String address;
}
