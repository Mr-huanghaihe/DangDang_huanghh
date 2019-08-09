package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Book;

public interface BookService {
	/**
	 * @return 所有图书的集合
	 */
	public List<Book> queryAllBooks();
	/**
	 * @param book 新增一本图书
	 * @param uploadFileName 图书封面的名字
	 */
	public void addBook(Book book,String uploadFileName);
	/**
	 * @param key 根据key的相关内容查询
	 * @param context key中包含的文本内容
	 * @return 根据key中包含的文本内容查询到的图书集合
	 */
	public List<Book> selectByKey(String key,String context);
	/**
	 * @param id 根据id移除图书
	 */
	public void removeBook(String id);
	/**
	 * @param book 修改后的图书对象
	 * @param uploadFileName 修改的图书封面名字
	 */
	public void modifyBook(Book book,String uploadFileName);
	/**
	 * @param id 根据id查询图书
	 * @return 根据id查询到的图书
	 */
	public Book queryOneBook(String id);
	/**
	 * @return 推荐图书2本
	 */
	public List<Book> selectRecommend();
	/**
	 * @return 根据销量降序查询书籍8本
	 */
	public List<Book> selectBySale();
	/**
	 * @return 根据图书创建时间降序查询图书8本
	 */
	public List<Book> selectByCreate_date();
	/**
	 * @return 根据销量和创建时间降序综合查询图书8本
	 */
	public List<Book> selectBySaleAndDate();
	/**
	 * @param id 一级类别id
	 * @param sid 二级类别id
	 * @return 根据一级和二级类别id查询到的图书的集合
	 */
	public List<Book> selectByFirstOrSecond(String id,String sid,Integer begin,Integer end);
	/**
	 * @param id 一级类别id
	 * @param sid 二级类别id
	 * @param pageSize 每页显示的条数
	 * @return 总页数
	 */
	public Integer getTotalPage(String id,String sid,Integer pageSize);
}
