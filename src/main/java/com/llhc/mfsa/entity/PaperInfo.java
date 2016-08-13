package com.llhc.mfsa.entity;

import java.util.Date;

public class PaperInfo {

	private Integer id;
	private String danganNum;
	private Integer bumenId;
	private Integer wupinId;
	private String fileNum;
	private Date qianfengDate;
	private Date daoqiDate;
	private String fuzeren;
	private String kehujingli;
	private String dianhua;
	private Integer ywyId;
	private String bumenName;
	private String wupinName;
	private String ywyName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDanganNum() {
		return danganNum;
	}
	public void setDanganNum(String danganNum) {
		this.danganNum = danganNum;
	}
	public Integer getBumenId() {
		return bumenId;
	}
	public void setBumenId(Integer bumenId) {
		this.bumenId = bumenId;
	}
	public Integer getWupinId() {
		return wupinId;
	}
	public void setWupinId(Integer wupinId) {
		this.wupinId = wupinId;
	}
	public String getFileNum() {
		return fileNum;
	}
	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}
	public Date getQianfengDate() {
		return qianfengDate;
	}
	public void setQianfengDate(Date qianfengDate) {
		this.qianfengDate = qianfengDate;
	}
	public Date getDaoqiDate() {
		return daoqiDate;
	}
	public void setDaoqiDate(Date daoqiDate) {
		this.daoqiDate = daoqiDate;
	}
	public String getFuzeren() {
		return fuzeren;
	}
	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}
	public String getKehujingli() {
		return kehujingli;
	}
	public void setKehujingli(String kehujingli) {
		this.kehujingli = kehujingli;
	}
	public String getDianhua() {
		return dianhua;
	}
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	public Integer getYwyId() {
		return ywyId;
	}
	public void setYwyId(Integer ywyId) {
		this.ywyId = ywyId;
	}
	public String getBumenName() {
		return bumenName;
	}
	public void setBumenName(String bumenName) {
		this.bumenName = bumenName;
	}
	public String getWupinName() {
		return wupinName;
	}
	public void setWupinName(String wupinName) {
		this.wupinName = wupinName;
	}
	public String getYwyName() {
		return ywyName;
	}
	public void setYwyName(String ywyName) {
		this.ywyName = ywyName;
	}
	
	public String toString() {
		return "PaperInfo [id=" + id + ", danganNum=" + danganNum + ", bumenId=" + bumenId + ", wupinId=" + wupinId
				+ ", fileNum=" + fileNum + ", qianfengDate=" + qianfengDate + ", daoqiDate=" + daoqiDate + ", fuzeren="
				+ fuzeren + ", kehujingli=" + kehujingli + ", dianhua=" + dianhua + ", ywyId=" + ywyId + ", bumenName="
				+ bumenName + ", wupinName=" + wupinName + ", ywyName=" + ywyName + "]";
	}
	
}
