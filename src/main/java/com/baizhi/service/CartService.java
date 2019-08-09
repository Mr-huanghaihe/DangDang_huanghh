package com.baizhi.service;

public interface CartService {
	public void addCart(String id);
	public void updateCart(String id,Integer count);
	public void deleteCart(String id);
	public void recoverCart(String id);
	public void removeCart(String[] ids);
}
