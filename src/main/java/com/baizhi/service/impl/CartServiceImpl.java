package com.baizhi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.CartItem;
import com.baizhi.service.CartService;
import com.baizhi.utils.MybatisUtils;

public class CartServiceImpl implements CartService{

	@Override
	public void addCart(String id) {
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		Book book=bd.selectById(id);
		HttpSession session=ServletActionContext.getRequest().getSession();
		Map<String,CartItem> map=null;
		Double save=0.0;
		Double total=0.0;
		map=(Map<String, CartItem>) session.getAttribute("cart");
		if(map==null){
			map=new HashMap<String,CartItem>();
			CartItem item=new CartItem();
			item.setBook(book);
			item.setCount(1);
			map.put(id, item);
			save=book.getPrice()-book.getDprice();
			total=book.getDprice();
			
		}else{
			if(map.containsKey(id)){
				CartItem item=map.get(id);
				item.setCount(item.getCount()+1);
				map.put(id, item);
			}else{
				CartItem item=new CartItem();
				item.setBook(book);
				item.setCount(1);
				map.put(id, item);
			}
			save=(Double) session.getAttribute("save");
			total=(Double) session.getAttribute("total");
			save=save+book.getPrice()-book.getDprice();
			total=total+book.getDprice();
		}
		session.setAttribute("cart", map);
		session.setAttribute("save", save);
		session.setAttribute("total", total);
		MybatisUtils.close();
	}

	@Override
	public void updateCart(String id, Integer count) {
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		Book book=bd.selectById(id);
		HttpSession session=ServletActionContext.getRequest().getSession();
		Map<String,CartItem> map=(Map<String, CartItem>) session.getAttribute("cart");
		CartItem item=map.get(id);
		Integer oldCount=item.getCount();
		Double save=(Double) session.getAttribute("save");
		Double total=(Double) session.getAttribute("total");
		item.setCount(count);
		save=save-(book.getPrice()-book.getDprice())*oldCount;
		save=save+(book.getPrice()-book.getDprice())*count;
		total=total-book.getDprice()*oldCount;
		total=total+book.getDprice()*count;
		map.put(id, item);
		session.setAttribute("cart", map);
		session.setAttribute("save", save);
		session.setAttribute("total", total);
		MybatisUtils.close();
	}

	@Override
	public void deleteCart(String id) {
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		Book book=bd.selectById(id);
		HttpSession session=ServletActionContext.getRequest().getSession();
		Map<String,CartItem> map=(Map<String, CartItem>) session.getAttribute("cart");
		CartItem item=map.get(id);
		item.setStatus(0);
		Integer oldCount=item.getCount();
		double save=(Double) session.getAttribute("save");
		double total=(Double) session.getAttribute("total");
		save=save-(book.getPrice()-book.getDprice())*oldCount;
		total=total-book.getDprice()*oldCount;
		map.remove(id);
		if(map.size()==0){
			session.removeAttribute("cart");
		}else{
			session.setAttribute("cart", map);
		}
		session.setAttribute("cart", map);
		session.setAttribute("save", save);
		session.setAttribute("total", total);
		MybatisUtils.close();
	}

	@Override
	public void recoverCart(String id) {
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		Book book=bd.selectById(id);
		HttpSession session=ServletActionContext.getRequest().getSession();
		Map<String,CartItem> map=(Map<String, CartItem>) session.getAttribute("cart");
		CartItem item=map.get(id);
		item.setStatus(1);
		Integer oldCount=item.getCount();
		double save=(Double) session.getAttribute("save");
		double total=(Double) session.getAttribute("total");
		save=save+(book.getPrice()-book.getDprice())*oldCount;
		total=total+book.getDprice()*oldCount;
		session.setAttribute("cart", map);
		session.setAttribute("save", save);
		session.setAttribute("total", total);
		MybatisUtils.close();
	}

	@Override
	public void removeCart(String[] ids) {
		HttpSession session=ServletActionContext.getRequest().getSession();
		Map<String,CartItem> map=(Map<String, CartItem>) session.getAttribute("cart");
		for (String id : ids) {
			CartItem item=map.get(id);
			if(item.getStatus()==0){
				map.remove(id);
				if(map.size()==0){
					session.removeAttribute("cart");
				}else{
					session.setAttribute("cart", map);
				}
			}
		}
	}	
}
