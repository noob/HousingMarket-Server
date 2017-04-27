package com.dale.ms.service;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dale.ms.dao.AdminUserDao;
import com.dale.ms.dao.MajorDao;
import com.dale.ms.dao.SchoolDao;
import com.dale.ms.entities.RecommendAnswer;
import com.dale.ms.entities.TMajor;
import com.dale.ms.entities.TMajorQuestion;
import com.dale.ms.entities.TSchool;
import com.dale.ms.entities.TSchoolMajor;
import com.dale.ms.model.Pagenation;
import com.dale.ms.utils.MapUtil;
import com.dale.ms.utils.MyLogUtil;
import com.dale.ms.utils.StringUtil;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.google.gson.JsonElement;

/**
 * 
 * @author Dale'
 * @date 2016-3-2 下午12:12:48
 * @description
 */
@Service("majorService")
public class MajorService {

	@Autowired
	@Qualifier("majorDao")
	private MajorDao majorDao;

	/**
	 * 分页查询所有专业
	 * @param pagenation
	 * @param condition
	 * @param value
	 * @param subject1
	 * @param subject2
	 * @param subject3
	 * @param department
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TMajor> getAllMajorByPage(Pagenation pagenation, String condition, String value, String department) {
		String hql = "";
		Object[] params = null;
		List<Object> list = new ArrayList<>();
		// condition value
		if(!StringUtil.isEmpty(condition) && !StringUtil.isEmpty(value)) {
			hql += " t." + condition + " like '%" + value + "%' and";
		}
		if(hql.length() > 0) {
			hql = "from TMajor t where" + hql.subSequence(0, hql.length() - 3) + " order by t.majorCode";
			params = list.toArray();
		} else {
			hql = "from TMajor t order by t.majorCode";
		}
		MyLogUtil.print(hql);
		return (List<TMajor>) majorDao.fuzzyQueryByPage(hql, params, pagenation);
	}
	
	/**
	 * 查询所有专业记录数
	 * @param condition
	 * @param value
	 * @param subject1
	 * @param subject2
	 * @param subject3
	 * @param department
	 * @return
	 */
	public int countAllMajor(String condition, String value, String department) {
		String hql = "";
		Object[] params = null;
		List<Object> list = new ArrayList<Object>();
		// condition value
		if(!StringUtil.isEmpty(condition) && !StringUtil.isEmpty(value)) {
			hql += " t." + condition + " like '%" + value + "%' and";
		}
		if(hql.length() > 0) {
			hql = "select count(*) from TMajor t where" + hql.subSequence(0, hql.length() - 3) + " order by t.majorCode";
			params = list.toArray();
		} else {
			hql = "select count(*) from TMajor t order by t.majorCode";
		}
		MyLogUtil.print(hql);
		return majorDao.fuzzyResultCount(hql, params);
	}
	
