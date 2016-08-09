package com.llhc.mfsa.helper;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class IdHelper {

	private String serialNum;
	
	public String getSerialNum() {
		Date date = new Date();
		long datel = date.getTime();
		serialNum = Long.toString(datel);
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	
}
