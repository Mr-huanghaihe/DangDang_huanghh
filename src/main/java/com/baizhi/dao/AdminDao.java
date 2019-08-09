package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;

public interface AdminDao {
	
	/**
	 * 后台管理员登录方法
	 * @param username 管理员名
	 * @return 查询出的管理员
	 */
	public Admin login(String username);
	public List<User> selectAll();
	public User selectOne(String id);
	public void updateStatus(User u);
	public List<Order> selectAllOrder();
	public List<Item> selectAllItem(String id);
	public Order selectOneOrder(String id);
}
