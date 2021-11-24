package com.ssafy.happyhouse.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.UserDao;
import com.ssafy.happyhouse.model.dto.LoginDto;
import com.ssafy.happyhouse.model.dto.UserBeforeChangePasswordDto;
import com.ssafy.happyhouse.model.dto.UserDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@Qualifier("msi")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private SqlSession sqlSession;
	
	
	
	@Override
	public UserDto login(UserDto userDto) throws Exception {
		if(userDto.getUserid() == null || userDto.getUserpwd() == null)
			return null;
		return sqlSession.getMapper(UserDao.class).login(userDto);
	}


	@Override
	public int join(UserDto vo) {
		return userDao.join(vo);
	}

	@Override
	public UserDto myPage(String userid) {
		return userDao.myPage(userid);
	}

	@Override
	public int checkPassword(LoginDto dto) {
		return userDao.checkPassword(dto);
	}
	
	@Override
	public String findUserId(UserDto dto) {
		return userDao.findUserId(dto);
	}

	@Override
	public int changePassword(LoginDto dto) {
		return userDao.updatePassword(dto);
	}
	
	@Override
	public int memberUpdate(UserDto vo) {
		return userDao.memberUpdate(vo);
	}

	@Override
	public int memberWithdraw(String userid, String userpwd) {
		return userDao.memberWithdraw(new LoginDto(userid, userpwd));
//	public int memberWithdraw(String userid) {
//		return userDao.memberWithdraw(userid);
	}

	@Override
	public int checkInfo(UserBeforeChangePasswordDto userFindPasswordDto) {
		return userDao.checkInfo(userFindPasswordDto);
	}
	
	@Override
	public int checkUserId(String userid) {
		return userDao.checkUserId(userid);
	}
	
}
