package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
	private String id;
	private String order_no;
	private String user_id;
	private Double total;
	private Date create_date;
	private String address_id;
	private Address address;
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getAddress_id() {
		return address_id;
	}
	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
	public Order(String id, String order_no, String user_id, Double total,
			Date create_date, String address_id) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.user_id = user_id;
		this.total = total;
		this.create_date = create_date;
		this.address_id = address_id;
	}
	public Order() {
		super();
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", order_no=" + order_no + ", user_id="
				+ user_id + ", total=" + total + ", create_date=" + create_date
				+ ", address_id=" + address_id + "]";
	}
	
}
