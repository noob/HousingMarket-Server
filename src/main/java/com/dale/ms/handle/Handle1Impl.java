/**
 * 
 */
package com.dale.ms.handle;

import java.util.Map;

<<<<<<< HEAD
import com.dale.ms.entities.HmUser;
<<<<<<< HEAD
import com.dale.ms.service.UserService;
import com.dale.ms.service.impl.UserServiceImpl;
=======
<<<<<<< HEAD
import com.dale.ms.service.UserService;
import com.dale.ms.service.impl.UserServiceImpl;
=======
<<<<<<< HEAD
import com.dale.ms.service.UserService;
=======
=======
<<<<<<< HEAD
import com.dale.ms.entities.HmUser;
=======
>>>>>>> f42e15d758185e880610f91deb685ded138090ec
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
>>>>>>> 141436243474dfee36a70341663322d157819f89
import com.dale.ms.service.impl.MainServiceImpl;
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
import com.dale.ms.utils.GlobalUtil;
import com.dale.ms.utils.MyLogUtil;

/**
 * @author Dale'
 * @date 2017-5-2 下午3:23:07
 * @description 
 */
public class Handle1Impl extends BaseHandle implements HandleInterface{

<<<<<<< HEAD
	private UserServiceImpl uerService;
=======
	private UserService uerService;
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
	private int cmd;
	private String resultData;
	
	
	
<<<<<<< HEAD
	public Handle1Impl(Map<String, Object> contents, int cmd, UserServiceImpl uerService) {
=======
	public Handle1Impl(Map<String, Object> contents, int cmd, UserService uerService) {
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
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
<<<<<<< HEAD
			break;
		case GlobalUtil.CMD_9:
			getOrderList(user);
=======
<<<<<<< HEAD
			break;
		case GlobalUtil.CMD_9:
			getOrderList(user);
=======
=======
			resultData = "shake it, shake it";
<<<<<<< HEAD
			HmUser user = (HmUser) object;
			System.out.println(user.getMobile());
			
=======
<<<<<<< HEAD
			HmUser user = (HmUser) object;
			System.out.println(user.getMobile());
=======
>>>>>>> f42e15d758185e880610f91deb685ded138090ec
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
>>>>>>> 141436243474dfee36a70341663322d157819f89
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
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
<<<<<<< HEAD
	private void login() {
=======
<<<<<<< HEAD
	private void login() {
=======
	public void login() {
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
		HmUser user = (HmUser) object;
		System.out.println("用户登录");
	}
	
	/**
	 * 用户注册 
	 * @param user
	 * 
	 * 短信注册
	 */
<<<<<<< HEAD
	private void regist(HmUser user) {
=======
<<<<<<< HEAD
	private void regist(HmUser user) {
=======
	public void regist(HmUser user) {
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
		System.out.println("用户注册");
	}

	/**
	 * 获取我的收藏
	 * @param user
	 */
<<<<<<< HEAD
	private void myCollection(HmUser user) {
=======
<<<<<<< HEAD
	private void myCollection(HmUser user) {
=======
	public void myCollection(HmUser user) {
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
		
	}
	
	/**
	 * 获取邀请码
	 * @param user
	 */
<<<<<<< HEAD
	private void inviteCode(HmUser user) {
=======
<<<<<<< HEAD
	private void inviteCode(HmUser user) {
=======
	public void inviteCode(HmUser user) {
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
		
	}
	
	/**
	 * 获取我的返现
	 * @param user
	 */
<<<<<<< HEAD
	private void cashBack(HmUser user) {
=======
<<<<<<< HEAD
	private void cashBack(HmUser user) {
=======
	public void cashBack(HmUser user) {
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
		
	}
	
	/**
	 * 签到
	 * @param user
	 */
<<<<<<< HEAD
	private void signIn(HmUser user) {
=======
<<<<<<< HEAD
	private void signIn(HmUser user) {
=======
	public void signIn(HmUser user) {
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
		
	}
	
	/**
	 * 统计积分
	 * @param user
	 */
<<<<<<< HEAD
	private void integralStatistics(HmUser user) {
=======
<<<<<<< HEAD
	private void integralStatistics(HmUser user) {
=======
	public void integralStatistics(HmUser user) {
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
		
	}
	
	/**
	 * 意见反馈
	 * @param user
	 */
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
	private void feedBack(HmUser user) {
		
	}
	
	/**
	 * 用户获取 订单列表
	 */
	private void getOrderList(HmUser user) {
		
	}
<<<<<<< HEAD
=======
=======
	public void feedBack(HmUser user) {
		
	}
	
	
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
<<<<<<< HEAD
			
=======

>>>>>>> f42e15d758185e880610f91deb685ded138090ec
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
		default:
			MyLogUtil.print("未知 CMD，执行默认方法!");
			break;
		}
	}
	
}
