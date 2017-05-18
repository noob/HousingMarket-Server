/**
 * 
 */
package com.dale.ms.handle;

import java.lang.reflect.Constructor;
import java.util.Map;

import javax.annotation.Resource;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
=======
<<<<<<< HEAD
=======
import org.springframework.stereotype.Service;
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
import com.dale.ms.controller.MainController;
import com.dale.ms.dataparse.DataParseBase;
import com.dale.ms.entities.HmOrder;
import com.dale.ms.entities.HmStore;
import com.dale.ms.entities.HmUser;
import com.dale.ms.service.MainService;
import com.dale.ms.service.OrderService;
import com.dale.ms.service.StoreService;
import com.dale.ms.service.UserService;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
import com.dale.ms.service.impl.MainServiceImpl;
import com.dale.ms.service.impl.OrderServiceImpl;
import com.dale.ms.service.impl.StoreServiceImpl;
import com.dale.ms.service.impl.UserServiceImpl;
<<<<<<< HEAD
=======
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
import com.dale.ms.status.TaskStatus;
import com.dale.ms.status.TaskStatusMap;
<<<<<<< HEAD
=======
=======
import com.dale.ms.dataparse.DataParseBase;
import com.dale.ms.entities.HmUser;
import com.dale.ms.service.impl.MainServiceImpl;
>>>>>>> f42e15d758185e880610f91deb685ded138090ec
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
import com.dale.ms.utils.GlobalUtil;
import com.dale.ms.utils.MyLogUtil;
import com.dale.util.SpringContextUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Dale'
 * @date 2017-5-2 下午12:32:49
 * @description 
 */
public class TaskDistribution {

<<<<<<< HEAD
	//此处由于spring与多线程的关系 不能自动注解 直接手动获取
//	private MainServiceImpl mainService = (MainServiceImpl) SpringContextUtil.getBean("mainService");
//	private UserServiceImpl userService =  (UserServiceImpl) SpringContextUtil.getBean("userService");
//	private StoreServiceImpl storeService = (StoreServiceImpl) SpringContextUtil.getBean("storeService");
//	private OrderServiceImpl orderService = (OrderServiceImpl) SpringContextUtil.getBean("orderService");
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void taskAnalysisAndDistribute(DataParseBase dataParseBase, String uuid,MainServiceImpl mainService, UserServiceImpl userService, StoreServiceImpl storeService, OrderServiceImpl orderService) {
//		public void taskAnalysisAndDistribute(DataParseBase dataParseBase, String uuid) {
		
=======
<<<<<<< HEAD
	@Resource(name="mainService")
	private MainService mainService;
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="storeService")
	private StoreService storeService;
	
