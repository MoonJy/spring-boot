package com.eggmoney.ws.web.security;


import com.eggmoney.ws.utils.IpUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


public class LoggingFilter extends OncePerRequestFilter {

	private Logger logger = LoggerFactory.getLogger(LoggingFilter.class.getName()+".Access");
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)	throws ServletException, IOException {
		long startTime = System.currentTimeMillis();
		Exception exception = null;
		try{
			chain.doFilter(req, res);	
		}
		catch(Exception e){
			exception = e;
			throw e;
		}
		finally{
			printAccessLog(req, res, exception , System.currentTimeMillis() - startTime);
		}
	}
	
	private void printAccessLog(HttpServletRequest req, HttpServletResponse res, Exception exception, long elapsedTime ){
		StringBuilder sb = new StringBuilder();
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if( authentication instanceof UsernamePasswordAuthenticationToken){
			UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
			sb.append(token.getName());
		}
		else {
			sb.append("Anonymous");
		}
		sb.append("|");
		sb.append(IpUtil.getClientIP(req)).append("|");
		sb.append(req.getMethod()).append("|");
		sb.append(req.getRequestURI()).append("|");
		
		StringBuilder params = new StringBuilder();
		Enumeration<String> e = req.getParameterNames();
		while( e.hasMoreElements() ){
			String name = e.nextElement();
			params.append(name).append("=").append(req.getParameter(name)).append(",");
		}
		sb.append(StringUtils.chomp(StringUtils.defaultIfEmpty(params.toString(), " "), ",")).append("|");
		sb.append(res.getStatus()).append("|");
		
		sb.append(elapsedTime);
		if( req.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION) != null ){
			sb.append("|").append(req.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION));
		}
		if( exception != null ){
			sb.append("|").append(exception.getMessage());
		}
		logger.info(sb.toString());
	}
}
