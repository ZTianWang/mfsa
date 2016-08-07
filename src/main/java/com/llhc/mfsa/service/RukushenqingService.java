package com.llhc.mfsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llhc.mfsa.dao.RukushenqingDao;
import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.entity.StorageInfo;
import com.llhc.mfsa.vo.RukushenqingParam;
import com.llhc.mfsa.vo.RukushenqingView;

@Service
public class RukushenqingService {

	@Autowired
	private RukushenqingDao dao;
	
	public List<RukushenqingView> selectPaper() {
		return dao.selectPaperList();
	}
	
	public int updateStorage(RukushenqingParam param){
		int count = 0;
		StorageInfo storageInfo = new StorageInfo();
		SerialInfo serialInfo = new SerialInfo();
		List<Integer> idList = param.getDanganId();
		serialInfo.setSerialNum(param.getInSerial());
		serialInfo.setBumenId(param.getBumenId());
		serialInfo.setYwyId(param.getYwyId());
		serialInfo.setCount(idList.size());
		try {
			dao.insertSerial(serialInfo);
			for (Integer danganId : idList) {
				Integer fileId = dao.selectFileId(danganId);
				storageInfo.setFileId(fileId);
				storageInfo.setInSerial(param.getInSerial());
				storageInfo.setYwyinId(param.getYwyId());
				count += dao.updateStorage(storageInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
}
