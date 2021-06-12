package com.ssafy.house.dto;

/**
 *  created by 현선미 
 *  상점 */
public class StoreDto  {
	private int storeCnt;                // 상가 개수
	private String dong;                // 법정동  

	public StoreDto() {}

	public StoreDto(int storeCnt, String dong) {
		super();
		this.storeCnt = storeCnt;
		this.dong = dong;
	}

	public int getStoreCnt() {
		return storeCnt;
	}

	public void setStoreCnt(int storeCnt) {
		this.storeCnt = storeCnt;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}
	

	
	

}
