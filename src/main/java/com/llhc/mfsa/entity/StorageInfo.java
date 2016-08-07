package com.llhc.mfsa.entity;

import java.util.Date;

public class StorageInfo {

	private Integer fileId;
	private String inSerial;
	private Character ywyinId;
	private Character jhyinId;
	private Character kgyinId;
	private Date inDate;
	private String outSerial;
	private Character ywyoutId;
	private Character jhyoutId;
	private Character kgyoutId;
	private Date outDate;
	private Character kucunState;
	private String position;
	
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public String getInSerial() {
		return inSerial;
	}
	public void setInSerial(String inSerial) {
		this.inSerial = inSerial;
	}
	public Character getYwyinId() {
		return ywyinId;
	}
	public void setYwyinId(Character ywyinId) {
		this.ywyinId = ywyinId;
	}
	public Character getJhyinId() {
		return jhyinId;
	}
	public void setJhyinId(Character jhyinId) {
		this.jhyinId = jhyinId;
	}
	public Character getKgyinId() {
		return kgyinId;
	}
	public void setKgyinId(Character kgyinId) {
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
	public Character getYwyoutId() {
		return ywyoutId;
	}
	public void setYwyoutId(Character ywyoutId) {
		this.ywyoutId = ywyoutId;
	}
	public Character getJhyoutId() {
		return jhyoutId;
	}
	public void setJhyoutId(Character jhyoutId) {
		this.jhyoutId = jhyoutId;
	}
	public Character getKgyoutId() {
		return kgyoutId;
	}
	public void setKgyoutId(Character kgyoutId) {
		this.kgyoutId = kgyoutId;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	public Character getKucunState() {
		return kucunState;
	}
	public void setKucunState(Character kucunState) {
		this.kucunState = kucunState;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
