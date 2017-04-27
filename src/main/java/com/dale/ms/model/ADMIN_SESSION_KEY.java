package com.dale.ms.model;

import java.sql.Timestamp;

/**
 * AdminUser entity. @author MyEclipse Persistence Tools
 */

public class ADMIN_SESSION_KEY implements java.io.Serializable {

	// Fields

	private Long adminId;
	private String adminName;
	private String password;
	private String adminImg;
	private Integer gender;
	private String idCard;
	private Timestamp createTime;
	private String mobile;
	private String lastIp;
	private Timestamp lastTime;
	private Integer power;

	// Constructors

	/** default constructor */
	public ADMIN_SESSION_KEY() {
	}

	/** minimal constructor */
	public ADMIN_SESSION_KEY(String adminName, String password, Timestamp createTime) {
		this.adminName = adminName;
		this.password = password;
		this.createTime = createTime;
	}

	/** full constructor */
	public ADMIN_SESSION_KEY(String adminName, String password, String adminImg,
			Integer gender, String idCard, Timestamp createTime, String mobile,
			String lastIp, Timestamp lastTime, Integer power) {
		this.adminName = adminName;
		this.password = password;
		this.adminImg = adminImg;
		this.gender = gender;
		this.idCard = idCard;
		this.createTime = createTime;
		this.mobile = mobile;
		this.lastIp = lastIp;
		this.lastTime = lastTime;
		this.power = power;
	}

	// Property accessors

	public Long getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminImg() {
		return this.adminImg;
	}

	public void setAdminImg(String adminImg) {
		this.adminImg = adminImg;
	}

	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLastIp() {
		return this.lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public Timestamp getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

	public Integer getPower() {
		return this.power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

}