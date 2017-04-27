package com.dale.ms.service;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dale.ms.dao.AdminUserDao;
import com.dale.ms.entities.AdminUser;
import com.dale.ms.entities.TLesson;
import com.dale.ms.entities.TLessonLog;
import com.dale.ms.entities.TVip;
import com.dale.ms.model.MoneyAmount;
import com.dale.ms.model.Pagenation;
import com.dale.ms.model.TLessonDataCount;
import com.dale.ms.utils.AlgorithmUtil;
import com.dale.ms.utils.GlobalUtil;
import com.dale.ms.utils.MyLogUtil;
import com.dale.ms.utils.NetUtil;
import com.dale.ms.utils.StringUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * 
 * @author Dale'
 * @date 2016-3-2 下午12:12:48
 * @description
 */
@Service("adminUserService")
public class AdminUserService {

	@Autowired
	@Qualifier("adminUserDao")
	private AdminUserDao adminUserDao;

	/**
	 * 根据名字得到管理员
	 * @param adminName
	 * @return
	 */
	public AdminUser getByAdminName(String adminName) {
		return (AdminUser) adminUserDao.getResultOne("from AdminUser t where t.adminName=?", new Object[]{adminName});
	}
	
	/**
	 * 修改super自身密码
	 * @param password
	 * @param newpassword
	 * @return
	 */
	public boolean modifyPSW(AdminUser adminUser, String newpawword) {
		adminUser.setPassword(AlgorithmUtil.Md5(newpawword.trim()));
		return adminUserDao.update(adminUser);
	}
	
	/**
	 * 根据用户名密码查询管理员
	 * @param trim
	 * @param md5
	 * @return
	 */
	public  AdminUser getByNameAndPassword(String username, String password) {
		return (AdminUser) adminUserDao.getResultOne("from AdminUser t where t.adminName = ? and t.password = ?", new Object[]{username, password});
	}

	/**
	 * 修改管理员最后登录信息
	 * @param adminUser
	 * @param request
	 * @return
	 */
	public boolean modifyLastLogin(AdminUser adminUser, HttpServletRequest request) {
		adminUser.setLastIp(NetUtil.getIpAddress(request));
		adminUser.setLastTime(StringUtil.getTime());
		return adminUserDao.merge(adminUser);
	}

	/**
	 * 根据条件查询
	 * @param pagenation
	 * @param mobile
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<?> getAllByPage(Pagenation pagenation, String mobile, String begin, String end) {
		String hql = "";
		Object[] params = null;
		List<Object> list = new ArrayList<Object>();
		if(!StringUtil.isEmpty(mobile)) {
			list.add(mobile);
			hql += " t.mobile" + " like '%" + mobile + "%' and";
		}
		if(hql.length() > 0) {
			hql = "from AdminUser t where " + hql + " t.power != 1 order by t.createTime desc";
		} else {
			hql = "from AdminUser t where t.power != 1 order by t.createTime desc";
		}
		hql = replaceWhere(hql, begin, end);
		MyLogUtil.print(hql);
		return adminUserDao.fuzzyQueryByPage(hql, params, pagenation);
	}

	/**
	 * 统计记录总数
	 * @param mobile
	 * @param begin
	 * @param end
	 * @return
	 */
	public int countAll(String mobile, String begin, String end) {
		String hql = "";
		Object[] params = null;
		List<Object> list = new ArrayList<Object>();
		if(!StringUtil.isEmpty(mobile)) {
			list.add(mobile);
			hql += " t.mobile" + " like '%" + mobile + "%' and";
		}
		if(hql.length() > 0) {
			hql = "select count(*) from AdminUser t where " + hql + " t.power != 1 order by t.createTime desc";
		} else {
			hql = "select count(*) from AdminUser t where t.power != 1 order by t.createTime desc";
		}
		hql = replaceWhere(hql, begin, end);
		MyLogUtil.print(hql);
		return adminUserDao.fuzzyResultCount(hql, params);
	}

	/**
	 * 删除管理员
	 * @param adminId
	 * @return
	 */
	public boolean delete(String adminId) {
		String sql = "delete from admin_user where ADMIN_ID = " + adminId;
		return adminUserDao.nativeUpdate(sql) == 0 ? false : true;
	}
	
