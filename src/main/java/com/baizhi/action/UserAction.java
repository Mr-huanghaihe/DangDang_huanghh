package com.baizhi.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.UserServiceImpl;
import com.baizhi.utils.MD5Utils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private User user;
	private String message;
	private String code;
	private String activeCode;
	
	
	public String getActiveCode() {
		return activeCode;
	}
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	UserService us=new UserServiceImpl();
	HttpSession session=ServletActionContext.getRequest().getSession();
	
	public String loginUser(){
		try {
			us.loginUser(user);
			return Action.SUCCESS;
		} catch (Exception e) {
			message=e.getMessage();
			return Action.ERROR;
		}
	}
	public String registerUser(){
		try {
			us.register(user, code);
			return Action.SUCCESS;
		} catch (Exception e) {
			message=e.getMessage();
			return Action.ERROR;
		}
	}
	public String activeCode(){
		String active=MD5Utils.getNum();
		session.setAttribute("activeCode", active);
		return Action.SUCCESS;
	}
	public String modifyActiveCode(){
		try {
			us.updateActiveCode(activeCode);
			return Action.SUCCESS;
		} catch (Exception e) {
			message=e.getMessage();
			return Action.ERROR;
		}
	}
	public String exit(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.removeAttribute("cart");
		session.invalidate();
		return Action.SUCCESS;
	}
}
