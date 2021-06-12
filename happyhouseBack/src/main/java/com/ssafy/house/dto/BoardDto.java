package com.ssafy.house.dto;

import java.io.Serializable;
//com.ssafy.edu.vue.dto.BoardDto
public class BoardDto implements Serializable {
	private int bid;
	private String userid;
	private String title;
	private String content;
	private String created_at;
	private String updated_at;
	private int totalPage;
	// serach
	private String searchtype;
	private String searchname;
	
	public String getSearchtype() {
		return searchtype;
	}
	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}
	public String getSearchname() {
		return searchname;
	}
	public void setSearchname(String searchname) {
		this.searchname = searchname;
	}
	
	public BoardDto(String searchtype, String searchname) {
		super();
		this.searchtype = searchtype;
		this.searchname = searchname;
	}
	
	public BoardDto() {}
	public BoardDto(int bid, String userid, String title, String content, String created_at, String updated_at) {
		super();
		this.bid = bid;
		this.userid = userid;
		this.title = title;
		this.content = content;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public BoardDto(int bid, String userid, String title, String content, String updated_at) {
		super();
		this.bid = bid;
		this.userid = userid;
		this.title = title;
		this.content = content;
		this.updated_at = updated_at;
	}
	public BoardDto(int bid, String userid, String title, String content) {
		super();
		this.bid = bid;
		this.userid = userid;
		this.title = title;
		this.content = content;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	@Override
	public String toString() {
		return "BoardDto [bid=" + bid + ", userid=" + userid + ", title=" + title + ", content=" + content
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", searchtype=" + searchtype
				+ ", searchname=" + searchname + "]";
	}
	
	
	
}