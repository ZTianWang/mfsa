package com.llhc.mfsa.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.llhc.mfsa.service.ClientService;

@Controller
public class test {
	
	@Autowired
	ClientService service;
	
	@RequestMapping("/v")
	public String view() {
		return "a";
	}
	
	@RequestMapping("/a")
	public Map<String, Object> init() {
		ModelMap model = new ModelMap();
//		service.start();
		return model.addAttribute("success", true);
	}
	
	@RequestMapping("/b")
	public Map<String, Object> send() {
		ModelMap model = new ModelMap();
		service.send("qqq");
		return model.addAttribute("success", true);
	}

}
