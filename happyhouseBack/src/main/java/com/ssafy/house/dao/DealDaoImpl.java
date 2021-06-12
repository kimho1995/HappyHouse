package com.ssafy.house.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.house.dto.DealDto;

@Repository
public class DealDaoImpl implements DealDao {
	
	private String namespace = "com.ssafy.house.dao.DealDaoImpl.";
	
	@Autowired
	private SqlSession sqlSession;
	/* 오피스텔 전/월세 정보 조회  
	 * input : DealDto
	 * output : List<DealDto> 
	 * */
	@Override
	public List<DealDto> officeRentList(DealDto deal) throws Exception {
		return sqlSession.selectList(namespace + "officeRentList", deal);
	}
	
	/* 오피스텔 전/월세 정보 전체 데이터 수 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int getTotCntOfficeRent(DealDto deal) throws Exception {
		return sqlSession.selectOne(namespace + "getTotCntOfficeRent", deal);
	}
	
	/* 오피스텔 매매 정보 조회  
	 * input : DealDto
	 * output : List<DealDto> 
	 * */
	@Override
	public List<DealDto> officeDealList(DealDto deal) throws Exception {
		return sqlSession.selectList(namespace + "officeDealList", deal);
	}

	/* 오피스텔 매매 정보 전체 데이터 수 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int getTotCntOfficeDeal(DealDto deal) throws Exception {
		return sqlSession.selectOne(namespace + "getTotCntOfficeDeal",deal);
	}

	/* 연립 다세대 전/월세 정보 조회  
	 * input : DealDto
	 * output : List<DealDto> 
	 * */
	@Override
	public List<DealDto> homeRentList(DealDto deal) throws Exception {
		return sqlSession.selectList(namespace + "homeRentList", deal);
	}
	
	/* 연립 다세대 전/월세 정보 전체 데이터 수 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int getTotCntHomeRent(DealDto deal) throws Exception {
		return sqlSession.selectOne(namespace + "getTotCntHomeRent", deal);
	}

	/* 연립 다세대 매매 정보 조회  
	 * input : DealDto
	 * output : List<DealDto> 
	 * */
	@Override
	public List<DealDto> homeDealList(DealDto deal) throws Exception {
		return sqlSession.selectList(namespace + "homeDealList", deal);
	}

	/* 연립 다세대 매매 정보 전체 데이터 수 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int getTotCntHomeDeal(DealDto deal) throws Exception {
		return sqlSession.selectOne(namespace + "getTotCntHomeDeal", deal);
	}

	/* 아파트 전/월세 정보 조회  
	 * input : DealDto
	 * output : List<DealDto> 
	 * */
	@Override
	public List<DealDto> aptRentList(DealDto deal) throws Exception {
		return sqlSession.selectList(namespace + "aptRentList", deal);
	}
	
	/* 아파트 전/월세 정보 전체 데이터 수   
	 * input : DealDto
	 * output : int
	 * */
	@Override
	public int getTotCntAptRent(DealDto deal) throws Exception {
		return sqlSession.selectOne(namespace + "getTotCntAptRent", deal);
	}
	
	/* 아파트 매매 정보 조회  
	 * input : DealDto
	 * output : List<DealDto> 
	 * */
	@Override
	public List<DealDto> aptDealList(DealDto deal) throws Exception {
		return sqlSession.selectList(namespace + "aptDealList", deal);
	}

	/* 아파트 매매 정보 전체 데이터 수   
	 * input : DealDto
	 * output : int
	 * */
	@Override
	public int getTotCntAptDeal(DealDto deal) throws Exception {
		return sqlSession.selectOne(namespace + "getTotCntAptDeal", deal);
	}

}
