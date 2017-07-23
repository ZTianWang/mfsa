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
				model.addAttribute("success", false);
				model.addAttribute("errorMsg", "文件编号重复");
			}else if (checkout == -1) {
				model.addAttribute("success", false);
				model.addAttribute("errorMsg", "未查询到客户信息");
			}else if (checkout == -2) {
				model.addAttribute("success", false);
				model.addAttribute("errorMsg", "未查询到负责人信息");
			}else {
				service.addItem(qianfengParam,checkout,(Integer)session.getAttribute("userId"));
				model.addAttribute("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("success", false);
			model.addAttribute("errorMsg", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/readd")
	@ResponseBody
	public Map<String, Object> readd(String fileNum,HttpSession session) {
		ModelMap model = new ModelMap();
		int i = service.readd(fileNum, (Integer)session.getAttribute("userId"));
		if (i != 0) {
			model.addAttribute("success", true);
		} else {
			model.addAttribute("success",false);
			model.addAttribute("errorMsg", "未查到原始记录");
		}
		return model;
	}
	
}
