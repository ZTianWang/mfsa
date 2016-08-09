package com.llhc.mfsa.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.PaperInfo;
import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.entity.StorageInfo;

@Component
public interface RukushouliDao {

	public List<SerialInfo> selectSerialList();
	
	public List<PaperInfo> selectPaperList(String serialNum);
	
	public String selectFileNum(String danganNum);
	
	public int updateStorage(StorageInfo storageInfo);
	
	public int updateSerial(SerialInfo serialInfo);
	
}
