package com.llhc.mfsa.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.llhc.mfsa.service.RuhushouliService;
import com.llhc.mfsa.vo.RukushouliParam;
import com.llhc.mfsa.vo.RukushouliView;

@Controller
@RequestMapping("/rksl")
public class RukushouliController {
	
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
		List<RukushouliView> serialList = service.getSerialList();
		int tote = 0;
		if (serialList.size() > 0) {
			for (RukushouliView view : serialList) {
				tote += view.getCount();
			}
		}
		model.addAttribute("tote", tote);
		model.addAttribute("serialList", serialList);
		return "rukushouli";
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> queryPapers(@RequestParam("serialNum")String serialNum) {
		ModelMap model = new ModelMap();
		if (serialNum != null && !"".equals(serialNum)) {
			RukushouliView view = service.queryPapers(serialNum);
			model.addAttribute("count", view.getPaperlist().size());
			model.addAttribute("paperInfo", view);
			model.addAttribute("serialNum", serialNum);
			model.addAttribute("success", true);
		}else {
			model.addAttribute("success", false);
			model.addAttribute("errorMsg", "没有查到流水号");
		}
		return model;
	}
	
	@RequestMapping("/accept")
	@ResponseBody
	public Map<String, Object> accept(RukushouliParam param,HttpSession session) {
		ModelMap model = new ModelMap();
		if (param.getFileNum() != null && param.getFileNum().size() != 0) {
			try {
				int count = service.accept(param,(Integer)session.getAttribute("userId"));
				if (count >0) {
//				service.send();
					model.addAttribute("sucCount", count);
					model.addAttribute("success", true);
				}else {
					model.addAttribute("success",false);
					model.addAttribute("errorMsg", "受理失败:未查询到档案编号！");
				}
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("success",false);
				model.addAttribute("errorMsg", "服务器错误");
			}
		}else {
			model.addAttribute("success",false);
			model.addAttribute("errorMsg", "未提交内容");
		}
		return model;
	}
	
}
