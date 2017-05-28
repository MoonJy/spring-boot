package com.eggmoney.ws.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping(value="/login.do")
	public String login(HttpServletRequest request, HttpSession session){
		return "/common/login";
	}
}
