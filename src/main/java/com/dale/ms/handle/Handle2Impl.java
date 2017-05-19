/**
 * 
 */
package com.dale.ms.handle;

import java.util.Map;

<<<<<<< HEAD
import com.dale.ms.entities.HmStore;
import com.dale.ms.service.StoreService;
import com.dale.ms.service.impl.StoreServiceImpl;
=======
<<<<<<< HEAD
import com.dale.ms.entities.HmStore;
import com.dale.ms.service.StoreService;
import com.dale.ms.service.impl.StoreServiceImpl;
=======
<<<<<<< HEAD
import com.dale.ms.entities.HmStore;
import com.dale.ms.service.StoreService;
import com.dale.ms.service.impl.StoreServiceImpl;
=======
import com.dale.ms.entities.HmUser;
import com.dale.ms.service.StoreService;
import com.dale.ms.service.impl.MainServiceImpl;
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
import com.dale.ms.utils.GlobalUtil;
import com.dale.ms.utils.MyLogUtil;

/**
 * @author Dale'
 * @date 2017-5-2 下午3:23:07
 * @description 
 */
public class Handle2Impl extends BaseHandle implements HandleInterface{

<<<<<<< HEAD
	private StoreServiceImpl storeService;
=======
<<<<<<< HEAD
	private StoreServiceImpl storeService;
=======
	private StoreService storeService;
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
	private int cmd;
	private String resultData;
	
	
	
<<<<<<< HEAD
	public Handle2Impl(Map<String, Object> contents, int cmd, StoreServiceImpl storeService) {
=======
<<<<<<< HEAD
	public Handle2Impl(Map<String, Object> contents, int cmd, StoreServiceImpl storeService) {
=======
	public Handle2Impl(Map<String, Object> contents, int cmd, StoreService storeService) {
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
		this.contents = contents;
		this.cmd = cmd;
		this.storeService = storeService;
	}

	/**
	 *   商家程序入口
	 */
	public void parseContent() {
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
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
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
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
<<<<<<< HEAD
	private void regist(HmStore store) {
=======
<<<<<<< HEAD
	private void regist(HmStore store) {
=======
<<<<<<< HEAD
	private void regist(HmStore store) {
=======
	public void regist(HmUser user) {
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
		
	}
	
	/**
	 * 短信登录
	 * @param user
	 */
<<<<<<< HEAD
	private void login(HmStore store) {
=======
<<<<<<< HEAD
	private void login(HmStore store) {
=======
<<<<<<< HEAD
	private void login(HmStore store) {
=======
	public void login(HmUser user) {
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
		
	}
	
	/**
	 * 获取店铺资料
	 * @param user
	 */
<<<<<<< HEAD
	private void storeDetail(HmStore store) {
=======
<<<<<<< HEAD
	private void storeDetail(HmStore store) {
=======
<<<<<<< HEAD
	private void storeDetail(HmStore store) {
=======
	public void storeDetail(HmUser user) {
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
		
	}
	
	/**
	 * 修改店铺资料
	 * @param user
	 */
<<<<<<< HEAD
	private void operateStore(HmStore store) {
=======
<<<<<<< HEAD
	private void operateStore(HmStore store) {
=======
<<<<<<< HEAD
	private void operateStore(HmStore store) {
=======
	public void operateStore(HmUser user) {
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
		
	}
	
	/**
	 * 获取店铺二维码
	 * @param user
	 */
<<<<<<< HEAD
	private void QRCode(HmStore store) {
=======
<<<<<<< HEAD
	private void QRCode(HmStore store) {
=======
<<<<<<< HEAD
	private void QRCode(HmStore store) {
=======
	public void QRCode(HmUser user) {
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
		
	}
	
	/**
	 * 意见与反馈
	 * @param user
	 */
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
	private void feedback(HmStore store) {
		
	}
	
	/**
	 * 商家获取订单列表
	 * @param store
	 */
	private void getOrderList(HmStore store) {
		
	}
	
	
	
	
	
	
	
	
	
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
	public void feedback(HmUser user) {
		
	}
	
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
	
	
	
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
