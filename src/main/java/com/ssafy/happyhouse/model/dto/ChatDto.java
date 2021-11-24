package com.ssafy.happyhouse.model.dto;

public class ChatDto {
	private String userid;
	private String message;
	private String send;
	private String avatar;
	private String color;
	private String date;
	public ChatDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChatDto [userid=" + userid + ", message=" + message + ", send=" + send + ", avatar=" + avatar
				+ ", color=" + color + ", date=" + date + "]";
	}
	public ChatDto(String userid, String message, String send, String avatar, String color, String date) {
		super();
		this.userid = userid;
		this.message = message;
		this.send = send;
		this.avatar = avatar;
		this.color = color;
		this.date = date;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSend() {
		return send;
	}
	public void setSend(String send) {
		this.send = send;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
