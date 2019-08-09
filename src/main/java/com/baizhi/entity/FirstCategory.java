package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

public class FirstCategory implements Serializable{
	private String id;
	private String name;
	private String parentId;
	private String levels;
	private List<Category> second;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	public List<Category> getSecond() {
		return second;
	}
	public void setSecond(List<Category> second) {
		this.second = second;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
