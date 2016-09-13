package com.llhc.mfsa.vo;

import java.util.List;

import com.llhc.mfsa.entity.PaperInfo;

public class JjckslView {
	
	private String serialNum;
	private int count; 
	private String bumenName;
	private String ywyName;
	private List<PaperInfo> paperList;
	
	public List<PaperInfo> getPaperList() {
		return paperList;
	}
	public void setPaperList(List<PaperInfo> paperList) {
		this.paperList = paperList;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getBumenName() {
		return bumenName;
	}
	public void setBumenName(String bumenName) {
		this.bumenName = bumenName;
	}
	public String getYwyName() {
		return ywyName;
	}
	public void setYwyName(String ywyName) {
		this.ywyName = ywyName;
	}
	
	
}
