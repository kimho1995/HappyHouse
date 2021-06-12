package com.ssafy.house.dao;

import java.util.List;

import com.ssafy.house.dto.CommentDto;

public interface CommentDao {
	List<CommentDto> commentList(int bid) throws Exception;

	int getCommentsCnt(int bid) throws Exception;

	int addComment(CommentDto commentDto) throws Exception;

	int modComment(CommentDto commentDto) throws Exception;

	int deleteComment(int cid) throws Exception;
}
