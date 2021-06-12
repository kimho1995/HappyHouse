package com.ssafy.house.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.house.dto.CommentDto;

@Repository
public class CommentDaoImpl implements CommentDao {
	@Autowired 
	private SqlSession sqlSession;
	
	private String namespace = "com.ssafy.house.dao.CommentDaoImpl.";
	/* 댓글 검색 
	 * input : int
	 * output : List<CommentDto>
	 * */
	@Override
	public List<CommentDto> commentList(int bid) throws Exception {
		return sqlSession.selectList(namespace + "commentList",bid);
	}

	/* 댓글 총 개 
	 * input : int
	 * output : int
	 * */
	@Override
	public int getCommentsCnt(int bid) throws Exception {
		return sqlSession.selectOne(namespace + "getCommentsCnt", bid);
	}


	/* 댓글 추가  
	 * input : CommentDto
	 * output : int
	 * */
	@Override
	public int addComment(CommentDto commentDto) throws Exception {
		return sqlSession.insert(namespace+"addComment",commentDto);
	}


	/* 댓글 수정 
	 * input : CommentDto
	 * output : int
	 * */
	@Override
	public int modComment(CommentDto commentDto) throws Exception {
		return sqlSession.update(namespace+"modComment",commentDto);
	}


	/* 댓글 삭제 
	 * input : int
	 * output : int
	 * */
	@Override
	public int deleteComment(int cid) throws Exception {
		return sqlSession.insert(namespace+"deleteComment",cid);
	}
}
