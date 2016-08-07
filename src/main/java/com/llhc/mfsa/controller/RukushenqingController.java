package com.llhc.mfsa.controller;

import java.util.List;
import java.util.Map;

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
	
	private String serial;
	
	@Autowired
	private RukushenqingService service;
	
	@RequestMapping("/access") 
	public String access(Model model) {
		IdHelper idHelper = new IdHelper();
		serial = idHelper.getSerialNum();
		List<RukushenqingView> list = service.selectPaper();
		model.addAttribute("serial", serial);
		model.addAttribute("pageView", list);
		return "rukushenqing";
	}
	
	@RequestMapping("/apply")
//	@ResponseBody
	public String apply(RukushenqingParam pageParam,Model model) {
//		ModelMap model = new ModelMap();
		pageParam.setInSerial(serial);
		pageParam.setYwyId('1');
		pageParam.setBumenId(1);
		try {
			service.updateStorage(pageParam);
			model.addAttribute("success", "申请成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("success", "申请失败");
			model.addAttribute("ErrorMessage", e.getMessage());
		}
		return "yewuyuan";
	}

}