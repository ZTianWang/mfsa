package com.llhc.mfsa.vo;

import java.util.List;

public class RukushenqingParam {

	private List<Integer> danganId;
	private Character ywyId;
	private String inSerial;
	private int bumenId;

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

	public String getInSerial() {
		return inSerial;
	}

	public void setInSerial(String inSerial) {
		this.inSerial = inSerial;
	}

	public List<Integer> getDanganId() {
		return danganId;
	}

	public void setDanganId(List<Integer> danganId) {
		this.danganId = danganId;
	}

}
