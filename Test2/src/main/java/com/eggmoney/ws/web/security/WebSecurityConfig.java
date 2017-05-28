package com.eggmoney.ws.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.eggmoney.ws.domain.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/index.do").permitAll().antMatchers("/user/**").permitAll()
				.anyRequest().authenticated().and().formLogin().loginPage("/login.do").failureUrl("/login.do?error")
				.loginProcessingUrl("/authLogin.do").defaultSuccessUrl("/index.do", true).permitAll().and().logout()
				.logoutUrl("/logout.do").logoutSuccessUrl("/login.do?logout")
				// .logoutSuccessHandler(new CustomLogoutSuccessHandler())
				.invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll();
	}
}
