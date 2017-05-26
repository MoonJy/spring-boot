package com.eggmoney.ws.domain.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.osgi.framework.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eggmoney.ws.dao.AssigendAuthorityDao;
import com.eggmoney.ws.dao.UserDao;
import com.eggmoney.ws.domain.entity.AssignedAuthority;
import com.eggmoney.ws.domain.entity.User;
import com.eggmoney.ws.domain.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private AssigendAuthorityDao assigendAuthorityDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("user_id:"+username);
		
		User user = userDao.findById(username);
		
		if(user == null){
			throw new UsernameNotFoundException("can't find user ["+username+"]");
		}
		List<AssignedAuthority> authList = assigendAuthorityDao.findListByGrade(user.getGrade());
		for(AssignedAuthority auth : authList){
			user.addAuthority(auth);
		}
		return user;
	}

	@Override
	public User findById(String user_id) throws ServiceException {
		User user = userDao.findById(user_id);
		return user;
	}

	@Override
	public void insert(User user) throws ServiceException {
		userDao.insert(user);
	}
}
