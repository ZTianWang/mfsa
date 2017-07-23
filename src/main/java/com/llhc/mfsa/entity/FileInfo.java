package com.llhc.mfsa.entity;

import java.util.Date;

import com.llhc.mfsa.helper.DateHelper;

public class FileInfo {

	private Integer id;
	private String fileNum;
	private Integer custId;
	private Integer bumenId;
	private String fileName;
	private Date qianfengDate;
	private Integer mId;
	private Integer ywyId;
	private String custName;
	private String bumenName;
	private String mName;
	private String ywyName;
	private String dateStr;
	private Integer kucunState;
	private String position;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFileNum() {
		return fileNum;
	}
	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public Integer getBumenId() {
		return bumenId;
	}
	public void setBumenId(Integer bumenId) {
		this.bumenId = bumenId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getQianfengDate() {
		return qianfengDate;
	}
	public void setQianfengDate(Date qianfengDate) {
		this.dateStr = DateHelper.dateToStr(qianfengDate);
		this.qianfengDate = qianfengDate;
	}
	public Integer getmId() {
		return mId;
	}
	public void setmId(Integer mId) {
		this.mId = mId;
	}
	public Integer getYwyId() {
		return ywyId;
	}
	public void setYwyId(Integer ywyId) {
		this.ywyId = ywyId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getBumenName() {
		return bumenName;
	}
	public void setBumenName(String bumenName) {
		this.bumenName = bumenName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getYwyName() {
		return ywyName;
	}
	public void setYwyName(String ywyName) {
		this.ywyName = ywyName;
	}
	public String getDateStr() {
		return dateStr;
	}
	public Integer getKucunState() {
		return kucunState;
	}
	public void setKucunState(Integer kucunState) {
		this.kucunState = kucunState;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
