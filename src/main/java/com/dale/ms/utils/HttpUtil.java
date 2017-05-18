package com.dale.ms.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * @author Dale'
 * @date 2016-3-2 下午12:12:57
 * @description
 */
public class HttpUtil {

	private static Gson gson;
	
	/**
	 * request数据解析类
	 * 将gson转换为map<String, ？>
	 */
	public static Map<String, String> ParseDataToMap(HttpServletRequest request) {
		BufferedReader bufferedReader;
		gson = new Gson();
		Map<String, String> map = null;
		String data = null;
		try {
			bufferedReader = request.getReader();
			data = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(data);
		map = gson.fromJson(data, new TypeToken<Map<String, ?>>(){}.getType());
		return map;
	}
	
	/**
	 * 回复msg
	 */
	public static void responseOutMsg(HttpServletResponse response, String msg) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Content-type", "text/html; charset=UTF-8");
			OutputStream outputStream = response.getOutputStream();
//			PrintWriter printWriter = new PrintWriter(outputStream);
//			printWriter.print(msg);
//			printWriter.flush();
			outputStream.write(msg.getBytes("UTF-8"));
//			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 回复msg
	 */
	public static void responsePrintMsg(HttpServletResponse response, String msg) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Cache-Control", "no-cache");
//			response.setHeader("Content-type", "application/json; charset=UTF-8");
			response.setHeader("Content-type", "text/html; charset=UTF-8");
//			//"*"存在风险，建议指定可信任的域名来接收响应信息，如"http://www.sosoapi.com"
//			response.addHeader("Access-Control-Allow-Origin", "*");
//			//如果存在自定义的header参数，需要在此处添加，逗号分隔
//			response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, "
//					+ "If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, "
//					+ "Content-Type, X-E4M-With");
//			response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");  
			OutputStream outputStream = response.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream);
			printWriter.println(msg);
//			if(printWriter != null) {
//				System.out.println("printWriter is not null!!");
//			}
//			System.out.println("11111111111111111");
<<<<<<< HEAD
			printWriter.flush();
//			System.out.println("2222222222222222");
			printWriter.close();
=======
<<<<<<< HEAD
			printWriter.flush();
//			System.out.println("2222222222222222");
			printWriter.close();
=======
<<<<<<< HEAD
			printWriter.flush();
//			System.out.println("2222222222222222");
			printWriter.close();
=======
<<<<<<< HEAD
			printWriter.flush();
//			System.out.println("2222222222222222");
			printWriter.close();
=======
//			printWriter.flush();
//			System.out.println("2222222222222222");
//			printWriter.close();
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
>>>>>>> 141436243474dfee36a70341663322d157819f89
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
