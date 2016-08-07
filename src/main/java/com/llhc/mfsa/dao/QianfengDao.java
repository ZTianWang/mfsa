package com.llhc.mfsa.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.PaperInfo;

@Component
public interface QianfengDao {

	public int insertPaper(PaperInfo paper);
	
	public int insertFile(Integer fileId);
	
	public List<PaperInfo> selectPaperList();
	
	public Integer selectFileId();
	
	public Integer selectDanganId();
	
}
