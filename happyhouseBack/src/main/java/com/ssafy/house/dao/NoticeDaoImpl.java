package com.ssafy.house.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.house.dto.NoticeDto;
import com.ssafy.house.dto.SearchCondition;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	private String ns="com.ssafy.house.dao.NoticeMapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public NoticeDto detailNotice(int nid) throws Exception {
		return sqlSession.selectOne(ns+"detailNotice", nid);
	}

	@Override
	public void addNotice(NoticeDto notice) throws Exception {
		sqlSession.insert(ns+"addNotice", notice);
	}

	@Override
	public boolean updateNotice(NoticeDto notice) throws Exception {
		sqlSession.update(ns+"updateNotice", notice);
		return true;
	}

	@Override
	public boolean deleteNotice(int nid) throws Exception {
		sqlSession.delete(ns+"deleteNotice", nid);
		return true;
	}

	@Override
	public List<NoticeDto> listNotice(SearchCondition condition) throws Exception {
		return sqlSession.selectList(ns+"listNotice", condition);
	}

	@Override
	public int getTotalLength(SearchCondition condition) throws Exception {
		return sqlSession.selectOne(ns+"getTotalCount", condition);
	}


}
