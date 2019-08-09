package com.baizhi.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.utils.MybatisUtils;

public class BookTest {
	@Test
	public void test1(){
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		List<Book> books=bd.selectAllBooks();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	@Test
	public void test2(){
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		Book book=new Book();
		bd.insertBook(book);
	}
	@Test
	public void test3(){
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		Book book=bd.selectById("2");
		System.out.println(book);
	}
}
