package com.llhc.mfsa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
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
	public String userRole(HttpSession session) {
		int role = (Integer)session.getAttribute("role");
		if (role == 1) {
			return "yewuyuan";
		}if (role == 2) {
			return "kuguanyuan";
		}
		else {
			return "error";
		}
	}
	
}
