package com.llhc.mfsa.dao;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.FileInfo;
import com.llhc.mfsa.entity.StorageInfo;

@Component
public interface QianfengDao {

	public int insertStorage(StorageInfo storage);
	
	public int insertFile(FileInfo file);
	
	public int updateStorage(StorageInfo storage);
	
	public FileInfo checkout(String fileNum);
	
	public Integer queryId(String name);
	
	public Integer queryMId(String name);
	
}
