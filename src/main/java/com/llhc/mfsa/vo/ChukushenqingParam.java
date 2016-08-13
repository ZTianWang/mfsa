package com.llhc.mfsa.vo;

import java.util.List;

public class ChukushenqingParam {
	
	private Integer bumenId;
	private String danganNum;
	private String qianfengDateF;
	private String qianfengDateL;
	private String daoqiDateF;
	private String daoqiDateL;
	private String serial;
	private List<Integer> danganId;
	
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public List<Integer> getDanganId() {
		return danganId;
	}
	public void setDanganId(List<Integer> danganId) {
		this.danganId = danganId;
	}
	public Integer getBumenId() {
		return bumenId;
	}
	public void setBumenId(Integer bumenId) {
		this.bumenId = bumenId;
	}
	public String getDanganNum() {
		return danganNum;
	}
	public void setDanganNum(String danganNum) {
		this.danganNum = danganNum;
	}
	public String getQianfengDateF() {
		return qianfengDateF;
	}
	public void setQianfengDateF(String qianfengDateF) {
		this.qianfengDateF = qianfengDateF;
	}
	public String getQianfengDateL() {
		return qianfengDateL;
	}
	public void setQianfengDateL(String qianfengDateL) {
		this.qianfengDateL = qianfengDateL;
	}
	public String getDaoqiDateF() {
		return daoqiDateF;
	}
	public void setDaoqiDateF(String daoqiDateF) {
		this.daoqiDateF = daoqiDateF;
	}
	public String getDaoqiDateL() {
		return daoqiDateL;
	}
	public void setDaoqiDateL(String daoqiDateL) {
		this.daoqiDateL = daoqiDateL;
	}
	
	public String toString() {
		return "ChukushenqingParam [bumenId=" + bumenId + ", danganNum=" + danganNum + ", qianfengDateF="
				+ qianfengDateF + ", qianfengDateL=" + qianfengDateL + ", daoqiDateF=" + daoqiDateF + ", daoqiDateL="
				+ daoqiDateL + "]";
	}
	
}
