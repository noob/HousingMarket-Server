/**
 * 
 */
package com.dale.ms.handle;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.dale.ms.entities.HmOrder;
import com.dale.ms.entities.HmUser;
import com.dale.ms.service.OrderService;
import com.dale.ms.service.impl.MainServiceImpl;
import com.dale.ms.service.impl.OrderServiceImpl;
import com.dale.ms.utils.GlobalUtil;
import com.dale.ms.utils.MyLogUtil;

/**
 * @author Dale'
 * @date 2017-5-2 下午3:23:07
 * @description 
 */
public class Handle3Impl extends BaseHandle implements HandleInterface{

	private OrderService orderService;
	private int cmd;
	private String resultData;
	
	public Handle3Impl() {
		super();
	}
	
	public Handle3Impl(Map<String, Object> contents, int cmd, OrderService orderService) {
		this.contents = contents;
		this.cmd = cmd;
		this.orderService = orderService;
	}

	/**
	 *   订单程序入口
	 */
	public void parseContent() {
		HmOrder order = (HmOrder) object;
		System.out.println(order.getBuyerMobile());
		switch (cmd) {
		case GlobalUtil.CMD_1:
			create(order);
			break;

		default:
			MyLogUtil.print("未知 CMD，执行默认方法!");
			break;
		}
	}
	
	/**
	 * 创建订单
	 * @param order 
	 */
	private void create(HmOrder order) {
		// 将得到的MAP结果gson
		if(orderService == null) {
			System.out.println("orderservice is null");
		}
		Map<String, String> map = orderService.create(order);
		resultData = gson.toJson(map);
	}
	
	/**
	 * 确认收货
	 * @param order
	 */
	private void confirmReceive(HmOrder order) {
		orderService.confirmReceive(order);
	}
	
	/**
	  * 商家接单
	  * @param order
	  * @return
	  */
	private void acceptOrder(HmOrder order) {
		orderService.acceptOrder(order);
	}
	
	/**
	  * 买家取消订单
	  * @param order
	  * @return
	  */
	private void cancelOrder(HmOrder order) {
		orderService.cancelOrder(order);
	}
	
	/**
	  * 买家删除订单
	  * @param order
	  * @return
	  */
	private void deleteOrder(HmOrder order) {
		orderService.deleteOrder(order);
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
