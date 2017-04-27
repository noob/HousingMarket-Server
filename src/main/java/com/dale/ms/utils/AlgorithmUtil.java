/**
 * 
 */
package com.dale.ms.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Dale'
 * @date 2016-3-8 下午12:56:20
 * @description 
 */
public class AlgorithmUtil {

	public final static String ENCODING = "UTF-8";
	
	/**
	 * md5加密算法
	 * 
	 * @param plainText
	 *            需要加密的字符串
	 * @return md5 加密后的字符串
	 */
	public static String Md5(String plainText) {
		StringBuffer buf = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
		} catch (NoSuchAlgorithmException e) {
			MyLogUtil.error("MD5 算法包未找到异常");
			e.printStackTrace();
		}
		return buf.toString();
	}
	
	
}
