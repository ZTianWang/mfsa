package com.llhc.mfsa.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.PaperInfo;
import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.entity.StorageInfo;

@Component
public interface RukushenqingDao {

	public List<PaperInfo> selectPaperList();
	
	public int updateStorage(StorageInfo storageInfo);
	
	public String selectFileNum(String danganNum);
	
	public int insertSerial(SerialInfo serialInfo);
	
}
