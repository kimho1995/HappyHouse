package com.ssafy.house.dao;

import java.util.Map;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.house.controller.StoreController;
import com.ssafy.house.dto.CategoryDto;
import com.ssafy.house.dto.StoreDto;

import ch.qos.logback.classic.Logger;
@Repository
public class StoreDaoImpl implements StoreDao {
	
	private String namespace = "com.ssafy.house.dao.StoreDaoImpl.";
	
	@Autowired
	private SqlSession sqlSession;
	/* 상권 정보 검색 
	 * input : StoreDto
	 * output : List<StoreDto>
	 * */
//	@Override
//	public List<StoreDto> searchByCode(StoreDto storeDto) throws Exception {
//		return sqlSession.selectList(namespace + "searchByCode", storeDto);
//	}
//
//	/* 상권 정보 검색 전체 데이터 수  
//	 * input : StoreDto
//	 * output : int
//	 * */
//	@Override
//	public int getTotalCount(StoreDto storeDto) throws Exception {
//		return sqlSession.selectOne(namespace + "getTotalCount", storeDto);
//	}
//	/* 주변 상권 검색 (카테고리별)
//	 * input : MAP
//	 * output : List<StoreDto>
//	 * */
//	@Override
//	public List<StoreDto> findAroundStore(Map map) throws Exception {
//		return sqlSession.selectList(namespace + "findAroundStore",map);
//	}

	@Override
	public List<StoreDto> findStoreCount(Map map) throws Exception {
		return sqlSession.selectList(namespace + "findStoreCount", map);
	}

	@Override
	public int findGugunStoreCount(Map map) throws Exception {
		return sqlSession.selectOne(namespace + "findGugunStoreCount", map);
	}

	@Override
	public List<CategoryDto> largeCategory() throws Exception {
		return sqlSession.selectList(namespace + "largeCategory");
	}

}
