package com.llhc.mfsa.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.PaperInfo;
import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.vo.JjckslParam;

@Component
public interface JjckslDao {

	public List<SerialInfo> selectSerialList();
	
	public List<PaperInfo> selectPaperList(List<String> serials);
	
	public int updateStorage(JjckslParam param);
	
	public int updateSerial(JjckslParam param);
	
}
