package com.ssafy.happyhouse.model.dao;

import com.ssafy.happyhouse.model.dto.LoginDto;
import com.ssafy.happyhouse.model.dto.UserDto;
import com.ssafy.happyhouse.model.dto.UserBeforeChangePasswordDto;
import com.ssafy.happyhouse.model.dto.UserChangePasswordDto;


public interface UserDao {
	 
	// 로그인
	public UserDto login(UserDto vo);

	// 회원가입
	public int join(UserDto vo);
	
	// 내 정보 보기
	public UserDto myPage(String userId);
	
	// 회원 정보 수정
	public int memberUpdate(UserDto vo);
	
	// 유저 탈퇴 
	public int memberWithdraw(LoginDto dto);
	
	// 비밀번호 변경 전 아이디, 이메일 검사
	public int checkInfo(UserBeforeChangePasswordDto dto);

	// 비밀번호 변경
	public int updatePassword(LoginDto vo);
	
	// 아이디 찾기
	public String findUserId(UserDto vo);
	
	// 비밀번호 중복검사(VO 형)
	public int checkPassword(LoginDto vo);
	
	// 아이디 중복검사 (int 형)
	public int checkUserId(String id);
}

