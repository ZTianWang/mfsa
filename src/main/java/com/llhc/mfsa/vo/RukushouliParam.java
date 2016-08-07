package com.llhc.mfsa.vo;

import java.util.List;

public class RukushouliParam {

	private String serialNum;
	private Character renyuanId;
	private List<Integer> danganId;
	
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public Character getRenyuanId() {
		return renyuanId;
	}
	public void setRenyuanId(Character renyuanId) {
		this.renyuanId = renyuanId;
	}
	public List<Integer> getDanganId() {
		return danganId;
	}
	public void setDanganId(List<Integer> danganId) {
		this.danganId = danganId;
	}
	
}
