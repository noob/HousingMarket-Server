package com.dale.ms.entities;

import java.sql.Timestamp;

/**
 * TLessonLog entity. @author MyEclipse Persistence Tools
 */

public class TLessonLog implements java.io.Serializable {

	// Fields

	private Long lessonLogId;
	private Long userId;
	private String userName;
	private String realName;
	private String idCard;
	private String userMobile;
	private String highSchoolName;
	private Integer gender;
	private Timestamp createTime;
	private String realPrice;
	private Long lessonId;
	private String lessonName;
	private Timestamp lessonBeginDate;
	private String outTradeNo;
	private String tradeNo;
	private String buyerAlipayAccount;
	private String tradeStatus;

	// Constructors

	/** default constructor */
	public TLessonLog() {
	}

	/** minimal constructor */
	public TLessonLog(Long userId, String userName, String realName,
			String idCard, String userMobile, String highSchoolName,
			Timestamp createTime, String realPrice, Long lessonId,
			String lessonName, Timestamp lessonBeginDate, String outTradeNo,
			String tradeNo, String buyerAlipayAccount, String tradeStatus) {
		this.userId = userId;
		this.userName = userName;
		this.realName = realName;
		this.idCard = idCard;
		this.userMobile = userMobile;
		this.highSchoolName = highSchoolName;
		this.createTime = createTime;
		this.realPrice = realPrice;
		this.lessonId = lessonId;
		this.lessonName = lessonName;
		this.lessonBeginDate = lessonBeginDate;
		this.outTradeNo = outTradeNo;
		this.tradeNo = tradeNo;
		this.buyerAlipayAccount = buyerAlipayAccount;
		this.tradeStatus = tradeStatus;
	}

	/** full constructor */
	public TLessonLog(Long userId, String userName, String realName,
			String idCard, String userMobile, String highSchoolName,
			Integer gender, Timestamp createTime, String realPrice,
			Long lessonId, String lessonName, Timestamp lessonBeginDate,
			String outTradeNo, String tradeNo, String buyerAlipayAccount,
			String tradeStatus) {
		this.userId = userId;
		this.userName = userName;
		this.realName = realName;
		this.idCard = idCard;
		this.userMobile = userMobile;
		this.highSchoolName = highSchoolName;
		this.gender = gender;
		this.createTime = createTime;
		this.realPrice = realPrice;
		this.lessonId = lessonId;
		this.lessonName = lessonName;
		this.lessonBeginDate = lessonBeginDate;
		this.outTradeNo = outTradeNo;
		this.tradeNo = tradeNo;
		this.buyerAlipayAccount = buyerAlipayAccount;
		this.tradeStatus = tradeStatus;
	}

	// Property accessors

	public Long getLessonLogId() {
		return this.lessonLogId;
	}

	public void setLessonLogId(Long lessonLogId) {
		this.lessonLogId = lessonLogId;
	}

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

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getUserMobile() {
		return this.userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getHighSchoolName() {
		return this.highSchoolName;
	}

	public void setHighSchoolName(String highSchoolName) {
		this.highSchoolName = highSchoolName;
	}

	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getRealPrice() {
		return this.realPrice;
	}

	public void setRealPrice(String realPrice) {
		this.realPrice = realPrice;
	}

	public Long getLessonId() {
		return this.lessonId;
	}

	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
	}

	public String getLessonName() {
		return this.lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public Timestamp getLessonBeginDate() {
		return this.lessonBeginDate;
	}

	public void setLessonBeginDate(Timestamp lessonBeginDate) {
		this.lessonBeginDate = lessonBeginDate;
	}

	public String getOutTradeNo() {
		return this.outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getBuyerAlipayAccount() {
		return this.buyerAlipayAccount;
	}

	public void setBuyerAlipayAccount(String buyerAlipayAccount) {
		this.buyerAlipayAccount = buyerAlipayAccount;
	}

	public String getTradeStatus() {
		return this.tradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

}