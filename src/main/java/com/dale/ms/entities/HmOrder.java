package com.dale.ms.entities;

import java.sql.Timestamp;

/**
 * HmOrder entity. @author MyEclipse Persistence Tools
 */

public class HmOrder implements java.io.Serializable {

	// Fields

	private Long orderId;
	private Long userId;
	private Long orderGoodsId;
	private Long storeId;
	private String orderTradeNo;
	private String payway;
	private String userName;
	private Double orderPrice;
	private Double sendPrice;
	private Timestamp orderCreateTime;
	private Timestamp orderPayTime;
	private Timestamp orderRefuseTime;
	private Timestamp orderRefundTime;
	private Timestamp orderConfirmTime;
	private Timestamp orderCompleteTime;
<<<<<<< HEAD
	private Integer orderStatus;
=======
<<<<<<< HEAD
	private Integer orderStatus;
=======
<<<<<<< HEAD
	private Integer orderStatus;
=======
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
	private String buyerMobile;
	private String address;
	private String manJian;
	private String manFan;
	private String manSong;

	// Constructors

	/** default constructor */
	public HmOrder() {
	}

	/** minimal constructor */
	public HmOrder(Long userId, Long orderGoodsId, String orderTradeNo,
			String payway, String userName, Double orderPrice, Double sendPrice) {
		this.userId = userId;
		this.orderGoodsId = orderGoodsId;
		this.orderTradeNo = orderTradeNo;
		this.payway = payway;
		this.userName = userName;
		this.orderPrice = orderPrice;
		this.sendPrice = sendPrice;
	}

	/** full constructor */
	public HmOrder(Long userId, Long orderGoodsId, Long storeId,
			String orderTradeNo, String payway, String userName,
			Double orderPrice, Double sendPrice, Timestamp orderCreateTime,
			Timestamp orderPayTime, Timestamp orderRefuseTime,
			Timestamp orderRefundTime, Timestamp orderConfirmTime,
<<<<<<< HEAD
			Timestamp orderCompleteTime, Integer orderStatus,
			String buyerMobile, String address, String manJian, String manFan,
			String manSong) {
=======
<<<<<<< HEAD
			Timestamp orderCompleteTime, Integer orderStatus,
			String buyerMobile, String address, String manJian, String manFan,
			String manSong) {
=======
<<<<<<< HEAD
			Timestamp orderCompleteTime, Integer orderStatus,
			String buyerMobile, String address, String manJian, String manFan,
			String manSong) {
=======
			Timestamp orderCompleteTime, String buyerMobile, String address,
			String manJian, String manFan, String manSong) {
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
		this.userId = userId;
		this.orderGoodsId = orderGoodsId;
		this.storeId = storeId;
		this.orderTradeNo = orderTradeNo;
		this.payway = payway;
		this.userName = userName;
		this.orderPrice = orderPrice;
		this.sendPrice = sendPrice;
		this.orderCreateTime = orderCreateTime;
		this.orderPayTime = orderPayTime;
		this.orderRefuseTime = orderRefuseTime;
		this.orderRefundTime = orderRefundTime;
		this.orderConfirmTime = orderConfirmTime;
		this.orderCompleteTime = orderCompleteTime;
<<<<<<< HEAD
		this.orderStatus = orderStatus;
=======
<<<<<<< HEAD
		this.orderStatus = orderStatus;
=======
<<<<<<< HEAD
		this.orderStatus = orderStatus;
=======
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
		this.buyerMobile = buyerMobile;
		this.address = address;
		this.manJian = manJian;
		this.manFan = manFan;
		this.manSong = manSong;
	}

	// Property accessors

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOrderGoodsId() {
		return this.orderGoodsId;
	}

	public void setOrderGoodsId(Long orderGoodsId) {
		this.orderGoodsId = orderGoodsId;
	}

	public Long getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getOrderTradeNo() {
		return this.orderTradeNo;
	}

	public void setOrderTradeNo(String orderTradeNo) {
		this.orderTradeNo = orderTradeNo;
	}

	public String getPayway() {
		return this.payway;
	}

	public void setPayway(String payway) {
		this.payway = payway;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Double getSendPrice() {
		return this.sendPrice;
	}

	public void setSendPrice(Double sendPrice) {
		this.sendPrice = sendPrice;
	}

	public Timestamp getOrderCreateTime() {
		return this.orderCreateTime;
	}

	public void setOrderCreateTime(Timestamp orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public Timestamp getOrderPayTime() {
		return this.orderPayTime;
	}

	public void setOrderPayTime(Timestamp orderPayTime) {
		this.orderPayTime = orderPayTime;
	}

	public Timestamp getOrderRefuseTime() {
		return this.orderRefuseTime;
	}

	public void setOrderRefuseTime(Timestamp orderRefuseTime) {
		this.orderRefuseTime = orderRefuseTime;
	}

	public Timestamp getOrderRefundTime() {
		return this.orderRefundTime;
	}

	public void setOrderRefundTime(Timestamp orderRefundTime) {
		this.orderRefundTime = orderRefundTime;
	}

	public Timestamp getOrderConfirmTime() {
		return this.orderConfirmTime;
	}

	public void setOrderConfirmTime(Timestamp orderConfirmTime) {
		this.orderConfirmTime = orderConfirmTime;
	}

	public Timestamp getOrderCompleteTime() {
		return this.orderCompleteTime;
	}

	public void setOrderCompleteTime(Timestamp orderCompleteTime) {
		this.orderCompleteTime = orderCompleteTime;
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
	public String getBuyerMobile() {
		return this.buyerMobile;
	}

	public void setBuyerMobile(String buyerMobile) {
		this.buyerMobile = buyerMobile;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getManJian() {
		return this.manJian;
	}

	public void setManJian(String manJian) {
		this.manJian = manJian;
	}

	public String getManFan() {
		return this.manFan;
	}

	public void setManFan(String manFan) {
		this.manFan = manFan;
	}

	public String getManSong() {
		return this.manSong;
	}

	public void setManSong(String manSong) {
		this.manSong = manSong;
	}

}