	/**
	 * 分页查询所有学校-专业
	 * @param pagenation
	 * @param condition
	 * @param value
	 * @param level
	 * @param recommend
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TSchoolMajor> getAllByPage(Pagenation pagenation, String value, String value_major, String value_schoolRegion,  String level, String isKey, String department, String subject1, String subject2, String subject3) {
		String hql = "";
		Object[] params = null;
		List<Object> list = new ArrayList<>();
		
		//全部
		if(!StringUtil.isEmpty(value_major) && !StringUtil.isEmpty(value) && !StringUtil.isEmpty(value_schoolRegion) && !StringUtil.isEmpty(subject1) && !StringUtil.isEmpty(subject2) && !StringUtil.isEmpty(subject3)) {
			hql += " t.schoolName like '%" + value + "%' and t.subject like '%" + subject1 + "%' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + subject2 + "%' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + subject3 + "%' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%不限%' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject1 + "，" + subject2 + "' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject2 + "，" + subject1 + "' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject1 + "，" + subject3 + "' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject3 + "，" + subject1+ "' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject2 + "，" + subject3+ "' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject3 + "，" + subject2+ "' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.schoolName like '%" + value + "%' and  t.subject like '%" + subject1 + "%' and t.subject like '%" + subject2 + "%' and t.subject like '%" + subject3 + "' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' and";
		}
		//school major subject
		else if(!StringUtil.isEmpty(value_major) && !StringUtil.isEmpty(value) && !StringUtil.isEmpty(subject1) && !StringUtil.isEmpty(subject2) && !StringUtil.isEmpty(subject3)) {
			hql += " t.schoolName like '%" + value + "%' and t.subject like '%" + subject1 + "%' and t.majorName like '%" + value_major
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + subject2 + "%' and t.majorName like '%" + value_major
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + subject3 + "%' and t.majorName like '%" + value_major
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + "不限" + "%' and t.majorName like '%" + value_major
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject1 + "，" + subject2 + "' and t.majorName like '%" + value_major
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject2 + "，" + subject1 + "' and t.majorName like '%" + value_major
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject1 + "，" + subject3 + "' and t.majorName like '%" + value_major
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject3 + "，" + subject1+ "' and t.majorName like '%" + value_major
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject2 + "，" + subject3+ "' and t.majorName like '%" + value_major
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject3 + "，" + subject2+ "' and t.majorName like '%" + value_major
//					+ "%' or t.schoolName like '%" + value + "%' and  t.subject like '%" + subject1 + "%' and t.subject like '%" + subject2 + "%' and t.subject like '%" + subject3 + "' and t.majorName like '%" + value_major 
					+ "%' and";
		}
		// school major region
		else if(!StringUtil.isEmpty(value_major) && !StringUtil.isEmpty(value)  && !StringUtil.isEmpty(value_schoolRegion)) {
			hql += " t.schoolName like '%" + value + "%' and t.schoolRegion like '%" + value_schoolRegion + "%' and t.majorName like '%" + value_major 
					+ "%' and";
		}
		// school region subject
		else if(!StringUtil.isEmpty(value_schoolRegion) && !StringUtil.isEmpty(value) && !StringUtil.isEmpty(subject1) && !StringUtil.isEmpty(subject2) && !StringUtil.isEmpty(subject3)) {
			hql += " t.schoolName like '%" + value + "%' and t.subject like '%" + subject1 + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + subject2 + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + subject3 + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + "不限" + "%' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject1 + "，" + subject2 + "' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject2 + "，" + subject1 + "' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject1 + "，" + subject3 + "' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject3 + "，" + subject1+ "' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject2 + "，" + subject3+ "' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject3 + "，" + subject2+ "' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.schoolName like '%" + value + "%' and  t.subject like '%" + subject1 + "%' and t.subject like '%" + subject2 + "%' and t.subject like '%" + subject3 + "' and t.schoolRegion like '%" + value_schoolRegion 
					+ "%' and";
		}
		// major region subject
		else if(!StringUtil.isEmpty(value_schoolRegion) && !StringUtil.isEmpty(value_major) && !StringUtil.isEmpty(subject1) && !StringUtil.isEmpty(subject2) && !StringUtil.isEmpty(subject3)) {
			hql += " t.majorName like '%" + value_major + "%' and t.subject like '%" + subject1 + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.majorName like '%" + value_major + "%' and t.subject like '%" + subject2 + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.majorName like '%" + value_major + "%' and t.subject like '%" + subject3 + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.majorName like '%" + value_major + "%' and t.subject like '%" + "不限" + "%' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject1 + "，" + subject2 + "' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject2 + "，" + subject1 + "' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject1 + "，" + subject3 + "' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject3 + "，" + subject1+ "' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject2 + "，" + subject3+ "' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject3 + "，" + subject2+ "' and t.schoolRegion like '%" + value_schoolRegion
//					+ "%' or t.majorName like '%" + value_major + "%' and  t.subject like '%" + subject1 + "%' and t.subject like '%" + subject2 + "%' and t.subject like '%" + subject3 + "' and t.schoolRegion like '%" + value_schoolRegion 
					+ "%' and";
		}
		//value subject
		else if(!StringUtil.isEmpty(value) && !StringUtil.isEmpty(subject1) && !StringUtil.isEmpty(subject2) && !StringUtil.isEmpty(subject3)) {
			hql += " t.schoolName like '%" + value + "%' and t.subject like '%" + subject1 
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + subject2
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + subject3 
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + "不限" 
//					+ "' or t.schoolName like '%" + value + "%' and t.subject = '" + subject1 + "，" + subject2 
//					+ "' or t.schoolName like '%" + value + "%' and t.subject = '" + subject2 + "，" + subject1 
//					+ "' or t.schoolName like '%" + value + "%' and t.subject = '" + subject1 + "，" + subject3 
//					+ "' or t.schoolName like '%" + value + "%' and t.subject = '" + subject3 + "，" + subject1
//					+ "' or t.schoolName like '%" + value + "%' and t.subject = '" + subject2 + "，" + subject3
//					+ "' or t.schoolName like '%" + value + "%' and t.subject = '" + subject3 + "，" + subject2
//					+ "' or t.schoolName like '%" + value + "%' and  t.subject like '%" + subject1 + "%' and t.subject like '%" + subject2 + "%' and t.subject like '%" + subject3 
					+ "%' and";
		}
		//major subject
		else if(!StringUtil.isEmpty(value_major) && !StringUtil.isEmpty(subject1) && !StringUtil.isEmpty(subject2) && !StringUtil.isEmpty(subject3)) {
			hql += " t.majorName like '%" + value_major + "%' and t.subject like '%" + subject1 
					+ "%' or t.majorName like '%" + value_major + "%' and t.subject like '%" + subject2
					+ "%' or t.majorName like '%" + value_major + "%' and t.subject like '%" + subject3 
					+ "%' or t.majorName like '%" + value_major + "%' and t.subject like '%不限" 
//					+ "' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject1 + "，" + subject2 
//					+ "' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject2 + "，" + subject1 
//					+ "' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject1 + "，" + subject3 
//					+ "' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject3 + "，" + subject1
//					+ "' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject2 + "，" + subject3
//					+ "' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject3 + "，" + subject2
//					+ "' or t.majorName like '%" + value_major + "%' and  t.subject like '%" + subject1 + "%' and t.subject like '%" + subject2 + "%' and t.subject like '%" + subject3 
					+ "%' and";
		}
		//region subject
		else if(!StringUtil.isEmpty(value_schoolRegion) && !StringUtil.isEmpty(subject1) && !StringUtil.isEmpty(subject2) && !StringUtil.isEmpty(subject3)) {
			hql += " t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject like '%" + subject1 
					+ "%' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject like '%" + subject2
					+ "%' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject like '%" + subject3 
					+ "%' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject like '%" + "不限" 
//					+ "' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject = '" + subject1 + "，" + subject2 
//					+ "' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject = '" + subject2 + "，" + subject1 
//					+ "' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject = '" + subject1 + "，" + subject3 
//					+ "' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject = '" + subject3 + "，" + subject1
//					+ "' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject = '" + subject2 + "，" + subject3
//					+ "' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject = '" + subject3 + "，" + subject2
//					+ "' or t.schoolRegion like '%" + value_schoolRegion + "%' and  t.subject like '%" + subject1 + "%' and t.subject like '%" + subject2 + "%' and t.subject like '%" + subject3 
					+ "%' and";
		}
		//major value
		else if(!StringUtil.isEmpty(value_major) && !StringUtil.isEmpty(value)) {
			hql += " t.majorName like '%" + value_major + "%' and t.schoolName like '%" + value 
					+ "%' and";
		}
		//major region
		else if(!StringUtil.isEmpty(value_major) && !StringUtil.isEmpty(value_schoolRegion)) {
			hql += " t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion 
					+ "%' and";
		}
		//value region
		else if(!StringUtil.isEmpty(value) && !StringUtil.isEmpty(value_schoolRegion)) {
			hql += " t.schoolName like '%" + value + "%' and t.schoolRegion like '%" + value_schoolRegion 
					+ "%' and";
		}
		// value
		else if(!StringUtil.isEmpty(value)) {
			hql += " t.schoolName like '%" + value 
					+ "%' and";
		}
		// subject
		else if(!StringUtil.isEmpty(subject1) && !StringUtil.isEmpty(subject2) && !StringUtil.isEmpty(subject3)) {
			hql += " t.subject like '%" + subject1
					+ "%' or t.subject like '%" + subject2
					+ "%' or t.subject like '%" + subject3
					+ "%' or t.subject like '%不限" 
//					+ "' or t.subject = '" + subject1 + "，" + subject2 
//					+ "' or t.subject = '" + subject2 + "，" + subject1 
//					+ "' or t.subject = '" + subject1 + "，" + subject3 
//					+ "' or t.subject = '" + subject3 + "，" + subject1
//					+ "' or t.subject = '" + subject2 + "，" + subject3
//					+ "' or t.subject = '" + subject3 + "，" + subject2
//					+ "' or t.subject like '%" + subject1 + "%' and t.subject like '%" + subject2 + "%' and t.subject like '%" + subject3 
					+ "%' and";
		} 
		// majorName	
		else if(!StringUtil.isEmpty(value_major)) {
			hql += " t.majorName like '%" + value_major 
					+ "%' and";
		}
		//region
		else if(!StringUtil.isEmpty(value_schoolRegion)) {
			hql += " t.schoolRegion like '%" + value_schoolRegion 
					+ "%' and";
		}
		
		if(hql.length() > 0) {
			hql = "from TSchoolMajor t where" + hql.subSequence(0, hql.length() - 3) + " order by t.recommend desc";
			params = list.toArray();
		} else {
			hql = "from TSchoolMajor t order by t.recommend desc";
		}
		MyLogUtil.print(hql);
		return (List<TSchoolMajor>) majorDao.fuzzyQueryByPage(hql, params, pagenation);
	}

	/**
	 * 查询学校-专业记录数
	 * @param condition
	 * @param value
	 * @param level
	 * @param recommend
	 * @return
	 */
	public int countAll(String value, String value_major, String value_schoolRegion, String level, String isKey, String department, String subject1, String subject2, String subject3) {
		String hql = "";
		Object[] params = null;
		List<Object> list = new ArrayList<Object>();
		//全部
		if(!StringUtil.isEmpty(value_major) && !StringUtil.isEmpty(value) && !StringUtil.isEmpty(value_schoolRegion) && !StringUtil.isEmpty(subject1) && !StringUtil.isEmpty(subject2) && !StringUtil.isEmpty(subject3)) {
			hql += " t.schoolName like '%" + value + "%' and t.subject like '%" + subject1 + "%' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + subject2 + "%' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + subject3 + "%' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%不限%' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject1 + "，" + subject2 + "' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject2 + "，" + subject1 + "' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject1 + "，" + subject3 + "' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject3 + "，" + subject1+ "' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject2 + "，" + subject3+ "' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject3 + "，" + subject2+ "' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.schoolName like '%" + value + "%' and  t.subject like '%" + subject1 + "%' and t.subject like '%" + subject2 + "%' and t.subject like '%" + subject3 + "' and t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' and";
		}
		//school major subject
		else if(!StringUtil.isEmpty(value_major) && !StringUtil.isEmpty(value) && !StringUtil.isEmpty(subject1) && !StringUtil.isEmpty(subject2) && !StringUtil.isEmpty(subject3)) {
			hql += " t.schoolName like '%" + value + "%' and t.subject like '%" + subject1 + "%' and t.majorName like '%" + value_major
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + subject2 + "%' and t.majorName like '%" + value_major
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + subject3 + "%' and t.majorName like '%" + value_major
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + "不限" + "%' and t.majorName like '%" + value_major
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject1 + "，" + subject2 + "' and t.majorName like '%" + value_major
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject2 + "，" + subject1 + "' and t.majorName like '%" + value_major
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject1 + "，" + subject3 + "' and t.majorName like '%" + value_major
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject3 + "，" + subject1+ "' and t.majorName like '%" + value_major
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject2 + "，" + subject3+ "' and t.majorName like '%" + value_major
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject3 + "，" + subject2+ "' and t.majorName like '%" + value_major
//							+ "%' or t.schoolName like '%" + value + "%' and  t.subject like '%" + subject1 + "%' and t.subject like '%" + subject2 + "%' and t.subject like '%" + subject3 + "' and t.majorName like '%" + value_major 
					+ "%' and";
		}
		// school major region
		else if(!StringUtil.isEmpty(value_major) && !StringUtil.isEmpty(value)  && !StringUtil.isEmpty(value_schoolRegion)) {
			hql += " t.schoolName like '%" + value + "%' and t.schoolRegion like '%" + value_schoolRegion + "%' and t.majorName like '%" + value_major 
					+ "%' and";
		}
		// school region subject
		else if(!StringUtil.isEmpty(value_schoolRegion) && !StringUtil.isEmpty(value) && !StringUtil.isEmpty(subject1) && !StringUtil.isEmpty(subject2) && !StringUtil.isEmpty(subject3)) {
			hql += " t.schoolName like '%" + value + "%' and t.subject like '%" + subject1 + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + subject2 + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + subject3 + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + "不限" + "%' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject1 + "，" + subject2 + "' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject2 + "，" + subject1 + "' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject1 + "，" + subject3 + "' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject3 + "，" + subject1+ "' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject2 + "，" + subject3+ "' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.schoolName like '%" + value + "%' and t.subject = '" + subject3 + "，" + subject2+ "' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.schoolName like '%" + value + "%' and  t.subject like '%" + subject1 + "%' and t.subject like '%" + subject2 + "%' and t.subject like '%" + subject3 + "' and t.schoolRegion like '%" + value_schoolRegion 
					+ "%' and";
		}
		// major region subject
		else if(!StringUtil.isEmpty(value_schoolRegion) && !StringUtil.isEmpty(value_major) && !StringUtil.isEmpty(subject1) && !StringUtil.isEmpty(subject2) && !StringUtil.isEmpty(subject3)) {
			hql += " t.majorName like '%" + value_major + "%' and t.subject like '%" + subject1 + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.majorName like '%" + value_major + "%' and t.subject like '%" + subject2 + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.majorName like '%" + value_major + "%' and t.subject like '%" + subject3 + "%' and t.schoolRegion like '%" + value_schoolRegion
					+ "%' or t.majorName like '%" + value_major + "%' and t.subject like '%" + "不限" + "%' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject1 + "，" + subject2 + "' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject2 + "，" + subject1 + "' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject1 + "，" + subject3 + "' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject3 + "，" + subject1+ "' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject2 + "，" + subject3+ "' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject3 + "，" + subject2+ "' and t.schoolRegion like '%" + value_schoolRegion
//							+ "%' or t.majorName like '%" + value_major + "%' and  t.subject like '%" + subject1 + "%' and t.subject like '%" + subject2 + "%' and t.subject like '%" + subject3 + "' and t.schoolRegion like '%" + value_schoolRegion 
					+ "%' and";
		}
		//value subject
		else if(!StringUtil.isEmpty(value) && !StringUtil.isEmpty(subject1) && !StringUtil.isEmpty(subject2) && !StringUtil.isEmpty(subject3)) {
			hql += " t.schoolName like '%" + value + "%' and t.subject like '%" + subject1 
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + subject2
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + subject3 
					+ "%' or t.schoolName like '%" + value + "%' and t.subject like '%" + "不限" 
//							+ "' or t.schoolName like '%" + value + "%' and t.subject = '" + subject1 + "，" + subject2 
//							+ "' or t.schoolName like '%" + value + "%' and t.subject = '" + subject2 + "，" + subject1 
//							+ "' or t.schoolName like '%" + value + "%' and t.subject = '" + subject1 + "，" + subject3 
//							+ "' or t.schoolName like '%" + value + "%' and t.subject = '" + subject3 + "，" + subject1
//							+ "' or t.schoolName like '%" + value + "%' and t.subject = '" + subject2 + "，" + subject3
//							+ "' or t.schoolName like '%" + value + "%' and t.subject = '" + subject3 + "，" + subject2
//							+ "' or t.schoolName like '%" + value + "%' and  t.subject like '%" + subject1 + "%' and t.subject like '%" + subject2 + "%' and t.subject like '%" + subject3 
					+ "%' and";
		}
		//major subject
		else if(!StringUtil.isEmpty(value_major) && !StringUtil.isEmpty(subject1) && !StringUtil.isEmpty(subject2) && !StringUtil.isEmpty(subject3)) {
			hql += " t.majorName like '%" + value_major + "%' and t.subject like '%" + subject1 
					+ "%' or t.majorName like '%" + value_major + "%' and t.subject like '%" + subject2
					+ "%' or t.majorName like '%" + value_major + "%' and t.subject like '%" + subject3 
					+ "%' or t.majorName like '%" + value_major + "%' and t.subject like '%不限" 
//							+ "' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject1 + "，" + subject2 
//							+ "' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject2 + "，" + subject1 
//							+ "' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject1 + "，" + subject3 
//							+ "' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject3 + "，" + subject1
//							+ "' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject2 + "，" + subject3
//							+ "' or t.majorName like '%" + value_major + "%' and t.subject = '" + subject3 + "，" + subject2
//							+ "' or t.majorName like '%" + value_major + "%' and  t.subject like '%" + subject1 + "%' and t.subject like '%" + subject2 + "%' and t.subject like '%" + subject3 
					+ "%' and";
		}
		//region subject
		else if(!StringUtil.isEmpty(value_schoolRegion) && !StringUtil.isEmpty(subject1) && !StringUtil.isEmpty(subject2) && !StringUtil.isEmpty(subject3)) {
			hql += " t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject like '%" + subject1 
					+ "%' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject like '%" + subject2
					+ "%' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject like '%" + subject3 
					+ "%' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject like '%" + "不限" 
//							+ "' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject = '" + subject1 + "，" + subject2 
//							+ "' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject = '" + subject2 + "，" + subject1 
//							+ "' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject = '" + subject1 + "，" + subject3 
//							+ "' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject = '" + subject3 + "，" + subject1
//							+ "' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject = '" + subject2 + "，" + subject3
//							+ "' or t.schoolRegion like '%" + value_schoolRegion + "%' and t.subject = '" + subject3 + "，" + subject2
//							+ "' or t.schoolRegion like '%" + value_schoolRegion + "%' and  t.subject like '%" + subject1 + "%' and t.subject like '%" + subject2 + "%' and t.subject like '%" + subject3 
					+ "%' and";
		}
		//major value
		else if(!StringUtil.isEmpty(value_major) && !StringUtil.isEmpty(value)) {
			hql += " t.majorName like '%" + value_major + "%' and t.schoolName like '%" + value 
					+ "%' and";
		}
		//major region
		else if(!StringUtil.isEmpty(value_major) && !StringUtil.isEmpty(value_schoolRegion)) {
			hql += " t.majorName like '%" + value_major + "%' and t.schoolRegion like '%" + value_schoolRegion 
					+ "%' and";
		}
		//value region
		else if(!StringUtil.isEmpty(value) && !StringUtil.isEmpty(value_schoolRegion)) {
			hql += " t.schoolName like '%" + value + "%' and t.schoolRegion like '%" + value_schoolRegion 
					+ "%' and";
		}
		// value
		else if(!StringUtil.isEmpty(value)) {
			hql += " t.schoolName like '%" + value 
					+ "%' and";
		}
		// subject
		else if(!StringUtil.isEmpty(subject1) && !StringUtil.isEmpty(subject2) && !StringUtil.isEmpty(subject3)) {
			hql += " t.subject like '%" + subject1
					+ "%' or t.subject like '%" + subject2
					+ "%' or t.subject like '%" + subject3
					+ "%' or t.subject like '%不限" 
//							+ "' or t.subject = '" + subject1 + "，" + subject2 
//							+ "' or t.subject = '" + subject2 + "，" + subject1 
//							+ "' or t.subject = '" + subject1 + "，" + subject3 
//							+ "' or t.subject = '" + subject3 + "，" + subject1
//							+ "' or t.subject = '" + subject2 + "，" + subject3
//							+ "' or t.subject = '" + subject3 + "，" + subject2
//							+ "' or t.subject like '%" + subject1 + "%' and t.subject like '%" + subject2 + "%' and t.subject like '%" + subject3 
					+ "%' and";
		} 
		// majorName	
		else if(!StringUtil.isEmpty(value_major)) {
			hql += " t.majorName like '%" + value_major 
					+ "%' and";
		}
		//region
		else if(!StringUtil.isEmpty(value_schoolRegion)) {
			hql += " t.schoolRegion like '%" + value_schoolRegion 
					+ "%' and";
		}
		if(hql.length() > 0) {
			hql = "select count(*) from TSchoolMajor t where" + hql.subSequence(0, hql.length() - 3) + " order by t.recommend desc";
		} else {
			hql = "select count(*) from TSchoolMajor t order by t.recommend desc";
		}
		MyLogUtil.print(hql);
		return majorDao.fuzzyResultCount(hql, params);
	}

