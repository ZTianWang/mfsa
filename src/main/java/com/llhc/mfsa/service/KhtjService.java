package com.llhc.mfsa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llhc.mfsa.dao.KhtjDao;
import com.llhc.mfsa.vo.KhtjParam;

@Service
public class KhtjService {

	@Autowired
	private KhtjDao dao;
	
	public void add(KhtjParam param) {
		dao.addCust(param);
	}
	
}
