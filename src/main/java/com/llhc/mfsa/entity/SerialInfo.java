package com.llhc.mfsa.entity;

public class SerialInfo {

	private Integer id;
	private String serialNum;
	private Integer operation;
	private Integer state;
	private Integer bumenId;
	private Integer ywyId;
	private Integer kgyId;
	private Integer count;
	private String bumenName;
	private String ywyName;
	private String kgyName;
	
	public String getYwyName() {
		return ywyName;
	}
	public void setYwyName(String ywyName) {
		this.ywyName = ywyName;
	}
	public String getKgyName() {
		return kgyName;
	}
	public void setKgyName(String kgyName) {
		this.kgyName = kgyName;
	}
	public String getBumenName() {
		return bumenName;
	}
	public void setBumenName(String bumenName) {
		this.bumenName = bumenName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public Integer getOperation() {
		return operation;
	}
	public void setOperation(Integer operation) {
		this.operation = operation;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getBumenId() {
		return bumenId;
	}
	public void setBumenId(Integer bumenId) {
		this.bumenId = bumenId;
	}
	public Integer getYwyId() {
		return ywyId;
	}
	public void setYwyId(Integer ywyId) {
		this.ywyId = ywyId;
	}
	public Integer getKgyId() {
		return kgyId;
	}
	public void setKgyId(Integer kgyId) {
		this.kgyId = kgyId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
