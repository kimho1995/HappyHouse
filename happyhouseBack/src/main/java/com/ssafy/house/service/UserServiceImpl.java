package com.ssafy.house.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ssafy.house.dao.UserDao;
import com.ssafy.house.dto.MemberDto;
import com.ssafy.house.dto.SearchCondition;
import com.ssafy.house.util.PageNavigation2;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private JavaMailSender mailSender;
	private static final String FROM_ADDRESS = "kimho5730@naver.com";
	
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		if(memberDto.getUserid() == null || memberDto.getPassword() == null)
			return null;
		return userDao.login(memberDto);
	}

	@Override
	public MemberDto userInfo(String userid) {
		return userDao.userInfo(userid);
	}

	@Override
	public boolean userRegister(MemberDto memberDto) {
		userDao.userRegister(memberDto);
		return true;
	}

	@Override
	public boolean userModify(MemberDto memberDto) {
		userDao.userModify(memberDto);
		return true;
	}

	@Override
	public boolean userDelete(String userid) {
		userDao.userDelete(userid);
		return true;
	}

//	@Override
//	public Map<String, Object> pagingSearch(SearchCondition condition) {
//		int totalCount = userDao.getTotalSearchCount(condition);
//		PageNavigation2 nav = new PageNavigation2(condition.getCurrentPage(), totalCount);
//        // 103 줄 /20 줄 -> 6페이지 
//		// 결과를 전달할 pagingResult를 만들고 books와 navigation을 키로 값을 저장한다.
//		Map<String, Object> pagingResult = new HashMap<>();
//
//		pagingResult.put("users", searchMember(condition));
//		pagingResult.put("navigation", nav);
//
//		return pagingResult;
//	}

//	@Override
//	public List<MemberDto> searchMember(SearchCondition searchcondition) {
//		return userDao.searchMember(searchcondition);
//	}
	
	@Override
	public MemberDto findpwd(MemberDto memberDto) {
		return userDao.findpwd(memberDto);
	}

	@Override
	public void sendMail(String pw, String address) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(address);
		message.setFrom(FROM_ADDRESS);
		message.setSubject("[임시]비밀번호 찾기");
		message.setText("비밀번호는" + pw + "입니다.");
		mailSender.send(message);
	}

	@Override
	public List<MemberDto> userList(SearchCondition condition) {
		return userDao.userList(condition);
	}

	@Override
	public int getTotalLength(SearchCondition condition) throws Exception {
		return userDao.getTotalLength(condition);
	}
}
