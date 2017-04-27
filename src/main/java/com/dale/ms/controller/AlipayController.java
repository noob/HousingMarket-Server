///**
// * 
// */
//package com.dale.ms.controller;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.io.Writer;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//import javax.servlet.http.Cookie;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.alipay.config.*;
//import com.alipay.util.*;
//import com.dale.ms.controller.generic.GenericController;
//import com.dale.ms.entities.TLesson;
//import com.dale.ms.entities.TUser;
//import com.dale.ms.entities.TVip;
//import com.dale.ms.model.USER_SESSION_KEY;
//import com.dale.ms.service.AdminUserService;
//import com.dale.ms.service.AlipayService;
//import com.dale.ms.service.UserService;
//import com.dale.ms.utils.GlobalUtil;
//import com.dale.ms.utils.StringUtil;
//import com.google.gson.Gson;
//
///**
// * @author Dale'
// * @date 2016-10-27 下午2:53:03
// * @description
// */
//@Controller
//@RequestMapping(value = "/alipay")
//public class AlipayController extends GenericController {
//
//	public static final String SUCCESS = "success";
//	public static final String ERROR = "error";
//	public static final String NO = "no";
//	private Gson gson = new Gson();
//
//	@Autowired
//	@Qualifier("alipayService")
//	private AlipayService alipayService;
//
//	@Autowired
//	@Qualifier("userService")
//	private UserService userService;
//	
//	@RequestMapping(value = "/index")
//	public String pay() {
//		return "alipay/index";
//	}
//
////	 @RequestMapping(value = "/notify_url")
////	 public void notify_url() throws Exception {
////		 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>notify_url<<<<<<<<<<<<<<<<<<<<<<<");
////		 Map<String,String> params = new HashMap<String,String>();
////			Map requestParams = request.getParameterMap();
////			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
////				String name = (String) iter.next();
////				String[] values = (String[]) requestParams.get(name);
////				String valueStr = "";
////				for (int i = 0; i < values.length; i++) {
////					valueStr = (i == values.length - 1) ? valueStr + values[i]
////							: valueStr + values[i] + ",";
////				}
////				//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
////				valueStr = new String(valueStr.getBytes("UTF-8"), "utf-8");
////				params.put(name, valueStr);
////				System.out.println("name = " + name + " value = " + valueStr);
////			}
////			//得到body的内容
////			String body = params.get("body");
////			//分离出userId
////			String userId = body.substring(body.indexOf("{") + 1, body.indexOf("}"));
////			//分离出lessonId
////			String lessonId = body.substring(body.indexOf("(") + 1, body.indexOf(")"));
////			//买家支护宝账户
////			String buyer_alipay_account = params.get("buyer_email");
////			//交易金额
////			String total_fee = params.get("total_fee");
////			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
////			//商户订单号
////
////			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("UTF-8"),"UTF-8");
////
////			//支付宝交易号
////
////			String trade_no = new String(request.getParameter("trade_no").getBytes("UTF-8"),"UTF-8");
////
////			//交易状态
////			String trade_status = new String(request.getParameter("trade_status").getBytes("UTF-8"),"UTF-8");
////			
////			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
////			
////			if(AlipayNotify.verify(params)){//验证成功
////				//////////////////////////////////////////////////////////////////////////////////////////
////				//请在这里加上商户的业务逻辑程序代码
////				TUser user = userService.getUserById(userId);
////				TLesson lesson = userService.getLessonById(lessonId);
////				if (user != null && lesson != null) { 
////					System.out.println(userId + "--" + lessonId);
////					return userService.oprateLessonLog(user, lesson, out_trade_no, trade_no, trade_status, buyer_alipay_account, total_fee).equals(SUCCESS) ? "web/default" : "web/fail";
////				}
////				//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
////				
////				if(trade_status.equals("TRADE_FINISHED")){
////					//判断该笔订单是否在商户网站中已经做过处理
////						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
////						//请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
////						//如果有做过处理，不执行商户的业务程序
////						
////					//注意：
////					//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
////				} else if (trade_status.equals("TRADE_SUCCESS")){
////					//判断该笔订单是否在商户网站中已经做过处理
////						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
////						//请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
////						//如果有做过处理，不执行商户的业务程序
////						
////					//注意：
////					//付款完成后，支付宝系统发送该交易状态通知
////				}
////
////				//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
////					
////				System.out.println("----------- 来自支付宝的请求  ------------  订单交易成功");
////				return "web/default";
////
////				//////////////////////////////////////////////////////////////////////////////////////////
////			}else{//验证失败
////				System.out.println("----------- 不是来自支付宝的请求  ------------  订单支付失败");
////				//该页面可做页面美工编辑
////				return "web/fail";
////			}
////		 return "alipay/notify_url";
////	 }
//	 
////	 @RequestMapping(value = "/notify_url2")
////	 public void notify_url2() throws Exception {
////		 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>notify_url2<<<<<<<<<<<<<<<<<<<<<<<");
////		 Map<String,String> params = new HashMap<String,String>();
////			Map requestParams = request.getParameterMap();
////			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
////				String name = (String) iter.next();
////				String[] values = (String[]) requestParams.get(name);
////				String valueStr = "";
////				for (int i = 0; i < values.length; i++) {
////					valueStr = (i == values.length - 1) ? valueStr + values[i]
////							: valueStr + values[i] + ",";
////				}
////				//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
////				valueStr = new String(valueStr.getBytes("UTF-8"), "utf-8");
////				params.put(name, valueStr);
////				System.out.println("name = " + name + " value = " + valueStr);
////			}
////			//得到body的内容
////			String body = params.get("body");
////			//分离出userId
////			String userId = body.substring(body.indexOf("{") + 1, body.indexOf("}"));
////			//买家支护宝账户
////			String buyer_alipay_account = params.get("buyer_email");
////			//交易金额
////			String total_fee = params.get("total_fee");
////			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
////			//商户订单号
////
////			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("UTF-8"),"UTF-8");
////
////			//支付宝交易号
////
////			String trade_no = new String(request.getParameter("trade_no").getBytes("UTF-8"),"UTF-8");
////
////			//交易状态
////			String trade_status = new String(request.getParameter("trade_status").getBytes("UTF-8"),"UTF-8");
////			
////			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
////			
////			if(AlipayNotify.verify(params)){//验证成功
////				//////////////////////////////////////////////////////////////////////////////////////////
////				//请在这里加上商户的业务逻辑程序代码
////				TUser user = userService.getUserById(userId);
////				if (user != null) { 
////					System.out.println(userId + "   user ID ===");
////					USER_SESSION_KEY user_SESSION_KEY = new USER_SESSION_KEY();
////					user_SESSION_KEY.setUserId(user.getUserId());
////					user_SESSION_KEY.setUserName(user.getUserName());
////					user_SESSION_KEY.setMobile(user.getMobile());
////					if(user.getUserImg() != null) {
////						user_SESSION_KEY.setUserImg(user.getUserImg());
////					}
////					if(user.getLastTime() != null) {
////						user_SESSION_KEY.setLastTime(user.getLastTime());
////					}
////					if(user.getLastIp() != null) {
////						user_SESSION_KEY.setLastIp(user.getLastIp());
////					}
////					user_SESSION_KEY.setRankPower(1);
////					session.setAttribute(GlobalUtil.USER_SESSION_KEY, user_SESSION_KEY);
////					return userService.oprateUserRankPower(user, out_trade_no, trade_no, trade_status, buyer_alipay_account, total_fee).equals(SUCCESS) ? "web/userZoom" : "web/fail";
////				}
////				//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
////				
////				if(trade_status.equals("TRADE_FINISHED")){
////					//判断该笔订单是否在商户网站中已经做过处理
////						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
////						//请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
////						//如果有做过处理，不执行商户的业务程序
////						
////					//注意：
////					//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
////				} else if (trade_status.equals("TRADE_SUCCESS")){
////					//判断该笔订单是否在商户网站中已经做过处理
////						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
////						//请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
////						//如果有做过处理，不执行商户的业务程序
////						
////					//注意：
////					//付款完成后，支付宝系统发送该交易状态通知
////				}
////
////				//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
////					
////				System.out.println("----------- 来自支付宝的请求  ------------  订单交易成功");
////				return "web/userZoom";
////
////				//////////////////////////////////////////////////////////////////////////////////////////
////			}else{//验证失败
////				System.out.println("----------- 不是来自支付宝的请求  ------------  订单支付失败");
////				//该页面可做页面美工编辑
////				 return "web/fail";
////			}
//			
////		 return "alipay/notify_url";
////	 }
//	 
//	 /**
//	  * 提交表单信息调用支付宝接口
//	  * @return
//	  * @throws Exception
//	  */
//	 @RequestMapping("/submit_info")
//		public String submit_info() throws Exception {
//		 return "alipay/alipayapi";
//	 }
//	 
//	 @RequestMapping("/submit_info_2")
//		public String submit_info_2() throws Exception {
//		 return "alipay/alipayapi2";
//	 }
//	 
//	 /**
//	  * 支付宝return_url
//	  * @return
//	  * @throws Exception
//	  */
//	 @RequestMapping(value = "/return_url")
//	 public String return_url() throws Exception {
//		 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>return_url<<<<<<<<<<<<<<<<<<<<<<<");
//		 Map<String,String> params = new HashMap<String,String>();
//			Map requestParams = request.getParameterMap();
//			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
//				String name = (String) iter.next();
//				String[] values = (String[]) requestParams.get(name);
//				String valueStr = "";
//				for (int i = 0; i < values.length; i++) {
//					valueStr = (i == values.length - 1) ? valueStr + values[i]
//							: valueStr + values[i] + ",";
//				}
//				//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
//				valueStr = new String(valueStr.getBytes("UTF-8"), "utf-8");
//				params.put(name, valueStr);
////				System.out.println("name = " + name + " value = " + valueStr);
//			}
//			//得到body的内容
//			String body = params.get("body");
//			//分离出userId
//			String userId = body.substring(body.indexOf("{") + 1, body.indexOf("}"));
//			//分离出lessonId
//			String lessonId = body.substring(body.indexOf("(") + 1, body.indexOf(")"));
//			//买家支护宝账户
//			String buyer_alipay_account = params.get("buyer_email");
//			//交易金额
//			String total_fee = params.get("total_fee");
//			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
//			//商户订单号
//
//			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("UTF-8"),"UTF-8");
//
//			//支付宝交易号
//
//			String trade_no = new String(request.getParameter("trade_no").getBytes("UTF-8"),"UTF-8");
//
//			//交易状态
//			String trade_status = new String(request.getParameter("trade_status").getBytes("UTF-8"),"UTF-8");
//
//			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
//			
//			//计算得出通知验证结果
//			boolean verify_result = AlipayNotify.verify(params);
//			
//			if(verify_result){//验证成功
//				//////////////////////////////////////////////////////////////////////////////////////////
//				//请在这里加上商户的业务逻辑程序代码
//						
//				TUser user = userService.getUserById(userId);
//				TLesson lesson = userService.getLessonById(lessonId);
//				if (user != null && lesson != null) { 
//					System.out.println(userId + "--" + lessonId);
//					return userService.oprateLessonLog(user, lesson, out_trade_no, trade_no, trade_status, buyer_alipay_account, total_fee).equals(SUCCESS) ? "web/default" : "web/fail";
//				}
//				
//				//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
//				if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
//					//判断该笔订单是否在商户网站中已经做过处理
//						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
//						//如果有做过处理，不执行商户的业务程序
//				}
//				
//				//该页面可做页面美工编辑
//				System.out.println("----------- 来自支付宝的请求  ------------  订单交易成功");
//				return "web/default";
//				//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
//
//				//////////////////////////////////////////////////////////////////////////////////////////
//			}else{
//				System.out.println("----------- 不是来自支付宝的请求  ------------  订单支付失败");
//				//该页面可做页面美工编辑
//				 return "web/fail";
//			}
//			
//
//	 }
//	 
//	 
//	 
//	 
//	 /**
//	  * 支付宝return_url
//	  * @return
//	  * @throws Exception
//	  */
//	 @RequestMapping(value = "/return_url2")
//	 public String return_url2() throws Exception {
//		 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>return_url2<<<<<<<<<<<<<<<<<<<<<<<");
//		 Map<String,String> params = new HashMap<String,String>();
//			Map requestParams = request.getParameterMap();
//			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
//				String name = (String) iter.next();
//				String[] values = (String[]) requestParams.get(name);
//				String valueStr = "";
//				for (int i = 0; i < values.length; i++) {
//					valueStr = (i == values.length - 1) ? valueStr + values[i]
//							: valueStr + values[i] + ",";
//				}
//				//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
//				valueStr = new String(valueStr.getBytes("UTF-8"), "utf-8");
//				params.put(name, valueStr);
////				System.out.println("name = " + name + " value = " + valueStr);
//			}
//			//得到body的内容
//			String body = params.get("body");
//			//分离出userId
//			String userId = body.substring(body.indexOf("{") + 1, body.indexOf("}"));
//			//买家支护宝账户
//			String buyer_alipay_account = params.get("buyer_email");
//			//交易金额
//			String total_fee = params.get("total_fee");
//			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
//			//商户订单号
//
//			String out_trade_no = params.get("out_trade_no");
//
//			//支付宝交易号
//
//			String trade_no = params.get("trade_no");
//
//			//交易状态
//			String trade_status = params.get("trade_status");
//			
//			String extra_common_param = params.get("extra_common_param");
//			
//			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
//			
//			//计算得出通知验证结果
//			boolean verify_result = AlipayNotify.verify(params);
//			
//			if(verify_result){//验证成功
//				//////////////////////////////////////////////////////////////////////////////////////////
//				//请在这里加上商户的业务逻辑程序代码
//						
//				TUser user = userService.getUserById(userId);
//				if (user != null) { 
//					USER_SESSION_KEY user_SESSION_KEY = new USER_SESSION_KEY();
//					user_SESSION_KEY.setUserId(user.getUserId());
//					user_SESSION_KEY.setUserName(user.getUserName());
//					user_SESSION_KEY.setMobile(user.getMobile());
//					if(user.getUserImg() != null) {
//						user_SESSION_KEY.setUserImg(user.getUserImg());
//					}
//					if(user.getLastTime() != null) {
//						user_SESSION_KEY.setLastTime(user.getLastTime());
//					}
//					if(user.getLastIp() != null) {
//						user_SESSION_KEY.setLastIp(user.getLastIp());
//					}
//					user_SESSION_KEY.setRankPower(1);
////					session = getSession(extra_common_param);
////					System.out.println(extra_common_param);
////					if(session == null) {
////						System.out.println("session is null");
////					}
//					session.setAttribute(GlobalUtil.USER_SESSION_KEY, user_SESSION_KEY);
//					return userService.oprateUserRankPower(user).equals(SUCCESS) ? "web/userZoom" : "web/fail";
//				}
//				
//				//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
//				if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
//					//判断该笔订单是否在商户网站中已经做过处理
//						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
//						//如果有做过处理，不执行商户的业务程序
//				}
//				
//				//该页面可做页面美工编辑
//				System.out.println("----------- 来自支付宝的请求  ------------  订单交易成功");
//				return "web/userZoom";
//				//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
//
//				//////////////////////////////////////////////////////////////////////////////////////////
//			}else{
//				System.out.println("----------- 不是来自支付宝的请求  ------------  订单支付失败");
//				//该页面可做页面美工编辑
//				 return "web/fail";
//			}
//			
//
//	 }
//	 
//	 
//	 
//	 
//	 
//	 
//	 
//	 /**
//	  * 跳转培训表单页面
//	  * @param userId
//	  * @param lessonId
//	  * @param map
//	  * @return
//	  * @throws Exception
//	  */
//	 @RequestMapping("/form_page")
//		public String form_page(@RequestParam("userId") String userId, @RequestParam("lessonId") String lessonId, Map<String, String> map) throws Exception {
//		 TLesson lesson = userService.getLessonById(lessonId);
//		 map.put("lessonTitle", lesson.getLessonTitle());
//		 map.put("teacherIntroduce", lesson.getTeacherIntroduce());
//		 map.put("place", lesson.getPlace());
//		 map.put("lessonItem", lesson.getLessonItem());
//		 map.put("lessonMsg", lesson.getLessonMsg());
//		 //判断是否享受打折价
//		if (StringUtil.getTime().getTime() < lesson.getLessonDiscountEndDate().getTime()) { //现在时间 小于 打折截止时间
//			map.put("WIDtotal_fee", lesson.getDiscountPrice());
//		} else {
//			map.put("WIDtotal_fee", lesson.getPrice());
//		}
//		map.put("WIDsubject", lesson.getLessonTitle());
//		map.put("WIDout_trade_no", StringUtil.getDate("yyyyMMdd") + System.currentTimeMillis());
//		map.put("WIDbody", "userId={" + userId + "} lessonId=(" +lessonId  +") 开课时间：" + lesson.getLessonBeginDate() + " 开课地点：" + lesson.getPlace());
//		return "web/lesson_form";
//	 }
//	 
//	 /**
//	  * 跳转VIP支付表单
//	  * @param userId
//	  * @param map
//	  * @return
//	  * @throws Exception
//	  */
//	 @RequestMapping("/rank_power_form")
//	 public String rank_power_form(@RequestParam("userId") String userId, Map<String, String> map) throws Exception {
//		 TVip vip = userService.getVip();
//		 if(vip != null) {
//			 map.put("WIDsubject", vip.getVip());
//			 map.put("WIDtotal_fee", vip.getFee());
//			 map.put("WIDout_trade_no", StringUtil.getDate("yyyyMMdd") + System.currentTimeMillis());
//			 map.put("WIDbody", "userId={" + userId + "}");
////			 map.put("msessionId", session.getId());
//		 }
//		 return "web/rank_power_form";
//	 }
//
//}
