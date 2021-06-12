package com.ssafy.house.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.house.dao.IBoardDao;
import com.ssafy.house.dto.BoardDto;
import com.ssafy.house.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private IBoardDao boardDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<BoardDto> findAllBoard() throws Exception {
		return boardDao.findAllBoard();
	}

	@Override
	@Transactional(readOnly=true)
	public BoardDto detailBoard(int bid) throws Exception {
		return boardDao.detailBoard(bid);
	}

	@Override
	public int addBoard(BoardDto board) throws Exception {
		boardDao.addBoard(board);
		return 1;
	}

	@Override
	public boolean updateBoard(BoardDto board) throws Exception {
		return boardDao.updateBoard(board);
	}

	@Override
	public boolean deleteBoard(int bid) throws Exception {
		return boardDao.deleteBoard(bid);
	}

	@Override
	@Transactional(readOnly=true)
	public List<BoardDto> searchBoard(BoardDto board) throws Exception {
		return boardDao.searchBoard(board);
	}

	@Override
	public List<BoardDto> listBoard(SearchCondition condition) throws Exception {
		return boardDao.listBoard(condition);
	}

	@Override
	public int getTotalLength(SearchCondition condition) throws Exception {
		return boardDao.getTotalLength(condition);
	}
}
