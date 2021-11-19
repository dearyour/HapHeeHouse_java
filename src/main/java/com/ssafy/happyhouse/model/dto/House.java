package com.ssafy.happyhouse.model.dto;

public class House {
	private String sido;
	private String gugun;
	private String dong;
	private String name;
	private String jibun;
	private int buildYear;
	private double lat;
	private double lng;
	private String imgSrc;
	
	public House(String sido, String gugun, String dong, String name, String jibun, int buildYear) {
		super();
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.name = name;
		this.jibun = jibun;
		this.buildYear = buildYear;
	}

	public House(String sido, String gugun, String dong, String name, String jibun, 
			int buildYear, double lat, double lng, String imgSrc) {
		this(sido, gugun, dong, name, jibun, buildYear);
		this.lat = lat;
		this.lng = lng;
		this.imgSrc = imgSrc;
	}
		
	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJibun() {
		return jibun;
	}
	
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	
	public int getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	@Override
	public String toString() {
		return "주소: " + sido + " " + gugun + " " + dong
				+ " " + name + " " + jibun + "\t준공년도: " + buildYear;
	}
}
