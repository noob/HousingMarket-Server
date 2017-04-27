/**
 * 
 */
package com.dale.ms.utils;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Dale'
 * @date 2016-3-8 下午12:58:27
 * @description 
 */
public class MyLogUtil {

	public final static Log log = LogFactory.getLog(MyLogUtil.class);
	public final static boolean isDebug = log.isDebugEnabled();
	public final static boolean isInfo = log.isInfoEnabled();
	public final static boolean isError = log.isErrorEnabled();
	public final static String PRINT = "[MyLog-PRINT]:";
	/**
	 * 按照类获取Log
	 * @param c
	 * @return
	 */
	public static final Log getLog(Class<?> c) {
		return LogFactory.getLog(c.getClass());
	}
	/**
	 * 获取默认的shop Log
	 * @return
	 */
	public static final Log getLog() {
		return log;
	}
	/**
	 * 直接控制台输出
	 * @param logStr
	 */
	public static void print(String logStr) {
		System.out.println(PRINT + logStr);
	}
	public static void print(String logStr, Class<?> cls) {
		System.out.println("[" + cls.getSimpleName() + "]-print " + logStr);
	}
	public static void debug(Object s) {
		if (log.isDebugEnabled())
			log.debug(s);
	}
	public static void debug(Object s,Throwable t) {
		if (log.isDebugEnabled())
			log.debug(s,t);
	}
	public static void debug(Object s, Class<?> cls) {
		if (log.isDebugEnabled()) {
			log.debug("[" + cls.getSimpleName() + "]:" + s);
		}
	}
	public static void info(Object s) {
		if (log.isInfoEnabled()) {
			log.info(s);
		}
	}
	public static void info(Object s,Throwable t) {
		if (log.isInfoEnabled()) {
			log.info(s,t);
		}
	}
	public static void info(Object s, Class<?> cls) {
		if (log.isInfoEnabled()) {
			log.info("[" + cls.getSimpleName() + "]:" + s);
		}
	}
	public static void error(Object error) {
		if (log.isErrorEnabled()) {
			log.error(error);
		}
	}
	public static void error(Object error,Throwable t) {
		if (log.isErrorEnabled()) {
			log.error(error,t);
		}
	}
	public static void error(Object s, Class<?> cls) {
		if (log.isErrorEnabled()) {
			log.error("[" + cls.getSimpleName() + "]:" + s);
		}
	}
	public static void warn(Object warn) {
		if (log.isWarnEnabled())
			log.warn(warn);
	}
	public static void warn(Object warn,Throwable t) {
		if (log.isWarnEnabled())
			log.warn(warn,t);
	}
	public static void warn(Object s, Class<?> cls) {
		if (log.isWarnEnabled()) {
			log.warn("[" + cls.getSimpleName() + "]:" + s);
		}
	}
	/**
	 * 打印Map
	 * @param map
	 */
	public static void printMap(Map<?, ?> map) {
		Iterator<?> it = map.keySet().iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Object values = map.get(key);
			if (values instanceof Object[]) {
				for (Object obj : (Object[]) values)
					log.info("pars>>>" + key.toString() + ":" + (String) obj);
			} else if (values instanceof String) {
				log.info(">>>" + key.toString() + ":" + (String) values);
			} else if (values instanceof Number) {
				log.info(">>>" + key.toString() + ":" + values);
			} else if (values instanceof Boolean) {
				log.info(">>>" + key.toString() + ":" + values);
			}
		}
	}
	public static void main(String[] args) {
		info("错误信息", MyLogUtil.class);
	}
	
}
