/**
 * 
 */
package com.dale.test;

/**
 * @author Dale'
 * @date 2016-12-10 下午4:20:30
 * @description 
 */
public class PleaseTestEverythingHere {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String body = "userId={99} 开课时间：2017-03-02 00:00:00.0 开课地点：宁波大红鹰学院701";
		String userId = body.substring(body.indexOf("{")+1, body.indexOf("}"));
		System.out.println(userId);
	}

}