	/**
	 * 根据ID删除专业
	 * @param majorId
	 * @return
	 */
	public boolean delete(String majorId) {
		int flag = majorDao.nativeUpdate("delete from t_major where Major_ID = " + Long.parseLong(majorId.trim()));
		return flag == 0 ? false : true;
	}
	
	/**
	 * 根据ID删除学校-专业
	 * @param majorId
	 * @return
	 */
	public boolean deleteSchoolMajor(String schoolMajorId) {
		int flag = majorDao.nativeUpdate("delete from t_school_major where SCHOOL_Major_ID = " + Long.parseLong(schoolMajorId.trim()));
		return flag == 0 ? false : true;
	}

	/**
	 * 添加专业
	 * @param major_model
	 * @return
	 */
	public String addMajor(TMajor major_model) {
		String msg = "ERROR";
		//查询是否有此专业代码的专业存在
		String hql = "from TMajor t where t.majorCode = '" + major_model.getMajorCode() + "'";
		TMajor major = (TMajor) majorDao.getResultOne(hql, null);
		//查询是否有此专业名字的专业存在
		String hql_2 = "from TMajor t where t.majorName = '" + major_model.getMajorName() + "'";
		TMajor major_2 = (TMajor) majorDao.getResultOne(hql_2, null);
		if(major != null) {
			msg = "该专业代码已存在！";
			return msg;
		}
		if(major_2 != null) {
			msg = "该专业名字已存在！";
			return msg;
		}
		if(majorDao.save(major_model)) {
			return "success";
		}
		return msg;
	}
	
