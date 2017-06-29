/**
 * 
 */
package com.dale.ms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dale.ms.dao.OrderDao;
import com.dale.ms.entities.HmOrder;
import com.dale.ms.entities.HmOrderGoods;
import com.dale.ms.entities.HmStore;
import com.dale.ms.entities.HmUser;
import com.dale.ms.service.OrderService;
import com.dale.ms.service.base.BaseServiceImpl;
import com.dale.ms.utils.GeTuiUtil;
import com.dale.ms.utils.GlobalUtil;
import com.dale.ms.utils.PrimaryGenerater;
import com.dale.ms.utils.StringUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
		String orderTradeNo = PrimaryGenerater.getInstance().generaterNextNumber();
		order.setOrderTradeNo(orderTradeNo); //设置 订单流水号
		order.setOrderCreateTime(StringUtil.getTime()); //订单创建时间
		order.setOrderStatus(GlobalUtil.NO_ACCEPT_ORDER);
		orderDao.save(order); //订单写入数据库
	
		//订单中商品单独写入一个表
		List<HmOrderGoods> list = new ArrayList<>();
		Gson gson = new Gson();
		list = gson.fromJson(order.getGoodInfo(), new TypeToken<List<HmOrderGoods>>(){}.getType());
		for(HmOrderGoods og : list) { //将所有写入
			orderDao.save(og);
		}
		
		//将订单推送到商家
		HmStore store = (HmStore) orderDao.getResultOne("from HmStore o where o.storeId = ?", new Object[]{order.getStoreId()});
		try {
			GeTuiUtil.push(store.getGetuiClientId() + "", orderTradeNo, store.getDeviceInfo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("order_trade_no", orderTradeNo);
		gson = null; // 清除占容
		return map;
	}

	/**
	  *  买家确认收货
	  * @param order
	  * @return
	  */
	public Map<String, String> confirmReceive(HmOrder order) {
		String orderTradeNo = order.getOrderTradeNo();
		HmOrder o = (HmOrder) orderDao.getResultOne("from HmOrder o where o.orderTradeNo = ?", new Object[]{orderTradeNo});
		o.setOrderStatus(GlobalUtil.IS_COMPLETE);
		
		Map<String, String> map = new HashMap<String, String>();
		
		if(orderDao.saveOrUpdate(o)) {
			map.put("msg", "success");
		} else {
			map.put("msg", "fail");
		}
		return map;
	}

	/**
	  * 商家接单
	  * @param order
	  * @return
	  */
	public Map<String, String> acceptOrder(HmOrder order) {
		String orderTradeNo = order.getOrderTradeNo();
		HmOrder o = (HmOrder) orderDao.getResultOne("from HmOrder o where o.orderTradeNo = ?", new Object[]{orderTradeNo});
		o.setOrderStatus(GlobalUtil.NO_RECEIVE);
		
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<String, String>();
		
		if(orderDao.saveOrUpdate(o)) {
			map.put("msg", "success");
			map.put("order", gson.toJson(o));
		} else {
			map.put("msg", "fail");
		}
		gson = null; // 清除占容
		return map;
	}

	/**
	  * 买家取消订单
	  * @param order
	  * @return
	  */
	public Map<String, String> cancelOrder(HmOrder order) {
		Gson gson = new Gson();
		String orderTradeNo = order.getOrderTradeNo();
		HmOrder o = (HmOrder) orderDao.getResultOne("from HmOrder o where o.orderTradeNo = ?", new Object[]{orderTradeNo});
		o.setOrderStatus(GlobalUtil.BUYER_CANCEL_ORDER);
		
		Map<String, String> map = new HashMap<String, String>();
		
		if(orderDao.saveOrUpdate(o)) { //订单状态更新成功
			map.put("msg", "success");
			map.put("order", gson.toJson(o));
			
			//将请求退款消息推送至商家
			HmStore store = (HmStore) orderDao.getResultOne("from HmStore o where o.storeId = ?", new Object[]{o.getStoreId()});
			try {
				GeTuiUtil.push(store.getGetuiClientId() + "", gson.toJson(o) + "_refund", store.getDeviceInfo());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else { //订单状态更新失败
			map.put("msg", "fail");
		}
		gson = null; // 清除占容
		return map;
		
	}

	 /**
	  * 买家删除订单
	  * @param order
	  * @return
	  */
	public Map<String, String> deleteOrder(HmOrder order) {
		return null;
	}

	/**
	 * 商家确认用户退款 
	 * @param order
	 * @return
	 */
	public Map<String, String> confirmRefund(HmOrder order) {
		String orderTradeNo = order.getOrderTradeNo();
		HmOrder o = (HmOrder) orderDao.getResultOne("from HmOrder o where o.orderTradeNo = ?", new Object[]{orderTradeNo});
		o.setOrderStatus(GlobalUtil.SELLER_CONFIRM_REFUND);
		
////////////////////////////////////////////////此处为第三方退款服务/////////////////////////////////////////////
//																																										 //
//																																										 //
////////////////////////////////////////////////此处为第三方退款服务/////////////////////////////////////////////
		
		Map<String, String> map = new HashMap<String, String>();
		
		if(orderDao.saveOrUpdate(o)) {
			map.put("msg", "success");
		} else {
			map.put("msg", "fail");
		}
		return map;
	}

	/**
	 * 商家拒接 并 结束订单
	 * @param order
	 * @return
	 */
	public Map<String, String> refuseOrder(HmOrder order) {
		Gson gson = new Gson();
		String orderTradeNo = order.getOrderTradeNo();
		HmOrder o = (HmOrder) orderDao.getResultOne("from HmOrder o where o.orderTradeNo = ?", new Object[]{orderTradeNo});
		o.setOrderStatus(GlobalUtil.REFUSE_ORDER);
		
		//将拒接单消息推送至买家
		HmUser user = (HmUser) orderDao.getResultOne("from HmUser o where o.userId = ?", new Object[]{o.getUserId()});
		try {
			GeTuiUtil.push(user.getGetuiClientId() + "", gson.toJson(o) + "_refuse", user.getDeviceInfo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		if(orderDao.saveOrUpdate(o)) {
			map.put("msg", "success");
			map.put("order", gson.toJson(o));
		} else {
			map.put("msg", "fail");
		}
		gson = null; // 清除占容
		return map;
	}


	
	
}
