package com.dale.ms.controller;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dale.ms.controller.generic.GenericController;
import com.wordnik.swagger.annotations.ApiOperation;


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
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据用户名获取用户对象", httpMethod = "GET", response = String.class, notes = "根据用户名获取用户对象")
    public void get(@PathVariable Integer id,PrintWriter pw){
        System.out.println("get"+id);
        pw.print("hello:"+id);
    }
	
	
	@RequestMapping(value="/findById/{userId}")
	@ResponseBody
	 public void findById(@PathVariable String userId, PrintWriter pw){
		System.out.println("-------------------------");
	        System.out.println("get "+userId);
	        pw.print("mike");
//	        return "mike";
	    }
	
}
