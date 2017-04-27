package com.dale.ms.entities;

/**
 * TMajor entity. @author MyEclipse Persistence Tools
 */

public class TMajor implements java.io.Serializable {

	// Fields

	private Long majorId;
	private String majorCode;
	private String majorName;
	private String majorRemarks;
	private String majorImg;
	private String cate;
	private Integer department;
	private Integer isSpecial;

	// Constructors

	/** default constructor */
	public TMajor() {
	}

	/** minimal constructor */
	public TMajor(String majorCode, String majorName) {
		this.majorCode = majorCode;
		this.majorName = majorName;
	}

	/** full constructor */
	public TMajor(String majorCode, String majorName, String majorRemarks,
			String majorImg, String cate, Integer department, Integer isSpecial) {
		this.majorCode = majorCode;
		this.majorName = majorName;
		this.majorRemarks = majorRemarks;
		this.majorImg = majorImg;
		this.cate = cate;
		this.department = department;
		this.isSpecial = isSpecial;
	}

	// Property accessors

	public Long getMajorId() {
		return this.majorId;
	}

	public void setMajorId(Long majorId) {
		this.majorId = majorId;
	}

	public String getMajorCode() {
		return this.majorCode;
	}

	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}

	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getMajorRemarks() {
		return this.majorRemarks;
	}

	public void setMajorRemarks(String majorRemarks) {
		this.majorRemarks = majorRemarks;
	}

	public String getMajorImg() {
		return this.majorImg;
	}

	public void setMajorImg(String majorImg) {
		this.majorImg = majorImg;
	}

	public String getCate() {
		return this.cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public Integer getDepartment() {
		return this.department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Integer getIsSpecial() {
		return this.isSpecial;
	}

	public void setIsSpecial(Integer isSpecial) {
		this.isSpecial = isSpecial;
	}

}