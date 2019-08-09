package com.baizhi.entity;

import java.io.Serializable;

public class CartItem implements Serializable{
	private Book book;
	private Integer count;
	private Integer status=1;
	
	
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public CartItem(Book book, Integer count) {
		super();
		this.book = book;
		this.count = count;
	}
	public CartItem() {
		super();
	}
	
}
