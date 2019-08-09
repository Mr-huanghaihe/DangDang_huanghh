package com.baizhi.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.FirstCategory;
import com.baizhi.service.BookService;
import com.baizhi.service.CategoryService;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport{
	private List<Book> books;
	private File upload;
	private String uploadFileName;
	private String uploadContextType;
	private Book book;
	private String key;
	private String context;
	private String id;
	private List<Book> hots;
	private List<Book> news;
	private List<Book> newHot;
	private List<FirstCategory> category;
	private FirstCategory firstCategory;
	private String sid;
	private Integer currentPage;
	private Integer pageSize=4;
	private Integer totalPage;
	
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public FirstCategory getFirstCategory() {
		return firstCategory;
	}
	public void setFirstCategory(FirstCategory firstCategory) {
		this.firstCategory = firstCategory;
	}
	public List<FirstCategory> getCategory() {
		return category;
	}
	public void setCategory(List<FirstCategory> category) {
		this.category = category;
	}
	public List<Book> getNewHot() {
		return newHot;
	}
	public void setNewHot(List<Book> newHot) {
		this.newHot = newHot;
	}
	public List<Book> getNews() {
		return news;
	}
	public void setNews(List<Book> news) {
		this.news = news;
	}
	public List<Book> getHots() {
		return hots;
	}
	public void setHots(List<Book> hots) {
		this.hots = hots;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContextType() {
		return uploadContextType;
	}
	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	CategoryService cs=new CategoryServiceImpl();
	BookService bs=new BookServiceImpl();
	
	public String allBooks(){
		books=bs.queryAllBooks();
		return Action.SUCCESS;
	}
	public String addBook(){
		//System.out.println(uploadFileName);
		String path=ServletActionContext.getServletContext().getRealPath("/back/img");
		File f=new File(path+"//"+uploadFileName);
		try {
			//f.createNewFile();
			FileUtils.copyFile(upload, f);
			bs.addBook(book, uploadFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	public String selectByKey(){
		books=bs.selectByKey(key, context);
		return Action.SUCCESS;
	}
	public String remove(){
		bs.removeBook(id);
		return Action.SUCCESS;
	}
	public String modifyBook(){
		if(uploadFileName==null){
			bs.modifyBook(book, uploadFileName);
		}else{
			String path=ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/back/img");
			File a=new File(path+"//"+uploadFileName);
			try {
				FileUtils.copyFile(upload, a);
				bs.modifyBook(book, uploadFileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return Action.SUCCESS;
	}
	public String queryOne(){
		book=bs.queryOneBook(id);
		if(key!=null){
			return Action.INPUT;
		}else{
			return Action.SUCCESS;
		}
	}
	public String main(){
		books=bs.selectRecommend();
		hots=bs.selectBySale();
		news=bs.selectByCreate_date();
		newHot=bs.selectBySaleAndDate();
		category=cs.selectFirstAndSecond();
		return Action.SUCCESS;
	}
	public String subpage(){
		firstCategory=cs.selectOneFirstById(id);
		books=bs.selectByFirstOrSecond(id, sid, currentPage, pageSize);
		totalPage=bs.getTotalPage(id, sid, pageSize);
		return Action.SUCCESS;
	}
}
