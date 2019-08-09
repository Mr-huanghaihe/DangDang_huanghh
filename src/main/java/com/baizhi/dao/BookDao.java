package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;

public interface BookDao {
	/**
	 * @return 所有图书
	 */
	public List<Book> selectAllBooks(); 
	/**
	 * @param book 插入图书对象
	 */
	public void insertBook(Book book);
	/**
	 * @param key 根据什么查询
	 * @param context 查询的内容
	 * @return 模糊查询的结果
	 */
	public List<Book> selectByKey(@Param("key")String key,@Param("context")String context);
	/**
	 * @param id 根据id删除图书
	 */
	public void deleteBook(String id);
	/**
	 * @param book 修改图书对象
	 */
	public void updateBook(Book book);
	/**
	 * @param id 根据id查询图书
	 * @return 查询的图书
	 */
	public Book selectById(String id);
	/**
	 * @return 推荐的图书的集合，随机两本
	 */
	public List<Book> selectRecommend();
	/**
	 * @return 根据销量降序展示图书8本（为0不展示）
	 */
	public List<Book> selectBySale();
	/**
	 * @return 根据创建时间降序展示图书8本
	 */
	public List<Book> selectByCreate_date();
	/**
	 * @return 根据销量和创建时间综合展示图书
	 */
	public List<Book> selectBySaleAndDate();
	/**
	 * @param id 一级类别id
	 * @param sid 二级类别id
	 * @param begin 分页后的起始条数
	 * @param end 分页后的结束条数
	 * @return 根据一级id或二级id查询到的图书分页展示
	 */
	public List<Book> selectByFirstOrSecond(@Param("id")String id,@Param("sid")String sid,@Param("begin")Integer begin,@Param("end")Integer end);
	
	/**
	 * @param id 一级类别id
	 * @param sid 二级类别id
	 * @return 根据一级和二级id查询到的图书的总条数
	 */
	public Integer getCount(@Param("id")String id,@Param("sid")String sid);
}
