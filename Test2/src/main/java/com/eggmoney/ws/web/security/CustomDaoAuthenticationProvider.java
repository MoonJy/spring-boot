package com.eggmoney.ws.web.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.eggmoney.ws.domain.entity.User;
import com.eggmoney.ws.utils.Messages;


public class CustomDaoAuthenticationProvider extends DaoAuthenticationProvider {

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,  UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		super.additionalAuthenticationChecks(userDetails, authentication);
		
		Object obj = authentication.getDetails();
		if( obj instanceof WebAuthenticationDetails && userDetails instanceof User){
			User user = (User) userDetails;
			WebAuthenticationDetails details = (WebAuthenticationDetails) obj;
			String remoteAddress = details.getRemoteAddress();
			String allowdIp = user.getAllowed_ip();
			if( !StringUtils.equals(allowdIp, "*")){
				if( !remoteAddress.matches(allowdIp) ){
					logger.debug("IP Filtering,"+user.getUsername()+",Fail.allowd ip["+allowdIp+"] remoteAddress=["+remoteAddress+"] ");
					throw new AuthenticationException(Messages.getMessage("AbstractUserDetailsAuthenticationProvider.notAllowedIp")){};
				}
				else{
					logger.debug("IP Filtering,"+user.getUsername()+",OK.allowd ip["+allowdIp+"] remoteAddress=["+remoteAddress+"] ");
				}
			}
			else {
				logger.debug("IP Filtering,"+user.getUsername()+",OK.allowd ip["+allowdIp+"] remoteAddress=["+remoteAddress+"] ");
			}
		}
		else {
			logger.debug("IP Filtering,Invalid Operator Information");
			throw new UsernameNotFoundException("invalid user");
		}

	}
}