	/**
	 * 开设学校-专业 
	 * @param school_major_model
	 * @return
	 */
	public String openMjaor(TSchoolMajor school_major_model) {
		String msg = "ERROR";
		//查询是否有此学校代码的学校存在
		String hql_2 = "from TSchool t where t.schoolCode = '" + school_major_model.getSchoolCode() + "'";
		TSchool school = (TSchool) majorDao.getResultOne(hql_2, null);
		//查询是否有此专业代码的专业存在
		String hql = "from TMajor t where t.majorCode = '" + school_major_model.getMajorCode() + "'";
		TMajor major = (TMajor) majorDao.getResultOne(hql, null);
		//在schoolCode的学校中是否已开设majorCode专业
		String hql_3 = "from TSchoolMajor t where t.majorCode = '" + school_major_model.getMajorCode() + "' and t.schoolCode = '" + school_major_model.getSchoolCode() + "'";
		TSchoolMajor school_major_3 = (TSchoolMajor) majorDao.getResultOne(hql_3, null);
		
		if(school == null) {
			msg = "该学校代码不存在！";
			return msg;
		} else if(major == null) {
			msg = "该专业代码不存在！";
			return msg;
		} else if(school_major_3 != null) {
			msg = "该学校已有此专业代码！";
			return msg;
		} else {
			String schoolName = school.getSchoolName();
			String majorName = major.getMajorName();
			school_major_model.setSchoolName(schoolName);
			school_major_model.setMajorName(majorName);
			if(majorDao.save(school_major_model)) {
				msg = "success";
				return msg;
			}
		}
		return msg;
	}

