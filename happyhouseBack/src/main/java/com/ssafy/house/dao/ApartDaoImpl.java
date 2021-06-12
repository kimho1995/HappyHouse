package com.ssafy.house.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.house.dto.ApartDto;
import com.ssafy.house.dto.AptAvgDto;
import com.ssafy.house.dto.CityDto;
import com.ssafy.house.dto.SearchCondition2;

@Repository
public class ApartDaoImpl implements ApartDao {
	
	private String ns="com.ssafy.house.dao.ApartMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<AptAvgDto> listAptAvgDesc(Map map) {
		return sqlSession.selectList(ns+"listAptAvgDesc", map);
	}
	@Override
	public List<AptAvgDto> listAptAvgAsc(Map map) {
		return sqlSession.selectList(ns+"listAptAvgAsc", map);
	}
	

	@Override
	public List<CityDto> listGu(String cityCode) {
		return sqlSession.selectList(ns+"listGu", cityCode);
	}

	@Override
	public List<CityDto> listDong(String guCode) {
		return sqlSession.selectList(ns+"listDong", guCode);
	}

	@Override
	public List<ApartDto> apartInfo(ApartDto apartDto) {
		return sqlSession.selectList(ns+"apartInfo", apartDto);
	}

	@Override
	public List<ApartDto> apartDetail(SearchCondition2 searchCondition) {
		return sqlSession.selectList(ns+"apartDetail", searchCondition);
	}

	@Override
	public List<ApartDto> apartList(String searchWord) {
		return sqlSession.selectList(ns+"apartList", searchWord);
	}

	@Override
	public List<CityDto> listSido() {
		return sqlSession.selectList(ns + "listSido");
	}

}
