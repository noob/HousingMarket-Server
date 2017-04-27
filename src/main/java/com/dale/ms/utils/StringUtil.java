package com.dale.ms.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;


/**
 * 
 * @author Dale'
 * @date 2015-8-13 下午11:56:12
 * @description 字符串工具类
 */
public class StringUtil {
	private static DateFormat dateFormat;
	/**
	 * 得到今日的日期
	 * @param format	日期格式
	 * @return
	 */
	public static String getDate(String format){
		dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(new Date());
	}
	
	/**
	 * 得到当前的月份有几天
	 * @return
	 */
	public static int getDaysOfMonth(){
		Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
		int day=aCalendar.getActualMaximum(Calendar.DATE);
		return day;
	}
	
	/**
	 * 返回 yyyy-MM-dd HH:mm:ss 格式的timeStamp
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String getTimeStamp(Timestamp date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);//时间存储为字符串
	}
	
	/**
	 * 返回 yyyMMdd 格式的timeStamp
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String getTimeStamp_yyyyMMdd(Timestamp date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);//时间存储为字符串
	}
	
	/**
	 * 得到明天的日期
	 * @param format	日期格式
	 * @return
	 * @throws ParseException
	 */
	public static String getNextDay(String format) throws ParseException{
		 dateFormat = new SimpleDateFormat(format);
		 Calendar cal = Calendar.getInstance();  
         cal.setTime(dateFormat.parse(getDate(format)));  
         cal.add(Calendar.DAY_OF_YEAR, +1);  
         return dateFormat.format(cal.getTime());  
	}
	/**
	 * 根据指定格式和日期，返回指定日期和格式的  时间字符串
	 * @param format	日期格式
	 * @param date		自定义时间
	 * @return
	 */
	public static String getDate(String format,Date date){
		dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	/**
	 * 得到当前月的最后一天或第一天
	 * @param format	日期格式
	 * @param day		1：第一天，-1：最后一天
	 * @return
	 */
	public static String getDayOfThisMonth(String format,int day){
		dateFormat = new SimpleDateFormat(format);
		Calendar   cal = Calendar.getInstance();	//获取当前日期 
		if(day == -1){
			cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));  // 得到当前月最后一天
		}else{
			cal.add(Calendar.MONTH, 0);
			cal.set(Calendar.DAY_OF_MONTH,day);	//设置为1号,当前日期既为本月第一天 
		}
        return dateFormat.format(cal.getTime());
	}
	/**
	 * 得到这个月的第一天
	 * @param term   格式： 2014-09-01
	 * @return	例如: 2014-09-01 00:00:00 的 long 类型数字字符串
	 */
	public static Date getFirstDayOfMonth(){
		DateFormat dd=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = dd.parse(getDayOfThisMonth("yyyy-MM-dd",1));
//			date = dd.parse("2014-08-01");
		} catch (ParseException e) {
			e.printStackTrace();
//			MyLog.error("日期格式转换错误！");
		}
		return date;
	}
	/**
	 * 得到上一个月的第一天
	 */
	public static String getFirstDayOfLastMonth(){
		 Calendar c = Calendar.getInstance();
	     c.add(Calendar.MONTH, -1);
	     c.set(Calendar.DAY_OF_MONTH,1);
	     return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}
	 
	/**
	 * 判断字符串是否为空
	 * @return true 为空，false 为不空
	 */
	public static boolean isEmpty(String str){
		if(str == null || str.trim().length() <= 0 ||  "".equals(str)){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 获取年月
	 * @param timestamp
	 * @return
	 */
	public static String getImageDate(Timestamp timestamp){
		Timestamp time = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String dateString = format.format(time);
		return dateString;
	}
	/**
	 * 获取年月日
	 * @param timestamp
	 * @return
	 */
	public static String getInsureDate(Timestamp timestamp){
		Timestamp time = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = format.format(time);
		return dateString;
	}
	
	/**
	 * 得到某年某月的第一天或者最后一天
	 * @param format 格式
	 * @param year	  年份
	 * @param month 月份
	 * @param flag 	  1 第一天，-1最后一天
	 * @return
	 */
	public static String getDayOfThisYear(String format,int year, int month,int flag) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
	 	Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);  				 // 设置年份
        cal.set(Calendar.MONTH, month-1);  // 设置月份
        String date = null;
        if(flag == 1){
        	//设置日历中月份的最小天数
        	int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        	cal.set(Calendar.DAY_OF_MONTH, firstDay);
        	date = sdf.format(cal.getTime());
        }else{
            int lastDay = cal.getActualMaximum(Calendar.DATE);
            cal.set(Calendar.DAY_OF_MONTH, lastDay);
            date = sdf.format(cal.getTime());
        }
        return date;
	}
	/**
	 * 从指定的时间字符串列表取最大的时间字符串
	 * @param time
	 * @return
	 * @throws ParseException 
	 */
	public static String getNewestTime(List<String> times) throws ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Calendar cMax = Calendar.getInstance();
		cMax.setTime(df.parse(times.get(0)));		// 设置初始值
		int index = 0;
		for(int i = 0; i < times.size(); i++){
			Calendar cal= Calendar.getInstance();	// 设置要比较的值
			try{
				cal.setTime(df.parse(times.get(i)));
			}catch(java.text.ParseException e){
				System.err.println("格式不正确");
			}
			int result=cMax.compareTo(cal);
			if(result < 0){									// 如果cMax 小于 cal,则将cal赋值给cMax
				cMax = cal;
				index = i;
			}											
		}
		return times.get(index);
	}
	/**
	 * 将字符串格式的时间 转换成timestamp形式
	 * @param date 格式为：yyyy-MM-dd HH:mm:ss
	 * @return  timestamp
	 * @throws ParseException 
	 */
	public static long getTime(String time) throws ParseException{
		Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = (Date) f.parseObject(time);
        return d.getTime();
	}
	/**
	 * 得到校验key
	 * @param method 方法名
	 * @return
	 */
//	public static String getKey(String method) {
//		return AlgorithmUtil.Md5(method+getDate("yyyyMMdd"));
//	}
	
	/**
	 * 将字符串的某几个位置替换成*
	 * 如将15757831852替换成157****1852
	 * @param res
	 * @return
	 */
	public static String replaceIndex(int start,int end,String res){
		String str =  "";
		for(int i = 0;i<=Math.abs(end-start)-1;i++){
			str = str+"*";
		}
		return res.substring(0,start)+str+res.substring(end,res.length());
	}
	
	public static void main(String[] args) {
		String idcard = replaceIndex(3,7,"15757831852");
		String idcard1 = replaceIndex(6,14,"330621199404235933");
		System.out.println(idcard1);
		System.out.println(idcard);
	}

	public static Timestamp getTime() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 根据指定的日期，得到下一日的日期
	 * @param format	日期格式
	 * @return  例如：2015-11-17
	 * @throws ParseException
	 */
	public static String getNextDayStr(String format, String time) throws ParseException{
		dateFormat = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();  
		cal.setTime(dateFormat.parse(time));  
		cal.add(Calendar.DAY_OF_YEAR, 1);  
		return dateFormat.format(cal.getTime());  
	}

	public static String getRandom() {
		Random rad=new Random();
		return rad.nextInt(1000000000)+"";
	}
}