	/**
	 * 修改学校-专业
	 * @param schoolMajor
	 * @return
	 */
	public String modifySchoolMajor(TSchoolMajor schoolMajor) {
		String msg = "ERROR";
		if(majorDao.saveOrUpdate(schoolMajor)) {
			msg = "success";
			return msg;
		}
		return msg;
	}
	
	/**
	 * 根据ID查找  TMajor
	 * @param majorId
	 * @return
	 */
	public TMajor getMajorById(String majorId) {
		TMajor major = (TMajor) majorDao.findById(TMajor.class, Long.parseLong(majorId.trim()));
		return major;
	}
	
	/**
	 * 根据ID查找  TSchoolMajor
	 * @param schoolMajorId
	 * @return
	 */
	public TSchoolMajor getSchoolMajorById(String schoolMajorId) {
		TSchoolMajor schoolMajor = (TSchoolMajor) majorDao.findById(TSchoolMajor.class, Long.parseLong(schoolMajorId.trim()));
		return schoolMajor;
	}

	/**
	 * 修改School
	 * @param major
	 * @return
	 */
	public String modifyMajor(TMajor major_model) {
		String msg = "ERROR";
		if(majorDao.saveOrUpdate(major_model)) {
			msg = "success";
		}
		return msg;
	}

	/**
	 * 得到本校所有专业
	 * @param schoolId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TSchoolMajor> getAllBySchoolCode(String schoolCode) {
		List<TSchoolMajor> list = new ArrayList<>();
		String hql = "from TSchoolMajor t where t.schoolCode = '" + schoolCode + "' order by t.recommend desc";
		list = (List<TSchoolMajor>) majorDao.getResult(hql, null);
		MyLogUtil.print(hql);
		return list;
	}

	/**
	 * 根据 专业代码 获取 权重
	 * @param majorCode
	 * @return
	 */
	public TMajorQuestion getWeightByMajorCode(String majorCode) {
		String hql = "from TMajorQuestion t where t.majorCode = ?";
		MyLogUtil.print(hql);
		return (TMajorQuestion) majorDao.getResultOne(hql, new Object[]{majorCode});
	}

