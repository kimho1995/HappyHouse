package com.ssafy.house.dto;

/**
 *  created by 현선미 
 *  상점 */
public class AptAvgDto  {
	private String dong;                
	private int dealAmountAvg;          

	public AptAvgDto() {}

	public AptAvgDto(String dong, int dealAmountAvg) {
		super();
		this.dong = dong;
		this.dealAmountAvg = dealAmountAvg;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public int getDealAmountAvg() {
		return dealAmountAvg;
	}

	public void setDealAmountAvg(int dealAmountAvg) {
		this.dealAmountAvg = dealAmountAvg;
	}

	
	
}
