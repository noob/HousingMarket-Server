package com.dale.ms.service;
//package com.dale.ms.service;
//
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import javax.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//import com.dale.ms.dao.UserDao;
//import com.dale.ms.entities.TLesson;
//import com.dale.ms.entities.TLessonLog;
//import com.dale.ms.entities.TSchoolMajor;
//import com.dale.ms.entities.TUser;
//import com.dale.ms.entities.TVip;
//import com.dale.ms.model.Pagenation;
//import com.dale.ms.utils.AlgorithmUtil;
//import com.dale.ms.utils.GlobalUtil;
//import com.dale.ms.utils.MyLogUtil;
//import com.dale.ms.utils.NetUtil;
//import com.dale.ms.utils.StringUtil;
//import com.google.gson.JsonElement;
//
///**
// * 
// * @author Dale'
// * @date 2016-3-2 下午12:12:48
// * @description
// */
//@Service("userService")
//public class UserService {
//
//	@Autowired
//	@Qualifier("userDao")
//	private UserDao userDao;
//
//	public TUser getUserInfo(String id) {
//		String hql = "from User t where t.id = ?";
//		Object[] params = new Object[] {Integer.parseInt(id)};
//		return (TUser) userDao.getResultOne(hql, params);
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<TUser>  getAllUserInfo() {
//		String hql = "from TUser t order by t.id";
//		Object[] params = null;
//		return (List<TUser>) userDao.getResult(hql, params);
//	}
//
//	public boolean deleteUser(String id) {
//		String hql = "from TUser t where t.id = ?";
//		Object[] params = new Object[] {Integer.parseInt(id)};
//		TUser user = (TUser) userDao.getResultOne(hql, params);
//		return userDao.delete(user);
//	}
//
//	public boolean updateUser(Map<String, String> map, String id) {
//		String hql = "from TUser t where t.id = ?";
//		Object[] params = new Object[] {Integer.parseInt(id)};
//		TUser user = (TUser) userDao.getResultOne(hql, params);
//		if(user != null) {
////			user.setUserId(map.get("userId"));
////			user.setPassword(map.get("password"));
////			user.setDeviceInfo(map.get("deviceInfo"));
////			user.setIdentifier(map.get("identifier"));
//		}
//		return userDao.update(user);
//	}
//
//	/**
//	 * 通过username password验证登录
//	 * @param username
//	 * @param password
//	 * @return
//	 */
//	public TUser getByNameAndPassword(String username, String password) {
//		return (TUser) userDao.getResultOne("from TUser t where t.mobile = ? and t.password = ?", new Object[]{username, password});
//	}
//
//	/**
//	 * 修改用户最后登录信息
//	 * @param adminUser
//	 * @param request
//	 * @return
//	 */
//	public boolean modifyLastLogin(TUser user, HttpServletRequest request) {
//		user.setLastIp(NetUtil.getIpAddress(request));
//		user.setLastTime(StringUtil.getTime());
//		return userDao.merge(user);
//	}
//
//	/**
//	 * 分页查询所有用户
//	 * @param pagenation
//	 * @param userStatus
//	 * @param value 
//	 * @param condition 
//	 * @param begin
//	 * @param end
//	 * @return
//	 */
//	public List<?> getAllByPage(Pagenation pagenation, String userStatus, String gender, String condition, String value, String begin, String end) {
//		String hql = "";
//		Object[] params = null;
//		List<Object> list = new ArrayList<>();
//		// condition value
//		if(!StringUtil.isEmpty(condition) && !StringUtil.isEmpty(value)) {
//			hql += " t." + condition + " like '%" + value + "%' and";
//		}
//		// userStatus
//		if(!StringUtil.isEmpty(userStatus)) {
//			list.add(Integer.parseInt(userStatus));
//			hql += " t.userStatus = ? and";
//		}
//		//gender
//		if(!StringUtil.isEmpty(gender)) {
//			list.add(Integer.parseInt(gender));
//			hql += " t.gender = ? and";
//		}
//		//总结
//		if(hql.length() > 0) {
//			hql = "from TUser t where " + hql.subSequence(0, hql.length() - 3) + " order by t.createTime desc";
//			params = list.toArray();
//		} else {
//			hql = "from TUser t order by t.createTime desc";
//			params = null;
//		}
//		//时间筛选
//		hql = replaceWhere(hql, begin, end);
//		MyLogUtil.print(hql);
//		return userDao.fuzzyQueryByPage(hql, params, pagenation);
//	}
//
//	/**
//	 * 查询记录数
//	 * @param userStatus
//	 * @param begin
//	 * @param end
//	 * @param condition
//	 * @param value
//	 * @return
//	 */
//	public int countAll(String userStatus, String gender, String begin, String end, String condition, String value) {
//		String hql = "";
//		Object[] params = null;
//		List<Object> list = new ArrayList<Object>();
//		// condition value
//		if(!StringUtil.isEmpty(condition) && !StringUtil.isEmpty(value)) {
//			hql += " t." + condition + " like '%" + value + "%' and";
//		}
//		if(!StringUtil.isEmpty(userStatus)) {
//			list.add(Integer.parseInt(userStatus));
//			hql += " t.userStatus = ? and";
//		}
//		if(!StringUtil.isEmpty(gender)) {
//			list.add(Integer.parseInt(gender));
//			hql += " t.gender = ? and";
//		}
//		if(hql.length() > 0) {
//			hql = "select count(*) from TUser t where " + hql.subSequence(0, hql.length() - 3) + " order by t.createTime desc";
//			params = list.toArray();
//		} else {
//			hql = "select count(*) from TUser t order by t.createTime desc";
//			params = null;
//		}
//		hql = replaceWhere(hql, begin, end);
//		MyLogUtil.print(hql);
//		return userDao.fuzzyResultCount(hql, params);
//	}
//	
//	/**
//	 * 时间筛选
//	 * @param hql
//	 * @param begin
//	 * @param end
//	 * @return
//	 */
//	private String replaceWhere(String hql, String begin, String end) {
//		if(!StringUtil.isEmpty(end)) {
//			try {
//				end = StringUtil.getNextDayStr("yyyy-MM-dd", end);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
//		//begin 与 end 都有
//		if(!StringUtil.isEmpty(end) && !StringUtil.isEmpty(begin)) {
//			if(hql.contains("where")) {
//				hql = hql.replace("where", "where t.createTime >= '" + begin + "' and t.createTime < '" + end + "' and");
//			} else {
//				if(hql.contains("order by")) {
//					hql = hql.replace("order by", "where t.createTime >= '" + begin + "' and t.createTime < '" + end + "' order by");
//				} else {
//					hql += "where t.createTime >= '" + begin +"' and t.createTime < '" + end + "'";
//				}
//			}
//		}
//		// 大于前时间
//		else if(!StringUtil.isEmpty(begin)){
//			if(hql.contains("where")) {
//				hql = hql.replace("where", "where t.createTime >= '" + begin + "' and");
//			}
//			else{
//				if(hql.contains("order by")) {
//					hql = hql.replace("order by", "where t.createTime >= '" + begin + "' order by");
//				} else {
//					hql = hql + " where t.createTime >= '" + begin + "'";
//				}
//			}
//		}
//		// 小于后时间
//		else if(!StringUtil.isEmpty(end)){
//			if(hql.contains("where"))
//				hql = hql.replace("where", "where t.createTime < '" + end + "' and");
//			else{
//				if(hql.contains("order by")){
//					hql = hql.replace("order by", "where t.createTime < '" + end + "' order by");
//				} else {
//					hql = hql + " where t.createTime < '" + end + "'";
//				}
//			}
//		}
//		return hql;
//	}
//
//	/**
//	 * 修改用户状态
//	 * @param userStatus
//	 * @param userId
//	 * @return
//	 */
//	public boolean optionUser(String userStatus, String userId) {
//		TUser user = (TUser) userDao.findById(TUser.class, Long.parseLong(userId.trim()));
//		if(user != null) {
//			user.setUserStatus(Integer.parseInt(userStatus.trim()));
//		}
//		return userDao.saveOrUpdate(user);
//	}
//
//	/**
//	 * 根据ID查找
//	 * @param userId
//	 * @return
//	 */
//	public TUser getUserById(String userId) {
//		TUser user = (TUser) userDao.findById(TUser.class, Long.parseLong(userId.trim()));
//		return user;
//	}
//
//	/**
//	 * 注册
//	 * @param regist_password
//	 * @param regist_userName
//	 * @return
//	 */
//	public String register(TUser user) {
//		TUser u = (TUser) userDao.getResultOne("from TUser t where t.mobile = '" + user.getMobile() + "'", null);
//		if(u != null) {
//			return "exist";
//		}
//		//保存user
//		user.setPassword(AlgorithmUtil.Md5(user.getPassword().trim()));
//		user.setUserStatus(1);
//		user.setGender(1);
//		user.setUserImg(GlobalUtil.DEFALUT_IMG);
//		user.setCreateTime(StringUtil.getTime());
//		if(userDao.save(user)) {
//			return "success";
//		}
//		return "error";
//	}
//
//	/**
//	 * 用户找回密码
//	 * @param user
//	 * @return
//	 */
//	public String updateUser(TUser user) {
//		TUser u = (TUser) userDao.getResultOne("from TUser t where t.mobile = '" + user.getMobile() + "'", null);
//		if(u == null) {
//			return "no_exist";
//		}
//		u.setPassword(AlgorithmUtil.Md5(user.getPassword()));
//		if (userDao.saveOrUpdate(u)) {
//			return "success";
//		}
//		return "error";
//	}
//	
//	/**
//	 * 验证码登录 如果用户不存在表中则注册
//	 * @param mobile
//	 * @return
//	 */
//	public TUser getUserByMobile(String mobile) {
//		TUser u = (TUser) userDao.getResultOne("from TUser t where t.userName = ?", new Object[]{mobile});
//		if(u == null) {
//			TUser user = new TUser();
//			user.setUserName(mobile);
//			user.setMobile(mobile);
//			user.setCreateTime(StringUtil.getTime());
//			user.setUserStatus(1);
//			user.setUserImg(GlobalUtil.DEFALUT_IMG);
//			userDao.save(user);
//			return user;
//		}
//		return u;
//	}
//
//	/**
//	 * 注册时 ajax 验证mobile是否存在
//	 * @param mobile
//	 */
//	public Integer mobileExist(String mobile) {
//		TUser user = (TUser) userDao.getResultOne("from TUser t where t.mobile = ?", new Object[]{mobile});
//		if(user != null) { 		//存在
//			return 1;
//		} else { 						//不存在
//			return 0;
//		}
//	}
//	
//	public String mobileExist(TUser u) {
//		TUser user = (TUser) userDao.getResultOne("from TUser t where t.mobile = ?", new Object[]{u.getMobile()});
//		if(user != null) { 		//存在
//			return "success";
//		} else { 						//不存在
//			return "no_exist";
//		}
//	}
//	
//	/**
//	 * 获取所有开设的课程 
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public List<TLesson> getAllLesson() {
//		String hql = "from TLesson t order by t.lessonBeginDate";
//		List<TLesson> list = (List<TLesson>) userDao.getResult(hql, null);
//		MyLogUtil.print(hql);
//		return list;
//	}
//
//	/**
//	 * 根据 id  查找 TLesson
//	 * @return
//	 */
//	public TLesson getLessonById(String lessonId) {
//		TLesson lesson = (TLesson) userDao.findById(TLesson.class, Long.parseLong(lessonId.trim()));
//		return lesson;
//	}
//
//	/**
//	 * 处理培训订单信息记录
//	 * @param user
//	 * @param lesson
//	 * @return
//	 */
//	public String oprateLessonLog(TUser user, TLesson lesson, String out_trade_no, String trade_no, String trade_status, String buyer_alipay_account, String total_fee) {
//		TLessonLog lessonLog = new TLessonLog();
//		lessonLog.setUserId(user.getUserId());
//		lessonLog.setUserName(user.getUserName());
//		lessonLog.setRealName(user.getRealName());
//		lessonLog.setIdCard(user.getIdCard());
//		lessonLog.setHighSchoolName(user.getHighSchool());
//		lessonLog.setUserMobile(user.getMobile());
//		lessonLog.setCreateTime(StringUtil.getTime());
//		lessonLog.setRealPrice(total_fee);
//		lessonLog.setLessonId(lesson.getLessonId());
//		lessonLog.setLessonName(lesson.getLessonTitle());
//		lessonLog.setLessonBeginDate(lesson.getLessonBeginDate());
//		lessonLog.setBuyerAlipayAccount(buyer_alipay_account);
//		lessonLog.setTradeNo(trade_no);
//		lessonLog.setOutTradeNo(out_trade_no);
//		lessonLog.setTradeStatus(trade_status);
//		if(userDao.save(lessonLog)) {
//			return "success";
//		}
//		return "error";
//	}
//
//	/**
//	 * 完善用户信息
//	 * @param user
//	 * @return
//	 */
//	public String complete_user_info(TUser user) {
//		TUser u = (TUser) userDao.findById(TUser.class, user.getUserId());
//		if (u != null && !StringUtil.isEmpty(user.getHighSchool()) && !StringUtil.isEmpty(user.getIdCard()) && !StringUtil.isEmpty(user.getRealName())) {
//			u.setRealName(user.getRealName());
//			u.setIdCard(AlgorithmUtil.Md5(user.getIdCard()));
//			u.setHighSchool(user.getHighSchool());
//			u.setIsEnterInfoComplete(1);
//			if(userDao.saveOrUpdate(u)) {
//				return "success";
//			}
//		}
//		return "error";
//	}
//
//	/**
//	 * 判断报名信息是否完善
//	 * @return
//	 */
//	public String if_user_info_complete(String userId) {
//		TUser user = (TUser) userDao.findById(TUser.class, Long.parseLong(userId));
//		if(user != null) {
//			if(!StringUtil.isEmpty(user.getHighSchool()) && !StringUtil.isEmpty(user.getIdCard()) && !StringUtil.isEmpty(user.getRealName())) {
//				return "complete";
//			}
//		}
//		return "incomplete";
//	}
//
//	/**
//	 * 更新密码
//	 * @param user
//	 */
//	public String modifyPassword(TUser user) {
//		userDao.saveOrUpdate(user);
//		return "success";
//	}
//
//	/**
//	 * @return
//	 */
//	public TVip getVip() {
//		TVip vip = (TVip) userDao.getResultOne("from TVip t where t.TVipId = ?", new Object[]{(long) 1});
//		return vip;
//	}
//
//	/**
//	 * 用户 查询 排行榜权限操作
//	 * @param user
//	 * @param out_trade_no
//	 * @param trade_no
//	 * @param trade_status
//	 * @param buyer_alipay_account
//	 * @param total_fee
//	 * @return
//	 */
//	public String oprateUserRankPower(TUser user) {
//		user.setRankPower(1);
//		if(userDao.saveOrUpdate(user)) {
//			return "success";
//		}
//		return "error";
//	}
//
//	/**
//	 * @param userId
//	 * @return
//	 */
//	public String if_user_vip(String userId) {
//		TUser user = (TUser) userDao.findById(TUser.class, Long.parseLong(userId));
//		if(user.getRankPower() != null && user.getRankPower() == 1) {
//			return "success";
//		} else {
//			return "error";
//		}
//		
//	}
//
//	
//}
