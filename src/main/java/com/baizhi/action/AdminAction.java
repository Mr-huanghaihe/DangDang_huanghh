package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;
import com.baizhi.service.AdminService;
import com.baizhi.service.CategoryService;
import com.baizhi.service.impl.AdminServiceImpl;
import com.baizhi.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport{
	private Admin admin;
	private String message;
	private String code;
	private List<Category> list;
	private List<Category> lists;
	private Category cate;
	private String id;
	private Book book;
	private List<User> users;
	private List<Order> orders;
	private List<Item> items;
	private Order order;
	
	
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Category> getLists() {
		return lists;
	}
	public void setLists(List<Category> lists) {
		this.lists = lists;
	}
	public Category getCate() {
		return cate;
	}
	public void setCate(Category cate) {
		this.cate = cate;
	}
	public List<Category> getList() {
		return list;
	}
	public void setList(List<Category> list) {
		this.list = list;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	HttpSession session=ServletActionContext.getRequest().getSession();
	public String loginAdmin(){
		AdminService as=new AdminServiceImpl();
		String vcode=(String) session.getAttribute("code");
		if(code.equals(vcode)){
			try {
				as.login(admin);
				return Action.SUCCESS;
			} catch (Exception e) {
				message=e.getMessage();
				return Action.ERROR;
			}
		}else{
			message="验证码有误！";
			return Action.ERROR;
		}
	}
	public String allCategory(){
		CategoryService cs=new CategoryServiceImpl();
		list=cs.queryAll();
		return Action.SUCCESS;
	}
	public String addFirstCategory(){
		CategoryService cs=new CategoryServiceImpl();
		cs.addOneFirst(cate);
		message="成功添加一级类别！";
		return Action.SUCCESS;
	}
	public String addSecondCategory(){
		CategoryService cs=new CategoryServiceImpl();
		cs.addOneSecond(cate);
		message="成功添加二级类别！";
		return Action.SUCCESS;
	}
	public String allFirst(){
		CategoryService cs=new CategoryServiceImpl();
		lists=cs.queryAllFirst();
		return Action.SUCCESS;
	}
	public String allSecond(){
		CategoryService cs=new CategoryServiceImpl();
		list=cs.queryAllSecond();
		return Action.SUCCESS;
	}
	public String removeOne(){
		CategoryService cs=new CategoryServiceImpl();
		cs.removeOne(id);
		return Action.SUCCESS;
	}
	public String exit(){
		session.invalidate();
		message="退出成功！";
		return Action.SUCCESS;
	}
	public String queryAllUser(){
		AdminService as=new AdminServiceImpl();
		users=as.queryAllUser();
		return Action.SUCCESS;
	}
	public String modifyStatus(){
		AdminService as=new AdminServiceImpl();
		as.modifyStatus(id);
		return Action.SUCCESS;
	}
	public String queryAllOrder(){
		AdminService as=new AdminServiceImpl();
		orders=as.queryAllOrder();
		return Action.SUCCESS;
	}
	public String queryAllItem(){
		AdminService as=new AdminServiceImpl();
		items=as.queryAllItem(id);
		order=as.queryOneOrder(id);
		return Action.SUCCESS;
	}
}
