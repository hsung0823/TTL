package com.fnw.book;

import java.sql.Date;

public class Book_TotalDTO {
	private int num;
	private String title;
	private String writer;
	private String company;
	private String publish_date;
	private String section;
	private int library;
	private String type;
	private int state;
	private String rent_id;
	private int rent_count;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	

	public String getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public int getLibrary() {
		return library;
	}
	public void setLibrary(int library) {
		this.library = library;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getRent_id() {
		return rent_id;
	}
	public void setRent_id(String rent_id) {
		this.rent_id = rent_id;
	}
	public int getRent_count() {
		return rent_count;
	}
	public void setRent_count(int rent_count) {
		this.rent_count = rent_count;
	}
}
