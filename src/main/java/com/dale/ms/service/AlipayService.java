/**
 * 
 */
package com.dale.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dale.ms.dao.UserDao;
import com.dale.ms.entities.TUser;
import com.dale.ms.utils.StringUtil;

/**
 * @author Dale'
 * @date 2016-11-2 下午6:22:01
 * @description 
 */
@Service("alipayService")
public class AlipayService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
//	/**
//	 * 创建订单,存入数据库
//	 * @param order
//	 * @return
//	 */
//	public boolean  createOrder(TOrder order) {
//		TUser user = (TUser) userDao.getResultOne("from TUser t where t.userId = ?", new Object[]{order.getUserId()});
//		if(user != null) {
//			order.setCreateTime(StringUtil.getTime());
//			order.setUserMobile(user.getMobile());
//			if(userDao.save(order)) {
//				return true;
//			}
//		}
//		return false;
//	}
	
}
