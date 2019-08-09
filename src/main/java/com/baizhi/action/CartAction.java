package com.baizhi.action;

import com.baizhi.service.CartService;
import com.baizhi.service.impl.CartServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport{
	private String id;
	private Integer count;
	private String[] ids;
	
	
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	CartService cs=new CartServiceImpl();
	public String addCart(){
		cs.addCart(id);
		return Action.SUCCESS;
	}
	public String updateCart(){
		cs.updateCart(id, count);
		return Action.SUCCESS;
	}
	public String deleteCart(){
		cs.deleteCart(id);
		return Action.SUCCESS;
	}
	public String recoverCart(){
		cs.recoverCart(id);
		return Action.SUCCESS;
	}
	public String removeCart(){
		cs.removeCart(ids);
		return Action.SUCCESS;
	}
}
