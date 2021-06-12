package com.ssafy.house.controller;

import java.util.Date;
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

import com.ssafy.house.dto.CommentDto;
import com.ssafy.house.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/* 댓글 관리 controller */

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
@Api(value="house", description="Happy house")

public class CommentController {
	
	public static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	private CommentService commentService;
	
	@ApiOperation(value = "게시물에 해당하는 댓글 리스트를 조회", response = List.class)
	@RequestMapping(value = "/comments/{bid}", method = RequestMethod.GET)
	public ResponseEntity<List<CommentDto>> commentList(@PathVariable int bid) throws Exception {
		logger.info("1-------------commentList-----------------------------"+new Date());
		
		List<CommentDto> comments = commentService.commentList(bid);
		if (comments.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CommentDto>>(comments, HttpStatus.OK);
	}
	
	@ApiOperation(value = "게시물에 해당하는 댓글 리스트 총 수 ", response = Integer.class)
	@RequestMapping(value = "/getCommentsCnt/{bid}", method = RequestMethod.GET)
	public ResponseEntity<Integer> getCommentsCnt(@PathVariable int bid) throws Exception {
		logger.info("1-------------getCommentsCnt-----------------------------"+new Date());
		
		int totCnt = commentService.getCommentsCnt(bid);
		if (totCnt==-1) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Integer>(totCnt, HttpStatus.OK);
	}
	
	@ApiOperation(value = " 게시글에 해당하는 댓글을 입력한다.", response = Integer.class)
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public ResponseEntity<Integer> addComment(@RequestBody CommentDto commentDto) throws Exception{
		logger.info("5-------------addComment-----------------------------"+new Date());
		
		int result = commentService.addComment(commentDto);
		
		if (result==-1) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = " 게시글에 해당하는 댓글을 수한다.", response = Integer.class)
	@RequestMapping(value = "/modComment", method = RequestMethod.PUT)
	public ResponseEntity<Integer> modComment(@RequestBody CommentDto commentDto) throws Exception{
		logger.info("5-------------modComment-----------------------------"+new Date());
		logger.info("5-------------modComment-----------------------------"+commentDto.getContent());
		int result = commentService.modComment(commentDto);
		
		if (result==-1) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = " 게시글에 해당하는 댓글을 삭제힌다.", response = Integer.class)
	@RequestMapping(value = "/deleteComment/{cid}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteComment(@PathVariable int cid) throws Exception{
		logger.info("5-------------deleteComment-----------------------------"+new Date());
		
		int result = commentService.deleteComment(cid);
		
		if (result==-1) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	

}
