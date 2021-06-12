package com.ssafy.house.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.house.dao.ApartDao;
import com.ssafy.house.dto.ApartDto;
import com.ssafy.house.dto.AptAvgDto;
import com.ssafy.house.dto.CityDto;
import com.ssafy.house.dto.SearchCondition2;

@Service
public class ApartServiceImpl implements ApartService {
	
	private static final Logger logger = LoggerFactory.getLogger(ApartServiceImpl.class);
	
	@Autowired
	private ApartDao apartDao;
	
	@Override
	public List<AptAvgDto> listAptAvgDesc(Map map) {
		return apartDao.listAptAvgDesc(map);
	}

	@Override
	public List<AptAvgDto> listAptAvgAsc(Map map) {
		return apartDao.listAptAvgAsc(map);
	}
	

	@Override
	@Transactional(readOnly=true)
	public List<CityDto> listGu(String cityCode) {
		return apartDao.listGu(cityCode);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CityDto> listDong(String guCode) {
		return apartDao.listDong(guCode);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ApartDto> apartInfo(ApartDto apartDto) {
		return apartDao.apartInfo(apartDto);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ApartDto> apartDetail(SearchCondition2 searchCondition) {
		return apartDao.apartDetail(searchCondition);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ApartDto> apartList(String searchWord) {
		return apartDao.apartList(searchWord);
	}

	@Override
	public List<CityDto> listSido() {
		return apartDao.listSido();
	}
	
}
