package com.llhc.mfsa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.llhc.mfsa.service.ChukushouliService;
import com.llhc.mfsa.vo.ChukushouliParam;
import com.llhc.mfsa.vo.ChukushouliView;

@Controller
@RequestMapping("/cksl")
public class ChukushouliController {
	
	private List<ChukushouliView> views;
	private ChukushouliView papers = null;

	@Autowired
	private ChukushouliService service;
	
	@RequestMapping("/access")
	public String access(Model model,HttpSession session) {
		if (session.getAttribute("userId") == null) {
			model.addAttribute("loginErr", "noUser");
			return "redirect:/account/loginErr";
		}else if ((Integer)session.getAttribute("role") != 2) {
			model.addAttribute("accountErr", "limited");
			return "redirect:/user";
		}
		views = service.getSerialList();
		int tote = 0;
		int count = 0;
		if (views.size() > 0) {
			for (ChukushouliView view : views) {
				tote += view.getCount();
			}
		}
		if (papers != null) {
			count = papers.getPaperlist().size();
		}
		model.addAttribute("tote",tote);
		model.addAttribute("serialList", views);
		model.addAttribute("count", count);
		model.addAttribute("paperInfo", papers);
		papers = null;
		return "chukushouli";
	}
	
	@RequestMapping("/query")
	public String queryPapers(ChukushouliParam param,Model model) {
//		this.serialNum = serialNum;
		papers= service.queryPapers(param.getSerialNum());
//		System.out.println(view.getPaperlist().size());
		return "redirect:/cksl/access";
//		return "chukushouli";
	}
	
	@RequestMapping("/accept")
	public String accept(ChukushouliParam param,Model model,HttpSession session) {
		param.setKgyId((Integer)session.getAttribute("userId"));
//		param.setKgyId(2);
		try {
			int count = service.accept(param);
			if (count > 0) {
				model.addAttribute("success", "受理成功!");
			}else {
				model.addAttribute("success", "未查询到流水号！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("success","受理失败");
			model.addAttribute("ErrorMessage", e.getMessage());
		}
		return "kuguanyuan";
	}
	
}
