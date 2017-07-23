package com.llhc.mfsa.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.llhc.mfsa.service.KhcxService;
import com.llhc.mfsa.vo.KhcxParam;
import com.llhc.mfsa.vo.KhcxView;

@Controller
@RequestMapping("/khcx")
public class KhcxController {
	
	@Autowired
	private KhcxService service;
	
	@RequestMapping("/access")
	public String view(Model model,HttpSession session) {
		if (session.getAttribute("userId") == null) {
			model.addAttribute("loginErr", "noUser");
			return "redirect:/account/loginErr";
		}
		return "khcx";
	}

	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(KhcxParam param) {
		ModelMap model = new ModelMap();
		KhcxView view = service.query(param);
		if (view.getName() != null) {
			model.addAttribute("cust", view);
			model.addAttribute("success", true);
		} else {
			model.addAttribute("success", false);
			model.addAttribute("errorMsg", "未查找到记录");
		}
		return model;
	}
	
}
