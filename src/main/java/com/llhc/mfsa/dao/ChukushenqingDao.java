package com.llhc.mfsa.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.FileInfo;
import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.entity.StorageInfo;
import com.llhc.mfsa.vo.ChukushenqingParam;

@Component
public interface ChukushenqingDao {

	public List<FileInfo> selectPaperList(ChukushenqingParam param);
	
	public String selectFileNum(Integer danganId);
	
	public int updateStorage(StorageInfo storageInfo);
	
	public int insertSerial(SerialInfo serialInfo);
	
	public int updateSerial(String serialNum);
	
}
