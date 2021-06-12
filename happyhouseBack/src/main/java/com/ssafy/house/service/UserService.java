package com.ssafy.house.service;

import java.util.List;
import java.util.Map;

import com.ssafy.house.dto.MemberDto;
import com.ssafy.house.dto.SearchCondition;

public interface UserService {
	public MemberDto login(MemberDto memberDto) throws Exception;
	public MemberDto userInfo(String userid);
	public boolean userRegister(MemberDto memberDto);
	public boolean userModify(MemberDto memberDto);
	public boolean userDelete(String userid);
//	Map<String, Object> pagingSearch(SearchCondition condition);
//	List<MemberDto> searchMember(SearchCondition searchcondition);
	public MemberDto findpwd(MemberDto memberDto);
	public void sendMail(String pw, String address);
	
	public List<MemberDto> userList(SearchCondition condition);
	public int getTotalLength(SearchCondition condition) throws Exception;
}
