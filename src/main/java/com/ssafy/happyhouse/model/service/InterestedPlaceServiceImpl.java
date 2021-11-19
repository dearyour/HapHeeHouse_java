package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dao.InterestedPlaceDAO;

public class InterestedPlaceServiceImpl implements InterestedPlaceService {
	private static InterestedPlaceService interestedPlaceService = new InterestedPlaceServiceImpl();
	private InterestedPlaceDAO interestedPlaceDAO;
	
	
	
	@Override
	public void selectAllPlace() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isExistingUser(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void placeUp(String userid, String gugunCode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyPlaceInfo(String userid, String oldGugunCode, String newGugunCode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePlaceInfo(String userid, String guguncode) {
		// TODO Auto-generated method stub

	}

}
