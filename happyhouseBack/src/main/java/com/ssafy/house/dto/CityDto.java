package com.ssafy.house.dto;

import java.io.Serializable;

public class CityDto implements Serializable{
	private String cityCode;
	private String city;
	private String guCode;
	private String gu;
	private String dongCode;
	private String dong;
	public CityDto() {}
	
	@Override
	public String toString() {
		return "CityDto [cityCode=" + cityCode + ", city=" + city + ", guCode=" + guCode + ", gu=" + gu + ", dongCode="
				+ dongCode + ", dong=" + dong + "]";
	}

	public CityDto(String cityCode, String city, String guCode, String gu, String dongCode, String dong) {
		super();
		this.cityCode = cityCode;
		this.city = city;
		this.guCode = guCode;
		this.gu = gu;
		this.dongCode = dongCode;
		this.dong = dong;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getGuCode() {
		return guCode;
	}
	public void setGuCode(String guCode) {
		this.guCode = guCode;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	
}
