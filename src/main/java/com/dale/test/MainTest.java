/**
 * 
 */
package com.dale.test;

import java.io.IOException;
import java.util.List;

import com.dale.ms.entities.TSchool;

/**
 * 
 * @author Dale'
 * @date 2016-3-28 下午7:35:32
 * @description 
 */
public class MainTest {

	public static String filePath ="C://Users/HZF/Desktop/excel.xlsx";
	
	public static void main(String[] args) {
		try {
			List<TSchool> list = ExcelUtil.readSchoolXlsx(filePath);
			for(int i=0; i<list.size(); i++) {
				System.out.println("code=" + list.get(i).getSchoolCode() + ", name=" + list.get(i).getSchoolName() + ", region=" + list.get(i).getSchoolRegion());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
