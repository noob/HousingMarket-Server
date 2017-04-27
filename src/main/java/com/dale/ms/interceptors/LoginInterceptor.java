/**
 * 
 */
package com.dale.ms.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dale.ms.utils.GlobalUtil;

/**
 * @author Dale'
 * @date 2016-3-11 上午10:57:19
 * @description 
 */
public class LoginInterceptor implements HandlerInterceptor{

	private String LoginPage = "/HousingMarket/";
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		Object user_login_status = request.getSession().getAttribute(GlobalUtil.USER_SESSION_KEY);
		Object admin_login_status = request.getSession().getAttribute(GlobalUtil.ADMIN_SESSION_KEY);
		if(user_login_status != null || admin_login_status != null) {
			return true;
		} else {
			response.sendRedirect(LoginPage);
			return false;
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

}
