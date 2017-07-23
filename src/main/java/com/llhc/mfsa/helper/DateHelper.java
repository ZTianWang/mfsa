package com.llhc.mfsa.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

	private Date CurrentDate = new Date(System.currentTimeMillis());
    
    public Date getCurrentDate() {
    	return CurrentDate;
	}
    
    public Date getDaoqiDate(Date qianfengDate) {
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(qianfengDate);
        calendar.add(Calendar.YEAR, +1);
        Date daoqiDate = calendar.getTime();
        return daoqiDate;
	}
    
    public static String dateToStr(Date date) {
    	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
    	return dateFormater.format(date);
	}
    
}
