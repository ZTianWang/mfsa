package com.llhc.mfsa.vo;

import java.util.List;

import com.llhc.mfsa.entity.PaperInfo;

public class ChukushouliView {

	private String serialNum;
	private int count; 
	private String bumenName;
	private String ywyName;
	private List<PaperInfo> paperlist;
	
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
	public List<PaperInfo> getPaperlist() {
		return paperlist;
	}
	public void setPaperlist(List<PaperInfo> paperlist) {
		this.paperlist = paperlist;
	}
	
	
}
