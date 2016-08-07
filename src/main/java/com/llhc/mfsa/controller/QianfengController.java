package com.llhc.mfsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.llhc.mfsa.service.QianfengService;
import com.llhc.mfsa.vo.QianfengParam;

@Controller
@RequestMapping("/qianfeng")
public class QianfengController {
	
	private Integer danganId;
	private Integer fileId;
	
	@Autowired
	private QianfengService qianfengService;
	

	@RequestMapping("/access") 
	public String access(Model model) {
		danganId = qianfengService.getDanganId();
		fileId = qianfengService.getFileId();
		model.addAttribute("fileId", fileId);
		model.addAttribute("danganId", danganId);
		return "qianfeng";
		
	}
	
	@RequestMapping("/add")
//	@ResponseBody
	public String addPaper(QianfengParam qianfengParam,Model model) {
//		ModelMap model = new ModelMap();
		qianfengParam.setDanganId(danganId);
		qianfengParam.setFileId(fileId);
//		System.out.println(qianfengParam);
		try {
//			qianfengService.addFile();
			qianfengService.addItem(qianfengParam);
			model.addAttribute("success", "签封成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("success", "签封失败");
			model.addAttribute("ErrorMessage", e.getMessage());
		}
		return "yewuyuan";
	}
	
}
