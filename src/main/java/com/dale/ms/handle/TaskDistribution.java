/**
 * 
 */
package com.dale.ms.handle;

import java.lang.reflect.Constructor;
import java.util.Map;

import javax.annotation.Resource;

import com.dale.ms.controller.MainController;
import com.dale.ms.dataparse.DataParseBase;
import com.dale.ms.entities.HmOrder;
import com.dale.ms.entities.HmStore;
import com.dale.ms.entities.HmUser;
import com.dale.ms.service.MainService;
import com.dale.ms.service.OrderService;
import com.dale.ms.service.StoreService;
import com.dale.ms.service.UserService;
import com.dale.ms.status.TaskStatus;
import com.dale.ms.status.TaskStatusMap;
import com.dale.ms.utils.GlobalUtil;
import com.dale.ms.utils.MyLogUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Dale'
 * @date 2017-5-2 下午12:32:49
 * @description 
 */
public class TaskDistribution {

	@Resource(name="mainService")
	private MainService mainService;
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="storeService")
	private StoreService storeService;
	
	@Resource(name="orderService")
	private OrderService orderService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void taskAnalysisAndDistribute(DataParseBase dataParseBase, String uuid) {
		Gson gson = new Gson();
		String result = null;
		String flag = dataParseBase.getType();
		Object obj = null;
		Class clazz = null;
		try {
			 Map<String, String> map = (Map<String, String>) dataParseBase.getInputObject();
			 int port = Integer.parseInt(map.get("port"));
			 int cmd = Integer.parseInt(map.get("cmd"));
			
			if (flag.equals("USER")) {
				obj = gson.fromJson(map.get("user"), new TypeToken<HmUser>(){}.getType());
			} else if (flag.equals("STORE")) {
				obj = gson.fromJson(map.get("store"), new TypeToken<HmStore>(){}.getType());
			} else if (flag.equals("ORDER")) {
				obj = gson.fromJson(map.get("order"), new TypeToken<HmOrder>(){}.getType());
			}
			
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
			
			Class c = Class.forName("com.dale.ms.handle.Handle" + port + "Impl");
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
				hIface = (HandleInterface) constructor.newInstance(new Object[] {dataParseBase.getContents(), cmd, orderService});
				break;
			default:
				hIface = (HandleInterface) constructor.newInstance(new Object[] {dataParseBase.getContents(), cmd, mainService});
				MyLogUtil.print("未知 PORT ，自动进入默认设置！");
				break;
			}
			
			result = hIface.getResult(obj);
			if (result != null) {
				TaskStatusMap.putTaskResultForKey(uuid, result);
			}
			TaskStatusMap.putTaskStatusForKey(uuid, TaskStatus.Complete);
			
			MainController.notifyResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
