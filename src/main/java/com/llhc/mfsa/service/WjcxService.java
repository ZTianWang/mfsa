package com.llhc.mfsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llhc.mfsa.dao.WjcxDao;
import com.llhc.mfsa.entity.FileInfo;
import com.llhc.mfsa.vo.WjcxParam;

@Service
public class WjcxService {

	@Autowired
	WjcxDao dao;
	
	public List<FileInfo> queryFileList(WjcxParam param) {
		List<FileInfo> files = dao.selectFileList(param);
		return files;
	}
	
}