	/**
	 * 时间筛选
	 * @param hql
	 * @param begin
	 * @param end
	 * @return
	 */
	private String replaceWhere(String hql, String begin, String end) {
		if(!StringUtil.isEmpty(end)) {
			try {
				end = StringUtil.getNextDayStr("yyyy-MM-dd", end);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		//begin 与 end 都有
		if(!StringUtil.isEmpty(end) && !StringUtil.isEmpty(begin)) {
			if(hql.contains("where")) {
				hql = hql.replace("where", "where t.createTime >= '" + begin + "' and t.createTime < '" + end + "' and");
			} else {
				if(hql.contains("order by")) {
					hql = hql.replace("order by", "where t.createTime >= '" + begin + "' and t.createTime < '" + end + "' order by");
				} else {
					hql += "where t.createTime >= '" + begin +"' and t.createTime < '" + end + "'";
				}
			}
		}
		// 大于前时间
		else if(!StringUtil.isEmpty(begin)){
			if(hql.contains("where")) {
				hql = hql.replace("where", "where t.createTime >= '" + begin + "' and");
			}
			else{
				if(hql.contains("order by")) {
					hql = hql.replace("order by", "where t.createTime >= '" + begin + "' order by");
				} else {
					hql = hql + " where t.createTime >= '" + begin + "'";
				}
			}
		}
		// 小于后时间
		else if(!StringUtil.isEmpty(end)){
			if(hql.contains("where"))
				hql = hql.replace("where", "where t.createTime < '" + end + "' and");
			else{
				if(hql.contains("order by")){
					hql = hql.replace("order by", "where t.createTime < '" + end + "' order by");
				} else {
					hql = hql + " where t.createTime < '" + end + "'";
				}
			}
		}
		return hql;
	}

	/**
	 * 根据ID获取
	 * @param adminId
	 * @return
	 */
	public AdminUser getAdminById(String adminId) {
		return (AdminUser) adminUserDao.findById(AdminUser.class, Long.parseLong(adminId));
	}

	/**
	 * 添加子管理员
	 * @param adminUser
	 * @return
	 */
	public String addAdmin(AdminUser adminUser_model) {
		String msg = "no";
		AdminUser adminUser = (AdminUser) adminUserDao.getResultOne("from AdminUser t where t.adminName = '" + adminUser_model.getAdminName() + "'", null);
		if(adminUser != null) {
			msg = "子管理员账号已存在!";
			return msg;
		}
		adminUser_model.setPassword(AlgorithmUtil.Md5("123123"));
		adminUser_model.setCreateTime(StringUtil.getTime());
		adminUser_model.setAdminImg(GlobalUtil.DEFALUT_IMG);
		if(adminUserDao.save(adminUser_model)) {
			msg = "success";
			return msg;
		}
		return msg;
	}

	/**
	 * 获取所有开设的课程 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TLesson> getAllLesson() {
		List<TLesson> list = (List<TLesson>) adminUserDao.getResult("from TLesson t where 1=1 order by t.lessonId", null);
		return list;
	}

	/**
	 * 更新课程信息
	 * @param lesson
	 */
	public String modifyLesson(TLesson lesson) {
		if(adminUserDao.saveOrUpdate(lesson)) {
			return "success";
		}
		return "error";
	}

	/**
	 * 分页 查询 培训订单记录
	 * @param pagenation
	 * @param mobile
	 * @param lessonName
	 * @param begin
	 * @param end
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TLessonLog> getAllLessonLogByPage(Pagenation pagenation, String userMobile, String lessonName, String begin, String end) {
		String hql = "";
		Object[] params = null;
		List<Object> list = new ArrayList<Object>();
		if(!StringUtil.isEmpty(userMobile)) {
			list.add(userMobile);
			hql += " t.userMobile" + " like '%" + userMobile + "%' and";
		}
		if(!StringUtil.isEmpty(lessonName)) {
			list.add(lessonName);
			hql += " t.lessonName" + " like '%" + lessonName + "%' and";
		}
		if(hql.length() > 0) {
			hql = "from TLessonLog t where " + hql.subSequence(0, hql.length() - 3) + " order by t.createTime desc";
		} else {
			hql = "from TLessonLog t where 1= 1 order by t.createTime desc";
		}
		hql = replaceWhere(hql, begin, end);
		MyLogUtil.print(hql);
		return (List<TLessonLog>) adminUserDao.fuzzyQueryByPage(hql, params, pagenation);
	}

	/**
	 * 统计 培训订单总数
	 * @param mobile
	 * @param lessonName
	 * @param begin
	 * @param end
	 * @return
	 */
	public int countAllLessonLog(String userMobile, String lessonName, String begin, String end) {
		String hql = "";
		Object[] params = null;
		List<Object> list = new ArrayList<Object>();
		if(!StringUtil.isEmpty(userMobile)) {
			list.add(userMobile);
			hql += " t.userMobile" + " like '%" + userMobile + "%' and";
		}
		if(!StringUtil.isEmpty(lessonName)) {
			list.add(lessonName);
			hql += " t.lessonName" + " like '%" + lessonName + "%' and";
		}
		if(hql.length() > 0) {
			hql = "select count(*) from TLessonLog t where " + hql.subSequence(0, hql.length() - 3) + " order by t.createTime desc";
		} else {
			hql = "select count(*) from TLessonLog t where 1= 1 order by t.createTime desc";
		}
		hql = replaceWhere(hql, begin, end);
		MyLogUtil.print(hql);
		return adminUserDao.fuzzyResultCount(hql, params);
	}

	/**
	 * 根据ID  删除 培训订单 
	 * @param lessonLogId
	 * @return
	 */
	public boolean deleteOrder(String lessonLogId) {
		int flag = adminUserDao.nativeUpdate("delete from t_lesson_log where LESSON_LOG_ID = " + Long.parseLong(lessonLogId.trim()));
		return flag == 0 ? false : true;
	}

	/**
	 * 生成培训数据统计列表
	 * @param list_lesson
	 * @return
	 */
	public List<TLessonDataCount> lessonDataCount(List<TLesson> list_lesson) {
		Gson gson = new Gson();
		List<TLessonDataCount> list =  new ArrayList<>();
		
		//I have no idea to deal this Object well, So I use the fool way to make it work↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
		//得到每个课程的id 与 总收入表
		List list_moneyAmount = adminUserDao.getResult("select lessonId, sum(realPrice) as amount_money from TLessonLog t group by t.lessonId order by t.lessonLogId", null);
		//转换为gson
		String data = gson.toJson(list_moneyAmount).substring(2, gson.toJson(list_moneyAmount).length()-2);
		//转换为数组
		String[] datas = data.split("\\],\\[");
		HashMap<String, String> id_money = new HashMap<>();
		//循环数组取值
		for(int i=0; i<datas.length; i++) {
//			System.out.println(datas[i]);
			//以下为打印结果
			//1,"47997"
			//2,"50997"
			//3,"37998"
			//分隔数据
			String[] all = datas[i].split(",");
			//前者为lessonId
			String id = all[0];
			//后者为该ID对应培训收到的钱总数
			String money = all[1].substring(1, all[1].length()-1);
			id_money.put(id, money);
		}
		
		for(int i=0; i<list_lesson.size(); i++) {
			TLessonDataCount count = new TLessonDataCount();
			//报名总人数
			int number = adminUserDao.fuzzyResultCount("select count(*) from TLessonLog t where t.lessonId = " + list_lesson.get(i).getLessonId(), null);
			count.setLessonId(list_lesson.get(i).getLessonId());
			count.setLessonTitle(list_lesson.get(i).getLessonTitle());
			count.setLessonBeginDate(list_lesson.get(i).getLessonBeginDate());
			count.setTeacherIntroduce(list_lesson.get(i).getTeacherIntroduce());
			count.setNumberOfPeople(number + "");
			count.setMoneyAmount(id_money.get(list_lesson.get(i).getLessonId() + ""));
			list.add(count);
		}
		return list;
	}

	/**
	 * 根据 ID 查询 TLessonLog
	 * @param lessonLogId
	 * @return
	 */
	public TLessonLog getLessonLogById(String lessonLogId) {
		TLessonLog lessonLog = (TLessonLog) adminUserDao.getResultOne("from TLessonLog t where t.lessonLogId = ?", new Object[]{Long.parseLong(lessonLogId)});
		return lessonLog;
	}

	/**
	 * @param lessonId
	 * @return
	 */
	public TLesson getLessonById(String lessonId) {
		TLesson lesson = (TLesson) adminUserDao.getResultOne("from TLesson t where t.lessonId = ?", new Object[]{Long.parseLong(lessonId)});
		return lesson;
	}

	/**
	 * @param lessonId
	 * @return
	 */
	public boolean deleteLesson(String lessonId) {
		int flag = adminUserDao.nativeUpdate("delete from t_lesson where LESSON_ID = " + Long.parseLong(lessonId.trim()));
		return flag == 0 ? false : true;
	}

	/**
	 * @param lesson
	 * @return
	 */
	public boolean addLesson(TLesson lesson) {
		if(adminUserDao.save(lesson)) {
			return true;
		}
		return false;
	}

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TVip> getAllVip() {
		return (List<TVip>) adminUserDao.getResult("from TVip t", null);
	}

	/**
	 * @param fee
	 */
	public boolean modifyVip(String fee) {
		int flag = adminUserDao.nativeUpdate("update t_vip set FEE = '" + fee + "' where T_VIP_ID = " + Long.parseLong("1"));
		return flag == 0 ? false : true;
	}


	
	
}
