package com.llhc.mfsa.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.llhc.mfsa.helper.IdHelper;
import com.llhc.mfsa.service.ChukushenqingService;
import com.llhc.mfsa.vo.ChukushenqingParam;
import com.llhc.mfsa.vo.ChukushenqingView;

@Controller
@RequestMapping("/cksq")
public class ChukushenqingController {

	private String serial;
	private List<ChukushenqingView> views = null;
	private List<ChukushenqingView> papers = new ArrayList<ChukushenqingView>();

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
		if (views != null) {
			if (papers.size() != 0) {
				for (ChukushenqingView viewp : papers) {
					Integer pid = viewp.getDanganId();
					for (ChukushenqingView view : views) {
						Integer id = view.getDanganId();
						if (pid == id) {
							views.remove(view);
							break;
						}
					}
				}
				model.addAttribute("pageList", papers);
			}
			model.addAttribute("pageViews", views);
		} else {
			if (papers.size() != 0) {
				model.addAttribute("pageList", papers);
			}
		}
		model.addAttribute("count", papers.size());
		String serial = new IdHelper().getSerialNum();
		model.addAttribute("serial", serial);
		this.serial = serial;//改动
		return "chukushenqing";
		 }
	}

	@RequestMapping("/query")
	public String query(ChukushenqingParam param, HttpSession session) {
//		System.out.println(param);
//		System.out.println((Integer)session.getAttribute("bumenId"));
		param.setBumenId((Integer)session.getAttribute("bumenId"));
		views = service.queryPaperList(param);
//		views = service.queryPaperLisr(param, 1);
		return "redirect:/cksq/access";
	}

	@RequestMapping("/add")
	public String add(ChukushenqingParam param) {
		List<Integer> ids = param.getDanganId();
		if (ids == null) {
			return "redirect:/cksq/access";
		}
		for (Integer danganId : ids) {
			for (ChukushenqingView view : views) {
				if (danganId == view.getDanganId()) {
					papers.add(view);
				}
			}
		}
		// views = null;
		return "redirect:/cksq/access";
	}
	
	@RequestMapping("/apply")
	public String apply(ChukushenqingParam param,HttpSession session,Model model) {
		param.setSerial(serial);
		try {
			service.updateStorage(param,(Integer)session.getAttribute("userId"),(Integer)session.getAttribute("bumenId"));
			model.addAttribute("success", "申请成功");
			views = null;
			papers.clear();
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("success", "申请失败");
			model.addAttribute("ErrorMessage", e.getMessage());
		}
		return "yewuyuan";
	}
	
	@RequestMapping("/urgency")
	public String urgency(ChukushenqingParam param,HttpSession session,Model model) {
		param.setSerial(serial);
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
		}finally {
			views = null;
			papers.clear();
		}
		return "yewuyuan";
	}
	
	@RequestMapping("/remove")
	public String remove(ChukushenqingParam param) {
		List<Integer> ids = param.getDanganId();
		if (ids == null) {
			return "redirect:/cksq/access";
		}
		for (Integer danganId : ids) {
			Iterator<ChukushenqingView> iterator = papers.iterator();
	        while(iterator.hasNext()){
	            ChukushenqingView viewP = iterator.next();
	            if(viewP.getDanganId() == danganId) {
	                iterator.remove();   //注意这个地方 
	            	views.add(viewP);
	            }
	        }
//			for (ChukushenqingView viewP : papers) {
//				if (danganId == viewP.getDanganId()) {
//					papers.remove(viewP);
//				}
//			}
		}
		return "redirect:/cksq/access";
	}

}
