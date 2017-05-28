package com.eggmoney.ws.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.eggmoney.ws.domain.entity.User;

@Repository
public interface UserDao {

	public User findById(String user_id) throws DataAccessException;

	public void insert(User user) throws DataAccessException;

	public void updateLoginFailCount(User user) throws DataAccessException;

}
