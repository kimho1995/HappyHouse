package com.ssafy.house.dto;

/**
 *  created by 현선미 
 *  상점 */
public class StoreDto2  {
	private int storeId;                // 상가 업소 번호
	private String storeName;           // 상호명
	private String branchName;          // 지점
	private String largeCategorCode;    // 대분류 코드
	private String largeCategory;       // 대분류
	private String mediumCategoryCode;  // 중분류 코드
	private String mediumCategory;      // 중분류
	private String smallCategoryCode;   // 소분류 코드
	private String smallCategory;       // 소분류
	private String sidoCode;            // 시코드
	private String sido;                // 시
	private String gugunCode;           // 구군코드
	private String gugun;               // 구군 
	private String dongCode;            // 법정동 코드  
	private String dong;                // 법정동  
	private String address;             // 지번주소  
	private String postNum;             // 우변번호  
	private String len;                 // 경도
	private String lat;                 // 위도
	
	private int curPage;                // 현재 페이지 
	private int spp;                    // 페이지당 글 수 
	private int start;                  // 시작 인덱
	
	public StoreDto2() {
		super();
	}
	
	
	public StoreDto2(String sidoCode, String gugunCode, String dongCode, int curPage, int spp) {
		super();
		this.sidoCode = sidoCode;
		this.gugunCode = gugunCode;
		this.dongCode = dongCode;
		this.curPage = curPage;
		this.spp = spp;
	    this.start = (this.curPage-1)*this.spp;
	}


	public StoreDto2(int storeId, String storeName, String branchName, String largeCategorCode, String largeCategory,
			String mediumCategoryCode, String mediumCategory, String smallCategoryCode, String smallCategory,
			String sidoCode, String sido, String gugunCode, String gugun, String dongCode, String dong, String address,
			String postNum, String len, String lat) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.branchName = branchName;
		this.largeCategorCode = largeCategorCode;
		this.largeCategory = largeCategory;
		this.mediumCategoryCode = mediumCategoryCode;
		this.mediumCategory = mediumCategory;
		this.smallCategoryCode = smallCategoryCode;
		this.smallCategory = smallCategory;
		this.sidoCode = sidoCode;
		this.sido = sido;
		this.gugunCode = gugunCode;
		this.gugun = gugun;
		this.dongCode = dongCode;
		this.dong = dong;
		this.address = address;
		this.postNum = postNum;
		this.len = len;
		this.lat = lat;
	}


	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getLargeCategorCode() {
		return largeCategorCode;
	}
	public void setLargeCategorCode(String largeCategorCode) {
		this.largeCategorCode = largeCategorCode;
	}
	public String getLargeCategory() {
		return largeCategory;
	}
	public void setLargeCategory(String largeCategory) {
		this.largeCategory = largeCategory;
	}
	public String getMediumCategoryCode() {
		return mediumCategoryCode;
	}
	public void setMediumCategoryCode(String mediumCategoryCode) {
		this.mediumCategoryCode = mediumCategoryCode;
	}
	public String getMediumCategory() {
		return mediumCategory;
	}
	public void setMediumCategory(String mediumCategory) {
		this.mediumCategory = mediumCategory;
	}
	public String getSmallCategoryCode() {
		return smallCategoryCode;
	}
	public void setSmallCategoryCode(String smallCategoryCode) {
		this.smallCategoryCode = smallCategoryCode;
	}
	public String getSmallCategory() {
		return smallCategory;
	}
	public void setSmallCategory(String smallCategory) {
		this.smallCategory = smallCategory;
	}
	public String getSidoCode() {
		return sidoCode;
	}
	public void setSidoCode(String sidoCode) {
		this.sidoCode = sidoCode;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugunCode() {
		return gugunCode;
	}
	public void setGugunCode(String gugunCode) {
		this.gugunCode = gugunCode;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostNum() {
		return postNum;
	}
	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}
	public String getLen() {
		return len;
	}
	public void setLen(String len) {
		this.len = len;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	
	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getSpp() {
		return spp;
	}

	public void setSpp(int spp) {
		this.spp = spp;
	}
	
	

}
