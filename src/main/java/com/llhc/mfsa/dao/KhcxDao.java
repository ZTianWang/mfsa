package com.llhc.mfsa.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.CustInfo;
import com.llhc.mfsa.vo.KhcxParam;

@Component
public interface KhcxDao {
	
	public CustInfo queryCust(KhcxParam param);
	
	public List<Integer> queryids(Integer cid);

}