	/**
	 * 用户查询学校/专业
	 * @param string
	 * @param search_value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TMajor> getMajorBySearch(String search_value) {
		StringBuffer hql = new StringBuffer("from TMajor t where 1 = 1");
		if(!StringUtil.isEmpty(search_value)){
			hql.append(" and");
			hql.append(" t.majorName like '%");
			hql.append(search_value);
			hql.append("%' order by t.majorCode");
		} else {
			hql.append(" order by t.majorCode");
		}
		System.out.println(hql.toString());
		return (List<TMajor>) majorDao.getResult(hql.toString(), null);
	}

	/**
	 * 获得专业排行榜
	 * @param answer
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, List<?>> analysisData(RecommendAnswer answer) {
		Map<String, Double> map = new LinkedHashMap<>();
		List<TMajorQuestion> list = (List<TMajorQuestion>) majorDao.getResult("from TMajorQuestion t order by t.majorQuestionId", null);
		List<TMajor> list_major = new ArrayList<>();
		List<Double> list_score = new ArrayList<>();
		//将得到的result格式化小数点后3位
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(3);
		//获得每个专业的推荐分数
		for(TMajorQuestion t : list) {
			double result = t.getWeight1() * answer.getQuestion1() + t.getWeight2() * answer.getQuestion2() + t.getWeight3() * answer.getQuestion3() + t.getWeight4() * answer.getQuestion4() + t.getWeight5() * answer.getQuestion5()
					+ t.getWeight6() * answer.getQuestion6() + t.getWeight7() * answer.getQuestion7() + t.getWeight8() * answer.getQuestion8() + t.getWeight9() * answer.getQuestion9() + t.getWeight10() * answer.getQuestion10()
					+ t.getWeight11() * answer.getQuestion11() + t.getWeight12() * answer.getQuestion12() + t.getWeight13() * answer.getQuestion13() + t.getWeight14() * answer.getQuestion14() + t.getWeight15() * answer.getQuestion15()
					+ t.getWeight16() * answer.getQuestion16() + t.getWeight17() * answer.getQuestion17() + t.getWeight18() * answer.getQuestion18() + t.getWeight19() * answer.getQuestion19() + t.getWeight20() * answer.getQuestion20()
					+ t.getWeight21() * answer.getQuestion21() + t.getWeight22() * answer.getQuestion22() + t.getWeight23() * answer.getQuestion23() + t.getWeight24() * answer.getQuestion24() + t.getWeight25() * answer.getQuestion25()
					+ t.getWeight26() * answer.getQuestion26() + t.getWeight27() * answer.getQuestion27() + t.getWeight28() * answer.getQuestion28() + t.getWeight29() * answer.getQuestion29() + t.getWeight30() * answer.getQuestion30()
					+ t.getWeight31() * answer.getQuestion31() + t.getWeight32() * answer.getQuestion32() + t.getWeight33() * answer.getQuestion33() + t.getWeight34() * answer.getQuestion34() + t.getWeight35() * answer.getQuestion35()
					+ t.getWeight36() * answer.getQuestion36() + t.getWeight37() * answer.getQuestion37() + t.getWeight38() * answer.getQuestion38() + t.getWeight39() * answer.getQuestion39() + t.getWeight40() * answer.getQuestion40();
			//将得到的result格式化小数点后3位
			double f_result = Double.parseDouble(nf.format(result));
			//放入 map<majorCode, result>
			map.put(t.getMajorCode(), f_result);
		}
		//--------------------------------输出原始map 与 处理后的map开始---------------------------
//		System.out.println("原始map");
//		MapUtil.printMap(map);
		LinkedHashMap<String, Double> map_result = (LinkedHashMap<String, Double>) MapUtil.sortMapDouble(map);
//		System.out.println("结果map");
//		MapUtil.printMap(map_result);
		//--------------------------------输出原始map 与 处理后的map结束---------------------------
		for(Entry<String, Double> entry : map_result.entrySet()) {
			TMajor m = (TMajor) majorDao.getResultOne("from TMajor t where t.majorCode=?", new Object[]{entry.getKey()});
			if(m != null) {
				if(m.getIsSpecial() == 0) {
					list_major.add(m);
					list_score.add(map_result.get(entry.getKey()));
				}
			}
		}
		Map<String, List<?>> final_result = new LinkedHashMap<>();
		final_result.put("major", list_major);
		final_result.put("score", list_score);
		return final_result;
	}

	/**
	 * Excel 导入专业
	 * @param major
	 * @return
	 */
	public boolean importMajor(TMajor major) {
		//判断代码是否存在
		String hql = "from TMajor t where t.majorCode = '" + major.getMajorCode() + "'";
		TMajor m = (TMajor) majorDao.getResultOne(hql, null);
		if(m != null) {
			return false;
		}
		return majorDao.saveOrUpdate(major);
	}

