package com.llhc.mfsa.vo;

import java.util.List;

import com.llhc.mfsa.entity.FileInfo;

public class RukushouliView {

	private String serialNum;
	private int count; 
	private String bumenName;
	private String ywyName;
	private List<FileInfo> paperlist;
	
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
	public List<FileInfo> getPaperlist() {
		return paperlist;
	}
	public void setPaperlist(List<FileInfo> paperlist) {
		this.paperlist = paperlist;
	}
	
}
