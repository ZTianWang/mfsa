package com.llhc.mfsa.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.llhc.mfsa.entity.FileInfo;
import com.llhc.mfsa.vo.WjcxParam;

@Component
public interface WjcxDao {

	public List<FileInfo> selectFileList(WjcxParam param);
	
}
