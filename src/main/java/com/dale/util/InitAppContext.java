package com.dale.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author Dale'
 * @date 2016-5-10 下午3:24:39
 * @description 
 */
public class InitAppContext extends HttpServlet{
 
	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy();
	}
	
	public void init() throws ServletException {
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		SpringContextUtil springContextUtil = new SpringContextUtil();
		springContextUtil.setApplicationContext(applicationContext);
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------");
	}
	
}
