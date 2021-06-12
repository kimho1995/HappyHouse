package com.ssafy.house.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ssafy.house.dto.SearchCondition;
import com.ssafy.house.help.BoolResult;
import com.ssafy.house.help.NumberResult;
import com.ssafy.house.service.BoardService;
import com.ssafy.house.util.NewsApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8197/happyhouse/swagger-ui.html
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
@Api(value="SSAFY", description="SSAFY Resouces Management 2019")
public class BoardController {
	
	public static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService  boardService; 

	
	@ApiOperation(value = "모든 게시판의 정보를 반환한다.", response = List.class)
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public ResponseEntity<List<BoardDto>> boards(SearchCondition condition) throws Exception {
		logger.info("1-------------findAllBoard-----------------------------"+condition);
		int start = condition.getCurrentPage() * condition.countPerPage - condition.countPerPage;
		condition.setStart(start);
		condition.setSpp(condition.countPerPage);
		logger.info("2-------------findAllBoard-----------------------------"+condition);
		List<BoardDto> board = boardService.listBoard(condition);
		if (board.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BoardDto>>(board, HttpStatus.OK);
	}
	
	@ApiOperation(value = "모든 게시판의 개수 반환", response = NumberResult.class)
	@RequestMapping(value = "/board/total", method = RequestMethod.GET)
	public ResponseEntity<NumberResult> totalBoard(SearchCondition condition) throws Exception {
		logger.info("1-------------findAllBoard-----------------------------"+condition);
		int total = boardService.getTotalLength(condition);
   		NumberResult nr=new NumberResult();
   		nr.setCount(total);
   		nr.setName("addBoard");
   		nr.setState("succ");
   		logger.info("5-------------addEmployee-------id------------------"+total);
   		if (total<=0) {
   			nr.setCount(-1);
   	   		nr.setName("noBoard");
   	   		nr.setState("fail");
   			return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
   		}
   		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
	}
	
//	@ApiOperation(value = "모든 게시판의 정보를 반환한다.", response = List.class)
//	@RequestMapping(value = "/board", method = RequestMethod.GET)
//	public ResponseEntity<List<BoardDto>> boards() throws Exception {
//		logger.info("1-------------findAllBoard-----------------------------"+new Date());
//		List<BoardDto> board = boardService.findAllBoard();
//		if (board.isEmpty()) {
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<BoardDto>>(board, HttpStatus.OK);
//	}
	@ApiOperation(value = "게시판 아이디로 게시판의 정보를 찾는다.", response = BoardDto.class)
	@RequestMapping(value = "/board/{bid}", method = RequestMethod.GET)
	public ResponseEntity<BoardDto> board(@PathVariable int bid) throws Exception {
		logger.info("1-------------findBoardById-----------------------------"+new Date());
		BoardDto board = boardService.detailBoard(bid);
		if (board==null || board.getBid()==0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoardDto>(board, HttpStatus.OK);
	}
	@ApiOperation(value = " 해당게시판의 정보를 삭제한다.", response = BoolResult.class)
	@RequestMapping(value = "/board/{bid}", method = RequestMethod.DELETE)
	public ResponseEntity<BoolResult> deleteBoard(@PathVariable int bid) throws Exception {
		logger.info("1-------------deleteBoard-----------------------------"+new Date());
		logger.info("1-------------deleteBoard-----------------------------"+bid);
		
		boolean total = boardService.deleteBoard(bid);
		
		BoolResult nr=new BoolResult();
		nr.setCount(total);
		nr.setName("deleteBoard");
		nr.setState("succ");
		if (!total) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}

    @ApiOperation(value = " 새로운 게시판을 정보를 입력한다.", response = NumberResult.class)
   	@RequestMapping(value = "/addBoard", method = RequestMethod.POST)
   	public ResponseEntity<NumberResult> addEmployee(@RequestBody BoardDto dto) throws Exception {
   		logger.info("5-------------addEmployee-----------------------------"+new Date());
   		logger.info("5-------------addEmployee-----------------------------"+dto);
   		int total = boardService.addBoard(dto);
   		NumberResult nr=new NumberResult();
   		nr.setCount(total);
   		nr.setName("addBoard");
   		nr.setState("succ");
   		logger.info("5-------------addEmployee-------id------------------"+total);
   		if (total<=0) {
   			nr.setCount(-1);
   	   		nr.setName("addEmployee");
   	   		nr.setState("fail");
   			//return new ResponseEntity(HttpStatus.NO_CONTENT);
   			return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
   		}
   		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
   	}
    
    @ApiOperation(value = " 게시판의 정보를 수정한다.", response = BoolResult.class)
   	@RequestMapping(value = "/updateBoard", method = RequestMethod.PUT)
   	public ResponseEntity<BoolResult> updateEmployee2(@RequestBody BoardDto dto) throws Exception {
   		logger.info("1-------------updateEmployee-----------------------------"+new Date());
   		logger.info("1-------------updateEmployee-----------------------------"+dto);
   		boolean total = boardService.updateBoard(dto);
   		BoolResult nr=new BoolResult();
   		nr.setCount(total);
   		nr.setName("updateBoard");
   		nr.setState("succ");
   		if (!total) {
   			return new ResponseEntity(HttpStatus.NO_CONTENT);
   		}
   		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
   	}
    
//    @ApiOperation(value = "검색한 모든 게시판의 정보를 반환한다.", response = List.class)
//	@RequestMapping(value = "/searchBoard/{searchtype}/{searchname}", method = RequestMethod.GET)
//	public ResponseEntity<List<BoardDto>> searchboard(@PathVariable String searchtype, @PathVariable String searchname) throws Exception {
//		logger.info("1-------------searchAllBoard-----------------------------"+new Date());
//		BoardDto dto = new BoardDto(searchtype, searchname);
//		List<BoardDto> board = boardService.searchBoard(dto);
//		if (board.isEmpty()) {
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<BoardDto>>(board, HttpStatus.OK);
//	}
    
	@ApiOperation(value = "모든 게시판의 정보를 반환한다.", response = String.class)
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public ResponseEntity<String> news() throws Exception {
		String clientId = "wrkZjByj56cMsCnOdbb_"; //애플리케이션 클라이언트 아이디값"
        String clientSecret = "JcsPfrSLmy"; //애플리케이션 클라이언트 시크릿값"

        String text = null;
        try {
            text = URLEncoder.encode("부동산", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }

        String apiURL = "https://openapi.naver.com/v1/search/news.json?query=" + text+ "&display=5&start=1&sort=sim";    // json 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = NewsApi.get(apiURL,requestHeaders);

		return new ResponseEntity<String>(responseBody, HttpStatus.OK);
	}
    
}
