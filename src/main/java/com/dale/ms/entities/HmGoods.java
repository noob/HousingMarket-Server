package com.dale.ms.entities;

import java.sql.Timestamp;

/**
 * HmGoods entity. @author MyEclipse Persistence Tools
 */

public class HmGoods implements java.io.Serializable {

	// Fields

	private Long goodsId;
	private Long cateId;
	private Long storeId;
	private Double goodOriginalPrice;
	private Double goodsPrice;
	private String goodName;
	private String goodImage;
	private Double discount;
	private String countUnit;
	private String description;
	private String mark;
	private Integer salesVolume;
	private Integer inventory;
	private Timestamp createDate;

	// Constructors

	/** default constructor */
	public HmGoods() {
	}

	/** minimal constructor */
	public HmGoods(Double goodsPrice, String goodName, String goodImage) {
		this.goodsPrice = goodsPrice;
		this.goodName = goodName;
		this.goodImage = goodImage;
	}

	/** full constructor */
	public HmGoods(Long cateId, Long storeId, Double goodOriginalPrice,
			Double goodsPrice, String goodName, String goodImage,
			Double discount, String countUnit, String description, String mark,
			Integer salesVolume, Integer inventory, Timestamp createDate) {
		this.cateId = cateId;
		this.storeId = storeId;
		this.goodOriginalPrice = goodOriginalPrice;
		this.goodsPrice = goodsPrice;
		this.goodName = goodName;
		this.goodImage = goodImage;
		this.discount = discount;
		this.countUnit = countUnit;
		this.description = description;
		this.mark = mark;
		this.salesVolume = salesVolume;
		this.inventory = inventory;
		this.createDate = createDate;
	}

	// Property accessors

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

	public Long getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Double getGoodOriginalPrice() {
		return this.goodOriginalPrice;
	}

	public void setGoodOriginalPrice(Double goodOriginalPrice) {
		this.goodOriginalPrice = goodOriginalPrice;
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

	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getCountUnit() {
		return this.countUnit;
	}

	public void setCountUnit(String countUnit) {
		this.countUnit = countUnit;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Integer getSalesVolume() {
		return this.salesVolume;
	}

	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}

	public Integer getInventory() {
		return this.inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}