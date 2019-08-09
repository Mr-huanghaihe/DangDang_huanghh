package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;

public interface AdminService {
	/**
	 * 后台管理员登录
	 * @param admin
	 */
	public void login(Admin admin);
	public List<User> queryAllUser();
	public void modifyStatus(String id);
	public List<Order> queryAllOrder();
	public Order queryOneOrder(String id);
	public List<Item> queryAllItem(String id);
}
