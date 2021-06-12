package com.ssafy.house.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.dao.StoreDao;
import com.ssafy.house.dto.CategoryDto;
import com.ssafy.house.dto.StoreDto;

@Service
public class StoreServiceImple implements StoreService {
	
	@Autowired
	private StoreDao storeDao;

	@Override
	public List<StoreDto> findStoreCount(Map map) throws Exception {
		return storeDao.findStoreCount(map);
	}

	@Override
	public int findGugunStoreCount(Map map) throws Exception {
		return storeDao.findGugunStoreCount(map);
	}

	@Override
	public List<CategoryDto> largeCategory() throws Exception {
		return storeDao.largeCategory();
	}

	/* 상권 정보 검색 
	 * input : StoreDto
	 * output : List<StoreDto>
	 * */
//	@Override
//	public List<StoreDto> searchByCode(StoreDto storeDto) throws Exception {
//		return storeDao.searchByCode(storeDto);
//	}
//	
//	/* 상권 정보 검색 전체 데이터 수  
//	 * input : StoreDto
//	 * output : int
//	 * */
//	@Override
//	public int getTotalCount(StoreDto storeDto) throws Exception{
//		return storeDao.getTotalCount(storeDto);
//	};
//	
//	/* 주변 상권 검색 (카테고리별)
//	 * input : MAP
//	 * output : List<StoreDto>
//	 * */
//	@Override
//	public List<StoreDto> findAroundStore(Map map) throws Exception {
//		return storeDao.findAroundStore(map);
//	}
	

}
