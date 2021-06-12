package com.ssafy.house.service;

import java.util.List;

import com.ssafy.house.dto.NoticeDto;
import com.ssafy.house.dto.SearchCondition;

public interface NoticeService {
	public NoticeDto detailNotice(int nid) throws Exception;
	public int addNotice(NoticeDto notice) throws Exception;
	public boolean updateNotice(NoticeDto notice) throws Exception;
	public boolean deleteNotice(int nid) throws Exception;
	public List<NoticeDto> listNotice(SearchCondition condition) throws Exception;
	public int getTotalLength(SearchCondition condition) throws Exception;
}
