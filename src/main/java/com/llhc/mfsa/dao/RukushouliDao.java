package com.llhc.mfsa.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.FileInfo;
import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.entity.StorageInfo;

@Component
public interface RukushouliDao {

	public List<SerialInfo> selectSerialList();
	
	public List<FileInfo> selectPaperList(String serialNum);
	
	public FileInfo selectFile(String fileNum);
	
	public int updateStorage(StorageInfo storageInfo);
	
	public int updateSerial(SerialInfo serialInfo);
	
}
