/**
 * 
 */
package com.dale.ms.utils;

/**
 * @author Dale'
 * @date 2016-12-9 下午3:08:18
 * @description 
 * 
 * 流水号格式为yyyyMMddXXXX，规定每天只能到9999
 * 
 * 流水账号作为数据表主键时可用
 */
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrimaryGenerater {

	private static final String SERIAL_NUMBER = "XXXX"; // 流水号格式
	private static PrimaryGenerater primaryGenerater = null;
	private static String currentNumber = null;

	private PrimaryGenerater() {
	}

	/**
	 * 取得PrimaryGenerater的单例实现
	 * 
	 * @return
	 */
	public static PrimaryGenerater getInstance() {
		if (primaryGenerater == null) {
			synchronized (PrimaryGenerater.class) {
				if (primaryGenerater == null) {
					primaryGenerater = new PrimaryGenerater();
					System.out.println("currentNumber = " + currentNumber);
				}
			}
		}
		return primaryGenerater;
	}

	/**
	 * 生成下一个编号
	 */
	public synchronized String generaterNextNumber() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		if (currentNumber == null) {
			currentNumber = formatter.format(date) + "0001";
		} else {
			int count = SERIAL_NUMBER.length();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < count; i++) {
				sb.append("0");
			}
			DecimalFormat df = new DecimalFormat("0000");
			currentNumber = formatter.format(date) + df.format(1 + Integer.parseInt(currentNumber.substring(8, 12)));
		}
		return currentNumber;
	}
	
}
