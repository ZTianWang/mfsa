package com.llhc.mfsa.vo;

import java.util.List;

public class ChukushouliParam {

	private Integer kgyId;
	private List<String> serialNum;

	public Integer getKgyId() {
		return kgyId;
	}

	public void setKgyId(Integer kgyId) {
		this.kgyId = kgyId;
	}

	public List<String> getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(List<String> serialNum) {
		this.serialNum = serialNum;
	}

	public String toString() {
		return "ChukushouliParam [kgyId=" + kgyId + ", serialNum=" + serialNum + "]";
	}

}
