package com.dale.ms.controller;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dale.ms.controller.generic.GenericController;
import com.dale.ms.dataparse.impl.HttpDataParseImpl;
import com.dale.ms.handle.TaskDistribution;
<<<<<<< HEAD
import com.dale.ms.service.impl.MainServiceImpl;
import com.dale.ms.service.impl.OrderServiceImpl;
import com.dale.ms.service.impl.StoreServiceImpl;
import com.dale.ms.service.impl.UserServiceImpl;
=======
<<<<<<< HEAD
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
import com.dale.ms.status.TaskStatus;
import com.dale.ms.status.TaskStatusMap;
=======
<<<<<<< HEAD
import com.dale.ms.status.TaskStatus;
import com.dale.ms.status.TaskStatusMap;
=======
>>>>>>> f42e15d758185e880610f91deb685ded138090ec
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
import com.dale.ms.utils.HttpUtil;
import com.dale.ms.utils.ThreadPoolUtil;

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
<<<<<<< HEAD
=======
	
<<<<<<< HEAD
=======
	@Autowired
	@Qualifier("taskDistribution")
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
	public static TaskDistribution taskDistribution = new TaskDistribution();
	
	@Resource(name="mainService")
	private MainServiceImpl mainService;
	
	@Resource(name="userService")
	private UserServiceImpl userService;
	
	@Resource(name="storeService")
	private StoreServiceImpl storeService;
	
	@Resource(name="orderService")
	private OrderServiceImpl orderService;
	
	@RequestMapping(value = "/request")
	public void Request() {
		final String uuid = UUID.randomUUID().toString();
		try {
			final HttpDataParseImpl httpDataParseImpl = new HttpDataParseImpl(request);
			TaskStatusMap.putTaskStatusForKey(uuid, TaskStatus.InQueue);
<<<<<<< HEAD
=======
=======
	public static TaskDistribution taskDistribution;
	
	@RequestMapping(value = "/request")
	public void Request() {
		System.out.println("-------------------------");
		try {
			final HttpDataParseImpl httpDataParseImpl = new HttpDataParseImpl(request);
>>>>>>> f42e15d758185e880610f91deb685ded138090ec
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
			ThreadPoolUtil.init().execute(new Thread(new Runnable() {
				
				@Override
				public void run() {
<<<<<<< HEAD
					// 由于spring和线程的关系 @Resource 注解只能写在线程外 所以在这将所有  service 传入
					//@Resource 写在线程内 无效 为null
					taskDistribution.taskAnalysisAndDistribute(httpDataParseImpl, uuid,mainService, userService, storeService, orderService);
//					taskDistribution.taskAnalysisAndDistribute(httpDataParseImpl, uuid);
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
					taskDistribution.taskAnalysisAndDistribute(httpDataParseImpl, uuid);
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
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
<<<<<<< HEAD
=======
=======
					taskDistribution.taskAnalysisAndDistribute(httpDataParseImpl);
				}
			}));
			
>>>>>>> f42e15d758185e880610f91deb685ded138090ec
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
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
