package com.ssafy.house.dto;

public class ApartDto {
	private String dong;
	private String AptName;
	private String code;
	private String buildYear;
	private String lat;
	private String lng;
	private String dealAmount;
	private String dealYear;
	private String dealMonth;
	private String dealDay;
	private String floor;
	private String jibun;
	private String gu;
	
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	@Override
	public String toString() {
		return "ApartDto [dong=" + dong + ", AptName=" + AptName + ", code=" + code + ", buildYear=" + buildYear
				+ ", lat=" + lat + ", lng=" + lng + ", dealAmount=" + dealAmount + ", dealYear=" + dealYear
				+ ", dealMonth=" + dealMonth + ", dealDay=" + dealDay + ", floor=" + floor + "]";
	}
	public ApartDto() {}
	public ApartDto(String dong, String gu) {
		super();
		this.dong = dong;
		this.gu = gu;
	}
	public ApartDto(String dong, String aptName, String code, String buildYear, String lat, String lng) {
		super();
		this.dong = dong;
		AptName = aptName;
		this.code = code;
		this.buildYear = buildYear;
		this.lat = lat;
		this.lng = lng;
	}
	public ApartDto(String dong, String aptName, String code, String buildYear, String dealAmount, String dealYear,
			String dealMonth, String dealDay, String floor) {
		super();
		this.dong = dong;
		AptName = aptName;
		this.code = code;
		this.buildYear = buildYear;
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.floor = floor;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getAptName() {
		return AptName;
	}
	public void setAptName(String aptName) {
		AptName = aptName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
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
	
}
