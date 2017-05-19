package com.dale.ms.controller;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dale.ms.controller.generic.GenericController;
import com.dale.ms.utils.HttpUtil;
import com.google.gson.Gson;


/**
 * 
 * @author Dale'
 * @date 2016-3-1 下午7:18:12
 * @description
 */
@Controller
public class ApiController extends GenericController{

	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	Gson gson = new Gson();
	
	@RequestMapping(value="/findById/{userId}")
	@ResponseBody
	 public void findById(@PathVariable String userId){
	        System.out.println("get "+userId);
//	        user.setRealName("Mr.H");
//	        HttpUtil.responsePrintMsg(response, gson.toJson(user));
	    }
	
}
