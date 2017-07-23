package com.llhc.mfsa.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llhc.mfsa.dao.LsruqfDao;
import com.llhc.mfsa.entity.FileInfo;
import com.llhc.mfsa.entity.StorageInfo;
import com.llhc.mfsa.helper.DateHelper;
import com.llhc.mfsa.helper.Position;
import com.llhc.mfsa.vo.QianfengParam;

@Service
public class LsruqfService {

	@Autowired
	private LsruqfDao dao;
	
	public int checkout(QianfengParam param) {
		FileInfo file = dao.checkout(param.getFileNum());
		if (file != null) {
			return 0;
		}
		Integer custId = dao.queryId(param.getCustName());
		if (custId == null || custId == 0) {
			return -1;
		}
		if (param.getmName() != null && !"".equals(param.getmName().trim())) {
			Integer mId = dao.queryMId(param.getmName().trim());
			if (mId == null || mId == 0) {
				return -2;
			}
		}
		return custId;
	}
	
	public void addItem(QianfengParam param,int custId,int userId) {
		DateHelper dateHelper = new DateHelper();
		Date qianfengDate = dateHelper.getCurrentDate();
		String fileNum = param.getFileNum().trim();
		FileInfo file = new FileInfo();
		file.setFileNum(param.getFileNum());
		file.setCustId(custId);
		file.setBumenId(param.getBumenId());
		file.setFileName(param.getFileName());
		file.setQianfengDate(qianfengDate);
		if (param.getmName() != null && !"".equals(param.getmName().trim())) {
			Integer mId = dao.queryMId(param.getmName().trim());
			file.setmId(mId);
		}
		file.setYwyId(userId);
		dao.insertFile(file);
		StorageInfo storageInfo = new StorageInfo();
		storageInfo.setFileNum(fileNum);
		storageInfo.setKgyinId(userId);
		String position = Position.getPosition(file.getBumenId(), dao.queryFileId(fileNum));
		storageInfo.setPosition(position);
		dao.insertStorage(storageInfo);
	}
	
	public int readd(String num,int userId) {
		FileInfo file = dao.checkout(num);
		if (file == null) {
			return 0;
		}else {
			StorageInfo storage = new StorageInfo();
			storage.setFileNum(num);
			storage.setKgyinId(userId);
			int i = dao.updateStorage(storage);
			return i;
		}
	}
	
}
