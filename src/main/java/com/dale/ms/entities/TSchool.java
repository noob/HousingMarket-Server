package com.dale.ms.entities;

/**
 * TSchool entity. @author MyEclipse Persistence Tools
 */

public class TSchool implements java.io.Serializable {

	// Fields

	private Long schoolId;
	private String schoolCode;
	private String schoolName;
	private String schoolRegion;
	private String schoolImg;

	// Constructors

	/** default constructor */
	public TSchool() {
	}

	/** minimal constructor */
	public TSchool(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	/** full constructor */
	public TSchool(String schoolCode, String schoolName, String schoolRegion,
			String schoolImg) {
		this.schoolCode = schoolCode;
		this.schoolName = schoolName;
		this.schoolRegion = schoolRegion;
		this.schoolImg = schoolImg;
	}

	// Property accessors

	public Long getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolCode() {
		return this.schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolRegion() {
		return this.schoolRegion;
	}

	public void setSchoolRegion(String schoolRegion) {
		this.schoolRegion = schoolRegion;
	}

	public String getSchoolImg() {
		return this.schoolImg;
	}

	public void setSchoolImg(String schoolImg) {
		this.schoolImg = schoolImg;
	}

}