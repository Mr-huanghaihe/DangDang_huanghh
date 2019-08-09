package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao {
	public User loginUser(String email);
	public void insertUser(User user);
	public void updateActiveCode(User user);
}
