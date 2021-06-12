package com.ssafy.house.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.house.dto.BoardDto;
import com.ssafy.house.dto.SearchCondition;

public interface IBoardDao {
	public List<BoardDto> findAllBoard() throws Exception;
	public BoardDto detailBoard(int bid) throws Exception;
	public void addBoard(BoardDto board) throws Exception;
	public boolean updateBoard(BoardDto board) throws Exception;
	public boolean deleteBoard(int bid) throws Exception;
	public List<BoardDto> searchBoard(BoardDto board) throws Exception;
	
	//수정중
	public List<BoardDto> listBoard(SearchCondition condition) throws Exception;
	public int getTotalLength(SearchCondition condition) throws Exception;
}