	@Resource(name="orderService")
	private OrderService orderService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
=======
	@Resource(name = "mainService")
	private MainService mainService;
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "storeService")
	private StoreService storeService;
	
	@Resource(name = "orderService")
	private OrderService orderService;
	
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
	public void taskAnalysisAndDistribute(DataParseBase dataParseBase, String uuid) {
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
		Gson gson = new Gson();
		String result = null;
		String flag = dataParseBase.getType();
		Object obj = null;
		Class clazz = null;
		try {
			 Map<String, String> map = (Map<String, String>) dataParseBase.getInputObject();
<<<<<<< HEAD
=======
=======
	public void taskAnalysisAndDistribute(DataParseBase dataParseBase) {
		System.out.println("taskAnalysisAndDistribute is running");
		Gson gson = new Gson();
		String flag = dataParseBase.getType();
		String obj = null;
		Class clazz = null;
		try {
			 Map<String, String> map = gson.fromJson((String) dataParseBase.getInputObject(), new TypeToken<Map<String, String>>(){}.getType());
>>>>>>> f42e15d758185e880610f91deb685ded138090ec
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
			 int port = Integer.parseInt(map.get("port"));
			 int cmd = Integer.parseInt(map.get("cmd"));
			
			if (flag.equals("USER")) {
				obj = gson.fromJson(map.get("user"), new TypeToken<HmUser>(){}.getType());
			} else if (flag.equals("STORE")) {
				obj = gson.fromJson(map.get("store"), new TypeToken<HmStore>(){}.getType());
			} else if (flag.equals("ORDER")) {
				obj = gson.fromJson(map.get("order"), new TypeToken<HmOrder>(){}.getType());
			}
<<<<<<< HEAD
			
			switch (port) {
			case GlobalUtil.PORT_1:
				clazz = UserServiceImpl.class;
				break;
			case GlobalUtil.PORT_2:
				clazz = StoreServiceImpl.class;
				break;
			case GlobalUtil.PORT_3:
				clazz = OrderServiceImpl.class;
				break;
			default:
				clazz = MainServiceImpl.class;
				MyLogUtil.print("未知 PORT ，自动进入默认设置！");
				break;
			}
=======
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
			
			switch (port) {
			case GlobalUtil.PORT_1:
				clazz = UserService.class;
				break;
			case GlobalUtil.PORT_2:
				clazz = StoreService.class;
				break;
			case GlobalUtil.PORT_3:
				clazz = OrderService.class;
				break;
			default:
				clazz = MainService.class;
				MyLogUtil.print("未知 PORT ，自动进入默认设置！");
				break;
			}
			
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
			
>>>>>>> f42e15d758185e880610f91deb685ded138090ec
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
			Class c = Class.forName("com.dale.ms.handle.Handle" + port + "Impl");
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
			Constructor constructor = c.getDeclaredConstructor(new Class[] {Map.class, int.class, clazz});
			constructor.setAccessible(true);
			
			HandleInterface hIface = null;
			
			switch (port) {
			case GlobalUtil.PORT_1:
				hIface = (HandleInterface) constructor.newInstance(new Object[] {dataParseBase.getContents(), cmd, userService});
				break;
			case GlobalUtil.PORT_2:
				hIface = (HandleInterface) constructor.newInstance(new Object[] {dataParseBase.getContents(), cmd, storeService});
				break;
			case GlobalUtil.PORT_3:
<<<<<<< HEAD
//				if(orderService == null) {
//					System.out.println("taskDistribution 中 orderService为空");
//				} else {
//					System.out.println("taskDistribution 中 orderService不空");
//					
//				}
=======
				hIface = (HandleInterface) constructor.newInstance(new Object[] {dataParseBase.getContents(), cmd, orderService});
=======
			
			switch (port) {
			case GlobalUtil.PORT_1:
				clazz = UserService.class;
				break;
			case GlobalUtil.PORT_2:
				clazz = StoreService.class;
				break;
			case GlobalUtil.PORT_3:
				clazz = OrderService.class;
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
				break;
			default:
				hIface = (HandleInterface) constructor.newInstance(new Object[] {dataParseBase.getContents(), cmd, mainService});
				MyLogUtil.print("未知 PORT ，自动进入默认设置！");
				break;
			}
<<<<<<< HEAD
			
=======
<<<<<<< HEAD
			
			Constructor constructor = c.getDeclaredConstructor(new Class[] {Map.class, int.class, clazz});
			constructor.setAccessible(true);
			
			HandleInterface hIface = null;
			
			switch (port) {
			case GlobalUtil.PORT_1:
				hIface = (HandleInterface) constructor.newInstance(new Object[] {dataParseBase.getContents(), cmd, userService});
				break;
			case GlobalUtil.PORT_2:
				hIface = (HandleInterface) constructor.newInstance(new Object[] {dataParseBase.getContents(), cmd, storeService});
				break;
			case GlobalUtil.PORT_3:
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
				hIface = (HandleInterface) constructor.newInstance(new Object[] {dataParseBase.getContents(), cmd, orderService});
				break;
			default:
				hIface = (HandleInterface) constructor.newInstance(new Object[] {dataParseBase.getContents(), cmd, mainService});
				MyLogUtil.print("未知 PORT ，自动进入默认设置！");
				break;
			}
			
<<<<<<< HEAD
=======
=======
		
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
>>>>>>> 141436243474dfee36a70341663322d157819f89
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
			result = hIface.getResult(obj);
			if (result != null) {
				TaskStatusMap.putTaskResultForKey(uuid, result);
			}
			TaskStatusMap.putTaskStatusForKey(uuid, TaskStatus.Complete);
			
			MainController.notifyResult();
<<<<<<< HEAD
=======
=======
			String result = hIface.getResult(obj);
			
			
			
			
			
>>>>>>> f42e15d758185e880610f91deb685ded138090ec
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
			
		} catch (Exception e) {
			e.printStackTrace();
		}
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
		
>>>>>>> f42e15d758185e880610f91deb685ded138090ec
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
	}
	
	
	
}
