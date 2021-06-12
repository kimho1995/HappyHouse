package com.ssafy.house.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.dto.BoardDto;
import com.ssafy.house.dto.NoticeDto;
import com.ssafy.house.dto.SearchCondition;
import com.ssafy.house.help.BoolResult;
import com.ssafy.house.help.NumberResult;
import com.ssafy.house.service.NoticeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8197/happyhouse/swagger-ui.html
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
@Api(value="SSAFY", description="SSAFY Resouces Management 2019")
public class NoticeController {
	
	public static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService  noticeService; 

	
	@ApiOperation(value = "모든 공지사항의 정보를 반환한다.", response = List.class)
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public ResponseEntity<List<NoticeDto>> boards(SearchCondition condition) throws Exception {
		int start = condition.getCurrentPage() * condition.countPerPage - condition.countPerPage;
		condition.setStart(start);
		condition.setSpp(condition.countPerPage);
		List<NoticeDto> board = noticeService.listNotice(condition);
		if (board.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<NoticeDto>>(board, HttpStatus.OK);
	}
	
	@ApiOperation(value = "모든 공지사항의 개수 반환", response = NumberResult.class)
	@RequestMapping(value = "/notice/total", method = RequestMethod.GET)
	public ResponseEntity<NumberResult> totalBoard(SearchCondition condition) throws Exception {
		int total = noticeService.getTotalLength(condition);
   		NumberResult nr=new NumberResult();
   		nr.setCount(total);
   		nr.setName("addNotice");
   		nr.setState("succ");
   		if (total<=0) {
   			nr.setCount(-1);
   	   		nr.setName("noNotice");
   	   		nr.setState("fail");
   			return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
   		}
   		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
	}

	@ApiOperation(value = "공지사항 아이디로 게시판의 정보를 찾는다.", response = BoardDto.class)
	@RequestMapping(value = "/notice/{nid}", method = RequestMethod.GET)
	public ResponseEntity<NoticeDto> board(@PathVariable int nid) throws Exception {
		NoticeDto board = noticeService.detailNotice(nid);
		if (board==null || board.getNid()==0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<NoticeDto>(board, HttpStatus.OK);
	}
	@ApiOperation(value = " 해당공지사항의 정보를 삭제한다.", response = BoolResult.class)
	@RequestMapping(value = "/notice/{nid}", method = RequestMethod.DELETE)
	public ResponseEntity<BoolResult> deleteBoard(@PathVariable int nid) throws Exception {
		boolean total = noticeService.deleteNotice(nid);
		BoolResult nr=new BoolResult();
		nr.setCount(total);
		nr.setName("deleteNotice");
		nr.setState("succ");
		if (!total) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}

    @ApiOperation(value = " 새로운 공지사항을 정보를 입력한다.", response = NumberResult.class)
   	@RequestMapping(value = "/notice", method = RequestMethod.POST)
   	public ResponseEntity<NumberResult> addEmployee(@RequestBody NoticeDto dto) throws Exception {
   		int total = noticeService.addNotice(dto);
   		NumberResult nr=new NumberResult();
   		nr.setCount(total);
   		nr.setName("addNotice");
   		nr.setState("succ");
   		if (total<=0) {
   			nr.setCount(-1);
   	   		nr.setName("addNotice");
   	   		nr.setState("fail");
   			//return new ResponseEntity(HttpStatus.NO_CONTENT);
   			return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
   		}
   		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
   	}
    
    @ApiOperation(value = " 공지사항의 정보를 수정한다.", response = BoolResult.class)
   	@RequestMapping(value = "/notice", method = RequestMethod.PUT)
   	public ResponseEntity<BoolResult> updateEmployee2(@RequestBody NoticeDto dto) throws Exception {
   		boolean total = noticeService.updateNotice(dto);
   		BoolResult nr=new BoolResult();
   		nr.setCount(total);
   		nr.setName("updateNotice");
   		nr.setState("succ");
   		if (!total) {
   			return new ResponseEntity(HttpStatus.NO_CONTENT);
   		}
   		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
   	}
    
}
