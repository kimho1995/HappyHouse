package com.ssafy.house.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.dto.BoardDto;
import com.ssafy.house.dto.MemberDto;
import com.ssafy.house.dto.SearchCondition;
import com.ssafy.house.help.NumberResult;
import com.ssafy.house.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@RestController
//@RequestMapping("/admin")
//@CrossOrigin("*")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
@Api(value="house", description="Happy house")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "모든 유저의 정보를 반환한다.", response = List.class)
	@RequestMapping(value = "/admin/user", method = RequestMethod.GET)
	public ResponseEntity<List<MemberDto>> boards(SearchCondition condition) throws Exception {
		logger.info("1-------------findAllMember-----------------------------"+condition);
		int start = condition.getCurrentPage() * condition.countPerPage - condition.countPerPage;
		condition.setStart(start);
		condition.setSpp(condition.countPerPage);
		logger.info("2-------------find-----------------------------"+condition);
		List<MemberDto> member = userService.userList(condition);
		if (member.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<MemberDto>>(member, HttpStatus.OK);
	}
	
	@ApiOperation(value = "모든 유저의 개수 반환", response = NumberResult.class)
	@RequestMapping(value = "/admin/total", method = RequestMethod.GET)
	public ResponseEntity<NumberResult> totalBoard(SearchCondition condition) throws Exception {
		logger.info("1-------------findAllBoard-----------------------------"+condition);
		int total = userService.getTotalLength(condition);
   		NumberResult nr=new NumberResult();
   		nr.setCount(total);
   		nr.setName("Member");
   		nr.setState("succ");
   		logger.info("5-------------test------------------"+total);
   		if (total<=0) {
   			nr.setCount(-1);
   	   		nr.setName("nomember");
   	   		nr.setState("fail");
   			return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
   		}
   		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
	}
	
//	@GetMapping(value = "/admin/user")
//	public ResponseEntity<List<MemberDto>> userList() {
//		logger.debug("사용자 목록 표시.........");
//		
//		List<MemberDto> list = userService.userList();
//		if(list != null && !list.isEmpty()) {
//			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
//		} else {
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//		}
//	}
	
//	@PostMapping(value = "/admin/user")
//	public ResponseEntity<List<MemberDto>> userRegister(@RequestBody MemberDto memberDto) {
//		boolean total = userService.userRegister(memberDto);
//		if(total) {
//			List<MemberDto> list = userService.userList();
//			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
//		} else
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//	}
	
//	@GetMapping(value = "/admin/user/{userid}")
//	public ResponseEntity<MemberDto> userInfo(@PathVariable("userid") String userid) {
//		logger.debug("파라미터 : {}", userid);
//		MemberDto memberDto = userService.userInfo(userid);
//		if(memberDto != null)
//			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
//		else
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//	}
	
//	@PutMapping(value = "/admin/user")
//	public ResponseEntity<List<MemberDto>> userModify(@RequestBody MemberDto memberDto) {
//		userService.userModify(memberDto);
//		List<MemberDto> list = userService.userList();
//		return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
//	}
	
	@DeleteMapping(value = "/admin/user/{userid}")
	public ResponseEntity<List<MemberDto>> userDelete(@PathVariable("userid") String userid) {
		userService.userDelete(userid);
		SearchCondition condition = new SearchCondition();
		int start = condition.getCurrentPage() * condition.countPerPage - condition.countPerPage;
		condition.setStart(start);
		condition.setSpp(condition.countPerPage);
		List<MemberDto> list = userService.userList(condition);
		return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
	}
	
}
