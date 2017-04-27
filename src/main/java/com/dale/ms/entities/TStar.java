package com.dale.ms.entities;

/**
 * TStar entity. @author MyEclipse Persistence Tools
 */

public class TStar implements java.io.Serializable {

	// Fields

	private Long starId;
	private String starImg;
	private String scoreMax;
	private String scoreMin;

	// Constructors

	/** default constructor */
	public TStar() {
	}

	/** full constructor */
	public TStar(String starImg, String scoreMax, String scoreMin) {
		this.starImg = starImg;
		this.scoreMax = scoreMax;
		this.scoreMin = scoreMin;
	}

	// Property accessors

	public Long getStarId() {
		return this.starId;
	}

	public void setStarId(Long starId) {
		this.starId = starId;
	}

	public String getStarImg() {
		return this.starImg;
	}

	public void setStarImg(String starImg) {
		this.starImg = starImg;
	}

	public String getScoreMax() {
		return this.scoreMax;
	}

	public void setScoreMax(String scoreMax) {
		this.scoreMax = scoreMax;
	}

	public String getScoreMin() {
		return this.scoreMin;
	}

	public void setScoreMin(String scoreMin) {
		this.scoreMin = scoreMin;
	}

}