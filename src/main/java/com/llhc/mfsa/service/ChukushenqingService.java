package com.llhc.mfsa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llhc.mfsa.dao.ChukushenqingDao;
import com.llhc.mfsa.entity.PaperInfo;
import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.entity.StorageInfo;
import com.llhc.mfsa.vo.ChukushenqingParam;
import com.llhc.mfsa.vo.ChukushenqingView;

@Service
public class ChukushenqingService {

	@Autowired
	ChukushenqingDao dao;
	
	public List<ChukushenqingView> queryPaperList(ChukushenqingParam param) {
//		param.setBumenId(bumenId);
		List<PaperInfo> papers = dao.selectPaperList(param);
		List<ChukushenqingView> views = new ArrayList<ChukushenqingView>();
		for (PaperInfo paper : papers) {
//			System.out.println(paper);
			ChukushenqingView view = new ChukushenqingView();
			view.setDanganId(paper.getId());
			view.setDanganNum(paper.getDanganNum());
			view.setBumenName(paper.getBumenName());
			view.setQianfengDate(paper.getQianfengDate());
			views.add(view);
		}
		return views;
	}
	
	public int updateStorage(ChukushenqingParam param,Integer ywyId,Integer bumenId){
		int count = 0;
		StorageInfo storageInfo = new StorageInfo();
		SerialInfo serialInfo = new SerialInfo();
		List<Integer> idList = param.getDanganId();
		serialInfo.setSerialNum(param.getSerial());
		serialInfo.setBumenId(bumenId);
		serialInfo.setYwyId(ywyId);
		serialInfo.setCount(idList.size());
		try {
			dao.insertSerial(serialInfo);
			for (Integer danganId : idList) {
				String fileNum = dao.selectFileNum(danganId);
				storageInfo.setFileNum(fileNum);
				storageInfo.setOutSerial(param.getSerial());
				storageInfo.setYwyoutId(ywyId);
				count += dao.updateStorage(storageInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public int updateSerial(ChukushenqingParam param,Integer ywyId,Integer bumenId) {
		int count = updateStorage(param,ywyId,bumenId);
		if (count > 0) {
			dao.updateSerial(param.getSerial());
			return 1;
		}
		return 0;
	}
	
}
