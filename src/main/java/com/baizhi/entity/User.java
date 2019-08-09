package com.baizhi.entity;

import java.io.Serializable;

public class User implements Serializable{
	private String id;
	private String email;
	private String password;
	private String nickname;
	private String salt;
	private String status;
	private String code;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public User(String id, String email, String password, String nickname,
			String salt, String status, String code) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.salt = salt;
		this.status = status;
		this.code = code;
	}
	public User() {
		super();
	}
}
