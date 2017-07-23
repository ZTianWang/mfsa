package com.llhc.mfsa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llhc.mfsa.dao.ChukushenqingDao;
import com.llhc.mfsa.entity.FileInfo;
import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.entity.StorageInfo;
import com.llhc.mfsa.vo.ChukushenqingParam;
import com.llhc.mfsa.vo.ChukushenqingView;

@Service
public class ChukushenqingService {

	@Autowired
	ChukushenqingDao dao;
	
	public List<ChukushenqingView> queryPaperList(ChukushenqingParam param) {
		List<FileInfo> papers = dao.selectPaperList(param);
		List<ChukushenqingView> views = new ArrayList<ChukushenqingView>();
		for (FileInfo paper : papers) {
			ChukushenqingView view = new ChukushenqingView();
			view.setFileId(paper.getId());
			view.setFileNum(paper.getFileNum());
			view.setCustName(paper.getCustName());
			view.setFileName(paper.getFileName());
			view.setQianfengDate(paper.getDateStr());
			views.add(view);
		}
		return views;
	}
	
	public int updateStorage(ChukushenqingParam param,Integer ywyId,Integer bumenId){
		int count = 0;
		StorageInfo storageInfo = new StorageInfo();
		SerialInfo serialInfo = new SerialInfo();
		List<String> numList = param.getFileNums();
		serialInfo.setSerialNum(param.getSerial());
		serialInfo.setBumenId(bumenId);
		serialInfo.setYwyId(ywyId);
		serialInfo.setCount(numList.size());
		try {
			dao.insertSerial(serialInfo);
			for (String num : numList) {
				storageInfo.setFileNum(num);
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
