package com.dale.ms.entities;

/**
 * TQuestion entity. @author MyEclipse Persistence Tools
 */

public class TQuestion implements java.io.Serializable {

	// Fields

	private Integer questionId;
	private String question;

	// Constructors

	/** default constructor */
	public TQuestion() {
	}

	/** full constructor */
	public TQuestion(String question) {
		this.question = question;
	}

	// Property accessors

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}