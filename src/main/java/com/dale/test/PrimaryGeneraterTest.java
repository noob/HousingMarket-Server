/**
 * 
 */
package com.dale.test;

import com.dale.ms.utils.PrimaryGenerater;

/**
 * @author Dale'
 * @date 2016-12-9 下午3:10:40
 * @description
 */
public class PrimaryGeneraterTest {
	public static void main(String[] args) {
		
		System.out.println(PrimaryGenerater.getInstance().generaterNextNumber("000000005678"));
	}
}
