package com.dale.ms.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dale.ms.dao.AdminUserDao;
import com.dale.ms.dao.SchoolDao;
import com.dale.ms.entities.TSchool;
import com.dale.ms.entities.TSchoolMajor;
import com.dale.ms.entities.TUser;
import com.dale.ms.model.Pagenation;
import com.dale.ms.utils.MyLogUtil;
import com.dale.ms.utils.StringUtil;
import com.google.gson.JsonElement;

/**
 * 
 * @author Dale'
 * @date 2016-3-2 下午12:12:48
 * @description
 */
@Service("schoolService")
public class SchoolService {

	@Autowired
	@Qualifier("schoolDao")
	private SchoolDao schoolDao;
	
	/**
	 * 分页查询所有学校
	 * @param pagenation
	 * @param condition
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TSchool> getAllByPage(Pagenation pagenation, String condition, String value) {
		String hql = "";
		Object[] params = null;
//		List<Object> list = new ArrayList<>();
		if(!StringUtil.isEmpty(value) && !StringUtil.isEmpty(condition)) {
			hql += " t." + condition + " like '%" + value + "%' and";
		}
		if(hql.length() > 0) {
			hql = "from TSchool t where" + hql.subSequence(0, hql.length() - 3) + " order by t.schoolCode";
		} else {
			hql = "from TSchool t order by t.schoolCode";
		}
		MyLogUtil.print(hql);
		return (List<TSchool>) schoolDao.fuzzyQueryByPage(hql, params, pagenation);
	}

	/**
	 * 查询记录数
	 * @param condition
	 * @param value
	 * @return
	 */
	public int countAll(String condition, String value) {
		String hql = "";
		Object[] params = null;
//		List<Object> list = new ArrayList<Object>();
		if(!StringUtil.isEmpty(value) && !StringUtil.isEmpty(condition)) {
			hql += " t." + condition + " like '%" + value + "%' and";
		}
		if(hql.length() > 0) {
			hql = "select count(*) from TSchool t where" + hql.subSequence(0, hql.length() - 3) + " order by t.schoolCode";
		} else {
			hql = "select count(*) from TSchool t order by t.schoolCode";
		}
		MyLogUtil.print(hql);
		return schoolDao.fuzzyResultCount(hql, params);
	}

	/**
	 * 添加学校
	 * @param school
	 * @return
	 */
	public String addSchool(TSchool school_model) {
		String msg = "";
		String hql = "from TSchool t where t.schoolCode = '" + school_model.getSchoolCode() + "'";
		TSchool school = (TSchool) schoolDao.getResultOne(hql, null);
		String hql_2 = "from TSchool t where t.schoolName = '" + school_model.getSchoolName() + "'";
		TSchool school_2 = (TSchool) schoolDao.getResultOne(hql_2, null);
		if(school != null && school_2 != null) {
			msg = "该学校代码与校名都已存在！";
		} else if(school != null) {
			msg = "该学校代码已存在！";
		} else if(school_2 != null) {
			msg = "该学校校名已存在！";
		} else if(school == null && school_2 == null) {
			if(schoolDao.save(school_model)) {
				msg = "success";
			} else {
				msg = "未知错误！";
			}
		}
		return msg;
	}

	/**
	 * 删除学校
	 * @param schoolId
	 * @return
	 */
	public boolean delete(String schoolId) {
		int flag = schoolDao.nativeUpdate("delete from t_school where SCHOOL_ID = " + Long.parseLong(schoolId.trim()));
		return flag == 0 ? false : true;
	}

	/**
	 * 根据ID查找
	 * @param schoolId
	 * @return
	 */
	public TSchool getSchoolById(String schoolId) {
		TSchool school = (TSchool) schoolDao.findById(TSchool.class, Long.parseLong(schoolId.trim()));
		return school;
	}
	
	/**
	 * 根据schoolCode查找学校
	 * @param schoolCode
	 * @return
	 */
	public TSchool getSchoolByCode(String schoolCode) {
		return (TSchool) schoolDao.getResultOne("From TSchool t where 1=1 and t.schoolCode = ?", new Object[] {schoolCode});
	}

	/**
	 * @param school_model
	 * @return
	 */
	public String modifySchool(TSchool school_model) {
		String msg = "ERROR";
		if(schoolDao.saveOrUpdate(school_model)) {
			msg = "success";
		}
		return msg;
	}

	/**
	 * 用户查询学校/专业
	 * @param search_value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TSchool> getSchoolBySearch(String search_value) {
		StringBuffer hql = new StringBuffer("from TSchool t where 1 = 1");
		if(!StringUtil.isEmpty(search_value)){
			hql.append(" and"); 
			hql.append(" t.schoolName like '%");
			hql.append(search_value);
			hql.append("%' order by t.schoolCode");
		}
		System.out.println(hql.toString());
		return (List<TSchool>) schoolDao.getResult(hql.toString(), null);
	}

	/**获取所有开设该专业的学校
	 * @param majorCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TSchool> getSchoolByMajorCodeByPage(Pagenation pagenation, String majorCode) {
		List<TSchoolMajor> list_sm = (List<TSchoolMajor>) schoolDao.getResult("from TSchoolMajor t where 1=1 and t.majorCode = ?", new Object[] {majorCode});
		List<TSchool> list_school_all = new ArrayList<>();
		List<TSchool> list_school = new ArrayList<>();
		for(TSchoolMajor t : list_sm) {
			String schoolCode = t.getSchoolCode();
			TSchool s = (TSchool) schoolDao.getResultOne("from TSchool t where 1=1 and t.schoolCode = ?", new Object[]{schoolCode});
			list_school_all.add(s);
		}
		//每页10个 分页显示
		int page = pagenation.getPage();
		//将 包含所有学校的列表，按照10个一组放入list_school
		for(int i=(page-1)*10; i<page*10; i++) {
			if(list_school_all.size() >= i+1) {
				list_school.add(list_school_all.get(i));
			}
		}
		
		return list_school;
	}

	/**
	 * 统计所有开设该专业的学校的总数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int countAllSchool(String majorCode) {
		List<TSchoolMajor> list_sm = (List<TSchoolMajor>) schoolDao.getResult("from TSchoolMajor t where 1=1 and t.majorCode = ?", new Object[] {majorCode});
		List<TSchool> list_school_all = new ArrayList<>();
		for(TSchoolMajor t : list_sm) {
			String schoolCode = t.getSchoolCode();
			TSchool s = (TSchool) schoolDao.getResultOne("from TSchool t where 1=1 and t.schoolCode = ?", new Object[]{schoolCode});
			list_school_all.add(s);
		}
		return list_school_all.size();
	}

	/**
	 * 写入Excel 中单个school
	 * @return
	 */
	public boolean importSchool(TSchool school) {
		//判断代码是否存在
		String hql = "from TSchool t where t.schoolCode = '" + school.getSchoolCode() + "'";
		TSchool s = (TSchool) schoolDao.getResultOne(hql, null);
		if(s != null) {
			return false;
		}
		return schoolDao.saveOrUpdate(school);
	}


	

	
	
	
	
}
