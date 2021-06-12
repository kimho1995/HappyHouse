package com.ssafy.house.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.house.dao.NoticeDao;
import com.ssafy.house.dto.NoticeDto;
import com.ssafy.house.dto.SearchCondition;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;

	@Override
	@Transactional(readOnly=true)
	public NoticeDto detailNotice(int nid) throws Exception {
		return noticeDao.detailNotice(nid);
	}

	@Override
	public int addNotice(NoticeDto notice) throws Exception {
		noticeDao.addNotice(notice);
		return 1;
	}

	@Override
	public boolean updateNotice(NoticeDto notice) throws Exception {
		return noticeDao.updateNotice(notice);
	}

	@Override
	public boolean deleteNotice(int nid) throws Exception {
		return noticeDao.deleteNotice(nid);
	}

	@Override
	public List<NoticeDto> listNotice(SearchCondition condition) throws Exception {
		return noticeDao.listNotice(condition);
	}

	@Override
	public int getTotalLength(SearchCondition condition) throws Exception {
		return noticeDao.getTotalLength(condition);
	}
}
