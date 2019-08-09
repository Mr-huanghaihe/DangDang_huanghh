package com.baizhi.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;
import com.baizhi.service.AdminService;
import com.baizhi.utils.MybatisUtils;

public class AdminServiceImpl implements AdminService{

	@Override
	public void login(Admin admin) {
		AdminDao dao=(AdminDao)MybatisUtils.getMapper(AdminDao.class);
		HttpSession session=ServletActionContext.getRequest().getSession();
		Admin a=null;
		a=dao.login(admin.getUsername());
		if(a==null)throw new RuntimeException("该用户不是管理员！");
		if(!a.getPassword().equals(admin.getPassword()))throw new RuntimeException("您输入的密码有误！");
		session.setAttribute("loginAdmin", a);
		MybatisUtils.close();
	}

	@Override
	public List<User> queryAllUser() {
		AdminDao dao=(AdminDao)MybatisUtils.getMapper(AdminDao.class);
		List<User> list=dao.selectAll();
		MybatisUtils.close();
		return list;
	}

	@Override
	public void modifyStatus(String id) {
		AdminDao dao=(AdminDao)MybatisUtils.getMapper(AdminDao.class);
		User u=dao.selectOne(id);
		try {
			if(u.getStatus().equals("正常")){
				u.setStatus("冻结");
			}else{
				u.setStatus("正常");
			}
			dao.updateStatus(u);
			MybatisUtils.commit();
		} catch (Exception e) {
			MybatisUtils.rollback();
		}
	}

	@Override
	public List<Order> queryAllOrder() {
		AdminDao dao=(AdminDao)MybatisUtils.getMapper(AdminDao.class);
		List<Order> list=dao.selectAllOrder();
		MybatisUtils.close();
		return list;
	}

	@Override
	public Order queryOneOrder(String id) {
		AdminDao dao=(AdminDao)MybatisUtils.getMapper(AdminDao.class);
		Order order=dao.selectOneOrder(id);
		MybatisUtils.close();
		return order;
	}

	@Override
	public List<Item> queryAllItem(String id) {
		AdminDao dao=(AdminDao)MybatisUtils.getMapper(AdminDao.class);
		List<Item> list=dao.selectAllItem(id);
		MybatisUtils.close();
		return list;
	}
}