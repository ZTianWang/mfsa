package com.llhc.mfsa.entity;

public class UserInfo {

	private Integer id;
	private String userName;
	private String realName;
	private String phone;
	private Integer bumenId;
	private Integer role;
	private String password;
	private String bumenName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getBumenId() {
		return bumenId;
	}
	public void setBumenId(Integer bumenId) {
		this.bumenId = bumenId;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBumenName() {
		return bumenName;
	}
	public void setBumenName(String bumenName) {
		this.bumenName = bumenName;
	}
	
}
