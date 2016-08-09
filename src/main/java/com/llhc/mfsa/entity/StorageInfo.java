package com.llhc.mfsa.entity;

import java.util.Date;

public class StorageInfo {

	private Integer id;
	private String fileNum;
	private String position;
	private String inSerial;
	private Integer ywyinId;
	private Integer jhyinId;
	private Integer kgyinId;
	private Date inDate;
	private String outSerial;
	private Integer ywyoutId;
	private Integer jhyoutId;
	private Integer kgyoutId;
	private Date outDate;
	private Integer kucunState;
	
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getInSerial() {
		return inSerial;
	}
	public void setInSerial(String inSerial) {
		this.inSerial = inSerial;
	}
	public Integer getYwyinId() {
		return ywyinId;
	}
	public void setYwyinId(Integer ywyinId) {
		this.ywyinId = ywyinId;
	}
	public Integer getJhyinId() {
		return jhyinId;
	}
	public void setJhyinId(Integer jhyinId) {
		this.jhyinId = jhyinId;
	}
	public Integer getKgyinId() {
		return kgyinId;
	}
	public void setKgyinId(Integer kgyinId) {
		this.kgyinId = kgyinId;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public String getOutSerial() {
		return outSerial;
	}
	public void setOutSerial(String outSerial) {
		this.outSerial = outSerial;
	}
	public Integer getYwyoutId() {
		return ywyoutId;
	}
	public void setYwyoutId(Integer ywyoutId) {
		this.ywyoutId = ywyoutId;
	}
	public Integer getJhyoutId() {
		return jhyoutId;
	}
	public void setJhyoutId(Integer jhyoutId) {
		this.jhyoutId = jhyoutId;
	}
	public Integer getKgyoutId() {
		return kgyoutId;
	}
	public void setKgyoutId(Integer kgyoutId) {
		this.kgyoutId = kgyoutId;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	public Integer getKucunState() {
		return kucunState;
	}
	public void setKucunState(Integer kucunState) {
		this.kucunState = kucunState;
	}
	
}
