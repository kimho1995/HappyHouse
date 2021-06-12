package com.ssafy.house.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.dao.DataDao;
import com.ssafy.house.dto.DealDto;

@Service
public class DataServiceImpl implements DataService {
	@Autowired
	private DataDao dataDao;
	
	/* 오피스텔 전월세 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addOfficeRentData(DealDto deal) throws Exception {
		return dataDao.addOfficeRentData(deal);
	}
	/* 오피스텔 매매 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addOfficeDealData(DealDto deal) throws Exception{
		return dataDao.addOfficeDealData(deal);
	}
	/* 연립다세대 전월세 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addHomeRentData(DealDto deal) throws Exception {
		return dataDao.addHomeRentData(deal);
	}
	
	/* 연립다세대 매매 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addHomeDealData(DealDto deal) throws Exception {
		return dataDao.addHomeDealData(deal);
	}
	
	/* 아파트 전월세 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addAptRentData(DealDto deal) throws Exception {
		return dataDao.addAptRentData(deal);
	}
	
	/* 아파트 매매 정보 저장 
	 * input : DealDto
	 * output : int 
	 * */
	@Override
	public int addAptDealData(DealDto deal) throws Exception {
		return dataDao.addAptDealData(deal);
	}

}
