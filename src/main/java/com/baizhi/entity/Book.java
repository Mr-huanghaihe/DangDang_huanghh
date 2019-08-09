package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{
	private String id;
	private String name;
	private String author;
	private String cover;
	private String press;
	private Date press_date;
	private String edition;
	private Date print_date;
	private String impression;
	private String isbn;
	private int word_num;
	private int page_num;
	private String sizes;
	private String paper;
	private String pack;
	private double price;
	private double dprice;
	private Date create_date;
	private String editor_recommend;
	private String content_abstract;
	private String author_abstract;
	private String director;
	private String media_commentary;
	private String category_id;
	private int sale;
	private int stock;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Date getPress_date() {
		return press_date;
	}
	public void setPress_date(Date press_date) {
		this.press_date = press_date;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Date getPrint_date() {
		return print_date;
	}
	public void setPrint_date(Date print_date) {
		this.print_date = print_date;
	}
	public String getImpression() {
		return impression;
	}
	public void setImpression(String impression) {
		this.impression = impression;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getWord_num() {
		return word_num;
	}
	public void setWord_num(int word_num) {
		this.word_num = word_num;
	}
	public int getPage_num() {
		return page_num;
	}
	public void setPage_num(int page_num) {
		this.page_num = page_num;
	}
	public String getSizes() {
		return sizes;
	}
	public void setSizes(String sizes) {
		this.sizes = sizes;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDprice() {
		return dprice;
	}
	public void setDprice(double dprice) {
		this.dprice = dprice;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getEditor_recommend() {
		return editor_recommend;
	}
	public void setEditor_recommend(String editor_recommend) {
		this.editor_recommend = editor_recommend;
	}
	public String getContent_abstract() {
		return content_abstract;
	}
	public void setContent_abstract(String content_abstract) {
		this.content_abstract = content_abstract;
	}
	public String getAuthor_abstract() {
		return author_abstract;
	}
	public void setAuthor_abstract(String author_abstract) {
		this.author_abstract = author_abstract;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getMedia_commentary() {
		return media_commentary;
	}
	public void setMedia_commentary(String media_commentary) {
		this.media_commentary = media_commentary;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Book(String id, String name, String author, String cover,
			String press, Date press_date, String edition, Date print_date,
			String impression, String isbn, int word_num, int page_num,
			String sizes, String paper, String pack, double price,
			double dprice, Date create_date, String editor_recommend,
			String content_abstract, String author_abstract, String director,
			String media_commentary, String category_id, int sale, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.cover = cover;
		this.press = press;
		this.press_date = press_date;
		this.edition = edition;
		this.print_date = print_date;
		this.impression = impression;
		this.isbn = isbn;
		this.word_num = word_num;
		this.page_num = page_num;
		this.sizes = sizes;
		this.paper = paper;
		this.pack = pack;
		this.price = price;
		this.dprice = dprice;
		this.create_date = create_date;
		this.editor_recommend = editor_recommend;
		this.content_abstract = content_abstract;
		this.author_abstract = author_abstract;
		this.director = director;
		this.media_commentary = media_commentary;
		this.category_id = category_id;
		this.sale = sale;
		this.stock = stock;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", cover=" + cover + ", press=" + press + ", press_date="
				+ press_date + ", edition=" + edition + ", print_date="
				+ print_date + ", impression=" + impression + ", isbn=" + isbn
				+ ", word_num=" + word_num + ", page_num=" + page_num
				+ ", sizes=" + sizes + ", paper=" + paper + ", pack=" + pack
				+ ", price=" + price + ", dprice=" + dprice + ", create_date="
				+ create_date + ", editor_recommend=" + editor_recommend
				+ ", content_abstract=" + content_abstract
				+ ", author_abstract=" + author_abstract + ", director="
				+ director + ", media_commentary=" + media_commentary
				+ ", category_id=" + category_id + ", sale=" + sale
				+ ", stock=" + stock + "]";
	}
	
}
