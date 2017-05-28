package com.eggmoney.ws.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.eggmoney.ws.domain.entity.Board;

public interface BoardDao {
	List<Board> findList(Map<String, Object> condition) throws DataAccessException;
    int findListCount(Map<String, Object> condition) throws DataAccessException;
}
