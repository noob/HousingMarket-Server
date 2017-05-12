/**
 * 
 */
package com.dale.ms.handle;

import java.util.Map;

import com.dale.ms.entities.HmUser;
import com.dale.ms.service.StoreService;
import com.dale.ms.service.impl.MainServiceImpl;
import com.dale.ms.utils.GlobalUtil;
import com.dale.ms.utils.MyLogUtil;

/**
 * @author Dale'
 * @date 2017-5-2 下午3:23:07
 * @description 
 */
public class Handle2Impl extends BaseHandle implements HandleInterface{

	private StoreService storeService;
	private int cmd;
	private String resultData;
	
	
	
	public Handle2Impl(Map<String, Object> contents, int cmd, StoreService storeService) {
		this.contents = contents;
		this.cmd = cmd;
		this.storeService = storeService;
	}

	/**
	 *   商家程序入口
	 */
	public void parseContent() {
		HmUser user = (HmUser) object;
		switch (cmd) {
		case GlobalUtil.CMD_1:
			regist(user);
			break;
		case GlobalUtil.CMD_2:
			login(user);
			break;
		case GlobalUtil.CMD_3:
			storeDetail(user);
			break;
		case GlobalUtil.CMD_4:
			operateStore(user);
			break;
		case GlobalUtil.CMD_5:
			QRCode(user);
			break;
		case GlobalUtil.CMD_6:
			feedback(user);
			break;
		default:
			MyLogUtil.print("未知 CMD，执行默认方法!");
			break;
		}
	}
	

	/**
	 * 申请入驻
	 * @param user
	 */
	public void regist(HmUser user) {
		
	}
	
	/**
	 * 短信登录
	 * @param user
	 */
	public void login(HmUser user) {
		
	}
	
	/**
	 * 获取店铺资料
	 * @param user
	 */
	public void storeDetail(HmUser user) {
		
	}
	
	/**
	 * 修改店铺资料
	 * @param user
	 */
	public void operateStore(HmUser user) {
		
	}
	
	/**
	 * 获取店铺二维码
	 * @param user
	 */
	public void QRCode(HmUser user) {
		
	}
	
	/**
	 * 意见与反馈
	 * @param user
	 */
	public void feedback(HmUser user) {
		
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
			
		default:
			MyLogUtil.print("未知 CMD，执行默认方法!");
			break;
		}
	}
	
}
