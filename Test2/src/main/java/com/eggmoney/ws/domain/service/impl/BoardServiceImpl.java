package com.eggmoney.ws.domain.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.osgi.framework.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eggmoney.ws.dao.BoardDao;
import com.eggmoney.ws.domain.entity.Board;
import com.eggmoney.ws.domain.entity.PagingObject;
import com.eggmoney.ws.domain.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public PagingObject findList(Map<String, Object> condition, int currentPage, int itemSize)
			throws ServiceException {
		int totalCount = boardDao.findListCount(condition);
        PagingObject obj = new PagingObject();
        obj.setCurrentPage(currentPage);
        obj.setTotalCount(totalCount);
        obj.setItemSize(itemSize);
        condition.put("startRow", obj.getStartRow());
        condition.put("endRow", obj.getEndRow());
        condition.put("itemSize", obj.getItemSize());
        obj.setResultList((List<Board>) ObjectUtils.defaultIfNull(boardDao.findList(condition), Collections.EMPTY_LIST));
        return obj;
	}

}
