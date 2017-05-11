package com.llhc.mfsa.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llhc.mfsa.dao.LsruqfDao;
import com.llhc.mfsa.entity.PaperInfo;
import com.llhc.mfsa.entity.StorageInfo;
import com.llhc.mfsa.helper.DateHelper;
import com.llhc.mfsa.vo.QianfengParam;

@Service
public class LsruqfService {

	@Autowired
	private LsruqfDao dao;
	
	public int checkout(QianfengParam qianfengParam) {
		PaperInfo paperInfo = new PaperInfo();
		paperInfo.setDanganNum(qianfengParam.getDanganNum());
		paperInfo.setFileNum(qianfengParam.getFileNum());
		PaperInfo pid = dao.checkoutDn(paperInfo);
		if (pid != null) {
			return 1;
		}
		PaperInfo pif = dao.checkoutFn(paperInfo);
		if (pif != null) {
			return 2;
		}
		return 0;
	}
	
	public void addItem(QianfengParam qianfengParam,int userId) {
		DateHelper dateHelper = new DateHelper();
		Date qianfengDate = dateHelper.getCurrentDate();
		Date daoqiDate = dateHelper.getDaoqiDate(qianfengDate);
		String fileNum = qianfengParam.getFileNum().trim();
		PaperInfo paper = new PaperInfo();
		paper.setDanganNum(qianfengParam.getDanganNum().trim());
		paper.setFileNum(fileNum);
		paper.setBumenId(qianfengParam.getBumenId());
		paper.setWupinId(qianfengParam.getWupinId());
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
		paper.setYwyId(userId);
		StorageInfo storageInfo = new StorageInfo();
		storageInfo.setFileNum(fileNum);
		storageInfo.setKgyinId(userId);
		dao.insertFile(storageInfo);
		dao.insertPaper(paper);
	}
	
}