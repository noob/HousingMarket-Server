/**
 * 
 */
package com.dale.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dale.ms.entities.TMajor;
import com.dale.ms.entities.TMajorQuestion;
import com.dale.ms.entities.TSchool;
import com.dale.ms.entities.TSchoolMajor;
import com.dale.ms.utils.StringUtil;

/**
 * @author Dale'
 * @date 2016-5-6 下午12:20:19
 * @description
 */
public class ExcelUtil {

	public static String filePath = "C://Users/HZF/Desktop/excel.xlsx";

	public static void getFileName(String filePath) {
		File file = new File(filePath);
		System.out.println(file.getName());
	}

	// ---------------------- 2003 begin----------------------------------
	// ---------------------- 2003 begin----------------------------------
	// ---------------------- 2003 begin----------------------------------
	// ---------------------- 2003 begin----------------------------------
	// ---------------------- 2003 begin----------------------------------
	// ---------------------- 2003 begin----------------------------------
	// ---------------------- 2003 begin----------------------------------
	// ---------------------- 2003 begin----------------------------------
	// ---------------------- 2003 begin----------------------------------
	// ---------------------- 2003 begin----------------------------------
	// ---------------------- 2003 begin----------------------------------
	/**
	 * 读取EXCEL文件
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	// office 2003 以前 包括2003  .xls
	@SuppressWarnings("resource")
	public static List<?> readXls(String filePath) throws IOException {
		List<?> list = new ArrayList<>();
		TSchool school = null;
		InputStream is = new FileInputStream(filePath);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		// 循环工作表
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// 循环Row
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					school = new TSchool();
					HSSFCell schoolCode = hssfRow.getCell(0);
					HSSFCell schoolName = hssfRow.getCell(1);
					school.setSchoolCode(getValue(schoolCode));
					school.setSchoolName(getValue(schoolName));
				}
			}
		}
		return list;
	}

	@SuppressWarnings("static-access")
	private static String getValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			// 返回数值类型的值
			return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			// 返回字符串类型的值
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}
	// ---------------------- 2003 end----------------------------------
	// ---------------------- 2003 end----------------------------------
	// ---------------------- 2003 end----------------------------------
	// ---------------------- 2003 end----------------------------------
	// ---------------------- 2003 end----------------------------------
	// ---------------------- 2003 end----------------------------------
	// ---------------------- 2003 end----------------------------------
	// ---------------------- 2003 end----------------------------------
	// ---------------------- 2003 end----------------------------------

	// ---------------------- 2007 begin----------------------------------
	// ---------------------- 2007 begin----------------------------------
	// ---------------------- 2007 begin----------------------------------
	// ---------------------- 2007 begin----------------------------------
	// ---------------------- 2007 begin----------------------------------
	// ---------------------- 2007 begin----------------------------------

	/**
	 * 读取EXCEL  .xlsx 文件
	 * TSchool
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static List<TSchool> readSchoolXlsx(String filePath) throws IOException { 
		List<TSchool> list = new ArrayList<>();
		TSchool school = null;
		InputStream is = new FileInputStream(filePath);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		// 循环工作表
		for(int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if(xssfSheet == null) {
				continue;
			}
			// 循环Row
			//rowNum=1 从第2行开始读取
			for(int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if(xssfRow != null) {
					school = new TSchool();
					XSSFCell schoolCode = xssfRow.getCell(0);
					XSSFCell schoolName = xssfRow.getCell(1);
					XSSFCell schoolRegion = xssfRow.getCell(2);
					school.setSchoolCode(getValue(schoolCode));
					school.setSchoolName(getValue(schoolName));
					school.setSchoolRegion(getValue(schoolRegion));
					list.add(school);
				}
			}
		}
		return list;
	}
	
	/**
	 * 读取EXCEL  .xlsx 文件
	 * TMajor
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static List<TMajor> readMajorXlsx(String filePath) throws IOException { 
		List<TMajor> list = new ArrayList<>();
		TMajor major = null;
		InputStream is = new FileInputStream(filePath);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		// 循环工作表
		for(int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if(xssfSheet == null) {
				continue;
			}
			// 循环Row
			//rowNum=1 从第2行开始读取
			for(int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if(xssfRow != null) {
					major = new TMajor();
					XSSFCell majorCode = xssfRow.getCell(1);
					XSSFCell majorName = xssfRow.getCell(2);
					XSSFCell isSpecial = xssfRow.getCell(0);
					
					//初始化专业
					major.setMajorCode(getValue(majorCode));
					major.setMajorName(getValue(majorName));
					if(!StringUtil.isEmpty(getValue(isSpecial)) && getValue(isSpecial).equals("基本专业")) {
						major.setIsSpecial(0);
					} else {
						major.setIsSpecial(1);
					}
					list.add(major);
				}
			}
		}
		return list;
	}
	
	/**
	 * 读取EXCEL  .xlsx 文件
	 * TSchoolMajor
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static List<TSchoolMajor> readSchoolMajorXlsx(String filePath) throws IOException { 
		List<TSchoolMajor> list = new ArrayList<>();
		TSchoolMajor schoolMajor = null;
		InputStream is = new FileInputStream(filePath);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		// 循环工作表
		for(int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if(xssfSheet == null) {
				continue;
			}
			// 循环Row
			//rowNum=1 从第2行开始读取
			for(int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if(xssfRow != null) {
					schoolMajor = new TSchoolMajor();
					XSSFCell majorCode = xssfRow.getCell(0);
					XSSFCell majorName = xssfRow.getCell(1);
					XSSFCell schoolCode = xssfRow.getCell(2);
					XSSFCell schoolName = xssfRow.getCell(3);
					XSSFCell cate = xssfRow.getCell(4);
					XSSFCell level = xssfRow.getCell(5);
					XSSFCell isKey = xssfRow.getCell(6);
					XSSFCell sub1 = xssfRow.getCell(7);
					XSSFCell sub2 = xssfRow.getCell(8);
					XSSFCell sub3 = xssfRow.getCell(9);
					XSSFCell tuition = xssfRow.getCell(10);
					XSSFCell department = xssfRow.getCell(11);
					XSSFCell score = xssfRow.getCell(12);
					XSSFCell score2016 = xssfRow.getCell(13);
					XSSFCell recommend = xssfRow.getCell(14);
					XSSFCell schoolRegion = xssfRow.getCell(15);
					//初始化专业
					schoolMajor.setSchoolCode(getValue(schoolCode));
					schoolMajor.setSchoolName(getValue(schoolName));
					schoolMajor.setMajorCode(getValue(majorCode));
					schoolMajor.setMajorName(getValue(majorName));
					schoolMajor.setCate(getValue(cate));
					schoolMajor.setLevel(getValue(level));
					schoolMajor.setIsKey(getValue(isKey));
					//初始化 科目
					String subject = "";
					if(!StringUtil.isEmpty(getValue(sub1))) {
						subject += getValue(sub1) + "，";
					}
					if(!StringUtil.isEmpty(getValue(sub2))) {
						subject += getValue(sub2) + "，";
					}
					if(!StringUtil.isEmpty(getValue(sub3))) {
						subject += getValue(sub3) + "，";
					}
					if(!StringUtil.isEmpty(subject)) {
						subject = subject.substring(0, subject.length()-1);
						schoolMajor.setSubject(subject);
					}
					if(level != null) {
						schoolMajor.setLevel(getValue(level));
					}
					 //判断文理
					String dep = getValue(department);
					if(!StringUtil.isEmpty(dep)) {
						if(dep.equals("文科") || dep.equals("文")) {
							schoolMajor.setDepartment(1);
						} else if(dep.equals("理科") || dep.equals("理")) {
							schoolMajor.setDepartment(2);
						} else {
							schoolMajor.setDepartment(0);
						}
					} else {
						schoolMajor.setDepartment(0);
					}
					
					if(!StringUtil.isEmpty(getValue(tuition))) {
						schoolMajor.setTuition(getValue(tuition));
					}
					String s = getValue(score);
					if(!StringUtil.isEmpty(s)) {
						schoolMajor.setScore(s);
					}
					String s2016 = getValue(score2016);
					if(!StringUtil.isEmpty(s)) {
						schoolMajor.setScore2016(s2016);
					}
					if(!StringUtil.isEmpty(getValue(recommend))) {
						schoolMajor.setRecommend(getValue(recommend));
					}
					schoolMajor.setSchoolRegion(getValue(schoolRegion));
					list.add(schoolMajor);
				}
			}
		}
		return list;
	}
	
	/**
	 * @param path
	 * @return
	 */
	@SuppressWarnings("resource")
	public static List<TMajorQuestion> readMajorQuestionXlsx(String path) throws IOException {
		List<TMajorQuestion> list = new ArrayList<>();
		TMajorQuestion majorQuestion = null;
		InputStream is = new FileInputStream(path);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		// 循环工作表
		for(int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if(xssfSheet == null) {
				continue;
			}
			// 循环Row
			//rowNum=1 从第2行开始读取
			for(int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if(xssfRow != null) {
					majorQuestion = new TMajorQuestion();
					XSSFCell majorCode = xssfRow.getCell(0);
					XSSFCell majorName = xssfRow.getCell(1);
					XSSFCell weight1 = xssfRow.getCell(2);
					XSSFCell weight2 = xssfRow.getCell(3);
					XSSFCell weight3 = xssfRow.getCell(4);
					XSSFCell weight4 = xssfRow.getCell(5);
					XSSFCell weight5 = xssfRow.getCell(6);
					XSSFCell weight6 = xssfRow.getCell(7);
					XSSFCell weight7 = xssfRow.getCell(8);
					XSSFCell weight8 = xssfRow.getCell(9);
					XSSFCell weight9 = xssfRow.getCell(10);
					XSSFCell weight10 = xssfRow.getCell(11);
					XSSFCell weight11 = xssfRow.getCell(12);
					XSSFCell weight12 = xssfRow.getCell(13);
					XSSFCell weight13 = xssfRow.getCell(14);
					XSSFCell weight14 = xssfRow.getCell(15);
					XSSFCell weight15 = xssfRow.getCell(16);
					XSSFCell weight16 = xssfRow.getCell(17);
					XSSFCell weight17 = xssfRow.getCell(18);
					XSSFCell weight18 = xssfRow.getCell(19);
					XSSFCell weight19 = xssfRow.getCell(20);
					XSSFCell weight20 = xssfRow.getCell(21);
					XSSFCell weight21 = xssfRow.getCell(22);
					XSSFCell weight22 = xssfRow.getCell(23);
					XSSFCell weight23 = xssfRow.getCell(24);
					XSSFCell weight24 = xssfRow.getCell(25);
					XSSFCell weight25 = xssfRow.getCell(26);
					XSSFCell weight26 = xssfRow.getCell(27);
					XSSFCell weight27 = xssfRow.getCell(28);
					XSSFCell weight28 = xssfRow.getCell(29);
					XSSFCell weight29 = xssfRow.getCell(30);
					XSSFCell weight30 = xssfRow.getCell(31);
					XSSFCell weight31 = xssfRow.getCell(32);
					XSSFCell weight32 = xssfRow.getCell(33);
					XSSFCell weight33 = xssfRow.getCell(34);
					XSSFCell weight34 = xssfRow.getCell(35);
					XSSFCell weight35 = xssfRow.getCell(36);
					XSSFCell weight36 = xssfRow.getCell(37);
					XSSFCell weight37 = xssfRow.getCell(38);
					XSSFCell weight38 = xssfRow.getCell(39);
					XSSFCell weight39 = xssfRow.getCell(40);
					XSSFCell weight40 = xssfRow.getCell(41);
					
					//初始化专业
					majorQuestion.setMajorCode(getValue(majorCode));
					majorQuestion.setMajorName(getValue(majorName));
					majorQuestion.setWeight1(Double.parseDouble(getWeightValue(weight1)));
					majorQuestion.setWeight2(Double.parseDouble(getWeightValue(weight2)));
					majorQuestion.setWeight3(Double.parseDouble(getWeightValue(weight3)));
					majorQuestion.setWeight4(Double.parseDouble(getWeightValue(weight4)));
					majorQuestion.setWeight5(Double.parseDouble(getWeightValue(weight5)));
					majorQuestion.setWeight6(Double.parseDouble(getWeightValue(weight6)));
					majorQuestion.setWeight7(Double.parseDouble(getWeightValue(weight7)));
					majorQuestion.setWeight8(Double.parseDouble(getWeightValue(weight8)));
					majorQuestion.setWeight9(Double.parseDouble(getWeightValue(weight9)));
					majorQuestion.setWeight10(Double.parseDouble(getWeightValue(weight10)));
					majorQuestion.setWeight11(Double.parseDouble(getWeightValue(weight11)));
					majorQuestion.setWeight12(Double.parseDouble(getWeightValue(weight12)));
					majorQuestion.setWeight13(Double.parseDouble(getWeightValue(weight13)));
					majorQuestion.setWeight14(Double.parseDouble(getWeightValue(weight14)));
					majorQuestion.setWeight15(Double.parseDouble(getWeightValue(weight15)));
					majorQuestion.setWeight16(Double.parseDouble(getWeightValue(weight16)));
					majorQuestion.setWeight17(Double.parseDouble(getWeightValue(weight17)));
					majorQuestion.setWeight18(Double.parseDouble(getWeightValue(weight18)));
					majorQuestion.setWeight19(Double.parseDouble(getWeightValue(weight19)));
					majorQuestion.setWeight20(Double.parseDouble(getWeightValue(weight20)));
					majorQuestion.setWeight21(Double.parseDouble(getWeightValue(weight21)));
					majorQuestion.setWeight22(Double.parseDouble(getWeightValue(weight22)));
					majorQuestion.setWeight23(Double.parseDouble(getWeightValue(weight23)));
					majorQuestion.setWeight24(Double.parseDouble(getWeightValue(weight24)));
					majorQuestion.setWeight25(Double.parseDouble(getWeightValue(weight25)));
					majorQuestion.setWeight26(Double.parseDouble(getWeightValue(weight26)));
					majorQuestion.setWeight27(Double.parseDouble(getWeightValue(weight27)));
					majorQuestion.setWeight28(Double.parseDouble(getWeightValue(weight28)));
					majorQuestion.setWeight29(Double.parseDouble(getWeightValue(weight29)));
					majorQuestion.setWeight30(Double.parseDouble(getWeightValue(weight30)));
					majorQuestion.setWeight31(Double.parseDouble(getWeightValue(weight31)));
					majorQuestion.setWeight32(Double.parseDouble(getWeightValue(weight32)));
					majorQuestion.setWeight33(Double.parseDouble(getWeightValue(weight33)));
					majorQuestion.setWeight34(Double.parseDouble(getWeightValue(weight34)));
					majorQuestion.setWeight35(Double.parseDouble(getWeightValue(weight35)));
					majorQuestion.setWeight36(Double.parseDouble(getWeightValue(weight36)));
					majorQuestion.setWeight37(Double.parseDouble(getWeightValue(weight37)));
					majorQuestion.setWeight38(Double.parseDouble(getWeightValue(weight38)));
					majorQuestion.setWeight39(Double.parseDouble(getWeightValue(weight39)));
					majorQuestion.setWeight40(Double.parseDouble(getWeightValue(weight40)));
					list.add(majorQuestion);
				}
			}
		}
		return list;
	}
	
