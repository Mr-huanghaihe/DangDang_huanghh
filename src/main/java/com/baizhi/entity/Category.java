package com.baizhi.entity;

import java.io.Serializable;

public class Category implements Serializable{
	private String id;
	private String name;
	private String parentId;
	private String levels;
	private Category first;
	
	public Category getFirst() {
		return first;
	}
	public void setFirst(Category first) {
		this.first = first;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public Category(String id, String name, String parentId, String levels) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.levels = levels;
	}
	public Category() {
		super();
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parentId="
				+ parentId + ", levels=" + levels + ", first=" + first + "]";
	}
	
	
}
