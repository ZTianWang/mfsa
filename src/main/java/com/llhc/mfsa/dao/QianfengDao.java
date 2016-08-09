package com.llhc.mfsa.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.PaperInfo;
import com.llhc.mfsa.entity.StorageInfo;

@Component
public interface QianfengDao {

	public int insertPaper(PaperInfo paper);
	
	public int insertFile(StorageInfo storageInfo);
	
	public List<PaperInfo> selectPaperList();
	
}
