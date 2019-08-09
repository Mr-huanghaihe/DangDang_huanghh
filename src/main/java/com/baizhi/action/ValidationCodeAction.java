package com.baizhi.action;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.utils.SecurityCode;
import com.baizhi.utils.SecurityImage;
import com.opensymphony.xwork2.ActionSupport;

public class ValidationCodeAction extends ActionSupport{
	public String getCode(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String code=SecurityCode.getSecurityCode();
		session.setAttribute("code",code);
		BufferedImage image=SecurityImage.createImage(code);
		ServletOutputStream stream=null;
		try {
			stream=ServletActionContext.getResponse().getOutputStream();
			ImageIO.write(image,"png",stream);
		} catch (Exception e) {}
		return null;
	}
	
}
