/**
 * 
 */
package com.dale.ms.handle;

import java.util.Map;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

<<<<<<< HEAD
=======
=======
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
import com.dale.ms.entities.HmOrder;
import com.dale.ms.entities.HmUser;
import com.dale.ms.service.OrderService;
import com.dale.ms.service.impl.MainServiceImpl;
<<<<<<< HEAD
import com.dale.ms.service.impl.OrderServiceImpl;
=======
<<<<<<< HEAD
import com.dale.ms.service.impl.OrderServiceImpl;
=======
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
import com.dale.ms.utils.GlobalUtil;
import com.dale.ms.utils.MyLogUtil;

/**
 * @author Dale'
 * @date 2017-5-2 下午3:23:07
 * @description 
 */
public class Handle3Impl extends BaseHandle implements HandleInterface{

<<<<<<< HEAD
	private OrderServiceImpl orderService;
	private int cmd;
	private String resultData;
	
	public Handle3Impl() {
		super();
	}
	
	public Handle3Impl(Map<String, Object> contents, int cmd, OrderServiceImpl orderService) {
		System.out.println("构造方法---------运行");
		this.contents = contents;
		this.cmd = cmd;
		this.orderService = orderService;
		if(orderService == null) {
			System.out.println("传过来的orderService为空");
		}
=======
	private OrderService orderService;
	private int cmd;
	private String resultData;
	
<<<<<<< HEAD
	public Handle3Impl() {
		super();
	}
=======
	
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
	
	public Handle3Impl(Map<String, Object> contents, int cmd, OrderService orderService) {
		this.contents = contents;
		this.cmd = cmd;
		this.orderService = orderService;
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
	}

	/**
	 *   订单程序入口
	 */
	public void parseContent() {
		HmOrder order = (HmOrder) object;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
		System.out.println(order.getBuyerMobile());
		switch (cmd) {
		case GlobalUtil.CMD_1:
			create(order);
<<<<<<< HEAD
=======
=======
		switch (cmd) {
		case GlobalUtil.CMD_1:
			
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
			break;

		default:
			MyLogUtil.print("未知 CMD，执行默认方法!");
			break;
		}
	}
	
	/**
	 * 创建订单
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
	 * @param order 
	 */
	private void create(HmOrder order) {
		// 将得到的MAP结果gson
<<<<<<< HEAD
//		if(orderService == null) {
//			System.out.println("orderservice is null");
//		}
//		Map<String, String> map = orderService.create(order);
//		resultData = gson.toJson(map);
=======
		if(orderService == null) {
			System.out.println("orderservice is null");
		}
		Map<String, String> map = orderService.create(order);
		resultData = gson.toJson(map);
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
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
<<<<<<< HEAD
=======
=======
	 * @param order
	 */
	public void create(HmOrder order) {

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
			
		default:
			MyLogUtil.print("未知 CMD，执行默认方法!");
			break;
		}
	}
	
}
