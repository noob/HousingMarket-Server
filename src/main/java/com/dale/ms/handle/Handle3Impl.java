/**
 * 
 */
package com.dale.ms.handle;

import java.util.Map;

import com.dale.ms.entities.HmOrder;
import com.dale.ms.entities.HmUser;
import com.dale.ms.service.OrderService;
import com.dale.ms.service.impl.MainServiceImpl;
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
		switch (cmd) {
		case GlobalUtil.CMD_1:
			
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
	public void create(HmOrder order) {

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
