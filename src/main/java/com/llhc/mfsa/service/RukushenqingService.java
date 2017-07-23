package com.llhc.mfsa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llhc.mfsa.dao.RukushenqingDao;
import com.llhc.mfsa.entity.FileInfo;
import com.llhc.mfsa.entity.SerialInfo;
import com.llhc.mfsa.entity.StorageInfo;
import com.llhc.mfsa.helper.DateHelper;
import com.llhc.mfsa.vo.RukushenqingParam;
import com.llhc.mfsa.vo.RukushenqingView;

@Service
public class RukushenqingService{

	@Autowired
	private RukushenqingDao dao;
	
	public List<RukushenqingView> selectPaper(Integer ywyId) {
		List<FileInfo> paperlist = dao.selectPaperList(ywyId);
		List<RukushenqingView> viewList = new ArrayList<RukushenqingView>();
		for (FileInfo paper : paperlist) {
			RukushenqingView view = new RukushenqingView();
			view.setFileName(paper.getFileName());
			view.setFileNum(paper.getFileNum());
			view.setCustName(paper.getCustName());
			view.setQianfengDate(DateHelper.dateToStr(paper.getQianfengDate()));
			viewList.add(view);
		}
		return viewList;
	}
	
	public int updateStorage(RukushenqingParam param,Integer ywyId) throws Exception{
		int count = 0;
		StorageInfo storageInfo = new StorageInfo();
		SerialInfo serialInfo = new SerialInfo();
		List<String> numList = param.getFileNum();
		serialInfo.setSerialNum(param.getInSerial());
		serialInfo.setBumenId(param.getBumenId());
		serialInfo.setYwyId(ywyId);
		serialInfo.setCount(numList.size());
		dao.insertSerial(serialInfo);
		for (String fileNum : numList) {
			storageInfo.setFileNum(fileNum);
			storageInfo.setInSerial(param.getInSerial());
			storageInfo.setYwyinId(ywyId);
			count += dao.updateStorage(storageInfo);
		}
		return count;
	}
	
}
