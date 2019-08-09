package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressService {
	/**
	 * @return 根据登陆的用户的id查询该id对应的所有的地址
	 */
	public List<Address> selectAll();
	/**
	 * @param id 地址的id
	 * @return 根据地址的id查询到的地址对象
	 */
	public Address selectOne(String id);
	public void addOrder(Address address);
}
