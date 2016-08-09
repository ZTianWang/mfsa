package com.llhc.mfsa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llhc.mfsa.dao.RukushouliDao;
import com.llhc.mfsa.entity.PaperInfo;
import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.entity.StorageInfo;
import com.llhc.mfsa.vo.RukushouliParam;
//import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.vo.RukushouliView;

@Service
public class RuhushouliService {
	
	@Autowired
	private RukushouliDao dao;
	
	public List<RukushouliView> getSerialList() {
		List<SerialInfo> serialList = dao.selectSerialList();
		List<RukushouliView> viewList =new ArrayList<RukushouliView>();
		for (SerialInfo serialInfo : serialList) {
			RukushouliView view = new RukushouliView();
			view.setBumenName(serialInfo.getBumenName());
			view.setCount(serialInfo.getCount());
			view.setYwyName(serialInfo.getYwyName());
			view.setSerialNum(serialInfo.getSerialNum());
			viewList.add(view);
		}
		return viewList;
	}
	
	public RukushouliView queryPapers(String serialNum) {
		List<PaperInfo> paperList = dao.selectPaperList(serialNum);
		RukushouliView view = new RukushouliView();
		view.setPaperlist(paperList);
		return view;
	}
	
	public int accept(RukushouliParam param,Integer kgyId) {
		StorageInfo storageInfo = new StorageInfo();
		int count = 0;
		try {
			List<String> numList = param.getDanganNum();
			if (numList == null) {
				return 0;
			}
			storageInfo.setKgyinId(kgyId);
			for (String danganNum : numList) {
				String fileNum = dao.selectFileNum(danganNum);
				storageInfo.setFileNum(fileNum);
				count += dao.updateStorage(storageInfo);
			}
			SerialInfo serialInfo = new SerialInfo();
			serialInfo.setKgyId(kgyId);
			serialInfo.setSerialNum(param.getSerialNum());
			dao.updateSerial(serialInfo);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
