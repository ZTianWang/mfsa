package com.llhc.mfsa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.llhc.mfsa.service.QianfengService;
import com.llhc.mfsa.vo.QianfengParam;

@Controller
@RequestMapping("/qianfeng")
public class QianfengController {
	
	@Autowired
	private QianfengService qianfengService;

	@RequestMapping("/access")
	public String access(Model model,HttpSession session) {
		if (session.getAttribute("userId") == null) {
			model.addAttribute("loginErr", "noUser");
			return "redirect:/account/loginErr";
		}else if ((Integer)session.getAttribute("role") != 1) {
			model.addAttribute("accountErr", "limited");
			return "redirect:/user";
		}
		return "qianfeng";
	}
	
	@RequestMapping("/add")
//	@ResponseBody
	public String addPaper(QianfengParam qianfengParam,Model model,HttpSession session) {
//		ModelMap model = new ModelMap();
//		System.out.println(qianfengParam);
		try {
//			qianfengService.addFile();
			qianfengService.addItem(qianfengParam,(Integer)session.getAttribute("userId"));
			model.addAttribute("success", "签封成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("success", "签封失败");
			model.addAttribute("ErrorMessage", e.getMessage());
		}
		return "yewuyuan";
	}
	
}
