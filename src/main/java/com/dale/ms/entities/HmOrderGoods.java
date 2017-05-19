package com.dale.ms.entities;

/**
 * HmOrderGoods entity. @author MyEclipse Persistence Tools
 */

public class HmOrderGoods implements java.io.Serializable {

	// Fields

	private Long orderGoodsId;
	private Long orderId;
	private Long storeId;
	private Long goodsId;
	private Long cateId;
	private Double goodsPrice;
	private String goodName;
	private String goodImage;
	private Integer goodCount;

	// Constructors

	/** default constructor */
	public HmOrderGoods() {
	}

	/** minimal constructor */
	public HmOrderGoods(Long orderId, Double goodsPrice, String goodName,
			String goodImage, Integer goodCount) {
		this.orderId = orderId;
		this.goodsPrice = goodsPrice;
		this.goodName = goodName;
		this.goodImage = goodImage;
		this.goodCount = goodCount;
	}

	/** full constructor */
	public HmOrderGoods(Long orderId, Long storeId, Long goodsId, Long cateId,
			Double goodsPrice, String goodName, String goodImage,
			Integer goodCount) {
		this.orderId = orderId;
		this.storeId = storeId;
		this.goodsId = goodsId;
		this.cateId = cateId;
		this.goodsPrice = goodsPrice;
		this.goodName = goodName;
		this.goodImage = goodImage;
		this.goodCount = goodCount;
	}

	// Property accessors

	public Long getOrderGoodsId() {
		return this.orderGoodsId;
	}

	public void setOrderGoodsId(Long orderGoodsId) {
		this.orderGoodsId = orderGoodsId;
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getCateId() {
		return this.cateId;
	}

	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}

	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodName() {
		return this.goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getGoodImage() {
		return this.goodImage;
	}

	public void setGoodImage(String goodImage) {
		this.goodImage = goodImage;
	}

	public Integer getGoodCount() {
		return this.goodCount;
	}

	public void setGoodCount(Integer goodCount) {
		this.goodCount = goodCount;
	}

}