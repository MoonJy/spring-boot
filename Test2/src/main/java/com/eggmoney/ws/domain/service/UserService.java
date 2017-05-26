package com.eggmoney.ws.domain.service;

import org.osgi.framework.ServiceException;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.eggmoney.ws.domain.entity.User;

public interface UserService extends UserDetailsService{
	User findById(String id) throws ServiceException;
	void insert(User user) throws ServiceException;
}
