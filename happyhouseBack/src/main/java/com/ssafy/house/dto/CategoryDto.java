package com.ssafy.house.dto;

public class CategoryDto {
	private String large_category_code;
	private String large_category_name;
	
	public CategoryDto() {}

	public CategoryDto(String large_category_code, String large_category_name) {
		super();
		this.large_category_code = large_category_code;
		this.large_category_name = large_category_name;
	}

	public String getLarge_category_code() {
		return large_category_code;
	}

	public void setLarge_category_code(String large_category_code) {
		this.large_category_code = large_category_code;
	}

	public String getLarge_category_name() {
		return large_category_name;
	}

	public void setLarge_category_name(String large_category_name) {
		this.large_category_name = large_category_name;
	}
	
	
}
