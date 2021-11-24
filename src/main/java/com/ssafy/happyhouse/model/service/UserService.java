package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dto.LoginDto;
import com.ssafy.happyhouse.model.dto.UserDto;
import com.ssafy.happyhouse.model.dto.UserBeforeChangePasswordDto;

public interface UserService { 
	
	//로그인
	public UserDto login(UserDto userDto) throws Exception;
	
	//회원가입
	public int join(UserDto vo);
	
	//아이디 찾기
	public String findUserId(UserDto vo);
	
	// 회원 정보 보기
	public UserDto myPage(String userId) throws Exception;
	
	// 회원 정보 수정
	public int memberUpdate(UserDto vo);
	
	// 회원 탈퇴
//	public int memberWithdraw(String userid);
	public int memberWithdraw(String userid, String userpwd);
	
	// 비밀번호 변경 전 아이디, 이메일, 이름 확인
	public int checkInfo(UserBeforeChangePasswordDto dto);
	
	// 비밀번호 변경
	public int changePassword(LoginDto dto);
	
	// 비밀번호 체크 - 회원 탈퇴
	public int checkPassword(LoginDto dto);
	
	// 아이디 체크
	public int checkUserId(String userid);
	
}
