package com.llhc.mfsa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoleController {

//	@RequestMapping("/ywy")
//	public String ywyAccount() {
//		return "yewuyuan";
//	}
//	
//	@RequestMapping("/kgy")
//	public String kgyAccount() {
//		return "kuguanyuan";
//	}
	
	@RequestMapping("/user")
	public String userRole(Model model,HttpSession session,String accountErr) {
		if (session.getAttribute("userId") == null) {
			model.addAttribute("loginErr", "noUser");
			return "redirect:/account/loginErr";
		}
		if (accountErr != null) {
			model.addAttribute("success", "访问受限!");
		}
		int role = (Integer)session.getAttribute("role");
		if (role == 1) {
			return "yewuyuan";
		}if (role == 2) {
			return "kuguanyuan";
		}
		else {
			model.addAttribute("loginErr", "unknownRole");
			return "redirect:/account/loginErr";
		}
	}
	
}
