//package com.dale.ms.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.dale.ms.controller.generic.GenericController;
//import com.dale.ms.entities.RecommendAnswer;
//import com.dale.ms.entities.TLesson;
//import com.dale.ms.entities.TLessonLog;
//import com.dale.ms.entities.TMajor;
//import com.dale.ms.entities.TQuestion;
//import com.dale.ms.entities.TSchool;
//import com.dale.ms.entities.TSchoolMajor;
//import com.dale.ms.entities.TStar;
//import com.dale.ms.entities.TUser;
//import com.dale.ms.model.Pagenation;
//import com.dale.ms.service.MajorService;
//import com.dale.ms.service.QuestionService;
//import com.dale.ms.service.SchoolService;
//import com.dale.ms.service.UserService;
//import com.dale.ms.utils.AlgorithmUtil;
//import com.dale.ms.utils.StringUtil;
//import com.google.gson.Gson;
//
///**
// * 
// * @author Dale'
// * @date 2016-3-1 下午7:18:12
// * @description
// */
//@Controller
//@RequestMapping(value = "/user")
//public class UserController extends GenericController{
//
//	public static final String SHOW = "show";
//	public static final String SUCCESS = "success";
//	public static final String ERROR = "error";
//	Gson gson = new Gson();
//	Pagenation pagenation = new Pagenation();
//	
//	@Autowired
//	@Qualifier("userService")
//	private UserService userService;
//	
//	@Autowired
//	@Qualifier("schoolService")
//	private SchoolService schoolService;
//	
//	@Autowired
//	@Qualifier("majorService")
//	private MajorService majorService;
//	
//	@Autowired
//	@Qualifier("questionService")
//	private QuestionService questionService;
//	
////	/**
////	 * 判断用户是否登录
////	 */
////	@ResponseBody
////	@RequestMapping("/if_login")
////	public String lesson_enter() {
////		if(session.getAttribute("USER_SESSION_KEY") == null) {
////			return gson.toJson("unlogin");
////		}
////		return gson.toJson(SUCCESS);
////	}
//	
//	/**
//	 * 用户中心界面
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/userZoom")
//	public String userZoom(Map<String, Object> map) {
//		if (session.getAttribute("USER_SESSION_KEY") == null) {
//			return "web/user-login";
//		}
//		return "web/userZoom";
//	}
//	
//	/**
//	 * 完善个人信息
//	 * @param user
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/complete_info")
//	public String complete_info(TUser user) {
//		return gson.toJson(userService.complete_user_info(user));
//	}
//	
//	@ResponseBody
//	@RequestMapping("/if_user_vip")
//	public String if_user_vip(String userId) {
//		return gson.toJson(userService.if_user_vip(userId));
//	}
//	
//	/**
//	 * 开设的课程列表
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/lessonList")
//	public String lessonList(Map<String, Object> map) {
//		List<TLesson> list = userService.getAllLesson();
//		map.put("list", list);
//		return "web/search-lesson";
//	}
//	
//	/**
//	 *  学校列表
//	 * @param condition
//	 * @param value
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/schoolList")
//	public String schoolList(@RequestParam("pagenation.page") String page, String condition, String value, Map<String, Object> map) {
//		pagenation.setPage(Integer.parseInt(page));
//		List<?> list = schoolService.getAllByPage(pagenation, condition, value);
//		if(list.size() > 0 && list != null) {
//			pagenation.setTotal(schoolService.countAll(condition, value));
//		} else {
//			pagenation.setTotal(0);
//		}
//		map.put("list", list);
//		map.put("pagenation", pagenation);
//		if(!StringUtil.isEmpty(condition)) {
//			map.put("condition", condition);
//		}
//		if(!StringUtil.isEmpty(value)) {
//			map.put("value", value);
//		}
//		return "web/search-college";
//	}
//	
//	/**
//	 * 专业列表
//	 * @param condition
//	 * @param value
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/majorList")
//	public String majorList(String condition, String value, Map<String, Object> map) {
//		List<TMajor> list = majorService.getAllMajorByTable(condition, value);
//		map.put("list", list);
//		if(!StringUtil.isEmpty(condition)) {
//			map.put("condition", condition);
//		}
//		if(!StringUtil.isEmpty(value)) {
//			map.put("value", value);
//		}
//		return "web/search-major";
//	}
//	
//	/**
//	 * 获取所有学校-专业列表
//	 * @param page
//	 * @param condition
//	 * @param value
//	 * @param select_level
//	 * @param select_isKey
//	 * @param select_department
//	 * @param select_subject1
//	 * @param select_subject2
//	 * @param select_subject3
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/school-majorList")
//	public String getAllSchoolMajor( @RequestParam("pagenation.page") String page, String value_school, String value_major,String value_schoolRegion, String level, String isKey, String department, String subject1, String subject2, String subject3, Map<String, Object> map) {
//		if(session.getAttribute("USER_SESSION_KEY") == null) {
//			return "web/user-login";
//		}
//		pagenation.setPage(Integer.parseInt(page));
//		pagenation.setTotal(0);
//		List<TSchoolMajor> list = majorService.getAllByPage(pagenation, value_school, value_major, value_schoolRegion, level, isKey, department, subject1, subject2, subject3);
//		if(list.size() > 0 && list != null) {
//			pagenation.setTotal(majorService.countAll(value_school, value_major, value_schoolRegion, level, isKey, department, subject1, subject2, subject3));
//		}
//		map.put("list", list);
//		map.put("pagenation", pagenation);
//		//页面回显
//		if(!StringUtil.isEmpty(value_school)) {
//			map.put("value_school", value_school);
//		}
//		if(!StringUtil.isEmpty(value_major)) {
//			map.put("value_major", value_major);
//		}
//		if(!StringUtil.isEmpty(value_schoolRegion)) {
//			map.put("value_schoolRegion", value_schoolRegion);
//		}
//		if(!StringUtil.isEmpty(department)) {
//			map.put("department", department);
//		}
//		if(!StringUtil.isEmpty(isKey)) {
//			map.put("isKey", isKey);
//		}
//		if(!StringUtil.isEmpty(level)) {
//			map.put("level", level);
//		}
//		String subject = "";
//		if(!StringUtil.isEmpty(subject1)) {
//			map.put("subject1", subject1);
//			subject += subject1;
//		}
//		if(!StringUtil.isEmpty(subject2)) {
//			map.put("subject2", subject2);
//			subject += subject2;
//		}
//		if(!StringUtil.isEmpty(subject3)) {
//			map.put("subject3", subject3);
//			subject += subject3;
//		}
//		map.put("subject", subject);
//		return "web/search-by-subject";
//	}
//	
////	public String getAllSchoolMajor( @RequestParam("pagenation.page") String page, String condition, String value,  String level, String isKey, String subject1, String subject2, String subject3, Map<String, Object> map) {
////		pagenation.setPage(Integer.parseInt(page));
////		pagenation.setTotal(0);
////		
////		List<TSchoolMajor> list = majorService.getAllByPage(pagenation, subject1, subject2, subject3);
////		
////		return null;
////	}
//	
//	/**
//	 * 专业推荐 题目列表 
//	 * @param page
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/questionList")
//	public String getAllQuestion(String userId, Map<String, Object> map) {
//		if(session.getAttribute("USER_SESSION_KEY") == null) {
//			return "web/user-login";
//		}
//		//查询以前做题记录
//		RecommendAnswer recommendAnswer = questionService.getRecommendAnswerByUserId(userId);
//		//查询题目
//		List<TQuestion> list = questionService.getAll();
//		List<TQuestion> list1 = new ArrayList<>();
//		List<TQuestion> list2 = new ArrayList<>();
//		List<TQuestion> list3 = new ArrayList<>();
//		List<TQuestion> list4 = new ArrayList<>();
//		if(list.size() > 0 && list != null) {
//			for(int i=0; i<10; i++) {
//				list1.add(list.get(i));
//			}
//			for(int i=10; i<20; i++) {
//				list2.add(list.get(i));
//			}
//			for(int i=20; i<30; i++) {
//				list3.add(list.get(i));
//			}
//			for(int i=30; i<40; i++) {
//				list4.add(list.get(i));
//			}
//		}
//		map.put("list", list);
//		map.put("list1", list1);
//		map.put("list2", list2);
//		map.put("list3", list3);
//		map.put("list4", list4);
//		if(recommendAnswer != null) {
//			map.put("recommendAnswer", recommendAnswer);
//			map.put("answer1", recommendAnswer.getQuestion1());
//			map.put("answer2", recommendAnswer.getQuestion2());
//			map.put("answer3", recommendAnswer.getQuestion3());
//			map.put("answer4", recommendAnswer.getQuestion4());
//			map.put("answer5", recommendAnswer.getQuestion5());
//			map.put("answer6", recommendAnswer.getQuestion6());
//			map.put("answer7", recommendAnswer.getQuestion7());
//			map.put("answer8", recommendAnswer.getQuestion8());
//			map.put("answer9", recommendAnswer.getQuestion9());
//			map.put("answer10", recommendAnswer.getQuestion10());
//			map.put("answer11", recommendAnswer.getQuestion11());
//			map.put("answer12", recommendAnswer.getQuestion12());
//			map.put("answer13", recommendAnswer.getQuestion13());
//			map.put("answer14", recommendAnswer.getQuestion14());
//			map.put("answer15", recommendAnswer.getQuestion15());
//			map.put("answer16", recommendAnswer.getQuestion16());
//			map.put("answer17", recommendAnswer.getQuestion17());
//			map.put("answer18", recommendAnswer.getQuestion18());
//			map.put("answer19", recommendAnswer.getQuestion19());
//			map.put("answer20", recommendAnswer.getQuestion20());
//			map.put("answer21", recommendAnswer.getQuestion21());
//			map.put("answer22", recommendAnswer.getQuestion22());
//			map.put("answer23", recommendAnswer.getQuestion23());
//			map.put("answer24", recommendAnswer.getQuestion24());
//			map.put("answer25", recommendAnswer.getQuestion25());
//			map.put("answer26", recommendAnswer.getQuestion26());
//			map.put("answer27", recommendAnswer.getQuestion27());
//			map.put("answer28", recommendAnswer.getQuestion28());
//			map.put("answer29", recommendAnswer.getQuestion29());
//			map.put("answer30", recommendAnswer.getQuestion30());
//			map.put("answer31", recommendAnswer.getQuestion31());
//			map.put("answer32", recommendAnswer.getQuestion32());
//			map.put("answer33", recommendAnswer.getQuestion33());
//			map.put("answer34", recommendAnswer.getQuestion34());
//			map.put("answer35", recommendAnswer.getQuestion35());
//			map.put("answer36", recommendAnswer.getQuestion36());
//			map.put("answer37", recommendAnswer.getQuestion37());
//			map.put("answer38", recommendAnswer.getQuestion38());
//			map.put("answer39", recommendAnswer.getQuestion39());
//			map.put("answer40", recommendAnswer.getQuestion40());
//		}
//		
//		return "web/major-recommend";
//	}
//	
//	/**
//	 * 答案解析
//	 * @param answer
//	 * @param map
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	@ResponseBody
//	@RequestMapping("/answerAnalysis")
//	public String AnswerAnalysis(RecommendAnswer answer, Map<String, Object> map) {
//		if(answer != null) {
//			//保存用户做题详情
//			if(answer.getUserId() != null) {
//				questionService.saveOrUpdate(answer);
//			}
//			//计算分数
//			Map<String, List<?>> map_result = majorService.analysisData(answer);
//			List<TMajor> list_major = (List<TMajor>) map_result.get("major");
//			session.setAttribute("list_major", list_major);
//			List<Double> list_score = (List<Double>) map_result.get("score");
//			session.setAttribute("list_score", list_score);
//			return gson.toJson(SUCCESS);
//		} else {
//			return gson.toJson(ERROR);
//		}
//	}
//	
//	/**
//	 * 用户做题记录
//	 * @param userId
//	 * @param map
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	@ResponseBody
//	@RequestMapping("/recommendRecord")
//	public String recommendRecord(String userId, Map<String, Object> map) {
//		RecommendAnswer answer = questionService.getRecommendAnswerByUserId(userId);
//		//如果该用户无记录
//		if (answer == null) {
//			return gson.toJson("fail");
//		} else {
//			Map<String, List<?>> map_result = majorService.analysisData(answer);
//			List<TMajor> list_major = (List<TMajor>) map_result.get("major");
//			session.setAttribute("list_major", list_major);
//			List<Double> list_score = (List<Double>) map_result.get("score");
//			session.setAttribute("list_score", list_score);
//			return gson.toJson(SUCCESS);
//		}
//	}
//	
//	/**
//	 * TOP页面跳转
//	 * @param answer
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/majorTOP")
//	public String MajorTOP(Map<String, Double> map) {
//		//获取星级标准线
//		List<TStar> list_star = questionService.getAllStar();
//		double lowest = Double.parseDouble(list_star.get(0).getScoreMin());
//		double three_four = Double.parseDouble(list_star.get(1).getScoreMin());
//		double four_five = Double.parseDouble(list_star.get(2).getScoreMin());
//		map.put("lowest", lowest);
//		map.put("three_four", three_four);
//		map.put("four_five", four_five);
//		return "web/major-rank";
//	}
//	
//	/**
//	 *  查找 大学/专业
//	 * @param search_value
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/search_function")
//	public String search_function(@RequestParam("search_value") String search_value, Map<String, Object> map) {
//		List<TMajor> list_major = majorService.getMajorBySearch(search_value);
//		List<TSchool> list_school = schoolService.getSchoolBySearch(search_value);
//		map.put("list_school", list_school);
//		map.put("list_major", list_major);
//		return "web/search-result";
//	}
//	
//	
//	/**
//	 * 学校详情
//	 * @param schoolId
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/schoolDetails")
//	public String schoolDetails(@RequestParam("schoolId") String schoolId, Map<String, Object> map) {
//		if(!StringUtil.isEmpty(schoolId)) {
//			TSchool school  = schoolService.getSchoolById(schoolId);
//			map.put("school", school);
//			List<TSchoolMajor> list = majorService.getAllBySchoolCode(school.getSchoolCode());
//			map.put("list", list);
//		}
//		return "web/major-in-school";
//	}
//	
//	/**
//	 * 获取所有开设该专业的学校
//	 * @param majorId
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/majorInSchool")
//	public String majorDetails(@RequestParam("pagenation.page") String page, @RequestParam("majorId") String majorId, String condition, String value, String subject1, String subject2, String subject3, Map<String, Object> map) {
//		pagenation.setPage(Integer.parseInt(page));
//		pagenation.setTotal(0);
//		
//		if(!StringUtil.isEmpty(majorId)) {
//			TMajor major = majorService.getMajorById(majorId);
//			map.put("major", major);
//			String majorCode = major.getMajorCode();
//			String majorName= major.getMajorName();
//			List<TSchoolMajor> list = majorService.getSchoolMajorByMajorCodeByPage(pagenation, majorCode, majorName, condition, value, subject1, subject2, subject3);
//			if(list.size() > 0 && list != null) {
//				pagenation.setTotal(majorService.countAllSchoolMajor(majorCode, majorName, condition, value, subject1, subject2, subject3));
//			} else {
//				pagenation.setTotal(0);
//			}
//			map.put("list", list);
//			map.put("pagenation", pagenation);
//		}
//		//页面回显
//		if(!StringUtil.isEmpty(condition)) {
//			map.put("condition", condition);
//		}
//		if(!StringUtil.isEmpty(value)) {
//			map.put("value", value);
//		}
//		String subject = "";
//		if(!StringUtil.isEmpty(subject1)) {
//			map.put("subject1", subject1);
//			subject += subject1;
//		}
//		if(!StringUtil.isEmpty(subject2)) {
//			map.put("subject2", subject2);
//			subject += subject2;
//		}
//		if(!StringUtil.isEmpty(subject3)) {
//			map.put("subject3", subject3);
//			subject += subject3;
//		}
//		map.put("subject", subject);
//		return "web/college-include-major";
//	}
//	
//	/**
//	 * 获取专业
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/major_page")
//	public String majorPage(Map<String, Object> map) {
//		List<TMajor> list = majorService.getMajorBySearch(" ");
//		map.put("list", list);
//		return "web/major_page";
//	}
//	
//	/**
//	 * 判断用户报名信息是否完善
//	 * @param userId
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/if_user_info_complete")
//	public String if_user_info_complete(@RequestParam("userId") String userId) {
//		return gson.toJson(userService.if_user_info_complete(userId));
//	}
//	
//	/**
//	 * 用户修改密码
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/modify_password")
//	public String modify_password(@RequestParam("userId") String userId, @RequestParam("old_password") String old_password, @RequestParam("new_password") String new_password) {
//		TUser user = userService.getUserById(userId);
//		if(AlgorithmUtil.Md5(old_password).equals(user.getPassword())) {
//			user.setPassword(AlgorithmUtil.Md5(new_password));
//			userService.modifyPassword(user);
//			return gson.toJson(SUCCESS);
//		}
//		return gson.toJson(ERROR);
//	}
//	
//}
