/**
 * 
 */
package com.dale.test;

import java.io.IOException;
import java.util.Date;

import com.dale.ms.utils.ValidateCode;

/**
 * @author Dale'
 * @date 2016-7-14 上午9:57:41
 * @description 
 */
public class ValidateCodeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidateCode code = new ValidateCode(120, 40, 5, 100);
		
		String path = "D:/t/"+new Date().getTime()+".png";
		System.out.println(code.getCode() + " > " + path);
		try {
			code.write(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
