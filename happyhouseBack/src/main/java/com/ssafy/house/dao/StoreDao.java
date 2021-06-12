package com.ssafy.house.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.house.dto.CategoryDto;
import com.ssafy.house.dto.StoreDto;

public interface StoreDao {
	/* 상권 정보 검색 
	 * input : StoreDto
	 * output : List<StoreDto>
	 * */
//	public List<StoreDto> searchByCode(StoreDto storeDto)throws Exception;
//	/* 상권 정보 검색 전체 데이터 수  
//	 * input : StoreDto
//	 * output : int
//	 * */
//	public int getTotalCount(StoreDto storeDto) throws Exception;
//	/* 주변 상권 검색 (카테고리별)
//	 * input : MAP
//	 * output : List<StoreDto>
//	 * */
//	public List<StoreDto> findAroundStore(Map map) throws Exception;
	
	public List<StoreDto> findStoreCount(Map map) throws Exception;
	public int findGugunStoreCount(Map map) throws Exception;
	public List<CategoryDto> largeCategory() throws Exception;
	
}
