package com.llhc.mfsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llhc.mfsa.dao.KhcxDao;
import com.llhc.mfsa.entity.CustInfo;
import com.llhc.mfsa.vo.KhcxParam;
import com.llhc.mfsa.vo.KhcxView;

@Service
public class KhcxService {

	@Autowired
	private KhcxDao dao;
	
	public KhcxView query(KhcxParam param) {
		CustInfo cust = dao.queryCust(param);
		KhcxView view = new KhcxView();
		if (cust != null) {
			view.setName(cust.getName());
			view.setPhone(cust.getPhone());
			view.setIdNum(cust.getIdNum());
			List<Integer> ids = dao.queryids(cust.getId());
			if (ids != null) {
				view.setCount(ids.size());
			}
		}
		return view;
	}
	
}
