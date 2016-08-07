package com.llhc.mfsa.helper;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.llhc.mfsa.dao.QianfengDao;

@Repository
public class IdHelper {

	private Integer danganId;
	private Integer fileId;
	private String serialNum;
	
	@Autowired
	private QianfengDao qianfengDao;

	public Integer getDanganId() {
		danganId = qianfengDao.selectDanganId()+1;
		return danganId;
	}

	public void setDanganId(Integer danganId) {
		this.danganId = danganId;
	}

	public Integer getFileId() {
		fileId = qianfengDao.selectFileId()+1;
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getSerialNum() {
		Date date = new Date();
		long datel = date.getTime();
		serialNum = Long.toString(datel);
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	
}
