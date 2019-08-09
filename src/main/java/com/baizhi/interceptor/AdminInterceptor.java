package com.baizhi.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Admin;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		Admin admin=null;
		admin=(Admin)session.getAttribute("loginAdmin");
		if(admin==null){
			return "login";
		}else{
			ai.invoke();
		}
		return null;
	}
}
