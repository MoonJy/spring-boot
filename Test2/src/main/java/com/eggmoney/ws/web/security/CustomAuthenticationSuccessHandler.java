package com.eggmoney.ws.web.security;

import com.eggmoney.ws.domain.entity.User;
import com.eggmoney.ws.domain.service.UserService;
import com.eggmoney.ws.utils.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
	
	@Autowired
	private UserService userService;
	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)  throws IOException,  ServletException{
		
		Object obj = authentication.getPrincipal();
		if( obj instanceof User){
			User user = (User) obj;
			logger.debug("Login Success : "+user.getUsername());
			
			
			user.setLoginTreat("true");
			user.setAttempt_login_count(0);
			user.setLogin_ip(IpUtil.getClientIP(request));
			userService.updateLoginFailCount(user);
			
			super.onAuthenticationSuccess(request, response, authentication);
		}
		else {
			SecurityContextHolder.getContext().setAuthentication(null);
			SecurityContextHolder.clearContext();
			logger.debug("Login fail : "+obj);
		}
		
	}
}
