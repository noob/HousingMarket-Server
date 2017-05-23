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
import com.dale.ms.dao.StoreDao;
import com.dale.ms.entities.HmStore;
import com.dale.ms.service.StoreService;
import com.dale.ms.service.base.BaseServiceImpl;
import com.google.gson.Gson;

/**
 * @author Dale'
 * @date 2017-5-2 下午1:57:40
 * @description 
 */

@Service("storeService")
public class StoreServiceImpl {

	@Autowired
	@Qualifier("storeDao")
	private StoreDao storeDao;
	
	private Gson gson;
	
	/**
	 * 申请入驻
	 * @param store
	 * @return
	 */
	public Map<String, String> regist(HmStore store) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "success");
		return map;
	}

	/**
	 * 短信登录
	 * @param store
	 * @return
	 */
	public Map<String, String> login(HmStore store) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "success");
		return map;
	}

	/**
	 * 获取店铺资料
	 * @param store
	 * @return
	 */
	public Map<String, String> storeDetail(HmStore store) {
		HmStore s = (HmStore) storeDao.getResultOne("from HmStore o where o.storeId = ?", new Object[]{store.getStoreId()});
		Map<String, String> map = new HashMap<String, String>();
		gson = new Gson();
		map.put("store", gson.toJson(s));
		gson = null;
		return map;
	}

	/**
	 * 修改店铺资料
	 * @param store
	 * @return
	 */
	public Map<String, String> operateStore(HmStore store) {
		HmStore s = (HmStore) storeDao.getResultOne("from HmStore o where o.storeId = ?", new Object[]{store.getStoreId()});
		if(store.getBussinessLicense() != null) {
			s.setBussinessLicense(store.getBussinessLicense());
		}
		if(store.getStoreAddress() != null) {
			s.setStoreAddress(store.getStoreAddress());
		}
		if(store.getStoreImg() != null) {
			s.setStoreImg(store.getStoreImg());
		}
		if(store.getStoreMobile() != null) {
			s.setStoreMobile(store.getStoreMobile());
		}
		if(store.getStoreName() != null) {
			s.setStoreName(store.getStoreName());
		}
		Map<String, String> map = new HashMap<String, String>();
		if(storeDao.saveOrUpdate(s)) { //是否修改成功 
			map.put("msg", "success");
		} else {
			map.put("msg", "fail");
		}
		return map;
	}

	/**
	 * 获取店铺二维码
	 * @param store
	 * @return
	 */
	public Map<String, String> QRCode(HmStore store) {
		
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}

	/**
	 *  意见与反馈
	 * @param store
	 * @return
	 */
	public Map<String, String> feedback(HmStore store) {
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}

	/**
	 * 商家获取订单列表
	 * @param store
	 * @return
	 */
	public Map<String, String> getOrderList(HmStore store) {
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}


	
	
}
