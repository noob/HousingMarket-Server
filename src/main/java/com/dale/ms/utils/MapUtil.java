/**
 * 
 */
package com.dale.ms.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Dale'
 * @date 2016-4-20 上午11:21:44
 * @description map工具类
 */
public class MapUtil {

	public static void main(String[] args) {

		Map<String, Double> map = new LinkedHashMap<>();
//		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("a", 0.345);
		map.put("b", 5.329);
		map.put("c", 68.4);
		map.put("d", 100.5);
		map.put("e", 97.3);
//		map.put("a", 1);
//		map.put("b", 2);
//		map.put("c", 5);
//		map.put("d", 3);
//		map.put("e", 4);
		printMap(map);
		printMap(sortMapDouble(map));
	}

	// 输出map的 键-值
	@SuppressWarnings("rawtypes")
	public static void printMap(Map map) {
		System.out.println("===================mapStart==================");
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println("===================mapEnd==================");
	}

	// map<String, Integer> 根据 value 排序 从小到大
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map sortMapInteger(Map oldMap) {
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(oldMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<java.lang.String, Integer> arg0, Entry<java.lang.String, Integer> arg1) {
				return arg0.getValue() - arg1.getValue();
			}
		});
		Map newMap = new LinkedHashMap();
		for (int i = 0; i < list.size(); i++) {
			newMap.put(list.get(i).getKey(), list.get(i).getValue());
		}
		return newMap;
	}
	
	// map<String, Double> 根据 value 排序 从大到小
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map sortMapDouble(Map oldMap) {
		ArrayList<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(oldMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			@Override
			public int compare(Entry<java.lang.String, Double> arg0, Entry<java.lang.String, Double> arg1) {
				if(arg0.getValue() - arg1.getValue() > 0) {
					return -1;
				} else if(arg0.getValue() - arg1.getValue() == 0) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		Map newMap = new LinkedHashMap();
		for (int i = 0; i < list.size(); i++) {
			newMap.put(list.get(i).getKey(), list.get(i).getValue());
		}
		return newMap;
	}

	// HashMap 按照 value排序   未检测
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(
			Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(
				map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

}
