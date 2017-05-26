package com.eggmoney.ws.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	private Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value= {"/index.do", "/"})
	public String index(Model model){
		return "/index";
	}
}