	@SuppressWarnings("static-access")
	private static String getValue(XSSFCell xssfCell) {
		if(xssfCell == null) {
			return null;
		}
		if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(xssfCell.getBooleanCellValue());
		} else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC) {
			// 返回数值类型的值
			String str = String.valueOf(xssfCell.getNumericCellValue());
			return str.substring(0, str.lastIndexOf("."));
		} else {
			// 返回字符串类型的值
			return String.valueOf(xssfCell.getStringCellValue());
		}
	}

	/**
	 * 实例数字 0.25
	 * @param xssfCell
	 * @return
	 */
	@SuppressWarnings("static-access")
	private static String getWeightValue(XSSFCell xssfCell) {
		if(xssfCell == null) {
			System.out.println("-------------------");
			return "0";
		}
		if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(xssfCell.getBooleanCellValue());
		} else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC) {
			// 返回数值类型的值
			return String.valueOf(xssfCell.getNumericCellValue());
		} else {
			// 返回字符串类型的值
			return String.valueOf(xssfCell.getStringCellValue());
		}
	}
	
	// ---------------------- 2007 end----------------------------------
	// ---------------------- 2007 end----------------------------------
	// ---------------------- 2007 end----------------------------------
	// ---------------------- 2007 end----------------------------------
	// ---------------------- 2007 end----------------------------------
	// ---------------------- 2007 end----------------------------------
	// ---------------------- 2007 end----------------------------------

	
}
