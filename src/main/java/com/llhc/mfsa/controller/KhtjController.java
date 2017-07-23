package com.llhc.mfsa.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.llhc.mfsa.service.KhtjService;
import com.llhc.mfsa.vo.KhtjParam;

@Controller
@RequestMapping("/khtj")
public class KhtjController {
	
	@Autowired
	private KhtjService service;
	
	@RequestMapping("/access")
	public String access(Model model,HttpSession session) {
		if (session.getAttribute("userId") == null) {
			model.addAttribute("loginErr", "noUser");
			return "redirect:/account/loginErr";
		}else if ((Integer)session.getAttribute("role") != 1) {
			model.addAttribute("accountErr", "limited");
			return "redirect:/user";
		}
		return "khtj";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(KhtjParam param) {
		ModelMap model = new ModelMap();
		service.add(param);
		return model.addAttribute("success", true);
	}
	
}
