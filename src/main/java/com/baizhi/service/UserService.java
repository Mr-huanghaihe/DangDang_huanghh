package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
	public void loginUser(User user);
	public void register(User user,String code);
	public void updateActiveCode(String activeCode);
}
