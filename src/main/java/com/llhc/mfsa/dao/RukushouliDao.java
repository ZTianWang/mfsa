package com.llhc.mfsa.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.PaperInfo;
import com.llhc.mfsa.entity.StorageInfo;
import com.llhc.mfsa.vo.RukushouliView;

@Component
public interface RukushouliDao {

	public List<RukushouliView> selectSerialList();
	
	public List<PaperInfo> selectPaperList(String serialNum);
	
	public Integer selectFileId(Integer danganId);
	
	public int updateStorage(StorageInfo storageInfo);
	
	public int updateSerial(String serialNum);
	
}
