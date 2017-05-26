package com.eggmoney.ws.domain.service;

import org.osgi.framework.ServiceException;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.eggmoney.ws.domain.entity.User;

public interface UserService extends UserDetailsService{
	public User findById(String id) throws ServiceException;
	public void insert(User user) throws ServiceException;
}
