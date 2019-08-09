package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Category;
import com.baizhi.entity.FirstCategory;

public interface CategoryService {
	/**
	 * @return 所有一级和二级类别
	 */
	public List<Category> queryAll();
	/**
	 * @param cate 增加一个一级类别
	 */
	public void addOneFirst(Category cate);
	/**
	 * @param cate 增加一个二级类别
	 */
	public void addOneSecond(Category cate);
	/**
	 * @return 查询所有的一级类别
	 */
	public List<Category> queryAllFirst();
	/**
	 * @param id 根据id移除一个类别
	 */
	public void removeOne(String id);
	/**
	 * @return 所有二级类别
	 */
	public List<Category> queryAllSecond();
	/**
	 * @return 所有的一级和对应的二级
	 */
	public List<FirstCategory> selectFirstAndSecond();
	/**
	 * @param id 一级类别的id
	 * @return 一级类别
	 */
	public FirstCategory selectOneFirstById(String id);
}