	/**
	 * 根据majorCode查找专业
	 * @param majorCode
	 * @return
	 */
	public TMajor getMajorByCode(String majorCode) {
		return (TMajor) majorDao.getResultOne("From TMajor t where 1=1 and t.majorCode = ?", new Object[] {majorCode});
	}

	/**
	 * 该学校是否已开设该专业
	 * @param schoolCode
	 * @param majorCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TSchoolMajor> getSchoolMajorByDoubleCode(String schoolCode, String majorCode) {
		return (List<TSchoolMajor>) majorDao.getResult("From TSchoolMajor t where 1=1 and t.schoolCode = ? and t.majorCode = ?", new Object[] {schoolCode, majorCode});
	}

	/**Excel 导入学校-专业
	 * @param t
	 * @return
	 */
	public boolean importSchoolMajor(TSchoolMajor t) {
		return majorDao.saveOrUpdate(t);
	}

	/**
	 * 分页获取有该majorCode的TSchoolMajor
	 * @param pagenation
	 * @param majorCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TSchoolMajor> getSchoolMajorByMajorCodeByPage(Pagenation pagenation, String majorCode, String majorName, String condition, String value, String subject1, String subject2, String subject3) {
		List<TSchoolMajor> list_sm = new ArrayList<>();
		String code_hql = " (t.majorCode = '" + majorCode + "'";
		String cate_hql = " or (t.cate = '" + majorName + "'";
		String hql = "";
		// condition value
		if(!StringUtil.isEmpty(condition) && !StringUtil.isEmpty(value)) {
			hql += " and t." + condition + " like '%" + value + "%')";
		}
		
		// subject
		String subql = "";
		if(!StringUtil.isEmpty(subject3)) {
			subql += " and (t.subject like '%" + subject3 + "%' or t.subject like '%" + subject1 + "%' or t.subject like '%"  +subject2 + "%' or t.subject like '%不限%'))";
			hql = hql.replace("%')", "%'") + subql;
		}
		
		if(hql.length() > 0) {
			hql = "from TSchoolMajor t where" + code_hql + hql + cate_hql + hql + " order by t.recommend desc";
		} else {
			hql = "from TSchoolMajor t where " + code_hql + ")" + cate_hql + ")" + " order by t.recommend desc";
		}
		MyLogUtil.print(hql);
//		list_sm = (List<TSchoolMajor>) majorDao.getResult(hql, null);
//		List<TSchoolMajor> list = new ArrayList<>();
//		//每页10个 分页显示
//		int page = pagenation.getPage();
//		//将 包含所有学校的列表，按照10个一组放入list
//		for(int i=(page-1)*10; i<page*10; i++) {
//			if(list_sm.size() >= i+1) {
//				list.add(list_sm.get(i));
//			}
//		}
//		return list;
		
		return (List<TSchoolMajor>) majorDao.fuzzyQueryByPage(hql, null, pagenation);
	}

	/**
	 * 统计有该majorCode的TSchoolMajor总数
	 * @param majorCode
	 * @return
	 */
	public int countAllSchoolMajor(String majorCode, String majorName, String condition, String value, String subject1, String subject2, String subject3) {
		String code_hql = " (t.majorCode = '" + majorCode + "'";
		String cate_hql = " or (t.cate = '" + majorName + "'";
		String hql = "";
		// condition value
		if(!StringUtil.isEmpty(condition) && !StringUtil.isEmpty(value)) {
			hql += " and t." + condition + " like '%" + value + "%')";
		}
		
		// subject
		String subql = "";
		if(!StringUtil.isEmpty(subject3)) {
			subql += " and (t.subject like '%" + subject3 + "%' or t.subject like '%" + subject1 + "%' or t.subject like '%"  +subject2 + "%' or t.subject like '%不限%'))";
			hql = hql.replace("%')", "%'") + subql;
		}
		
		if(hql.length() > 0) {
			hql = "select count(*) from TSchoolMajor t where" + code_hql + hql + cate_hql + hql + " order by t.recommend desc";
		} else {
			hql = "select count(*) from TSchoolMajor t where " + code_hql + ")" + cate_hql + ")" + " order by t.recommend desc";
		}
		
		MyLogUtil.print(hql);
		return majorDao.fuzzyResultCount(hql, null);
	}

