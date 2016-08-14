package com.llhc.mfsa.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.PaperInfo;
import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.entity.StorageInfo;
import com.llhc.mfsa.vo.ChukushouliParam;

@Component
public interface ChukushouliDao {

	public List<SerialInfo> selectSerialList();
	
	public List<PaperInfo> selectPaperList(List<String> serials);
	
	public int updateStorage(StorageInfo storageInfo);
	
	public int updateSerial(ChukushouliParam param);
	
}
