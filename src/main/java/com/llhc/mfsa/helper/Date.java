package com.llhc.mfsa.helper;

public class Date extends java.util.Date {

	@Override
	public String toString() {
		return getYear() + "-" + getMonth() + "-" + getDate();
	}

	
	
}
