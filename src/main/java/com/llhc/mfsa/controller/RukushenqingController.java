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

import com.llhc.mfsa.helper.IdHelper;
import com.llhc.mfsa.service.RukushenqingService;
import com.llhc.mfsa.vo.RukushenqingParam;
import com.llhc.mfsa.vo.RukushenqingView;

@Controller
@RequestMapping("/rksq")
public class RukushenqingController {
	
	@Autowired
	private RukushenqingService service;
	
	@RequestMapping("/access") 
	public String access(Model model,HttpSession session) {
		if (session.getAttribute("userId") == null) {
			model.addAttribute("loginErr", "noUser");
			return "redirect:/account/loginErr";
		}else if ((Integer)session.getAttribute("role") != 1) {
			model.addAttribute("accountErr", "limited");
			return "redirect:/user";
		}
		IdHelper idHelper = new IdHelper();
		String serial = idHelper.getSerialNum();
		List<RukushenqingView> list = service.selectPaper((Integer)session.getAttribute("userId"));
		model.addAttribute("serial", serial);
		model.addAttribute("pageView", list);
		return "rukushenqing";
	}
	
	@RequestMapping("/apply")
	@ResponseBody
	public Map<String, Object> apply(RukushenqingParam pageParam,HttpSession session) {
		ModelMap model = new ModelMap();
		pageParam.setBumenId((Integer)session.getAttribute("bumenId"));
		try {
			int i = service.updateStorage(pageParam,(Integer)session.getAttribute("userId"));
			if (i != 0) {
				model.addAttribute("success", false);
				model.addAttribute("errorMsg", "没有找到记录");
			}
			model.addAttribute("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("success", false);
			model.addAttribute("errorMsg", e.getMessage());
		}
		return model;
	}

}
