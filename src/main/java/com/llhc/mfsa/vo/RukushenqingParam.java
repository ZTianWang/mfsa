package com.llhc.mfsa.vo;

import java.util.List;

public class RukushenqingParam {

	private List<String> fileNum;
	private String inSerial;
	private int bumenId;

	public int getBumenId() {
		return bumenId;
	}

	public void setBumenId(int bumenId) {
		this.bumenId = bumenId;
	}

	public String getInSerial() {
		return inSerial;
	}

	public void setInSerial(String inSerial) {
		this.inSerial = inSerial;
	}

	public List<String> getFileNum() {
		return fileNum;
	}

	public void setFileNum(List<String> fileNum) {
		this.fileNum = fileNum;
	}

}
