/**
 * 
 */
package com.dale.ms.handle;

import java.util.Map;

<<<<<<< HEAD
import com.dale.ms.entities.HmUser;
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
<<<<<<< HEAD
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
	public void login() {
		HmUser user = (HmUser) object;
		System.out.println("用户登录");
	}
	
	/**
	 * 用户注册 
	 * @param user
	 * 
	 * 短信注册
	 */
	public void regist(HmUser user) {
		System.out.println("用户注册");
	}

	/**
	 * 获取我的收藏
	 * @param user
	 */
	public void myCollection(HmUser user) {
		
	}
	
	/**
	 * 获取邀请码
	 * @param user
	 */
	public void inviteCode(HmUser user) {
		
	}
	
	/**
	 * 获取我的返现
	 * @param user
	 */
	public void cashBack(HmUser user) {
		
	}
	
	/**
	 * 签到
	 * @param user
	 */
	public void signIn(HmUser user) {
		
	}
	
	/**
	 * 统计积分
	 * @param user
	 */
	public void integralStatistics(HmUser user) {
		
	}
	
	/**
	 * 意见反馈
	 * @param user
	 */
	public void feedBack(HmUser user) {
		
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
