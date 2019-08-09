package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Category;
import com.baizhi.entity.FirstCategory;

public interface CategoryDao {
	/**
	 * @return 查询出的所有的类别的集合
	 */
	public List<Category> selectAll();
	/**
	 * @param cate 增加一级类别
	 */
	public void insertOne(Category cate);
	/**
	 * @param cate 增加二级类别
	 */
	public void insertOneSecond(Category cate);
	/**
	 * @return 查询所有的一级类别
	 */
	public List<Category> selectAllFirst();
	/**
	 * @param id 删除对应id的类别
	 */
	public void deleteOne(String id);
	/**
	 * @param id 
	 * @return 查询对应id的一级类别
	 */
	public FirstCategory selectOneFirst(String id);
	/**
	 * @return 所有二级类别
	 */
	public List<Category> selectAllSecond();
	/**
	 * @return 查询所有的一级和二级
	 */
	public List<FirstCategory> selectFirstAndSecond();
}
