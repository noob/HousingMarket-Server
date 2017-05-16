/**
 * 
 */
package com.dale.ms.utils;

/**
 * @author Dale'
 * @date 2016-3-8 下午2:25:50
 * @description 
 */
public class GlobalUtil {

	public final static String ADMIN_SESSION_KEY = "ADMIN_SESSION_KEY";
	public final static String USER_SESSION_KEY = "USER_SESSION_KEY";
	
	public final static int PORT_1 = 1; //Buyer
	public final static int PORT_2 = 2; //Seller
	public final static int PORT_3 = 3; //Order
	
	public final static int CMD_1 = 1; //
	public final static int CMD_2 = 2; //
	public final static int CMD_3 = 3; //
	public final static int CMD_4 = 4; //
	public final static int CMD_5 = 5; //
	public final static int CMD_6 = 6; //
	public final static int CMD_7 = 7; //
	public final static int CMD_8 = 8; //
	public final static int CMD_9 = 9; //
	
	//个推 host 
	public static final String host = "http://sdk.open.api.igexin.com/apiex.htm";
//	public static final String host = "https://api.getui.com/apiex.htm";
	
	/**
	 * 个推配置--用户端
	 */
	public static final String APP_ID = "uBnCGQFabv54EniP9cq0Y9";
	public static final String APP_KEY = "IRZusOljuFADdQm6BxQvb";
	public static final String MASTER_SECRET = "JnrheNl2PQ7Og8Bd3CJPo"; 
	
	/**
	 * 个推配置--商家端
	 */
	public static final String STORE_APP_ID = "7Ujuss3Oz67uqVrzmi9Yv8";
	public static final String STORE_APP_KEY = "8vZh4kUx9o80X3LPtgPl61";
	public static final String STORE_MASTER_SECRET = "0aflY90LKM8FzGKjYVf4m4"; 
	
	/**
	 * 订单状态配置
	 */
	public static final int NO_PAY = 1;							//下单未付款
	public static final int NO_ACCEPT_ORDER = 2;		//商家未接单
	public static final int NO_RECEIVE = 3;					//买家未确认收货
	public static final int IS_COMPLETE = 4;					//订单完成
	
	
}
