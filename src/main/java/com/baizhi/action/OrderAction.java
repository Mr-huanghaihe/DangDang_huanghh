package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.service.AddressService;
import com.baizhi.service.impl.AddressServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport{
	private List<Address> list;
	private String id;
	private Address address;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Address> getList() {
		return list;
	}
	public void setList(List<Address> list) {
		this.list = list;
	}

	AddressService as=new AddressServiceImpl();
	public String allAddress(){
		list=as.selectAll();
		return Action.SUCCESS;
	}
	public String oneAddress(){
		list=as.selectAll();
		address=as.selectOne(id);
		return Action.SUCCESS;
	}
	public String addOrderItem(){
		as.addOrder(address);
		return Action.SUCCESS;
	}
}
