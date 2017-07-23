package com.llhc.mfsa.dao;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.FileInfo;
import com.llhc.mfsa.entity.StorageInfo;

@Component
public interface LsruqfDao {
	
	public int insertStorage(StorageInfo storage);
	
	public int updateStorage(StorageInfo storage);
	
	public Integer queryFileId(String fileNum);
	
	public int insertFile(FileInfo file);
	
	public FileInfo checkout(String fileNum);
	
	public Integer queryId(String name);
	
	public Integer queryMId(String name);
}
