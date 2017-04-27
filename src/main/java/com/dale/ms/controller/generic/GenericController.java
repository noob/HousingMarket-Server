package com.dale.ms.controller.generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.dale.ms.model.ADMIN_SESSION_KEY;
import com.dale.ms.model.Pagenation;
import com.dale.ms.utils.GlobalUtil;
import com.dale.ms.utils.ThreadPoolUtil;
import com.google.gson.Gson;

/**
 * 
 * @author Dale'
 * @date 2016-3-1 下午7:18:25
 * @description
 */
public class GenericController {

	protected  HttpServletRequest request;
	protected  HttpServletResponse response;
	
	public Pagenation pagenation = new Pagenation();
	
	@ModelAttribute  
	public void createThreadPool() {
		ThreadPoolUtil.init();
	}
	
	@ModelAttribute  
    public void setRequestAndReseponse(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;  
        this.response = response;  
    } 
	
	@ModelAttribute
	private void init() {
		if(pagenation == null) {
			pagenation = new Pagenation();
		} else {
			setPagenation(pagenation);
		}
	}
	
	public Pagenation getPagenation() {
		return pagenation;
	}

	public void setPagenation(Pagenation pagenation) {
		this.pagenation = pagenation;
	}
	
	/**
	 * 清除session缓存
	 * @param session
	 */
	public static void clearSession(HttpSession session) {
		session.invalidate();
	}
	
}