	/**
	 * 找专业界面 table
	 * @param condition
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TMajor> getAllMajorByTable(String condition, String value) {
		String hql = "";
		if(!StringUtil.isEmpty(condition) && !StringUtil.isEmpty(value)) {
			hql += " t." + condition + " like '%" + value + "%'";
		}
		if(hql.length() > 0) {
			hql = "from TMajor t where 1=1 and" + hql + " and t.isSpecial !=10 order by t.majorCode";
		} else {
			hql = "from TMajor t where 1=1 and t.isSpecial !=10 order by t.majorCode";
		}
		MyLogUtil.print(hql);
		return (List<TMajor>) majorDao.getResult(hql, null);
	}

	/**
	 * 管理员查询 TSchoolMajor
	 * @param pagenation
	 * @param condition
	 * @param value
	 * @param value_major
	 * @param select_level
	 * @param select_isKey
	 * @param select_department
	 * @param select_subject1
	 * @param select_subject2
	 * @param select_subject3
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TSchoolMajor> adminGetAllByPage(Pagenation pagenation, String condition, String value, String select_level, String select_isKey, String select_department, String subject1, String subject2, String subject3) {
		String hql = "";
		Object[] params = null ;
		List<Object> list = new ArrayList<Object>();
		if(!StringUtil.isEmpty(condition) && !StringUtil.isEmpty(value)) {
			hql = " t." + condition + " like '%" + value + "%' and";
		}
		if(!StringUtil.isEmpty(select_level)) {
			hql += " t.level = ? and";
			list.add(select_level);
		}
		if(!StringUtil.isEmpty(select_isKey) && select_isKey.equals("0")) {
			hql += " t.isKey = ? and";
			select_isKey = "否";
			list.add(select_isKey);
		} else if (!StringUtil.isEmpty(select_isKey) && !select_isKey.equals("0")) {
			hql += " t.isKey != ? and";
			select_isKey = "否";
			list.add(select_isKey);
		}
		// subject
		if(!StringUtil.isEmpty(subject1)) {
			hql += " t.subject like '%" + subject1 + "%' and";
		}
		if(!StringUtil.isEmpty(subject2)) {
			hql += " t.subject like '%" + subject2 + "%' and";
		}
		if(!StringUtil.isEmpty(subject3)) {
			hql += " t.subject like '%" + subject3 + "%' and";
		}
		if(hql.length() > 0) {
			hql = "from TSchoolMajor t where " + hql.subSequence(0, hql.length()-3) + " order by t.schoolMajorId";
			params = list.toArray();
		} else {
			hql = "from TSchoolMajor t where 1=1 order by t.schoolMajorId";
			params = null;
		}
		MyLogUtil.print(hql);
		return (List<TSchoolMajor>) majorDao.fuzzyQueryByPage(hql, params, pagenation);
	}

	/**
	 * 管理员查询 TSchoolMajor 统计总数
	 * @param condition
	 * @param value
	 * @param value_major
	 * @param select_level
	 * @param select_isKey
	 * @param select_department
	 * @param select_subject1
	 * @param select_subject2
	 * @param select_subject3
	 * @return
	 */
	public int adminCountAll(String condition, String value, String select_level, String select_isKey, String select_department, String subject1, String subject2, String subject3) {
		String hql = "";
		Object[] params = null ;
		List<Object> list = new ArrayList<Object>();
		if(!StringUtil.isEmpty(condition) && !StringUtil.isEmpty(value)) {
			hql = " t." + condition + " like '%" + value + "%' and";
		}
		if(!StringUtil.isEmpty(select_level)) {
			hql += " t.level = ? and";
			list.add(select_level);
		}
		if(!StringUtil.isEmpty(select_isKey) && select_isKey.equals("0")) {
			hql += " t.isKey = ? and";
			select_isKey = "否";
			list.add(select_isKey);
		} else if (!StringUtil.isEmpty(select_isKey) && !select_isKey.equals("0")) {
			hql += " t.isKey != ? and";
			select_isKey = "否";
			list.add(select_isKey);
		}
		// subject
		if(!StringUtil.isEmpty(subject1)) {
			hql += " t.subject like '%" + subject1 + "%' and";
		}
		if(!StringUtil.isEmpty(subject2)) {
			hql += " t.subject like '%" + subject2 + "%' and";
		}
		if(!StringUtil.isEmpty(subject3)) {
			hql += " t.subject like '%" + subject3 + "%' and";
		}
		if(hql.length() > 0) {
			hql = "select count(*) from TSchoolMajor t where " + hql.subSequence(0, hql.length()-3) + " order by t.schoolMajorId";
			params = list.toArray();
		} else {
			hql = "select count(*) from TSchoolMajor t where 1=1 order by t.schoolMajorId";
			params = null;
		}
		MyLogUtil.print(hql);
		return majorDao.fuzzyResultCount(hql, params);
	}

	

	
	
	
	
}
