package com.ssafy.house.dto;

/* 댓글 dto */
public class CommentDto {
	private int cid;                // 댓글 id
	private int bid;                // 본문 id
	private String userid;          // 사용자 id (작성자)         
	private String content;
	private String created_at;      // 작성일자 
	private String updated_at;      // 수정일자 
	
	/* 페이징 처리 */
	private int totalPage;
	
	public CommentDto() {
		super();
	}

	public CommentDto(int cid, int bid, String userid, String content, String created_at, String updated_at,
			int totalPage) {
		super();
		this.cid = cid;
		this.bid = bid;
		this.userid = userid;
		this.content = content;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.totalPage = totalPage;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
