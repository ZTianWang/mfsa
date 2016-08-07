package com.llhc.mfsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llhc.mfsa.dao.RukushouliDao;
import com.llhc.mfsa.entity.PaperInfo;
import com.llhc.mfsa.entity.StorageInfo;
import com.llhc.mfsa.vo.RukushouliParam;
//import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.vo.RukushouliView;

@Service
public class RuhushouliService {

	@Autowired
	private RukushouliDao dao;
	
	public List<RukushouliView> getSerialList() {
		List<RukushouliView> views = dao.selectSerialList();
//		List<RuhushouliView> views = null;
//		for (SerialInfo serialInfo : serialInfos) {
//			RuhushouliView view = new RuhushouliView();
//			view.setBumenName(serialInfo.getBumenName());
//			view.setCount(serialInfo.getCount());
//			view.setRenyuanName(serialInfo.getYwyName());
//			view.setSerialNum(serialInfo.getSerialNum());
//			views.add(view);
//		}
		return views;
	}
	
	public List<PaperInfo> queryPapers(String serialNum) {
		return dao.selectPaperList(serialNum);
	}
	
	public int accept(RukushouliParam param) {
		StorageInfo storageInfo = new StorageInfo();
		int count = 0;
		try {
			List<Integer> list = param.getDanganId();
			storageInfo.setKgyinId(param.getRenyuanId());
			for (Integer danganId : list) {
				Integer fileId = dao.selectFileId(danganId);
				storageInfo.setFileId(fileId);
				count += dao.updateStorage(storageInfo);
			}
			dao.updateSerial(param.getSerialNum());
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
