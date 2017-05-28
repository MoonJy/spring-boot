package com.eggmoney.ws.domain.service;

import java.util.Map;

import org.osgi.framework.ServiceException;

import com.eggmoney.ws.domain.entity.PagingObject;

public interface BoardService {

	PagingObject findList(Map<String, Object> conditionMap, int currentPage, int itemSize) throws ServiceException;

}
