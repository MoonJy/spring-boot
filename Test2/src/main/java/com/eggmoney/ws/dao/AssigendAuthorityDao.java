package com.eggmoney.ws.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.eggmoney.ws.domain.entity.AssignedAuthority;

@Repository
public interface AssigendAuthorityDao {
	public List<AssignedAuthority> findListByGrade(String grade) throws DataAccessException;
	public void insert(AssignedAuthority assignedAuthority) throws DataAccessException;
	public void delete(String grade) throws DataAccessException;
}
