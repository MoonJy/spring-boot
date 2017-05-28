package com.eggmoney.ws.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

	private Logger logger = LoggerFactory.getLogger(CustomAuthenticationLogoutSuccessHandler.class);
	
	
	//@Autowired
	//private SessionRegistry sessionRegistry;

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,  Authentication authentication)   throws IOException, javax.servlet.ServletException{
		super.onLogoutSuccess(request, response, authentication);
		//logger.debug("CMS : Logout Success : "+authentication.getName());
		SecurityContextHolder.getContext().setAuthentication(null);
		SecurityContextHolder.clearContext();
		//sessionRegistry.removeSessionInformation(request.getSession().getId());
	}
	
	
}
