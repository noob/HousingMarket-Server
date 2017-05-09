/**
 * 
 */
package com.dale.ms.handle;

import java.util.Map;

<<<<<<< HEAD
import com.dale.ms.entities.HmUser;
=======
>>>>>>> f42e15d758185e880610f91deb685ded138090ec
import com.dale.ms.service.impl.MainServiceImpl;
import com.dale.ms.utils.GlobalUtil;
import com.dale.ms.utils.MyLogUtil;

/**
 * @author Dale'
 * @date 2017-5-2 下午3:23:07
 * @description 
 */
public class Handle1Impl extends BaseHandle implements HandleInterface{

	private MainServiceImpl mainService;
	private int cmd;
	private String resultData;
	
	
	
	public Handle1Impl(Map<String, Object> contents, int cmd, MainServiceImpl mainService) {
		this.contents = contents;
		this.cmd = cmd;
		this.mainService = mainService;
	}

	/**
	 * 程序入口
	 */
	public void parseContent() {
		switch (cmd) {
		case GlobalUtil.CMD_1:
			resultData = "shake it, shake it";
<<<<<<< HEAD
			HmUser user = (HmUser) object;
			System.out.println(user.getMobile());
=======
>>>>>>> f42e15d758185e880610f91deb685ded138090ec
			break;

		default:
			MyLogUtil.print("未知 CMD，执行默认方法!");
			break;
		}
	}
	

	@Override
	public void resultContent() {
		parseContent();
	}



	@Override
	public void write() {
		switch (cmd) {
		case GlobalUtil.CMD_1:
			backData = resultData; //将业务运行结果赋值给返回值
			break;
<<<<<<< HEAD
			
=======

>>>>>>> f42e15d758185e880610f91deb685ded138090ec
		default:
			MyLogUtil.print("未知 CMD，执行默认方法!");
			break;
		}
	}
	
}
