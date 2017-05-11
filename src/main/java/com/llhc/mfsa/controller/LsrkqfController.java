package com.llhc.mfsa.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.llhc.mfsa.service.LsruqfService;
import com.llhc.mfsa.vo.QianfengParam;

@Controller
@RequestMapping("/lsrkqf")
public class LsrkqfController {

	@Autowired
	public LsruqfService service;
	
	@RequestMapping("/access")
	public String access(Model model,HttpSession session) {
		if (session.getAttribute("userId") == null) {
			model.addAttribute("loginErr", "noUser");
			return "redirect:/account/loginErr";
		}else if ((Integer)session.getAttribute("role") != 2) {
			System.out.println((Integer)session.getAttribute("role"));
			model.addAttribute("accountErr", "limited");
			return "redirect:/user";
		}
		return "lsrkqf";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> addPaper(QianfengParam qianfengParam,HttpSession session) {
		ModelMap model = new ModelMap();
		try {
			int checkout = service.checkout(qianfengParam);
			if (checkout == 0) {
				service.addItem(qianfengParam,(Integer)session.getAttribute("userId"));
				model.addAttribute("success", true);
			}else {
				model.addAttribute("success", false);
				if (checkout == 1) {
					model.addAttribute("errorMsg", "文件编号重复");
				} else {
					model.addAttribute("errorMsg", "档案袋编号重复");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("success", false);
			model.addAttribute("errorMsg", e.getMessage());
		}
		return model;
	}
	
}
