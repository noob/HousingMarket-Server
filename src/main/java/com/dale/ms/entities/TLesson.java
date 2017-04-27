package com.dale.ms.entities;

import java.sql.Timestamp;

/**
 * TLesson entity. @author MyEclipse Persistence Tools
 */

public class TLesson implements java.io.Serializable {

	// Fields

	private Long lessonId;
	private String lessonTitle;
	private String lessonMsg;
	private String teacherIntroduce;
	private Timestamp lessonBeginDate;
	private String place;
	private String duration;
	private String price;
	private String discountPrice;
	private Timestamp lessonDiscountEndDate;
	private String lessonCondition;
	private String lessonItem;

	// Constructors

	/** default constructor */
	public TLesson() {
	}

	/** minimal constructor */
	public TLesson(String lessonTitle, String teacherIntroduce,
			Timestamp lessonBeginDate, String place, String price,
			String discountPrice, Timestamp lessonDiscountEndDate) {
		this.lessonTitle = lessonTitle;
		this.teacherIntroduce = teacherIntroduce;
		this.lessonBeginDate = lessonBeginDate;
		this.place = place;
		this.price = price;
		this.discountPrice = discountPrice;
		this.lessonDiscountEndDate = lessonDiscountEndDate;
	}

	/** full constructor */
	public TLesson(String lessonTitle, String lessonMsg,
			String teacherIntroduce, Timestamp lessonBeginDate, String place,
			String duration, String price, String discountPrice,
			Timestamp lessonDiscountEndDate, String lessonCondition,
			String lessonItem) {
		this.lessonTitle = lessonTitle;
		this.lessonMsg = lessonMsg;
		this.teacherIntroduce = teacherIntroduce;
		this.lessonBeginDate = lessonBeginDate;
		this.place = place;
		this.duration = duration;
		this.price = price;
		this.discountPrice = discountPrice;
		this.lessonDiscountEndDate = lessonDiscountEndDate;
		this.lessonCondition = lessonCondition;
		this.lessonItem = lessonItem;
	}

	// Property accessors

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

	public String getLessonMsg() {
		return this.lessonMsg;
	}

	public void setLessonMsg(String lessonMsg) {
		this.lessonMsg = lessonMsg;
	}

	public String getTeacherIntroduce() {
		return this.teacherIntroduce;
	}

	public void setTeacherIntroduce(String teacherIntroduce) {
		this.teacherIntroduce = teacherIntroduce;
	}

	public Timestamp getLessonBeginDate() {
		return this.lessonBeginDate;
	}

	public void setLessonBeginDate(Timestamp lessonBeginDate) {
		this.lessonBeginDate = lessonBeginDate;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDiscountPrice() {
		return this.discountPrice;
	}

	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Timestamp getLessonDiscountEndDate() {
		return this.lessonDiscountEndDate;
	}

	public void setLessonDiscountEndDate(Timestamp lessonDiscountEndDate) {
		this.lessonDiscountEndDate = lessonDiscountEndDate;
	}

	public String getLessonCondition() {
		return this.lessonCondition;
	}

	public void setLessonCondition(String lessonCondition) {
		this.lessonCondition = lessonCondition;
	}

	public String getLessonItem() {
		return this.lessonItem;
	}

	public void setLessonItem(String lessonItem) {
		this.lessonItem = lessonItem;
	}

}