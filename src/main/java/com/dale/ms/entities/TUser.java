package com.dale.ms.entities;

import java.sql.Timestamp;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private Long userId;
	private String userName;
	private String password;
	private String userImg;
	private Integer gender;
	private String idCard;
	private Timestamp createTime;
	private String mobile;
	private String lastIp;
	private Timestamp lastTime;
	private Integer userStatus;
	private String realName;
	private String highSchool;
	private Integer isEnterInfoComplete;
	private Integer rankPower;

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(String userName, Timestamp createTime) {
		this.userName = userName;
		this.createTime = createTime;
	}

	/** full constructor */
	public TUser(String userName, String password, String userImg,
			Integer gender, String idCard, Timestamp createTime, String mobile,
			String lastIp, Timestamp lastTime, Integer userStatus,
			String realName, String highSchool, Integer isEnterInfoComplete,
			Integer rankPower) {
		this.userName = userName;
		this.password = password;
		this.userImg = userImg;
		this.gender = gender;
		this.idCard = idCard;
		this.createTime = createTime;
		this.mobile = mobile;
		this.lastIp = lastIp;
		this.lastTime = lastTime;
		this.userStatus = userStatus;
		this.realName = realName;
		this.highSchool = highSchool;
		this.isEnterInfoComplete = isEnterInfoComplete;
		this.rankPower = rankPower;
	}

	// Property accessors

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserImg() {
		return this.userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
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

	public Integer getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getHighSchool() {
		return this.highSchool;
	}

	public void setHighSchool(String highSchool) {
		this.highSchool = highSchool;
	}

	public Integer getIsEnterInfoComplete() {
		return this.isEnterInfoComplete;
	}

	public void setIsEnterInfoComplete(Integer isEnterInfoComplete) {
		this.isEnterInfoComplete = isEnterInfoComplete;
	}

	public Integer getRankPower() {
		return this.rankPower;
	}

	public void setRankPower(Integer rankPower) {
		this.rankPower = rankPower;
	}

}