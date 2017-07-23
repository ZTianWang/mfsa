package com.llhc.mfsa.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.FileInfo;
import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.vo.ChukushouliParam;

@Component
public interface ChukushouliDao {

	public List<SerialInfo> selectSerialList();
	
	public List<FileInfo> selectPaperList(List<String> serials);
	
	public int updateStorage(ChukushouliParam param);
	
	public int updateSerial(ChukushouliParam param);
	
}
