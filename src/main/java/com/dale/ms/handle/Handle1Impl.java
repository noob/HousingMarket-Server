/**
 * 
 */
package com.dale.ms.handle;

import java.util.Map;

import com.dale.ms.entities.HmUser;
import com.dale.ms.service.impl.UserServiceImpl;
import com.dale.ms.utils.GlobalUtil;
import com.dale.ms.utils.MyLogUtil;

/**
 * @author Dale'
 * @date 2017-5-2 下午3:23:07
 * @description 
 */
public class Handle1Impl extends BaseHandle implements HandleInterface{

	private UserServiceImpl userService;
	private int cmd;
	private String resultData;
	
	
	
	public Handle1Impl(Map<String, Object> contents, int cmd, UserServiceImpl userService) {
		this.contents = contents;
		this.cmd = cmd;
		this.userService = userService;
	}

	/**
	 *   用户程序入口
	 */
	public void parseContent() {
		HmUser user = (HmUser) object;
		switch (cmd) {
		case GlobalUtil.CMD_1:
			login(user);
			break;
		case GlobalUtil.CMD_2:
			regist(user);
			break;
		case GlobalUtil.CMD_3:
			myCollection(user);
			break;
		case GlobalUtil.CMD_4:
			inviteCode(user);
			break;
		case GlobalUtil.CMD_5:
			cashBack(user);
			break;
		case GlobalUtil.CMD_6:
			signIn(user);
			break;
		case GlobalUtil.CMD_7:
			integralStatistics(user);
			break;
		case GlobalUtil.CMD_8:
			feedBack(user);
			break;
		case GlobalUtil.CMD_9:
			getOrderList(user);
			break;
		default:
			MyLogUtil.print("未知 CMD，执行默认方法!");
			break;
		}
	}
	
	
	
	/**
	 * 用户登录
	 * 
	 * 短信登录
	 */
	private void login(HmUser user) {
		System.out.println("用户登录");
		Map<String, String> map = userService.login(user);
		resultData = gson.toJson(map);
	}
	
	/**
	 * 用户注册 
	 * @param user
	 * 
	 * 短信注册
	 */
	private void regist(HmUser user) {
		System.out.println("用户注册");
		Map<String, String> map = userService.regist(user);
		resultData = gson.toJson(map);
		
	}

	/**
	 * 获取我的收藏
	 * @param user
	 */
	private void myCollection(HmUser user) {
		Map<String, String> map = userService.myCollection(user);
		resultData = gson.toJson(map);
	}
	
	/**
	 * 获取邀请码
	 * @param user
	 */
	private void inviteCode(HmUser user) {
		Map<String, String> map = userService.inviteCode(user);
		resultData = gson.toJson(map);
	}
	
	/**
	 * 获取我的返现
	 * @param user
	 */
	private void cashBack(HmUser user) {
		Map<String, String> map = userService.cashBack(user);
		resultData = gson.toJson(map);
	}
	
	/**
	 * 签到
	 * @param user
	 */
	private void signIn(HmUser user) {
		Map<String, String> map = userService.signIn(user);
		resultData = gson.toJson(map);
	}
	
	/**
	 * 统计积分
	 * @param user
	 */
	private void integralStatistics(HmUser user) {
		Map<String, String> map = userService.integralStatistics(user);
		resultData = gson.toJson(map);
	}
	
	/**
	 * 意见反馈
	 * @param user
	 */
	private void feedBack(HmUser user) {
		Map<String, String> map = userService.feedBack(user);
		resultData = gson.toJson(map);
	}
	
	/**
	 * 用户获取 订单列表
	 */
	private void getOrderList(HmUser user) {
		Map<String, String> map = userService.getOrderList(user);
		resultData = gson.toJson(map);
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
