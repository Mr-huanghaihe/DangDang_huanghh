package com.baizhi.service.impl;

import java.util.List;
import java.util.UUID;

import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Category;
import com.baizhi.entity.FirstCategory;
import com.baizhi.service.CategoryService;
import com.baizhi.utils.MybatisUtils;

public class CategoryServiceImpl implements CategoryService{

	@Override
	public List<Category> queryAll() {
		CategoryDao ca=(CategoryDao)MybatisUtils.getMapper(CategoryDao.class);
		List<Category> list=ca.selectAll();
		MybatisUtils.close();
		return list;
	}

	@Override
	public void addOneFirst(Category cate) {
		CategoryDao ca=(CategoryDao)MybatisUtils.getMapper(CategoryDao.class);
		try {
			cate.setId(UUID.randomUUID().toString());
			cate.setLevels("1");
			ca.insertOne(cate);
			MybatisUtils.commit();
		} catch (Exception e) {
			MybatisUtils.rollback();
		}
	}

	@Override
	public void addOneSecond(Category cate) {
		CategoryDao ca=(CategoryDao)MybatisUtils.getMapper(CategoryDao.class);
		try {
			cate.setId(UUID.randomUUID().toString());
			cate.setLevels("2");
			ca.insertOneSecond(cate);
			MybatisUtils.commit();
		} catch (Exception e) {
			MybatisUtils.rollback();
		}
	}

	@Override
	public List<Category> queryAllFirst() {
		CategoryDao ca=(CategoryDao)MybatisUtils.getMapper(CategoryDao.class);
		List<Category> list=ca.selectAllFirst();
		MybatisUtils.close();
		return list;
	}

	@Override
	public void removeOne(String id) {
		CategoryDao cd=(CategoryDao) MybatisUtils.getMapper(CategoryDao.class);
		FirstCategory fc=null;
		try {
			fc=cd.selectOneFirst(id);
			if(fc==null){
				cd.deleteOne(id);
			}else{
				List<Category> list=fc.getSecond();
				if(list.size()==0){
					cd.deleteOne(id);
				}else{
					throw new RuntimeException("该一级分类不可删除");
				}
			}
			MybatisUtils.commit();
		} catch (Exception e) {
			MybatisUtils.rollback();
		}
	}

	@Override
	public List<Category> queryAllSecond() {
		CategoryDao ca=(CategoryDao)MybatisUtils.getMapper(CategoryDao.class);
		List<Category> list=ca.selectAllSecond();
		MybatisUtils.close();
		return list;
	}

	@Override
	public List<FirstCategory> selectFirstAndSecond() {
		CategoryDao ca=(CategoryDao)MybatisUtils.getMapper(CategoryDao.class);
		List<FirstCategory> list=ca.selectFirstAndSecond();
		MybatisUtils.close();
		return list;
	}

	@Override
	public FirstCategory selectOneFirstById(String id) {
		CategoryDao ca=(CategoryDao)MybatisUtils.getMapper(CategoryDao.class);
		FirstCategory fc=ca.selectOneFirst(id);
		MybatisUtils.close();
		return fc;
	}
}
