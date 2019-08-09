package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.entity.Book;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;

public interface AddressDao {
	/**
	 * @param id 用户id 
	 * @return 根据用户id查询到的所有的地址集合
	 */
	public List<Address> selectAll(String id);
	/**
	 * @param id 根据id查询一个地址
	 * @return 根据id查询到的地址
	 */
	public Address selectOne(String id);
	/**
	 * @param a 需要添加的地址对象
	 */
	public void insertAddress(Address a);
	/**
	 * @param a 需要修改的地址对象
	 */
	public void updateAddress(Address a);
	/**
	 * @param order 添加一个订单对象
	 */
	public void insertOneOrder(Order order);
	/**
	 * @param item 添加一个订单项
	 */
	public void insertOneItem(Item item);
	/**
	 * @param book 修改图书对象
	 */
	public void updateBook(Book book);
}
