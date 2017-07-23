package com.llhc.mfsa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoleController {
	
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
			return "ywy";
		}if (role == 2) {
			return "kgy";
		}
		else {
			model.addAttribute("loginErr", "unknownRole");
			return "redirect:/account/loginErr";
		}
	}
	
	@RequestMapping("/ywy")
	public String ywy(Model model,HttpSession session,String accountErr){
		return"yewuyuan";
	}
	
	@RequestMapping("/kgy")
	public String kgy(Model model,HttpSession session,String accountErr){
		return"kuguanyuan";
	}
	
}
