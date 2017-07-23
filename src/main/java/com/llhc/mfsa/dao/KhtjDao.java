package com.llhc.mfsa.dao;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.vo.KhtjParam;

@Component
public interface KhtjDao {
	
	public int addCust(KhtjParam param);

}
