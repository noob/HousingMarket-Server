/**
 * 
 */
package com.dale.ms.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.dale.ms.entities.HmOrder;
import com.dale.ms.entities.HmStore;
import com.dale.ms.entities.HmUser;
import com.dale.ms.service.base.BaseService;

/**
 * @author Dale'
 * @date 2017-5-12 下午1:23:41
 * @description 
 */

public interface OrderService extends BaseService{
	
	/**
	 * 买家创建订单
	 * @param order
	 * @return
	 */
	 Map<String, String> create(HmOrder order);
	
	 /**
	  * 商家接单
	  * @param order
	  * @return
	  */
	 Map<String, String> acceptOrder(HmOrder order);
	 
	 /**
	  *  买家确认收货
	  * @param order
	  * @return
	  */
	 Map<String, String> confirmReceive(HmOrder order);
	 
	 /**
	  * 买家取消订单
	  * @param order
	  * @return
	  */
	 Map<String, String> cancelOrder(HmOrder order);
	 
	 /**
	  * 买家删除订单
	  * @param order
	  * @return
	  */
	 Map<String, String> deleteOrder(HmOrder order);
}
