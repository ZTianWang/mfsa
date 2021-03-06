package com.llhc.mfsa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llhc.mfsa.dao.ChukushouliDao;
import com.llhc.mfsa.entity.FileInfo;
import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.entity.StorageInfo;
import com.llhc.mfsa.vo.ChukushouliParam;
import com.llhc.mfsa.vo.ChukushouliView;

@Service
public class ChukushouliService {

	@Autowired
	ChukushouliDao dao;
	
	public List<ChukushouliView> getSerialList() {
		List<SerialInfo> serialList = dao.selectSerialList();
		List<ChukushouliView> viewList = new ArrayList<ChukushouliView>();
		for (SerialInfo serialInfo : serialList) {
			ChukushouliView view = new ChukushouliView();
			view.setBumenName(serialInfo.getBumenName());
			view.setCount(serialInfo.getCount());
			view.setYwyName(serialInfo.getYwyName());
			view.setSerialNum(serialInfo.getSerialNum());
			viewList.add(view);
		}
		return viewList;
	}
	
	public List<FileInfo> queryPapers(List<String> serials) {
		List<FileInfo> paperList = dao.selectPaperList(serials);
		return paperList;
	}
	
	public int accept(ChukushouliParam param) {
		StorageInfo storage = new StorageInfo();
		int count = 0;
		List<String> serialList = param.getSerialNum();
		if (serialList == null) {
			return 0;
		}
		storage.setKgyoutId(param.getKgyId());
		count += dao.updateStorage(param);
		if (count != 0) {
			dao.updateSerial(param);
		}
		return count;
	}
	
}
