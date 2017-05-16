/**
 * 
 */
package com.dale.ms.handle;

import java.util.Map;

import com.dale.ms.entities.HmUser;
import com.dale.ms.service.UserService;
import com.dale.ms.service.impl.UserServiceImpl;
import com.dale.ms.utils.GlobalUtil;
import com.dale.ms.utils.MyLogUtil;

/**
 * @author Dale'
 * @date 2017-5-2 下午3:23:07
 * @description 
 */
public class Handle1Impl extends BaseHandle implements HandleInterface{

	private UserService uerService;
	private int cmd;
	private String resultData;
	
	
	
	public Handle1Impl(Map<String, Object> contents, int cmd, UserService uerService) {
		this.contents = contents;
		this.cmd = cmd;
		this.uerService = uerService;
	}

	/**
	 *   用户程序入口
	 */
	public void parseContent() {
		HmUser user = (HmUser) object;
		switch (cmd) {
		case GlobalUtil.CMD_1:
			login();
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
	private void login() {
		HmUser user = (HmUser) object;
		System.out.println("用户登录");
	}
	
	/**
	 * 用户注册 
	 * @param user
	 * 
	 * 短信注册
	 */
	private void regist(HmUser user) {
		System.out.println("用户注册");
	}

	/**
	 * 获取我的收藏
	 * @param user
	 */
	private void myCollection(HmUser user) {
		
	}
	
	/**
	 * 获取邀请码
	 * @param user
	 */
	private void inviteCode(HmUser user) {
		
	}
	
	/**
	 * 获取我的返现
	 * @param user
	 */
	private void cashBack(HmUser user) {
		
	}
	
	/**
	 * 签到
	 * @param user
	 */
	private void signIn(HmUser user) {
		
	}
	
	/**
	 * 统计积分
	 * @param user
	 */
	private void integralStatistics(HmUser user) {
		
	}
	
	/**
	 * 意见反馈
	 * @param user
	 */
	private void feedBack(HmUser user) {
		
	}
	
	/**
	 * 用户获取 订单列表
	 */
	private void getOrderList(HmUser user) {
		
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
