package com.baizhi.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AddressDao;
import com.baizhi.dao.BookDao;
import com.baizhi.entity.Address;
import com.baizhi.entity.Book;
import com.baizhi.entity.CartItem;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;
import com.baizhi.service.AddressService;
import com.baizhi.utils.MybatisUtils;

public class AddressServiceImpl implements AddressService{

	@Override
	public List<Address> selectAll() {
		AddressDao ad=(AddressDao) MybatisUtils.getMapper(AddressDao.class);
		HttpSession session=ServletActionContext.getRequest().getSession();
		User user=(User) session.getAttribute("loginUser");
		List<Address> list=ad.selectAll(user.getId());
		MybatisUtils.close();
		return list;
	}

	@Override
	public Address selectOne(String id) {
		AddressDao ad=(AddressDao) MybatisUtils.getMapper(AddressDao.class);
		Address address=ad.selectOne(id);
		MybatisUtils.close();
		return address;
	}

	@Override
	public void addOrder(Address address) {
		
		AddressDao ad=(AddressDao) MybatisUtils.getMapper(AddressDao.class);
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		HttpSession session=ServletActionContext.getRequest().getSession();
		User user=(User) session.getAttribute("loginUser");
		try {
			Address a=null;
			a=ad.selectOne(address.getId());
			if(a==null){
				address.setId(UUID.randomUUID().toString());
				address.setUser_id(user.getId());
				ad.insertAddress(address);
			}else{
				if(!a.equals(address)){
					ad.updateAddress(address);
				}
			}
			//测试地址
			//System.out.println(address);
			Double total=(Double) session.getAttribute("total");
			Order order=new Order();
			Date date=new Date();
			order.setId(UUID.randomUUID().toString());
			order.setOrder_no(String.valueOf(date.getTime()));
			order.setAddress_id(address.getId());
			order.setCreate_date(date);
			order.setTotal(total);
			order.setUser_id(user.getId());
			ad.insertOneOrder(order);
			//测试订单
			System.out.println(order);
			Map<String,CartItem> map=(Map<String, CartItem>) session.getAttribute("cart");
			Set<String> set=map.keySet();
			for (String id : set) {
				CartItem c=map.get(id);
				Item i=new Item();
				i.setId(UUID.randomUUID().toString());
				i.setBook_id(id);
				i.setCount(c.getCount());
				i.setCreate_date(date);
				i.setOrder_id(order.getId());
				ad.insertOneItem(i);
				//测试订单项
				//System.out.println(i);
				Book book=bd.selectById(id);
				book.setSale(book.getSale()+c.getCount());
				book.setStock(book.getStock()-c.getCount());
				ad.updateBook(book);
				//测试图书
				//System.out.println(book);
			}
			session.setAttribute("order_no", order.getOrder_no());
			session.removeAttribute("cart");
			MybatisUtils.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtils.rollback();
			throw new RuntimeException("添加异常！");
		}
	}
}
