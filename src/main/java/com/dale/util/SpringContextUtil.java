/**
 * 
 */
package com.dale.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * SPRING 辅助文件
 * @author Dale'
 * @date 2016-5-9 下午7:17:27
 * @description 
 */
public class SpringContextUtil implements ApplicationContextAware{

	// Spring应用上下文环境
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	/**
	 * 根据名字获得BEAN
	 * @param name
	 * @return
	 * @throws BeansException
	 */
	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}
	
}
