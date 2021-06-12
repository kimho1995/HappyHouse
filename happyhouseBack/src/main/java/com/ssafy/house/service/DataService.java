package com.ssafy.house.service;

import com.ssafy.house.dto.DealDto;

public interface DataService {
	
	public int addOfficeRentData(DealDto deal) throws Exception;

	public int addOfficeDealData(DealDto deal) throws Exception;

	public int addHomeRentData(DealDto deal) throws Exception;
	
	public int addHomeDealData(DealDto deal) throws Exception;
	
	public int addAptRentData(DealDto deal) throws Exception;
	
	public int addAptDealData(DealDto deal) throws Exception;

}
