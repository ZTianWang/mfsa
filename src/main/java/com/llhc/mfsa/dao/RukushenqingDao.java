package com.llhc.mfsa.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.entity.StorageInfo;
import com.llhc.mfsa.vo.RukushenqingView;

@Component
public interface RukushenqingDao {

	public List<RukushenqingView> selectPaperList();
	
	public int updateStorage(StorageInfo storageInfo);
	
	public Integer selectFileId(Integer danganId);
	
	public int insertSerial(SerialInfo serialInfo);
	
}
