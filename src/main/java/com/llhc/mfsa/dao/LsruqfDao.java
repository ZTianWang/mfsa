package com.llhc.mfsa.dao;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.PaperInfo;
import com.llhc.mfsa.entity.StorageInfo;

@Component
public interface LsruqfDao {
	
	public int insertPaper(PaperInfo paper);
	
	public int insertFile(StorageInfo storageInfo);
	
	public PaperInfo checkoutDn(PaperInfo paper);
	
	public PaperInfo checkoutFn(PaperInfo paper);
}
