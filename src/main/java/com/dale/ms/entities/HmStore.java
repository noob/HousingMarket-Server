package com.dale.ms.entities;

import java.sql.Timestamp;

/**
 * HmStore entity. @author MyEclipse Persistence Tools
 */

public class HmStore implements java.io.Serializable {

	// Fields

	private Long storeId;
	private Long userId;
	private String bussinessLicense;
	private String storeAddress;
	private String storeName;
	private String storeMobile;
	private String storeImg;
	private Timestamp createDate;
	private String getuiClientId;
	private String deviceInfo;

	// Constructors

	/** default constructor */
	public HmStore() {
	}

	/** minimal constructor */
	public HmStore(Long userId) {
		this.userId = userId;
	}

	/** full constructor */
	public HmStore(Long userId, String bussinessLicense, String storeAddress,
			String storeName, String storeMobile, String storeImg,
			Timestamp createDate, String getuiClientId, String deviceInfo) {
		this.userId = userId;
		this.bussinessLicense = bussinessLicense;
		this.storeAddress = storeAddress;
		this.storeName = storeName;
		this.storeMobile = storeMobile;
		this.storeImg = storeImg;
		this.createDate = createDate;
		this.getuiClientId = getuiClientId;
		this.deviceInfo = deviceInfo;
	}

	// Property accessors

	public Long getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getStoreImg() {
		return this.storeImg;
	}

	public void setStoreImg(String storeImg) {
		this.storeImg = storeImg;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
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