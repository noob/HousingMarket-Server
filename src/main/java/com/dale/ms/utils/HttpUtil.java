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
	public static Map<String, ?> ParseDataToMap(HttpServletRequest request) {
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
			response.setHeader("Content-type", "text/xml; charset=UTF-8");
			OutputStream outputStream = response.getOutputStream();
//			PrintWriter printWriter = new PrintWriter(outputStream);
//			printWriter.print(msg);
//			printWriter.flush();
			outputStream.write(msg.getBytes("UTF-8"));
			outputStream.close();
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
			response.setHeader("Content-type", "text/xml; charset=UTF-8");
			OutputStream outputStream = response.getOutputStream();
			System.out.println("-----------" + outputStream + "-------------");
			PrintWriter printWriter = new PrintWriter(outputStream);
			printWriter.print(msg);
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
