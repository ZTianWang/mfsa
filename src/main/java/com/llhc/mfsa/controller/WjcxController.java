package com.llhc.mfsa.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.llhc.mfsa.entity.FileInfo;
import com.llhc.mfsa.service.WjcxService;
import com.llhc.mfsa.vo.WjcxParam;

@Controller
@RequestMapping("/wjcx")
public class WjcxController {

	@Autowired
	private WjcxService service;

	@RequestMapping("/access")
	public String access(Model model, HttpSession session) {
		 if (session.getAttribute("userId") == null)  {
		 model.addAttribute("loginErr", "noUser");
		 return "redirect:/account/loginErr";
		 }else {
			 return "wjcx";
		 }
	}

	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(WjcxParam param, HttpSession session) {
		ModelMap model = new ModelMap();
		List<FileInfo> views = service.queryFileList(param);
		if (views != null && views.size() != 0) {
				model.addAttribute("pageViews", views);
				model.addAttribute("success", true);
		}else {
			model.addAttribute("success", false);
			model.addAttribute("errorMsg", "没有查到库存记录");
		}
		return model;
	}

}
