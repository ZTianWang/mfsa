package com.llhc.mfsa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.llhc.mfsa.service.RuhushouliService;
import com.llhc.mfsa.vo.RukushouliParam;
import com.llhc.mfsa.vo.RukushouliView;

@Controller
@RequestMapping("/rksl")
public class RukushouliController {
	
	private List<RukushouliView> serialList;
	private String serialNum;
	private int tote = 0;
	
	@Autowired
	private RuhushouliService service;

	@RequestMapping("/access")
	public String access(Model model,HttpSession session) {
		if (session.getAttribute("userId") == null) {
			model.addAttribute("loginErr", "noUser");
			return "redirect:/account/loginErr";
		}else if ((Integer)session.getAttribute("role") != 2) {
			model.addAttribute("accountErr", "limited");
			return "redirect:/user";
		}
		serialList = service.getSerialList();
		if (serialList.size() > 0) {
			for (RukushouliView view : serialList) {
				tote += view.getCount();
			}
		}
		model.addAttribute("tote", tote);
		model.addAttribute("count", 0);
		model.addAttribute("serialList", serialList);
		return "rukushouli";
	}
	
	@RequestMapping(value="/query",method=RequestMethod.GET)
	public String queryPapers(@RequestParam("serialNum")String serialNum,Model model) {
		this.serialNum = serialNum;
		RukushouliView view = service.queryPapers(serialNum);
		model.addAttribute("tote", tote);
		model.addAttribute("count", view.getPaperlist().size());
		model.addAttribute("serialList", serialList);
		model.addAttribute("paperInfo", view);
		return "rukushouli";
	}
	
	@RequestMapping("/accept")
//	@ResponseBody
	public String accept(RukushouliParam param,Model model,HttpSession session) {
//		ModelMap model = new ModelMap();
		param.setSerialNum(serialNum);
		try {
			int count = service.accept(param,(Integer)session.getAttribute("userId"));
			if (count >0) {
				model.addAttribute("success", "受理成功!");
			}else {
				model.addAttribute("success","受理失败:未查询到档案编号！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("success","受理失败");
			model.addAttribute("ErrorMessage", e.getMessage());
		}
		return "kuguanyuan";
	}
	
}
