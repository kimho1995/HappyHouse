package com.ssafy.house.dto;
/* created by 현선미 
 * 거래내역 */
public class DealDto {
	/* 공통 */
	private String name;            // 주택
	private String buildYear;       // 건축 년도 
	private String dealYear;        // 거래 년
	private String dealMonth;       // 거래 월 
	private String dealDay;         // 거래 일 
	private String floor;           // 층 
	private String jibun;           // 지번 
	private String dong;            // 법정동 명 
	private String gunguCode;       // 군구 코드 
	private String area;            // 면적 
	
	/* 전월세 */
	private String deposit;         // 보증금 
	private String rentMoney;       // 월세
	private int type;            // 전월세 구분 
	
	/* 매매 */
	private String dealAmount;      // 매매
	
	/* 페이징 */
	private int curPage;                // 현재 페이지 
	private int spp;                    // 페이지당 글 수 
	private int start;                  // 시작 인덱스 
	
	public DealDto() {
		super();
	}
	
	public DealDto(int type, String gunguCode, String dong, int curPage, int spp) {
		super();
		this.type = type;
		this.gunguCode = gunguCode;
		this.dong = dong;
		this.curPage = curPage;
		this.spp = spp;
	    this.start = (this.curPage-1)*this.spp;
	}



	public DealDto(String name, String buildYear, String dealYear, String dealMonth, String dealDay, String floor,
			String jibun, String dong, String gunguCode, String area, String deposit, String rentMoney, int type,
			String dealAmount, int curPage, int spp, int start) {
		super();
		this.name = name;
		this.buildYear = buildYear;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.floor = floor;
		this.jibun = jibun;
		this.dong = dong;
		this.gunguCode = gunguCode;
		this.area = area;
		this.deposit = deposit;
		this.rentMoney = rentMoney;
		this.type = type;
		this.dealAmount = dealAmount;
		this.curPage = curPage;
		this.spp = spp;
		this.start = start;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDealYear() {
		return dealYear;
	}
	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}
	public String getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}
	public String getDealDay() {
		return dealDay;
	}
	public void setDealDay(String dealDay) {
		this.dealDay = dealDay;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getGunguCode() {
		return gunguCode;
	}
	public void setGunguCode(String gunguCode) {
		this.gunguCode = gunguCode;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getRentMoney() {
		return rentMoney;
	}
	public void setRentMoney(String rentMoney) {
		this.rentMoney = rentMoney;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	@Override
	public String toString() {
		return "DealDto [name=" + name + ", buildYear=" + buildYear + ", dealYear=" + dealYear + ", dealMonth="
				+ dealMonth + ", dealDay=" + dealDay + ", floor=" + floor + ", jibun=" + jibun + ", dong=" + dong
				+ ", gunguCode=" + gunguCode + ", area=" + area + ", deposit=" + deposit + ", rentMoney=" + rentMoney
				+ ", type=" + type + ", dealAmount=" + dealAmount + ", curPage=" + curPage + ", spp=" + spp + ", start="
				+ start + "]";
	}
	
	

}
