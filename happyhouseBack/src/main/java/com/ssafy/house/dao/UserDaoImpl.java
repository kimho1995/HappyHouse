package com.ssafy.house.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.house.dto.MemberDto;
import com.ssafy.house.dto.SearchCondition;

@Repository
public class UserDaoImpl implements UserDao {

	private String ns="com.ssafy.house.dao.UserMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberDto login(MemberDto memberDto) throws SQLException {
		return sqlSession.selectOne(ns+"login", memberDto);
	}

	@Override
	public MemberDto userInfo(String userid) {
		return sqlSession.selectOne(ns+"userInfo", userid);
	}

	@Override
	public void userRegister(MemberDto memberDto) {
		sqlSession.insert(ns+"userRegister",memberDto);
	}

	@Override
	public void userModify(MemberDto memberDto) {
		sqlSession.update(ns+"userModify",memberDto);
	}

	@Override
	public void userDelete(String userid) {
		sqlSession.delete(ns+"userDelete",userid);
	}

//	@Override
//	public int getTotalSearchCount(SearchCondition searchcondition) {
//		return sqlSession.selectOne(ns+"",searchcondition);
//	}

//	@Override
//	public List<MemberDto> searchMember(SearchCondition searchcondition) {
//		return sqlSession.selectList(ns+"searchMember", searchcondition);
//	}
	
	@Override
	public MemberDto findpwd(MemberDto memberDto) {
		return sqlSession.selectOne(ns+"findpwd",memberDto);
	}

	@Override
	public List<MemberDto> userList(SearchCondition searchcondition) {
		return sqlSession.selectList(ns+"userList", searchcondition);
	}

	@Override
	public int getTotalLength(SearchCondition condition) throws Exception {
		return sqlSession.selectOne(ns+"getTotalCount", condition);
	}

}
