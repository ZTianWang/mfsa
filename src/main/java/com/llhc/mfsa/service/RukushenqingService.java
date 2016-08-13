package com.llhc.mfsa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llhc.mfsa.dao.RukushenqingDao;
import com.llhc.mfsa.entity.PaperInfo;
import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.entity.StorageInfo;
import com.llhc.mfsa.vo.RukushenqingParam;
import com.llhc.mfsa.vo.RukushenqingView;

@Service
public class RukushenqingService {

	@Autowired
	private RukushenqingDao dao;
	
	public List<RukushenqingView> selectPaper(Integer ywyId) {
		List<PaperInfo> paperlist = dao.selectPaperList(ywyId);
		List<RukushenqingView> viewList = new ArrayList<RukushenqingView>();
		for (PaperInfo paper : paperlist) {
			RukushenqingView view = new RukushenqingView();
			view.setBumenName(paper.getBumenName());
			view.setDanganNum(paper.getDanganNum());
			view.setQianfengDate(paper.getQianfengDate());
			viewList.add(view);
		}
		return viewList;
	}
	
	public int updateStorage(RukushenqingParam param,Integer ywyId){
		int count = 0;
		StorageInfo storageInfo = new StorageInfo();
		SerialInfo serialInfo = new SerialInfo();
		List<String> numList = param.getDanganNum();
		serialInfo.setSerialNum(param.getInSerial());
		serialInfo.setBumenId(param.getBumenId());
		serialInfo.setYwyId(ywyId);
		serialInfo.setCount(numList.size());
		try {
			dao.insertSerial(serialInfo);
			for (String danganNum : numList) {
				String fileNum = dao.selectFileNum(danganNum);
				storageInfo.setFileNum(fileNum);
				storageInfo.setInSerial(param.getInSerial());
				storageInfo.setYwyinId(ywyId);
				count += dao.updateStorage(storageInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
}
