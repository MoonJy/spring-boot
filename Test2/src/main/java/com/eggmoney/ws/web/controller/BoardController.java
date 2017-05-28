package com.eggmoney.ws.web.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eggmoney.ws.config.AWSconfig;
import com.eggmoney.ws.domain.entity.PagingObject;
import com.eggmoney.ws.domain.service.BoardService;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AWSconfig awsConfig;
	
	@Autowired
	private BoardService boardService;
	
	private final String BUCKET_BOARD_PATH = "images/board/";
	
	@RequestMapping(value="/getList.do")
    public String list(HttpSession session, Model model, @ModelAttribute BoardForm form){

        Map<String, Object> conditionMap = form.getConditionMap();

        PagingObject pagingObject = boardService.findList(conditionMap, form.getCurrentPage(),
                form.getItemSize());
        form.setPagingObject(pagingObject);
        model.addAttribute("searchForm", form);
        return "/board/boardrList";

    }
}
