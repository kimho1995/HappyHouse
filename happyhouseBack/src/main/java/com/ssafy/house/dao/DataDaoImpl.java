package com.ssafy.house.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.house.dto.DealDto;
@Repository
public class DataDaoImpl implements DataDao {
	
	private String namespace="com.ssafy.house.dao.DataDaoImpl.";
	
	@Autowired
	private SqlSession sqlSession;
	/* 오피스텔 전월세 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addOfficeRentData(DealDto deal) throws Exception {
		return sqlSession.insert(namespace + "addOfficeRentData",deal);
	}
	
	/* 오피스텔 매매 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addOfficeDealData(DealDto deal) throws Exception {
		return sqlSession.insert(namespace + "addOfficeDealData", deal);
	}
	
	/* 연립다세대 전월세 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addHomeRentData(DealDto deal) throws Exception {
		return sqlSession.insert(namespace + "addHomeRentData", deal);
	}
	
	/* 연립다세대 매매 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addHomeDealData(DealDto deal) throws Exception {
		return sqlSession.insert(namespace + "addHomeDealData", deal);
	}

	/* 아파트 전월세 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addAptRentData(DealDto deal) throws Exception {
		return sqlSession.insert(namespace + "addAptRentData", deal);
	}

	/* 아파트 매매 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addAptDealData(DealDto deal) throws Exception {
		return sqlSession.insert(namespace + "addAptDealData", deal);
	}

}
