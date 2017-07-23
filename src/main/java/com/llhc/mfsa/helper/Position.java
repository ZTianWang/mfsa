package com.llhc.mfsa.helper;

public class Position {
	
	public static String getPosition(int bId,int fId) {
		String a;
		if (bId == 1) {
			a = "A";
		}else {
			a = "B";
		}
		return a+fId;
	}
	
}
