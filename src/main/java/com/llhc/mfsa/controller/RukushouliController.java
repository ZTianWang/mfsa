package com.llhc.mfsa.controller;

import java.util.List;

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
	
	@Autowired
	private RuhushouliService service;

	@RequestMapping("/access")
	public String access(Model model) {
		serialList = service.getSerialList();
		model.addAttribute("serialList", serialList);
		return "rukushouli";
	}
	
	@RequestMapping(value="/query",method=RequestMethod.GET)
	public String queryPapers(@RequestParam("serialNum")String serialNum,Model model) {
		this.serialNum = serialNum;
		RukushouliView view = service.queryPapers(serialNum);
		model.addAttribute("serialList", serialList);
		model.addAttribute("paperInfo", view);
		return "rukushouli";
	}
	
	@RequestMapping("/accept")
//	@ResponseBody
	public String accept(RukushouliParam param,Model model) {
//		ModelMap model = new ModelMap();
		param.setSerialNum(serialNum);
		try {
			int count = service.accept(param,2);
			if (count >0) {
				model.addAttribute("success", "受理成功");
			}else {
				model.addAttribute("success","受理失败:未查询到档案编号");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("success","受理失败");
			model.addAttribute("ErrorMessage", e.getMessage());
		}
		return "kuguanyuan";
	}
	
}
