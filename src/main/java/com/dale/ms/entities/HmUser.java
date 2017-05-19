package com.dale.ms.entities;

import java.sql.Timestamp;

/**
 * HmUser entity. @author MyEclipse Persistence Tools
 */

public class HmUser implements java.io.Serializable {

	// Fields

	private Long userId;
	private String userName;
	private String password;
	private String userImg;
	private Integer gender;
	private String idCard;
	private Timestamp createTime;
	private String mobile;
	private String address;
	private Timestamp lastLoginTime;
	private Long storeId;
	private Integer isStore;
	private String bussinessLicense;
	private String storeAddress;
	private String storeName;
	private String storeMobile;
	private String getuiClientId;
	private String deviceInfo;

	// Constructors

	/** default constructor */
	public HmUser() {
	}

	/** minimal constructor */
	public HmUser(String userName, String password, Timestamp createTime) {
		this.userName = userName;
		this.password = password;
		this.createTime = createTime;
	}

	/** full constructor */
	public HmUser(String userName, String password, String userImg,
			Integer gender, String idCard, Timestamp createTime, String mobile,
			String address, Timestamp lastLoginTime, Long storeId,
			Integer isStore, String bussinessLicense, String storeAddress,
			String storeName, String storeMobile, String getuiClientId,
			String deviceInfo) {
		this.userName = userName;
		this.password = password;
		this.userImg = userImg;
		this.gender = gender;
		this.idCard = idCard;
		this.createTime = createTime;
		this.mobile = mobile;
		this.address = address;
		this.lastLoginTime = lastLoginTime;
		this.storeId = storeId;
		this.isStore = isStore;
		this.bussinessLicense = bussinessLicense;
		this.storeAddress = storeAddress;
		this.storeName = storeName;
		this.storeMobile = storeMobile;
		this.getuiClientId = getuiClientId;
		this.deviceInfo = deviceInfo;
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Long getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Integer getIsStore() {
		return this.isStore;
	}

	public void setIsStore(Integer isStore) {
		this.isStore = isStore;
	}

	public String getBussinessLicense() {
		return this.bussinessLicense;
	}

	public void setBussinessLicense(String bussinessLicense) {
		this.bussinessLicense = bussinessLicense;
	}

	public String getStoreAddress() {
		return this.storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreMobile() {
		return this.storeMobile;
	}

	public void setStoreMobile(String storeMobile) {
		this.storeMobile = storeMobile;
	}

	public String getGetuiClientId() {
		return this.getuiClientId;
	}

	public void setGetuiClientId(String getuiClientId) {
		this.getuiClientId = getuiClientId;
	}

	public String getDeviceInfo() {
		return this.deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

}
