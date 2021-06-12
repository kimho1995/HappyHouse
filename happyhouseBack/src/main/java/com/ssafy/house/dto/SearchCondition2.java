package com.ssafy.house.dto;

import java.io.Serializable;

public class SearchCondition2 implements Serializable{

	private String key = "none";
	private String word = "none";
	private String dong;
	private String AptName;

	public SearchCondition2() {
	}

	public SearchCondition2(String key, String word, String dong, String aptName) {
		super();
		this.key = key;
		this.word = word;
		this.dong = dong;
		this.AptName = aptName;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
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

	

}
