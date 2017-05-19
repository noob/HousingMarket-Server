/**
 * 
 */
package com.dale.ms.service;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dale.ms.entities.HmOrder;
import com.dale.ms.entities.HmStore;
import com.dale.ms.entities.HmUser;
<<<<<<< HEAD
import com.dale.ms.service.base.BaseService;

=======
<<<<<<< HEAD
import com.dale.ms.service.base.BaseService;

=======

=======
import org.springframework.stereotype.Service;

>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
/**
 * @author Dale'
 * @date 2017-5-12 下午1:23:41
 * @description 
 */
<<<<<<< HEAD

public interface OrderService extends BaseService{
=======
<<<<<<< HEAD

public interface OrderService extends BaseService{
=======
<<<<<<< HEAD

public interface OrderService {
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
	
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
@Service("orderService")
public interface OrderService {

>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
}
