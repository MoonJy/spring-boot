package com.eggmoney.ws.web.security;

import com.eggmoney.ws.domain.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PreTreatFilter extends OncePerRequestFilter {

	private Logger logger = LoggerFactory.getLogger(PreTreatFilter.class);
	
	private String otpPage;
	private String agreePage;

	public String getOtpPage() {
		return otpPage;
	}
	public void setOtpPage(String otpPage) {
		this.otpPage = otpPage;
	}

	public String getAgreePage() {
		return agreePage;
	}
	public void setAgreePage(String agreePage) {
		this.agreePage = agreePage;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)	throws ServletException, IOException {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if( authentication instanceof UsernamePasswordAuthenticationToken ){
			logger.debug("PreFilter, "+req.getRequestURI());
			UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
			User user = (User) token.getPrincipal();
			
			if( user != null ){
				if( !StringUtils.startsWith(req.getRequestURI(), req.getContextPath()+"/common") ){
					if( !StringUtils.startsWith(req.getRequestURI(), req.getContextPath()+"/agree") ){
						if( !user.isPersonAgree() ){
							req.getRequestDispatcher(agreePage).forward(req, res);
							return;
						}
						/* remove OTP. Kim JB request  
						if( !StringUtils.startsWith(req.getRequestURI(), req.getContextPath()+"/otp") ){
							if( !user.isOtpAuthenticated() ){
								req.getRequestDispatcher(otpPage).forward(req, res);
								return;
							}
						}
						*/
					}
				}
			}
		}
		
		try{
			chain.doFilter(req, res);	
		}
		catch(Exception e){
			logger.error("=============================================");
			logger.error(req.getSession().getId());
			logger.error(req.getRequestURI());
			logger.error(e.getMessage());
			logger.error("=============================================");
			
			throw e;
		}
		
	}

}
