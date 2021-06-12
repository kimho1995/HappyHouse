package com.ssafy.house.dao;

import java.util.List;

import com.ssafy.house.dto.NoticeDto;
import com.ssafy.house.dto.SearchCondition;

public interface NoticeDao {
	public NoticeDto detailNotice(int nid) throws Exception;
	public void addNotice(NoticeDto notice) throws Exception;
	public boolean updateNotice(NoticeDto notice) throws Exception;
	public boolean deleteNotice(int nid) throws Exception;
	public List<NoticeDto> listNotice(SearchCondition condition) throws Exception;
	public int getTotalLength(SearchCondition condition) throws Exception;
}
