/**
 * 
 */
package com.dale.ms.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dale.ms.dao.OrderDao;
import com.dale.ms.entities.HmOrder;
import com.dale.ms.entities.HmStore;
import com.dale.ms.service.OrderService;
import com.dale.ms.service.base.BaseServiceImpl;
import com.dale.ms.utils.GeTuiUtil;
import com.dale.ms.utils.GlobalUtil;
import com.dale.ms.utils.PrimaryGenerater;
import com.dale.ms.utils.StringUtil;
import com.google.gson.Gson;

/**
 * @author Dale'
 * @date 2017-5-2 下午1:57:40
 * @description 
 */

@Service("orderService")
public class OrderServiceImpl {

	@Autowired
	@Qualifier("orderDao")
	private OrderDao orderDao;
	
	/**
	 * 创建订单
	 * @param order
	 * @return
	 */
	public Map<String, String> create(HmOrder order) {
		order.setOrderTradeNo(PrimaryGenerater.getInstance().generaterNextNumber()); //设置 订单流水号
		order.setOrderCreateTime(StringUtil.getTime()); //订单创建时间
		order.setOrderStatus(GlobalUtil.NO_PAY);
		orderDao.save(order); //写入数据库
	
		//将订单推送到商家
//		HmStore store = (HmStore) orderDao.getResultOne("from HmStore o where o.storeId = ?", new Object[]{order.getStoreId()});
//		try {
//			GeTuiUtil.push(store.getStoreId() + "", order.getOrderTradeNo(), store.getDeviceInfo());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("order_trade_no", order.getOrderTradeNo());
		return map;
	}

	/**
	  *  买家确认收货
	  * @param order
	  * @return
	  */
	public Map<String, String> confirmReceive(HmOrder order) {
		return null;
	}

	/**
	  * 商家接单
	  * @param order
	  * @return
	  */
	public Map<String, String> acceptOrder(HmOrder order) {
		return null;
	}

	/**
	  * 买家取消订单
	  * @param order
	  * @return
	  */
	public Map<String, String> cancelOrder(HmOrder order) {
		return null;
	}

	 /**
	  * 买家删除订单
	  * @param order
	  * @return
	  */
	public Map<String, String> deleteOrder(HmOrder order) {
		return null;
	}

	
	
	
}
