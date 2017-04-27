package com.dale.ms.model;

import java.sql.Timestamp;

/**
 * TLessonDataCount entity. @author MyEclipse Persistence Tools
 */

public class TLessonDataCount implements java.io.Serializable {

	// Fields

	private Long lessonDataCountId;
	private Long lessonId;
	private String lessonTitle;
	private Timestamp lessonBeginDate;
	private String teacherIntroduce;
	private String numberOfPeople;
	private String moneyAmount;

	// Constructors

	/** default constructor */
	public TLessonDataCount() {
	}

	/** full constructor */
	public TLessonDataCount(Long lessonId, String lessonTitle,
			Timestamp lessonBeginDate, String teacherIntroduce,
			String numberOfPeople, String moneyAmount) {
		this.lessonId = lessonId;
		this.lessonTitle = lessonTitle;
		this.lessonBeginDate = lessonBeginDate;
		this.teacherIntroduce = teacherIntroduce;
		this.numberOfPeople = numberOfPeople;
		this.moneyAmount = moneyAmount;
	}

	// Property accessors

	public Long getLessonDataCountId() {
		return this.lessonDataCountId;
	}

	public void setLessonDataCountId(Long lessonDataCountId) {
		this.lessonDataCountId = lessonDataCountId;
	}

	public Long getLessonId() {
		return this.lessonId;
	}

	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
	}

	public String getLessonTitle() {
		return this.lessonTitle;
	}

	public void setLessonTitle(String lessonTitle) {
		this.lessonTitle = lessonTitle;
	}

	public Timestamp getLessonBeginDate() {
		return this.lessonBeginDate;
	}

	public void setLessonBeginDate(Timestamp lessonBeginDate) {
		this.lessonBeginDate = lessonBeginDate;
	}

	public String getTeacherIntroduce() {
		return this.teacherIntroduce;
	}

	public void setTeacherIntroduce(String teacherIntroduce) {
		this.teacherIntroduce = teacherIntroduce;
	}

	public String getNumberOfPeople() {
		return this.numberOfPeople;
	}

	public void setNumberOfPeople(String numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public String getMoneyAmount() {
		return this.moneyAmount;
	}

	public void setMoneyAmount(String moneyAmount) {
		this.moneyAmount = moneyAmount;
	}

}