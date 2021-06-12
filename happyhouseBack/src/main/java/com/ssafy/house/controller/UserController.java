package com.ssafy.house.controller;

import java.util.UUID;

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
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.dto.MemberDto;
import com.ssafy.house.help.BoolResult;
import com.ssafy.house.service.UserService;

import io.swagger.annotations.Api;


@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
@Api(value="house", description="Happy house")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/user")
	public ResponseEntity<BoolResult> userRegister(@RequestBody MemberDto memberDto) {	
		boolean total = userService.userRegister(memberDto);
		BoolResult nr=new BoolResult();
		nr.setCount(total);
		nr.setName("insertEmployee");
		nr.setState("succ");
		if (!total) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}
	
	@PostMapping(value = "/user/login")
	public ResponseEntity<MemberDto> login(@RequestBody MemberDto mdto) throws Exception {
		MemberDto memberDto = userService.login(mdto);
		if(memberDto != null)
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value = "/user")
	public ResponseEntity<MemberDto> userModify(@RequestBody MemberDto memberDto) {	
		boolean total = userService.userModify(memberDto);
		if (!total) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		MemberDto mdto = userService.userInfo(memberDto.getUserid());
		return new ResponseEntity<MemberDto>(mdto, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/user/{userid}")
	public ResponseEntity<BoolResult> userDelete(@PathVariable("userid") String userid) {
		boolean total = userService.userDelete(userid);
		BoolResult nr=new BoolResult();
		nr.setCount(total);
		nr.setName("deleteEmployee");
		nr.setState("succ");
		if (!total) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}
	
	@PostMapping(value = "/user/findpw")
	public ResponseEntity<BoolResult> findPassword(@RequestBody MemberDto mdto) {
		MemberDto memberDto = userService.findpwd(mdto);
		if(memberDto == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} else {
			String uuid = UUID.randomUUID().toString().replace("-", "");
			uuid = uuid.substring(0,10);
			memberDto.setPassword(uuid);
			boolean total = userService.userModify(memberDto);
			BoolResult nr=new BoolResult();
			nr.setCount(total);
			nr.setName("succEmail");
			nr.setState("succ");
			userService.sendMail(uuid, memberDto.getEmail());
			return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/user/{userid}")
	public ResponseEntity<BoolResult> checkId(@PathVariable("userid") String userid) {
		logger.debug("파라미터 : {}", userid);
		MemberDto memberDto = userService.userInfo(userid);
		BoolResult nr=new BoolResult();
		nr.setCount(false);
		nr.setName("noId");
		nr.setState("succ");
		if(memberDto == null) {
			nr.setCount(true);
			return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
		}
		else
			return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}
	
}
