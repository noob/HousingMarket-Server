package com.dale.ms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dale.ms.controller.generic.GenericController;
import com.dale.ms.entities.AdminUser;
import com.dale.ms.entities.TSchool;
import com.dale.ms.entities.TSchoolMajor;
import com.dale.ms.entities.TUser;
import com.dale.ms.model.ADMIN_SESSION_KEY;
import com.dale.ms.model.USER_SESSION_KEY;
import com.dale.ms.service.AdminUserService;
import com.dale.ms.service.MajorService;
import com.dale.ms.service.SchoolService;
import com.dale.ms.service.UserService;
import com.dale.ms.utils.AlgorithmUtil;
import com.dale.ms.utils.GlobalUtil;
import com.dale.ms.utils.RedisClient;
import com.dale.ms.utils.StringUtil;
import com.dale.ms.utils.ValidateCode;
import com.google.gson.Gson;
import com.sms.SDKTestSendTemplateSMS;
import com.sms.ZeroToNineRandom;

/**
 * 
 * @author Dale'
 * @date 2016-3-1 下午7:18:12
 * @description
 */
@Controller
public class MainController extends GenericController{

	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	Gson gson = new Gson();
	
	@Autowired
	@Qualifier("adminUserService")
	private AdminUserService adminUserService;
	
	@RequestMapping(value = "/user_login_ui")
	public String user_login_UI() {
		return "web/user-login";
	}
	
	@RequestMapping(value = "/request")
	public void redisRequest() {
		RedisClient.set("hhh", "333");
		System.out.println(RedisClient.get("hhh"));
	}
	
}
