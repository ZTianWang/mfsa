package com.llhc.mfsa.entity;

public class SerialInfo {

	private String serialNum;
	private int operation;
	private int state;
	private int bumenId;
	private Character ywyId;
	private int count; 
	private String bumenName;
	private String renyuanName;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public int getOperation() {
		return operation;
	}
	public void setOperation(int operation) {
		this.operation = operation;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getBumenId() {
		return bumenId;
	}
	public void setBumenId(int bumenId) {
		this.bumenId = bumenId;
	}
	public Character getYwyId() {
		return ywyId;
	}
	public void setYwyId(Character ywyId) {
		this.ywyId = ywyId;
	}
	public String getBumenName() {
		return bumenName;
	}
	public void setBumenName(String bumenName) {
		this.bumenName = bumenName;
	}
	public String getRenyuanName() {
		return renyuanName;
	}
	public void setRenyuanName(String renyuanName) {
		this.renyuanName = renyuanName;
	}
	
}
