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
import com.llhc.mfsa.service.ChukushenqingService;
import com.llhc.mfsa.vo.ChukushenqingParam;
import com.llhc.mfsa.vo.ChukushenqingView;

@Controller
@RequestMapping("/cksq")
public class ChukushenqingController {

	@Autowired
	private ChukushenqingService service;

	@RequestMapping("/access")
	public String access(Model model, HttpSession session) {
		 if (session.getAttribute("userId") == null)  {
		 model.addAttribute("loginErr", "noUser");
		 return "redirect:/account/loginErr";
		 }else if ((Integer)session.getAttribute("role") != 1) {
		 model.addAttribute("accountErr", "limited");
		 return "redirect:/user";
		 }else {
		String serial = new IdHelper().getSerialNum();
		model.addAttribute("serial", serial);
		return "chukushenqing";
		 }
	}

	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(ChukushenqingParam param, HttpSession session) {
		ModelMap model = new ModelMap();
		param.setBumenId((Integer)session.getAttribute("bumenId"));
		List<ChukushenqingView> views = service.queryPaperList(param);
		if (views != null && views.size() != 0) {
				model.addAttribute("pageViews", views);
				model.addAttribute("success", true);
		}else {
			model.addAttribute("success", false);
			model.addAttribute("errorMsg", "没有查到库存记录");
		}
		return model;
	}

	@RequestMapping("/apply")
	@ResponseBody
	public Map<String, Object> apply(ChukushenqingParam param,HttpSession session) {
		ModelMap model = new ModelMap();
		try {
			service.updateStorage(param,(Integer)session.getAttribute("userId"),(Integer)session.getAttribute("bumenId"));
			model.addAttribute("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("success",false);
			model.addAttribute("ErrorMessage", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/urgency")
	public String urgency(ChukushenqingParam param,HttpSession session,Model model) {
		try {
			int suc = service.updateSerial(param,(Integer)session.getAttribute("userId"),(Integer)session.getAttribute("bumenId"));
			if (suc == 1) {
				model.addAttribute("success", "申请成功");
			}else {
				model.addAttribute("success", "申请失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("success", "申请失败");
			model.addAttribute("ErrorMessage", e.getMessage());
		}
		return "yewuyuan";
	}
	
}
