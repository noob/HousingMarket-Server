package com.dale.ms.entities;

/**
 * TSchoolMajor entity. @author MyEclipse Persistence Tools
 */

public class TSchoolMajor implements java.io.Serializable {

	// Fields

	private Long schoolMajorId;
	private String schoolCode;
	private String schoolName;
	private String schoolRegion;
	private String majorCode;
	private String majorName;
	private String cate;
	private String subject;
	private String level;
	private String isKey;
	private Integer department;
	private String tuition;
	private String score;
	private String recommend;
	private String score2016;

	// Constructors

	/** default constructor */
	public TSchoolMajor() {
	}

	/** minimal constructor */
	public TSchoolMajor(String schoolCode, String schoolName,
			String schoolRegion, String majorCode, String majorName) {
		this.schoolCode = schoolCode;
		this.schoolName = schoolName;
		this.schoolRegion = schoolRegion;
		this.majorCode = majorCode;
		this.majorName = majorName;
	}

	/** full constructor */
	public TSchoolMajor(String schoolCode, String schoolName,
			String schoolRegion, String majorCode, String majorName,
			String cate, String subject, String level, String isKey,
			Integer department, String tuition, String score, String recommend,
			String score2016) {
		this.schoolCode = schoolCode;
		this.schoolName = schoolName;
		this.schoolRegion = schoolRegion;
		this.majorCode = majorCode;
		this.majorName = majorName;
		this.cate = cate;
		this.subject = subject;
		this.level = level;
		this.isKey = isKey;
		this.department = department;
		this.tuition = tuition;
		this.score = score;
		this.recommend = recommend;
		this.score2016 = score2016;
	}

	// Property accessors

	public Long getSchoolMajorId() {
		return this.schoolMajorId;
	}

	public void setSchoolMajorId(Long schoolMajorId) {
		this.schoolMajorId = schoolMajorId;
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

	public String getCate() {
		return this.cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getIsKey() {
		return this.isKey;
	}

	public void setIsKey(String isKey) {
		this.isKey = isKey;
	}

	public Integer getDepartment() {
		return this.department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public String getTuition() {
		return this.tuition;
	}

	public void setTuition(String tuition) {
		this.tuition = tuition;
	}

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getRecommend() {
		return this.recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getScore2016() {
		return this.score2016;
	}

	public void setScore2016(String score2016) {
		this.score2016 = score2016;
	}

}