package com.llhc.mfsa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.llhc.mfsa.entity.UserInfo;
import com.llhc.mfsa.service.AccountService;
import com.llhc.mfsa.vo.AccountParam;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService service;
	
	@RequestMapping("/view")
	public String view() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String account(AccountParam param,Model model,HttpSession session) {
		UserInfo user = new UserInfo();
		user.setUserName(param.getUserName());
		user.setPassword(param.getPassword());
		user = service.confirm(user);
		if (user == null) {
			model.addAttribute("loginError", "账号或密码错误，请重新输入！");
			return "login";
		}else {
			session.setAttribute("userId", user.getId());
			session.setAttribute("bumenId", user.getBumenId());
			session.setAttribute("realName", user.getRealName());
			session.setAttribute("role", user.getRole());
			return "forward:/user";
		}
	}
	
}
