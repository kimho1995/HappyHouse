package com.ssafy.house.dto;

import java.io.Serializable;

public class MemberDto implements Serializable{

	private String rid;
	private String userid;
	private String username;
	private String password;
	private String email;
	private String number;
	private String address;
	private String created_at;
	private String updated_at;
	private String rolename;
	
	public MemberDto() {}
	public MemberDto(String rid, String userid, String username, String password, String email, String number,
			String address, String created_at, String updated_at, String rolename) {
		super();
		this.rid = rid;
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.number = number;
		this.address = address;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.rolename = rolename;
	}
	public MemberDto(String rid, String userid, String username, String password, String email, String number,
			String address, String created_at, String rolename) {
		super();
		this.rid = rid;
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.number = number;
		this.address = address;
		this.created_at = created_at;
		this.rolename = rolename;
	}
	public MemberDto(String userid, String username, String password, String email, String number, String address,
			String created_at) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.number = number;
		this.address = address;
		this.created_at = created_at;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	@Override
	public String toString() {
		return "MemberDto [rid=" + rid + ", userid=" + userid + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", number=" + number + ", address=" + address + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", rolename=" + rolename + "]";
	}
	
	
}
