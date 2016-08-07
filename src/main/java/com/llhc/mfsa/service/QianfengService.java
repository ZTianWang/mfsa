package com.llhc.mfsa.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llhc.mfsa.dao.QianfengDao;
import com.llhc.mfsa.entity.PaperInfo;
import com.llhc.mfsa.helper.DateHelper;
import com.llhc.mfsa.vo.QianfengParam;

@Service
public class QianfengService {

	@Autowired
	private QianfengDao dao;
	
	public Integer getDanganId() {
		Integer danganId = dao.selectDanganId()+1;
		return danganId;
	}
	
	public Integer getFileId() {
		Integer fileId = dao.selectFileId()+1;
		return fileId;
	}
	
	public void addItem(QianfengParam qianfengParam) {
		Integer fileId = qianfengParam.getFileId();
		DateHelper dateHelper = new DateHelper();
		Date qianfengDate = dateHelper.getCurrentDate();
		Date daoqiDate = dateHelper.getDaoqiDate(qianfengDate);
		PaperInfo paper = new PaperInfo();
		paper.setDanganId(qianfengParam.getDanganId());
		paper.setBumenId(qianfengParam.getBumenId());
		paper.setWupinId(qianfengParam.getWupinId());
		paper.setFileId(fileId);
		paper.setQianfengDate(qianfengDate);
		paper.setDaoqiDate(daoqiDate);
		String fuzeren = qianfengParam.getFuzeren();
		String kehujingli = qianfengParam.getKehujingli();
		String dianhua = qianfengParam.getDianhua();
		if (!fuzeren.equals(null)) {
			paper.setFuzeren(fuzeren.trim());
		}
		if (!kehujingli.equals(null)) {
			paper.setKehujingli(kehujingli.trim());
		}
		if (!dianhua.equals(null)) {
			paper.setDianhua(dianhua.trim());
		}
//		System.out.println(fileId);
		dao.insertFile(fileId);
		dao.insertPaper(paper);
	}
	
//	public int addFile() {
//		int count = dao.insertFile(fileId);
//		return count;
//	}
	
}
