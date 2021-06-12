package com.ssafy.house.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.house.dto.MemberDto;
import com.ssafy.house.dto.SearchCondition;

public interface UserDao {

	public MemberDto login(MemberDto memberDto) throws SQLException;
	public MemberDto userInfo(String userid);
	public void userRegister(MemberDto memberDto);
	public void userModify(MemberDto memberDto);
	public void userDelete(String userid);
//	int getTotalSearchCount(SearchCondition searchcondition);
//	List<MemberDto> searchMember(SearchCondition searchcondition);
	public MemberDto findpwd(MemberDto memberDto);

	public List<MemberDto> userList(SearchCondition searchcondition);
	public int getTotalLength(SearchCondition condition) throws Exception;
}
