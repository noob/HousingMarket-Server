/**
 * 
 */
package com.dale.ms.model;

/**
 * @author Dale'
 * @date 2016-11-29 下午3:12:23
 * @description 
 */
public class MoneyAmount implements java.io.Serializable {

	private long lessonId;
	private String moneyAmount;
	
	public MoneyAmount() {
		
	}
	
	public long getLessonId() {
		return lessonId;
	}

	public void setLessonId(long lessonId) {
		this.lessonId = lessonId;
	}

	public String getMoneyAmount() {
		return moneyAmount;
	}
	
	public void setMoneyAmount(String moneyAmount) {
		this.moneyAmount = moneyAmount;
	}
	
	
	
}
