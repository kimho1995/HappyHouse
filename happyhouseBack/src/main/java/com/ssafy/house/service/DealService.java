package com.ssafy.house.service;

import java.util.List;

import com.ssafy.house.dto.DealDto;

public interface DealService {

	List<DealDto> officeRentList(DealDto deal) throws Exception;
	
	int getTotCntOfficeRent(DealDto deal) throws Exception;

	List<DealDto> officeDealList(DealDto deal) throws Exception;
	
	int getTotCntOfficeDeal(DealDto deal) throws Exception;

	List<DealDto> homeRentList(DealDto deal) throws Exception;

	int getTotCntHomeRent(DealDto deal) throws Exception;
	
	List<DealDto> homeDealList(DealDto deal) throws Exception;

	int getTotCntHomeDeal(DealDto deal) throws Exception;

	List<DealDto> aptRentList(DealDto deal) throws Exception;

	int getTotCntAptRent(DealDto deal) throws Exception;
	
	List<DealDto> aptDealList(DealDto deal) throws Exception;

	int getTotCntAptDeal(DealDto deal) throws Exception;




}
