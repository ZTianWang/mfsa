package com.llhc.mfsa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {

	@RequestMapping("/ywy")
	public String ywyAccount() {
		return "yewuyuan";
	}
	
	@RequestMapping("/kgy")
	public String cgyAccount() {
		return "kuguanyuan";
	}
	
}
