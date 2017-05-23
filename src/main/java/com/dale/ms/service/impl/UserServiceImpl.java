/**
 * 
 */
package com.dale.ms.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dale.ms.entities.HmUser;
import com.dale.ms.service.base.BaseServiceImpl;

/**
 * @author Dale'
 * @date 2017-5-2 下午1:57:40
 * @description 
 */

@Service("userService")
public class UserServiceImpl {

	/**
	 * 用户短信登录
	 * @param user
	 */
	public Map<String, String> login(HmUser user) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "success");
		return map;
	}

	/**
	 * 用户短信 注册
	 * @param user
	 * @return
	 */
	public Map<String, String> regist(HmUser user) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "success");
		return map;
	}

	/**
	 * 获取我的收藏
	 * @param user
	 * @return
	 */
	public Map<String, String> myCollection(HmUser user) {
		
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}

	/**
	 * 获取邀请码
	 * @param user
	 * @return
	 */
	public Map<String, String> inviteCode(HmUser user) {
		
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}

	/**
	 * 获取我的返现
	 * @param user
	 * @return
	 */
	public Map<String, String> cashBack(HmUser user) {
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}

	/**
	 * 签到
	 * @param user
	 * @return
	 */
	public Map<String, String> signIn(HmUser user) {
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}

	/**
	 * 统计积分
	 * @param user
	 * @return
	 */
	public Map<String, String> integralStatistics(HmUser user) {
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}

	/**
	 * 意见反馈
	 * @param user
	 * @return
	 */
	public Map<String, String> feedBack(HmUser user) {
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}

	/**
	 *  用户获取 订单列表
	 * @param user
	 * @return
	 */
	public Map<String, String> getOrderList(HmUser user) {
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}

	
	
}
