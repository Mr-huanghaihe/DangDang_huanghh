package com.baizhi.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		User user=null;
		user=(User) session.getAttribute("loginUser");
		if(user==null){
			return "login";
		}else{
			if(user.getCode()==null||"".equals(user.getCode())){
				return "active";
			}else{
				ai.invoke();
			}
		}
		return null;
	}
}
