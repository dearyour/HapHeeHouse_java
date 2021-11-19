package com.ssafy.happyhouse.model.dto;

public class PageInfo {
	private String url;
	private boolean isForward;
	
	public PageInfo(String url, boolean isForward) {
		super();
		this.url = url;
		this.isForward = isForward;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isForward() {
		return isForward;
	}
	public void setForward(boolean isForward) {
		this.isForward = isForward;
	}
	
	
}
