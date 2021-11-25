package com.ssafy.happyhouse.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dao.LoginDao;
import com.ssafy.happyhouse.model.dto.UserDtos;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDao loginDao;
	
	@Override
	public UserDtos login(UserDtos dto) {
		System.out.println(dto);
		UserDtos userDtos = loginDao.login(dto.getUserEmail());
		
		if( userDtos != null && userDtos.getUserPassword().equals(dto.getUserPassword())) {
			return userDtos;
		}else {
			return null;
		}
	}
}