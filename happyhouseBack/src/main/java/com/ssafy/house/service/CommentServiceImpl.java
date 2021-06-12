package com.ssafy.house.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.dao.CommentDao;
import com.ssafy.house.dto.CommentDto;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired 
	private CommentDao commentDao;
	/* 댓글 검색 
	 * input : int
	 * output : List<CommentDto>
	 * */
	@Override
	public List<CommentDto> commentList(int bid) throws Exception {
		return commentDao.commentList(bid);
	}

	/* 댓글 총 개 
	 * input : int
	 * output : int
	 * */
	@Override
	public int getCommentsCnt(int bid) throws Exception {
		return commentDao.getCommentsCnt(bid);
	}


	/* 댓글 추가  
	 * input : CommentDto
	 * output : int
	 * */
	@Override
	public int addComment(CommentDto commentDto) throws Exception {
		return commentDao.addComment(commentDto);
	}


	/* 댓글 수정 
	 * input : CommentDto
	 * output : int
	 * */
	@Override
	public int modComment(CommentDto commentDto) throws Exception {
		return commentDao.modComment(commentDto);
	}


	/* 댓글 삭제 
	 * input : CommentDto
	 * output : int
	 * */
	@Override
	public int deleteComment(int cid) throws Exception {
		return commentDao.deleteComment(cid);
	}

}
