/**
 * 
 */
package com.dale.ms.utils;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Dale'
 * @date 2016-3-9 下午4:07:29
 * @description 
 */
public class GsonUtil {

	Gson gson = new Gson();
	
	/**
	 *   Map to Gson
	 * @param map
	 * @return string
	 */
	public String map2Gson(Map<String, Object> map) {
		String result = gson.toJson(map, Map.class);
		return result;
	}
	
	/**
	 * List to Gson
	 * @param list
	 * @return
	 */
	public String list2Gson(List<Object> list) {
		String result = gson.toJson(list, List.class);
		return result;
	}
	
	/**
	 * Gson to List
	 * @param str
	 * @return
	 */
	public List<Object> gson2List(String str) {
		List<Object> list = gson.fromJson(str, new TypeToken<List<Object>>(){}.getType());
		return list;
	}
	
	/**
	 * Gson to Map
	 * @param str
	 * @return
	 */
	public Map<String, Object> gson2Map(String str) {
		Map<String, Object> map = gson.fromJson(str, new TypeToken<Map<String, Object>>(){}.getType());
		return map;
	}
	
	
}
