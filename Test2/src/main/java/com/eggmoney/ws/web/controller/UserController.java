package com.eggmoney.ws.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.eggmoney.ws.define.MemberType;
import com.eggmoney.ws.domain.entity.User;
import com.eggmoney.ws.domain.service.UserService;
import com.eggmoney.ws.utils.IpUtil;
import com.eggmoney.ws.utils.ResultMessage;
import com.eggmoney.ws.web.controller.form.SearchForm.COMMAND;
import com.eggmoney.ws.web.controller.form.UserForm;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register.do", method = RequestMethod.GET)
	public String registerForm(Model model, @ModelAttribute UserForm form){
		form.setCmd(COMMAND.CREATE.getCode());
		User user = form.getUser();
		user.setMember_type(MemberType.USER.getCode());
		model.addAttribute("userForm", form);
		return "/user/userForm";
	}
	
	@RequestMapping(value="/register.do", method = RequestMethod.POST)
	public String register(HttpServletRequest request, HttpSession session, Model model, @ModelAttribute UserForm form, BindingResult result, SessionStatus status){
		try {
            //아이디 중복 체크
            User user = form.getUser();
            User dbUser = userService.findById(user.getMember_id());
            if (dbUser != null) {
                result.rejectValue("user.member_id", "field.id.duplicated");
                return "/user/userForm";
            }
            user.setLogin_ip(IpUtil.getClientIP(request));
            user.setEmail(user.getMember_id());
            userService.insert(user);

            status.setComplete();

            session.setAttribute("MEMBER_ID", user.getMember_id());
            return "redirect:/user/congratuation.do";
        } catch (Exception e) {
            session.setAttribute("failMessages", ResultMessage.getServerErrorMessages());
            return "/common/error";
        }
	}
	
	@RequestMapping(value ="/congratuaion.do", method = RequestMethod.GET)
	public String congratuation(HttpSession session, Model model, @ModelAttribute UserForm form){
		String member_id = (String)session.getAttribute("MEMBER_ID");
		if(!StringUtils.isBlank(member_id)){
			User user = userService.findById(member_id);
			form.setUser(user);
			model.addAttribute("userForm", form);
		}
		session.removeAttribute("MEMBER_ID");
		return "/user/congratuation";
	}
}
