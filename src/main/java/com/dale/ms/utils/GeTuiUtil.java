/**
 * 
 */
package com.dale.ms.utils;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.ITemplate;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;

/**
 * @author Dale'
 * @date 2017-5-11 下午2:25:36
 * @description 
 */
public class GeTuiUtil {

	public static void main(String[] args) {
		try {
<<<<<<< HEAD
//			push("Android");
=======
<<<<<<< HEAD
//			push("Android");
=======
<<<<<<< HEAD
//			push("Android");
=======
			push("Android");
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
<<<<<<< HEAD
	public static void push(String clientId, String content, String deviceInfo) throws Exception {
=======
<<<<<<< HEAD
	public static void push(String clientId, String content, String deviceInfo) throws Exception {
=======
<<<<<<< HEAD
	public static void push(String clientId, String content, String deviceInfo) throws Exception {
=======
	public static void push(String deviceInfo) throws Exception {
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
		String appId = getConfig("APP_ID", deviceInfo);
		String appkey = getConfig("APP_KEY", deviceInfo);
		String masterSecret = getConfig("MASTER", deviceInfo);
		
		
		// https连接
        IGtPush push = new IGtPush(GlobalUtil.host, appkey, masterSecret);
        
        SingleMessage message = new SingleMessage();
		
		ITemplate template = null;
		if (deviceInfo.contains("Android")) {
<<<<<<< HEAD
			template = getAndriodTransmissionTemplate(content, appId, appkey);
=======
<<<<<<< HEAD
			template = getAndriodTransmissionTemplate(content, appId, appkey);
=======
<<<<<<< HEAD
			template = getAndriodTransmissionTemplate(content, appId, appkey);
=======
			template = getAndriodTransmissionTemplate(appId, appkey);
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
		}
		message.setOffline(true);
		// 离线有效时间，单位为毫秒，可选
		message.setOfflineExpireTime(24 * 3600 * 1000);
		message.setData(template);	
		message.setPushNetWorkType(0); // 可选，判断是否客户端是否wifi环境下推送，1为在WIFI环境下，0为不限制网络环境。
		
		Target target = new Target();
        target.setAppId(appId);
<<<<<<< HEAD
        //"f6c9acef2a733c3d24a7c9f1d1783e64"
        target.setClientId(clientId);
=======
<<<<<<< HEAD
        //"f6c9acef2a733c3d24a7c9f1d1783e64"
        target.setClientId(clientId);
=======
<<<<<<< HEAD
        //"f6c9acef2a733c3d24a7c9f1d1783e64"
        target.setClientId(clientId);
=======
        target.setClientId("f6c9acef2a733c3d24a7c9f1d1783e64");
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
        // 用户别名推送，cid和用户别名只能2者选其一
//         String alias = "商家端";
//         target.setAlias(alias);
        IPushResult ret = null;
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
            System.out.println("ret = " + ret);
        }
        if (ret != null) {
            System.out.println(ret.getResponse().toString());
        } else {
            System.out.println("服务器响应异常");
        }
		
		
	}
	
	/**
	 * Andriod 透传消息模板
	 * @return
	 */
<<<<<<< HEAD
	public static TransmissionTemplate getAndriodTransmissionTemplate(String content, String appId, String appkey) throws Exception{
=======
<<<<<<< HEAD
	public static TransmissionTemplate getAndriodTransmissionTemplate(String content, String appId, String appkey) throws Exception{
=======
<<<<<<< HEAD
	public static TransmissionTemplate getAndriodTransmissionTemplate(String content, String appId, String appkey) throws Exception{
=======
	public static TransmissionTemplate getAndriodTransmissionTemplate(String appId, String appkey) throws Exception{
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
		TransmissionTemplate template = new TransmissionTemplate();
	    template.setAppId(appId);
	    template.setAppkey(appkey);
	    // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
	    template.setTransmissionType(2);
<<<<<<< HEAD
	    template.setTransmissionContent(content);
=======
<<<<<<< HEAD
	    template.setTransmissionContent(content);
=======
<<<<<<< HEAD
	    template.setTransmissionContent(content);
=======
	    template.setTransmissionContent("我是一只胡龙呱，呱呱呱");
>>>>>>> 6655372f9e8d6c6c58bddc39817e4fdfc5aad381
>>>>>>> 8b524b034893a58123136e072f9c2d5db6b0173c
>>>>>>> e29539dff60f85419c4469ca27c1b309769013f3
	    // 设置定时展示时间
//	     template.setDuration("2017-01-16 11:40:00", "2018-01-16 12:24:00");
	    return template;
	}
	
	
	/**
	 * 根据APP不同的客户端，切换个推应用配置信息
	 * @param deviceInfo
	 */
	public static String getConfig(String type, String deviceInfo){
		switch (type) {
			case "APP_ID":
				if(deviceInfo.contains("_STORE")){
					return GlobalUtil.STORE_APP_ID;
				}else{
					return GlobalUtil.APP_ID;
				}
			case "APP_KEY":
				if(deviceInfo.contains("_STORE")){
					return GlobalUtil.STORE_APP_KEY;
				}else{
					return GlobalUtil.APP_KEY;
				}
			case "MASTER":
				if(deviceInfo.contains("_STORE")){
					return GlobalUtil.STORE_MASTER_SECRET;
				}else{
					return GlobalUtil.MASTER_SECRET;
				}
			default:
				return null;
		}
	}
	
}
