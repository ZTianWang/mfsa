package com.llhc.mfsa.vo;

public class QianfengParam {

	private Integer fileId;
	private Integer danganId;
	private Integer bumenId;
	private Integer wupinId;
	private String fuzeren;
	private String kehujingli;
	private String dianhua;
	
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public Integer getDanganId() {
		return danganId;
	}
	public void setDanganId(Integer danganId) {
		this.danganId = danganId;
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
	
	public String toString() {
		return "QianfengParam [fileId=" + fileId + ", danganId=" + danganId + ", bumenId=" + bumenId + ", wupinId="
				+ wupinId + ", fuzeren=" + fuzeren + ", kehujingli=" + kehujingli + ", dianhua=" + dianhua + "]";
	}
	
}
