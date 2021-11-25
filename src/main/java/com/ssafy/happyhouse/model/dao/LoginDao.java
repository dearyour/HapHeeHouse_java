package com.ssafy.happyhouse.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.UserDtos;


@Mapper
public interface LoginDao {
	public UserDtos login(String userEmail);
}
