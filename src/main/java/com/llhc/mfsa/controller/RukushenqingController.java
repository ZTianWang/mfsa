package com.llhc.mfsa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.llhc.mfsa.helper.IdHelper;
import com.llhc.mfsa.service.RukushenqingService;
import com.llhc.mfsa.vo.RukushenqingParam;
import com.llhc.mfsa.vo.RukushenqingView;

@Controller
@RequestMapping("/rksq")
public class RukushenqingController {
	
	private String serial;
	
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
		serial = idHelper.getSerialNum();
		List<RukushenqingView> list = service.selectPaper((Integer)session.getAttribute("userId"));
		model.addAttribute("serial", serial);
		model.addAttribute("pageView", list);
		return "rukushenqing";
	}
	
	@RequestMapping("/apply")
//	@ResponseBody
	public String apply(RukushenqingParam pageParam,Model model,HttpSession session) {
//		ModelMap model = new ModelMap();
		pageParam.setInSerial(serial);
		pageParam.setBumenId((Integer)session.getAttribute("bumenId"));
		try {
			service.updateStorage(pageParam,(Integer)session.getAttribute("userId"));
			model.addAttribute("success", "申请成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("success", "申请失败");
			model.addAttribute("ErrorMessage", e.getMessage());
		}
		return "yewuyuan";
	}

}
