package com.dale.ms.controller;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dale.ms.controller.generic.GenericController;
import com.dale.ms.dataparse.impl.HttpDataParseImpl;
import com.dale.ms.handle.TaskDistribution;
import com.dale.ms.status.TaskStatus;
import com.dale.ms.status.TaskStatusMap;
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
	public static Object lock = new Object();
	
	public static TaskDistribution taskDistribution = new TaskDistribution();
	
	@RequestMapping(value = "/request")
	public void Request() {
		final String uuid = UUID.randomUUID().toString();
		try {
			final HttpDataParseImpl httpDataParseImpl = new HttpDataParseImpl(request);
			TaskStatusMap.putTaskStatusForKey(uuid, TaskStatus.InQueue);
			ThreadPoolUtil.init().execute(new Thread(new Runnable() {
				
				@Override
				public void run() {
					taskDistribution.taskAnalysisAndDistribute(httpDataParseImpl, uuid);
				}
			}));
			
			long time = System.nanoTime();
			synchronized (lock) {
				while (TaskStatusMap.getTaskStatusForKey(uuid) != TaskStatus.Complete) {
					lock.wait();
					if (System.nanoTime() - time > 100000000000L) {
						//超时 
					}
				}
			}
			HttpUtil.responsePrintMsg(response, TaskStatusMap.getTaskResultForKey(uuid));
//			HttpUtil.responseOutMsg(response, TaskStatusMap.getTaskResultForKey(uuid));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			TaskStatusMap.deleteTaskResultForKey(uuid);
			TaskStatusMap.deleteTaskStatusForKey(uuid);
		}
	}
	
	public static synchronized void notifyResult() {
		synchronized (lock) {
			lock.notifyAll();
		}
	}
	
}
