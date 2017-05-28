package com.eggmoney.ws.web.security;

import com.eggmoney.ws.domain.entity.User;
import com.eggmoney.ws.domain.service.UserService;
import com.eggmoney.ws.utils.IpUtil;
import com.eggmoney.ws.utils.Messages;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class CustomAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {

    private static Logger logger = LoggerFactory.getLogger(CustomAuthenticationFailHandler.class);

    @Autowired
    private UserService userService;

    private String targetUrlParameter = null;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        if (exception instanceof BadCredentialsException) {
            String username = request.getParameter("j_username");
            if (!StringUtils.isBlank(username)) {
                User user = userService.findById(username);
                if (user != null) {
                    user.setAttempt_login_count(user.getAttempt_login_count() + 1);
                    if (user.isAccountNonLocked()) {
                        List<String> failMessages = new ArrayList<String>();
                        failMessages.add(String.format(Messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentialsOption"), user.getAttempt_login_count(), Messages.getMessage("POLICY.ACCOUNT.LOCK.COUNT")));
                        request.getSession().setAttribute("failMessages", failMessages);
                    } else {
                        List<String> failMessages = new ArrayList<String>();
                        failMessages.add(Messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentialsOptionblock"));
                        request.getSession().setAttribute("failMessages", failMessages);

                    }
                    user.setLogin_ip(IpUtil.getClientIP(request));
                    userService.updateLoginFailCount(user);
                }
            }
        }

        if (logger.isDebugEnabled()) {
            String username = request.getParameter("j_username");
            if (!StringUtils.isBlank(username)) {
                User user = userService.findById(username);
                if (user != null) {
                    logger.debug(user.toString() + "," + exception.toString());
                } else {
                    logger.debug(username + "," + exception.toString());
                }
            } else {
                logger.debug(username + "," + exception.toString());
            }
        }

        String targetUrl = null;
        if(this.targetUrlParameter != null) {
            targetUrl = request.getParameter(this.targetUrlParameter);
        }

        if(StringUtils.contains(targetUrl, "/common/loginResult.do")){ //Ajax로 로그인하는 경우에만 처리
            this.saveException(request, exception);
            if(isUseForward()) {
                logger.debug("Forwarding to " + targetUrl);
                request.getRequestDispatcher(targetUrl).forward(request, response);
            } else {
                logger.debug("Redirecting to " + targetUrl);
                getRedirectStrategy().sendRedirect(request, response, targetUrl);
            }
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }

    public String getTargetUrlParameter() {
        return targetUrlParameter;
    }

    public void setTargetUrlParameter(String targetUrlParameter) {
        this.targetUrlParameter = targetUrlParameter;
    }
}
