package com.sms;

import java.util.Random;

/**
 * 6位随机数
 * 
 * @author Dale'
 * @date 2016-6-17 上午11:40:22
 * @description
 */
public class ZeroToNineRandom {

	public static String initCode() {
		Random random = new Random();
		String str = "";
		for (int i = 0; i < 6; i++) {
			str += random.nextInt(10) + "";
		}
		System.out.println("手机验证码 = " + str);
		return str;
	}

}
