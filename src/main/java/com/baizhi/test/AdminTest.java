package com.baizhi.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.dao.AdminDao;
import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.service.impl.CategoryServiceImpl;
import com.baizhi.utils.MybatisUtils;

public class AdminTest {
	@Test
	public void test(){
		AdminDao dao=(AdminDao)MybatisUtils.getMapper(AdminDao.class);
		Admin a=dao.login("admin");
		System.out.println(a);
	}
	@Test
	public void test1(){
		CategoryDao ca=(CategoryDao)MybatisUtils.getMapper(CategoryDao.class);
		List<Category> list=ca.selectAll();
		for (Category category : list) {
			System.out.println(category);
		}
	}
	@Test
	public void Test2(){
		CategoryDao ca=(CategoryDao)MybatisUtils.getMapper(CategoryDao.class);
		List<Category> list=ca.selectAllFirst();
		for (Category category : list) {
			System.out.println(category);
		}
	}
	@Test
	public void Test3(){
		CategoryService cs=new CategoryServiceImpl();
		List<Category> list=cs.queryAllFirst();
		for (Category category : list) {
			System.out.println(category);
		}
	}
	@Test
	public void Test4(){
		CategoryService cs=new CategoryServiceImpl();
		cs.removeOne("4e80b6d2-8ab9-4c28-8508-d603abf62c87");
	}
}
