package com.dale.ms.service;


import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dale.ms.dao.FileDao;
import com.dale.ms.dao.QuestionDao;
import com.dale.ms.entities.RecommendAnswer;
import com.dale.ms.entities.TFile;
import com.dale.ms.entities.TMajor;
import com.dale.ms.entities.TMajorQuestion;
import com.dale.ms.entities.TQuestion;
import com.dale.ms.entities.TStar;
import com.dale.ms.model.Pagenation;
import com.dale.ms.utils.GlobalUtil;
import com.dale.ms.utils.MyLogUtil;
import com.dale.ms.utils.QiniuUtil;
import com.dale.ms.utils.StringUtil;
import com.google.gson.JsonElement;

/**
 * 
 * @author Dale'
 * @date 2016-3-2 下午12:12:48
 * @description
 */
@Service("questionService")
public class QuestionService {

	@Autowired
	@Qualifier("questionDao")
	private QuestionDao questionDao;

	/**
	 * 获取星级列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TStar> getAllStar() {
		String hql = "from TStar t where 1=1 order by t.starId";
		return (List<TStar>) questionDao.getResult(hql, null);
	}
	
	/**
	 * @param pagenation
	 * @param condition
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TQuestion> getAllByPage(Pagenation pagenation, String condition, String value) {
		String hql = "";
		// condition value
		if(!StringUtil.isEmpty(condition) && !StringUtil.isEmpty(value)) {
			hql += " t." + condition + " like '%" + value + "%' and";
		}
		if(hql.length() > 0) {
			hql = "from TQuestion t where" + hql.subSequence(0, hql.length() - 3) + " order by t.questionId";
		} else {
			hql = "from TQuestion t order by t.questionId";
		}
		MyLogUtil.print(hql);
		return (List<TQuestion>) questionDao.fuzzyQueryByPage(hql, null, pagenation);
	}

	/**
	 * @param condition
	 * @param value
	 * @return
	 */
	public int countAll(String condition, String value) {
		String hql = "";
		// condition value
		if(!StringUtil.isEmpty(condition) && !StringUtil.isEmpty(value)) {
			hql += " t." + condition + " like '%" + value + "%' and";
		}
		if(hql.length() > 0) {
			hql = "select count(*) from TQuestion t where" + hql.subSequence(0, hql.length() - 3) + " order by t.questionId";
		} else {
			hql = "select count(*) from TQuestion t order by t.questionId";
		}
		MyLogUtil.print(hql);
		return questionDao.fuzzyResultCount(hql, null);
	}

	/**
	 * 修改题目
	 * @param question
	 * @return
	 */
	public String modifyQuestion(TQuestion question) {
		String msg = "ERROR";
		if(questionDao.saveOrUpdate(question)) {
			msg = "success";
		}
		return msg;
	}

	/**
	 * 获取所有题目
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TQuestion> getAll() {
		String hql = "from TQuestion t order by t.questionId";
		MyLogUtil.print(hql);
		List<TQuestion> list = (List<TQuestion>) questionDao.getResult(hql, null);
		return list;
	}

	/**
	 * 修改权重
	 * @param majorQuestion
	 * @return
	 */
	public String modifyWeight(TMajorQuestion majorQuestion) {
		String msg = "ERROR";
		if(questionDao.saveOrUpdate(majorQuestion)) {
			msg = "success";
		}
		return msg;
	}

	/**
	 * 修改星级
	 * @param star_model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String modifyStar(String lowest, String three_four, String four_five) {
		String msg = "ERROR";
		//获取星级列表
		List<TStar> list = (List<TStar>) questionDao.getResult("from TStar t where 1=1 order by t.starId", null);
		list.get(0).setScoreMin(lowest);
		list.get(0).setScoreMax(three_four);
		list.get(1).setScoreMin(three_four);
		list.get(1).setScoreMax(four_five);
		list.get(2).setScoreMin(four_five);
		int sign = 0;
		for(TStar s : list) {
			if(!questionDao.saveOrUpdate(s)) {
				sign = 1;
			}
		}
		if(sign == 0) {
			msg = "success";
		}
		return msg;
	}

	/**
	 * Excel 导入 权重
	 * @param majorQuestion 
	 * @return
	 */
	public boolean saveOrUpdateWeight(TMajorQuestion majorQuestion) {
		String hql = "from TMajorQuestion t where 1=1 and t.majorCode = ?";
		TMajorQuestion mq = (TMajorQuestion) questionDao.getResultOne(hql, new Object[]{majorQuestion.getMajorCode()});
		if(mq != null) {
			questionDao.nativeUpdate("delete from t_major_question where MAJOR_QUESTION_ID = " + mq.getMajorQuestionId());
		}
		return questionDao.saveOrUpdate(majorQuestion);
	}

	/**
	 * 保存或更新用户答题
	 * @param answer
	 */
	public void saveOrUpdate(RecommendAnswer answer) {
		RecommendAnswer an = (RecommendAnswer) questionDao.getResultOne("from RecommendAnswer t where t.userId = ?", new Object[]{answer.getUserId()});
		if(an != null) {
			questionDao.delete(an);
		}
		questionDao.saveOrUpdate(answer);
	}

	/**
	 * 查询用户做题记录
	 * @param userId
	 * @return
	 */
	public RecommendAnswer getRecommendAnswerByUserId(String userId) {
		return (RecommendAnswer) questionDao.getResultOne("from RecommendAnswer t where t.userId = ?", new Object[]{userId});
	}

	


	
	
}
