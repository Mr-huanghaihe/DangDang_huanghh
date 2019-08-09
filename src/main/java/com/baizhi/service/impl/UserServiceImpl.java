package com.baizhi.service.impl;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.utils.MD5Utils;
import com.baizhi.utils.MybatisUtils;

public class UserServiceImpl implements UserService{

	@Override
	public void loginUser(User user) {
		UserDao ud=(UserDao) MybatisUtils.getMapper(UserDao.class);
		User u=null;
		u=ud.loginUser(user.getEmail());
		if(u==null)throw new RuntimeException("该用户不存在!");
		String password=user.getPassword()+u.getSalt();
		String pass=MD5Utils.getPassword(password);
		if(!pass.equals(u.getPassword()))throw new RuntimeException("密码错误！");
		if(u.getStatus().equals("冻结"))throw new RuntimeException("该用户已被冻结！");
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("loginUser", u);
		MybatisUtils.close();
	}

	@Override
	public void register(User user, String code) {
		UserDao ud=(UserDao) MybatisUtils.getMapper(UserDao.class);
		HttpSession session=ServletActionContext.getRequest().getSession();
		String vdcode=(String) session.getAttribute("code");
		if(!code.equals(vdcode))throw new RuntimeException("验证码错误！");
		User u=ud.loginUser(user.getEmail());
		if(u!=null)throw new RuntimeException("该用户已存在！");
		try {
			user.setId(UUID.randomUUID().toString());
			user.setStatus("正常");
			String salt=MD5Utils.getSalt();
			String password=user.getPassword()+salt;
			String pass=MD5Utils.getPassword(password);
			user.setPassword(pass);
			user.setSalt(salt);
			ud.insertUser(user);
			session.setAttribute("loginUser", user);
			MybatisUtils.commit();
		} catch (Exception e) {
			MybatisUtils.rollback();
		}
	}

	@Override
	public void updateActiveCode(String activeCode) {
		UserDao ud=(UserDao) MybatisUtils.getMapper(UserDao.class);
		HttpSession session=ServletActionContext.getRequest().getSession();
		String code=(String) session.getAttribute("activeCode");
		if(!code.equals(activeCode))throw new RuntimeException("激活码错误！");
		User u=(User) session.getAttribute("loginUser");
		u.setCode(activeCode);
		try {
			ud.updateActiveCode(u);
			session.setAttribute("loginUser", u);
			MybatisUtils.commit();
		} catch (Exception e) {
			MybatisUtils.rollback();
		}
	}
}
