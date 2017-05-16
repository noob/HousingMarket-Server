/**
 * 
 */
package com.dale.ms.handle;

import java.util.Map;

import com.dale.ms.entities.HmStore;
import com.dale.ms.service.StoreService;
import com.dale.ms.service.impl.StoreServiceImpl;
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
		HmStore store = (HmStore) object;
		switch (cmd) {
		case GlobalUtil.CMD_1:
			regist(store);
			break;
		case GlobalUtil.CMD_2:
			login(store);
			break;
		case GlobalUtil.CMD_3:
			storeDetail(store);
			break;
		case GlobalUtil.CMD_4:
			operateStore(store);
			break;
		case GlobalUtil.CMD_5:
			QRCode(store);
			break;
		case GlobalUtil.CMD_6:
			feedback(store);
			break;
		case GlobalUtil.CMD_7:
			getOrderList(store);
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
	private void regist(HmStore store) {
		
	}
	
	/**
	 * 短信登录
	 * @param user
	 */
	private void login(HmStore store) {
		
	}
	
	/**
	 * 获取店铺资料
	 * @param user
	 */
	private void storeDetail(HmStore store) {
		
	}
	
	/**
	 * 修改店铺资料
	 * @param user
	 */
	private void operateStore(HmStore store) {
		
	}
	
	/**
	 * 获取店铺二维码
	 * @param user
	 */
	private void QRCode(HmStore store) {
		
	}
	
	/**
	 * 意见与反馈
	 * @param user
	 */
	private void feedback(HmStore store) {
		
	}
	
	/**
	 * 商家获取订单列表
	 * @param store
	 */
	private void getOrderList(HmStore store) {
		
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
