/**
 * 
 */
package com.dale.ms.handle;

import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dale.ms.dataparse.DataParseBase;
import com.dale.ms.entities.HmUser;
import com.dale.ms.service.impl.MainServiceImpl;
import com.dale.ms.utils.GlobalUtil;
import com.dale.ms.utils.GsonUtil;
import com.dale.ms.utils.MyLogUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Dale'
 * @date 2017-5-2 下午12:32:49
 * @description 
 */
@Service("taskDistribution")
public class TaskDistribution {

	@Resource(name = "mainService")
	private MainServiceImpl mainService;
	
	public void taskAnalysisAndDistribute(DataParseBase dataParseBase) {
		System.out.println("taskAnalysisAndDistribute is running");
		Gson gson = new Gson();
		String flag = dataParseBase.getType();
		String obj = null;
		Class clazz = null;
		try {
			 Map<String, String> map = gson.fromJson((String) dataParseBase.getInputObject(), new TypeToken<Map<String, String>>(){}.getType());
			 int port = Integer.parseInt(map.get("port"));
			 int cmd = Integer.parseInt(map.get("cmd"));
			
			if (flag.equals("Buyer")) {
				obj = gson.fromJson(map.get("user"), new TypeToken<HmUser>(){}.getType());
			} else if (flag.equals("Seller")) {
				obj = gson.fromJson(map.get("user"), new TypeToken<HmUser>(){}.getType());
			} 
			
			
			Class c = Class.forName("com.dale.ms.handle.Handle" + port + "Impl");
			HandleInterface hIface = null;
			switch (port) {
			case GlobalUtil.PORT_1:
				clazz = MainServiceImpl.class;
				Constructor constructor = c.getDeclaredConstructor(new Class[] {Map.class, int.class, clazz});
				constructor.setAccessible(true);
				hIface = (HandleInterface) constructor.newInstance(new Object[] {dataParseBase.getContents(), cmd, mainService});
				break;
	
			default:
				clazz = MainServiceImpl.class;
				MyLogUtil.print("未知 PORT ，自动进入默认设置！");
				break;
			}
		
			String result = hIface.getResult(obj);
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
