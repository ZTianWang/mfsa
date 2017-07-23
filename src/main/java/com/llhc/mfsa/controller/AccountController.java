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
		if (param == null) {
			return "login";
		}
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
			return "redirect:/user";
		}
	}
	
	@RequestMapping("/loginErr")
	public String loginError(String loginErr,Model model) {
		if (loginErr.equals("noUser")) {
			model.addAttribute("loginError", "请先登录");
		}else if (loginErr.equals("unknownRole")) {
			model.addAttribute("loginError", "身份验证失败，请重新登录");
		}
		return "forward:/account/view";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
}
