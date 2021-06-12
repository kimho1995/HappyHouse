package com.ssafy.house.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.dao.DealDao;
import com.ssafy.house.dto.DealDto;

@Service
public class DealServiceImpl implements DealService {
	
	@Autowired
	private DealDao dealDao;
	/* 오피스텔 전/월세 정보 조회  
	 * input : DealDto
	 * output : List<DealDto> 
	 * */
	@Override
	public List<DealDto> officeRentList(DealDto deal) throws Exception {
		return dealDao.officeRentList(deal);
	}
	
	/* 오피스텔 전/월세 정보 전체 데이터 수 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int getTotCntOfficeRent(DealDto deal) throws Exception {
		return dealDao.getTotCntOfficeRent(deal);
	}
	/* 오피스텔 매매 정보 조회  
	 * input : DealDto
	 * output : List<DealDto> 
	 * */
	@Override
	public List<DealDto> officeDealList(DealDto deal) throws Exception {
		return dealDao.officeDealList(deal);
	}
	
	/* 오피스텔 매매 정보 전체 데이터 수 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int getTotCntOfficeDeal(DealDto deal) throws Exception {
		return dealDao.getTotCntOfficeDeal(deal);
	}

	/* 연립 다세대 전/월세 정보 조회  
	 * input : DealDto
	 * output : List<DealDto> 
	 * */
	@Override
	public List<DealDto> homeRentList(DealDto deal) throws Exception {
		return dealDao.homeRentList(deal);
	}
	
	/* 연립 다세대 전/월세 정보 전체 데이터 수 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int getTotCntHomeRent(DealDto deal) throws Exception {
		return dealDao.getTotCntHomeRent(deal);
	}
	
	/* 연립 다세대 매매 정보 조회  
	 * input : DealDto
	 * output : List<DealDto> 
	 * */
	@Override
	public List<DealDto> homeDealList(DealDto deal) throws Exception {
		return dealDao.homeDealList(deal);
	}
	
	/* 연립 다세대 매매 정보 전체 데이터 수 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int getTotCntHomeDeal(DealDto deal) throws Exception {
		return dealDao.getTotCntHomeDeal(deal);
	}
	
	/* 아파트 전/월세 정보 조회  
	 * input : DealDto
	 * output : List<DealDto> 
	 * */
	@Override
	public List<DealDto> aptRentList(DealDto deal) throws Exception {
		return dealDao.aptRentList(deal);
	}
	
	/* 아파트 전/월세 정보 전체 데이터 수   
	 * input : DealDto
	 * output : int
	 * */
	@Override
	public int getTotCntAptRent(DealDto deal) throws Exception {
		return dealDao.getTotCntAptRent(deal);
	}
	
	/* 아파트 매매 정보 조회  
	 * input : DealDto
	 * output : List<DealDto> 
	 * */
	@Override
	public List<DealDto> aptDealList(DealDto deal) throws Exception {
		return dealDao.aptDealList(deal);
	}
	/* 아파트 매매 정보 전체 데이터 수   
	 * input : DealDto
	 * output : int
	 * */
	@Override
	public int getTotCntAptDeal(DealDto deal) throws Exception {
		return dealDao.getTotCntAptDeal(deal);
	}
	

}
