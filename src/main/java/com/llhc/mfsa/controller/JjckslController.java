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

import com.llhc.mfsa.entity.PaperInfo;
import com.llhc.mfsa.service.JjckslService;
import com.llhc.mfsa.vo.JjckslParam;
import com.llhc.mfsa.vo.JjckslView;

@Controller
@RequestMapping("/jjcksl")
public class JjckslController {
	
	@Autowired
	JjckslService service;
	
	@RequestMapping("/access")
	public String access(Model model,HttpSession session) {
		if (session.getAttribute("userId") == null) {
			model.addAttribute("loginErr", "noUser");
			return "redirect:/account/loginErr";
		}else if ((Integer)session.getAttribute("role") != 2) {
			model.addAttribute("accountErr", "limited");
			return "redirect:/user";
		}
		List<JjckslView> views = service.getSerialList();
		int tote = 0;
		if (views.size() > 0) {
			for (JjckslView view : views) {
				tote += view.getCount();
			}
		}
		model.addAttribute("tote", tote);
		model.addAttribute("serialList", views);
		return "jjcksl";
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> queryPapers(JjckslParam param) {
		ModelMap model = new ModelMap();
		if (param.getSerialNum() != null && param.getSerialNum().size() != 0) {
			List<String> serialList = param.getSerialNum();
			List<PaperInfo> paperList = service.queryPapers(serialList);
			JjckslView view = new JjckslView();
			view.setPaperList(paperList);
			model.addAttribute("success", true);
			model.addAttribute("paperCount", paperList.size());
			model.addAttribute("paperInfos", view.getPaperList());
		}else {
			model.addAttribute("success", false);
			model.addAttribute("errorMsg", "未找到流水号");
		}
		return model;
	}
	
	@RequestMapping("/accept")
	@ResponseBody
	public Map<String, Object> accept(JjckslParam param,HttpSession session) {
		ModelMap model = new ModelMap();
		if (param.getSerialNum() != null && param.getSerialNum().size() != 0) {
			param.setKgyId((Integer)session.getAttribute("userId"));
			try {
				int count = service.accept(param);
				if (count > 0) {
					model.addAttribute("success", true);
				}else {
					model.addAttribute("success", false);
					model.addAttribute("errorMsg", "数据处理错误");
				}
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("success",false);
				model.addAttribute("errorMsg", "服务器处理错误");
			}
		}else {
			model.addAttribute("success", false);
			model.addAttribute("errorMsg", "未提交内容");
		}
		return model;
	}
	
}
