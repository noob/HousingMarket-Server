package com.dale.ms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dale.ms.controller.generic.GenericController;
import com.dale.ms.dataparse.impl.HttpDataParseImpl;
import com.dale.ms.handle.TaskDistribution;
import com.dale.ms.utils.HttpUtil;
import com.dale.ms.utils.ThreadPoolUtil;
import com.google.gson.Gson;

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
	@Qualifier("taskDistribution")
	public static TaskDistribution taskDistribution;
	
	@RequestMapping(value = "/request")
	public void Request() {
		System.out.println("-------------------------");
		try {
			final HttpDataParseImpl httpDataParseImpl = new HttpDataParseImpl(request);
			ThreadPoolUtil.init().execute(new Thread(new Runnable() {
				
				@Override
				public void run() {
					taskDistribution.taskAnalysisAndDistribute(httpDataParseImpl);
				}
			}));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
