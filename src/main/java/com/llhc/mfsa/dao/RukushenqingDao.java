package com.llhc.mfsa.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.FileInfo;
import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.entity.StorageInfo;

@Component
public interface RukushenqingDao {

	public List<FileInfo> selectPaperList(Integer ywyId);
	
	public int updateStorage(StorageInfo storageInfo);
	
	public int insertSerial(SerialInfo serialInfo);
	
}
