package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.service.BookService;
import com.baizhi.utils.MybatisUtils;

public class BookServiceImpl implements BookService{
	
	@Override
	public List<Book> queryAllBooks() {
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		List<Book> books=bd.selectAllBooks();
		MybatisUtils.close();
		return books;
	}
	@Override
	public void addBook(Book book,String uploadFileName) {
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		try {
			book.setId(UUID.randomUUID().toString());
			book.setCreate_date(new Date());
			book.setSale(0);
			book.setCover(uploadFileName);
			bd.insertBook(book);
			MybatisUtils.commit();
		} catch (Exception e) {
			MybatisUtils.rollback();
		}
	}
	@Override
	public List<Book> selectByKey(String key, String context) {
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		List<Book> list=bd.selectByKey(key, context);
		MybatisUtils.close();
		return list;
	}
	@Override
	public void removeBook(String id) {
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		try {
			bd.deleteBook(id);
			MybatisUtils.commit();
		} catch (Exception e) {
			MybatisUtils.rollback();
		}
	}
	@Override
	public void modifyBook(Book book, String uploadFileName) {
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		try {
			book.setCover(uploadFileName);
			bd.updateBook(book);
			MybatisUtils.commit();
		} catch (Exception e) {
			MybatisUtils.rollback();
		}
	}
	@Override
	public Book queryOneBook(String id) {
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		Book book=bd.selectById(id);
		MybatisUtils.close();
		return book;
	}
	@Override
	public List<Book> selectRecommend() {
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		List<Book> list=bd.selectAllBooks();
		Integer a=new Random().nextInt(list.size());
		Integer b=new Random().nextInt(list.size());
		while(true){
			if(a==b){
				b=new Random().nextInt(list.size());
			}else break;
		}
		List<Book> books=new ArrayList<Book>();
		books.add(list.get(a));
		books.add(list.get(b));
		MybatisUtils.close();
		return books;
	}
	@Override
	public List<Book> selectBySale() {
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		List<Book> list=bd.selectBySale();
		MybatisUtils.close();
		return list;
	}
	@Override
	public List<Book> selectByCreate_date() {
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		List<Book> list=bd.selectByCreate_date();
		MybatisUtils.close();
		return list;
	}
	@Override
	public List<Book> selectBySaleAndDate() {
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		List<Book> list=bd.selectBySaleAndDate();
		MybatisUtils.close();
		return list;
	}
	@Override
	public List<Book> selectByFirstOrSecond(String id, String sid,Integer currentPage,Integer pageSize) {
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		Integer begin=(currentPage-1)*pageSize+1;
		Integer end=currentPage*pageSize;
		List<Book> list=bd.selectByFirstOrSecond(id, sid, begin, end);
		MybatisUtils.close();
		return list;
	}
	@Override
	public Integer getTotalPage(String id, String sid, Integer pageSize) {
		BookDao bd=(BookDao) MybatisUtils.getMapper(BookDao.class);
		Integer totalCount=bd.getCount(id, sid);
		Integer totalPage=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
		MybatisUtils.close();
		return totalPage;
	}
	
}
