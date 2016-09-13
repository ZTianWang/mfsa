package com.llhc.mfsa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llhc.mfsa.dao.JjckslDao;
import com.llhc.mfsa.entity.PaperInfo;
import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.entity.StorageInfo;
import com.llhc.mfsa.vo.JjckslParam;
import com.llhc.mfsa.vo.JjckslView;

@Service
public class JjckslService {

	@Autowired
	JjckslDao dao;
	
	public List<JjckslView> getSerialList() {
		List<SerialInfo> serialList = dao.selectSerialList();
		List<JjckslView> viewList = new ArrayList<JjckslView>();
		for (SerialInfo serialInfo : serialList) {
			JjckslView view = new JjckslView();
			view.setBumenName(serialInfo.getBumenName());
			view.setCount(serialInfo.getCount());
			view.setYwyName(serialInfo.getYwyName());
			view.setSerialNum(serialInfo.getSerialNum());
			viewList.add(view);
		}
		return viewList;
	}
	
	public List<PaperInfo> queryPapers(List<String> serials) {
		List<PaperInfo> paperList = dao.selectPaperList(serials);
		return paperList;
	}
	
	public int accept(JjckslParam param) {
		StorageInfo storage = new StorageInfo();
		int count = 0;
		try {
			List<String> serialList = param.getSerialNum();
			if (serialList == null) {
				return 0;
			}
			storage.setKgyoutId(param.getKgyId());
//			for (String serialNum : serialList) {
//				storage.setOutSerial(serialNum);
				count = dao.updateStorage(param);
//			}
			if (count != 0) {
				dao.updateSerial(param);
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
