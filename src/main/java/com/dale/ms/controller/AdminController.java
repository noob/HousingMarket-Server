//package com.dale.ms.controller;
//
//import java.io.File;
//import java.text.NumberFormat;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//import com.dale.ms.controller.generic.GenericController;
//import com.dale.ms.entities.AdminUser;
//import com.dale.ms.entities.TLesson;
//import com.dale.ms.entities.TLessonLog;
//import com.dale.ms.entities.TMajor;
//import com.dale.ms.entities.TMajorQuestion;
//import com.dale.ms.entities.TQuestion;
//import com.dale.ms.entities.TSchool;
//import com.dale.ms.entities.TSchoolMajor;
//import com.dale.ms.entities.TStar;
//import com.dale.ms.entities.TUser;
//import com.dale.ms.entities.TVip;
//import com.dale.ms.model.TLessonDataCount;
//import com.dale.ms.service.AdminUserService;
//import com.dale.ms.service.FileService;
//import com.dale.ms.service.MajorService;
//import com.dale.ms.service.QuestionService;
//import com.dale.ms.service.SchoolService;
//import com.dale.ms.service.UserService;
//import com.dale.ms.utils.AlgorithmUtil;
//import com.dale.ms.utils.FileUtil;
//import com.dale.ms.utils.QiniuUtil;
//import com.dale.ms.utils.StringUtil;
//import com.dale.test.ExcelUtil;
//import com.google.gson.Gson;
//
///**
// * 
// * @author Dale'
// * @date 2016-3-1 下午7:18:12
// * @description
// */
//@Controller
//@RequestMapping(value = "/admin")
//public class AdminController extends GenericController{
//	
//	public static final String SUCCESS = "success";
//	public static final String ERROR = "error";
//	public static final String NO = "no";
//	private Gson gson = new Gson();
//	
//	@Autowired
//	@Qualifier("adminUserService")
//	private AdminUserService adminUserService;
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
//	@Qualifier("fileService")
//	private FileService fileService;
//	
//	@Autowired
//	@Qualifier("questionService")
//	private QuestionService questionService;
//	
//	
//	/**
//	 * 超级管理员登录
//	 * @return
//	 */
//	@RequestMapping("/superadmin")
//	public String superadmin() {
//		return "admin/superadmin";
//	}
//	
//	/**
//	 * 管理员登录
//	 * @return
//	 */
//	@RequestMapping("/admin")
//	public String admin() {
//		return "admin/admin";
//	}
//	
//	/**
//	 * 管理员信息
//	 * @return
//	 */
//	@RequestMapping("/adminInfo")
//	public String adminInfo(Map<String, Object> map) {
//		AdminUser adminUser = adminUserService.getByAdminName(getAdmin().getAdminName());
//		map.put("admin", adminUser);
//		return "admin/adminDetails";
//	}
//	
//	/**
//	 * 修改密码界面
//	 * @return
//	 */
//	@RequestMapping("/modifyPswUI")
//	public String modifyPswUI() {
//		return "admin/modify_psw";
//	}
//	
//	/**
//	 * 修改密码
//	 * @param password
//	 * @param newpassword
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/modifyPsw")
//	public String modifyPsw(@RequestParam("password") String password, @RequestParam("newpassword") String newpassword) {
//		String msg = ERROR;
//		if(StringUtil.isEmpty(password.trim())&&StringUtil.isEmpty(newpassword.trim())){
//			msg="no";
//			return gson.toJson(msg);
//		}
//		//得到管理员
//		AdminUser adminUser = adminUserService.getByAdminName(getAdmin().getAdminName());
//		//判断输入的原密码与管理员密码是否相同
//		if(!adminUser.getPassword().equals(AlgorithmUtil.Md5(password.trim()))) {
//			msg = "fail";
//			return gson.toJson(msg);
//		}
//		if(adminUserService.modifyPSW(adminUser,newpassword.trim())){
//			msg= "success";
//			return gson.toJson(msg);
//		}
//		return gson.toJson(msg);
//	}
//	
//	 // 														-----------------------------------列表模块开始------------------------------------
//	// 														-----------------------------------列表模块开始------------------------------------
//	// 														-----------------------------------列表模块开始------------------------------------
//	/**
//	 * 获取子管理员列表
//	 * @param mobile
//	 * @param begin
//	 * @param end
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/adminList")
//	public String getAllAdmin(@RequestParam("pagenation.page") String page, String mobile, String begin, String end, Map<String, Object> map) {
//		pagenation.setPage(Integer.parseInt(page));
//		pagenation.setTotal(0);
//		List<?> list = adminUserService.getAllByPage(pagenation, mobile, begin, end);
//		if(list.size() > 0 && list != null) {
//			pagenation.setTotal(adminUserService.countAll(mobile, begin, end));
//		}
//		map.put("list", list);
//		map.put("pagenation", pagenation);
//		//页面回显
//		if(!StringUtil.isEmpty(mobile)) {
//			map.put("mobile", mobile);
//		}
//		if(!StringUtil.isEmpty(begin)) {
//			map.put("begin", begin);
//		}
//		if(!StringUtil.isEmpty(end)) {
//			map.put("end", end);
//		}
//		return "admin/admin_manage";
//	}
//	
//	/**
//	 * 获取所有用户列表
//	 * @return
//	 */
//	@RequestMapping("/userList")
//	public String getAllUser(@RequestParam("pagenation.page") String page, String userStatus, String gender, String begin, String end, String condition, String value, Map<String, Object> map) {
//		pagenation.setPage(Integer.parseInt(page));
//		pagenation.setTotal(0);
//		List<?> list = userService.getAllByPage(pagenation, userStatus, gender, condition, value, begin, end);
//		if(list.size() > 0 && list != null) {
//			pagenation.setTotal(userService.countAll(userStatus, gender, begin, end, condition, value));
//		}
//		map.put("list", list);
//		map.put("pagenation", pagenation);
//		//页面回显
//		if(!StringUtil.isEmpty(condition)) {
//			map.put("condition", condition);
//		}
//		if(!StringUtil.isEmpty(value)) {
//			map.put("value", value);
//		}
//		if(!StringUtil.isEmpty(userStatus)) {
//			map.put("userStatus", userStatus);
//		}
//		if(!StringUtil.isEmpty(gender)) {
//			map.put("gender", gender);
//		}
//		if(!StringUtil.isEmpty(begin)) {
//			map.put("begin", begin);
//		}
//		if(!StringUtil.isEmpty(end)) {
//			map.put("end", end);
//		}
//		return "admin/user_manage";
//	}
//	
//	/**
//	 * 获取所有学校列表
//	 * @return
//	 */
//	@RequestMapping("/schoolList")
//	public String getAllSchool(@RequestParam("pagenation.page") String page, String condition, String value, Map<String, Object> map) {
//		pagenation.setPage(Integer.parseInt(page));
//		pagenation.setTotal(0);
//		List<?> list = schoolService.getAllByPage(pagenation, condition, value);
//		if(list.size() > 0 && list != null) {
//			pagenation.setTotal(schoolService.countAll(condition, value));
//		}
//		map.put("list", list);
//		map.put("pagenation", pagenation);
//		//页面回显
//		if(!StringUtil.isEmpty(condition)) {
//			map.put("condition", condition);
//		}
//		if(!StringUtil.isEmpty(value)) {
//			map.put("value", value);
//		}
//		return "admin/school_manage";
//	}
//	
//	/**
//	 * 所有专业列表
//	 * @param page
//	 * @param condition
//	 * @param value
//	 * @param subject1
//	 * @param subject2
//	 * @param subject3
//	 * @param department
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/majorList")
//	public String getAllMajor(@RequestParam("pagenation.page") String page, String condition, String value, String select_department, Map<String, Object> map) {
//		pagenation.setPage(Integer.parseInt(page));
//		pagenation.setTotal(0);
//		List<?> list = majorService.getAllMajorByPage(pagenation, condition, value, select_department);
//		if(list.size() > 0 && list != null) {
//			pagenation.setTotal(majorService.countAllMajor(condition, value, select_department));
//		}
//		map.put("list", list);
//		map.put("pagenation", pagenation);
//		//页面回显
//		if(!StringUtil.isEmpty(condition)) {
//			map.put("condition", condition);
//		}
//		if(!StringUtil.isEmpty(value)) {
//			map.put("value", value);
//		}
//		if(!StringUtil.isEmpty(select_department)) {
//			map.put("department", select_department);
//		}
//		return "admin/major_manage";
//	}
//	
//	/**
//	 * 获取所有学校-专业列表
//	 * @return
//	 */
//	@RequestMapping("/school-majorList")
//	public String getAllSchoolMajor( @RequestParam("pagenation.page") String page, String condition, String value, String select_level, String select_isKey, String select_department, String select_subject1, String select_subject2, String select_subject3, Map<String, Object> map) {
//		pagenation.setPage(Integer.parseInt(page));
//		pagenation.setTotal(0);
//		List<TSchoolMajor> list = majorService.adminGetAllByPage(pagenation, condition, value, select_level, select_isKey, select_department, select_subject1, select_subject2, select_subject3);
//		if(list.size() > 0 && list != null) {
//			pagenation.setTotal(majorService.adminCountAll(condition, value, select_level, select_isKey, select_department, select_subject1, select_subject2, select_subject3));
//		}
//		map.put("list", list);
//		map.put("pagenation", pagenation);
//		//页面回显
//		if(!StringUtil.isEmpty(condition)) {
//			map.put("condition", condition);
//		}
//		if(!StringUtil.isEmpty(value)) {
//			map.put("value", value);
//		}
//		if(!StringUtil.isEmpty(select_department)) {
//			map.put("department", select_department);
//		}
//		if(!StringUtil.isEmpty(select_isKey)) {
//			map.put("isKey", select_isKey);
//		}
//		if(!StringUtil.isEmpty(select_level)) {
//			map.put("level", select_level);
//		}
//		if(!StringUtil.isEmpty(select_subject1)) {
//			map.put("subject1", select_subject1);
//		}
//		if(!StringUtil.isEmpty(select_subject2)) {
//			map.put("subject2", select_subject2);
//		}
//		if(!StringUtil.isEmpty(select_subject3)) {
//			map.put("subject3", select_subject3);
//		}
//		return "admin/school-major_manage";
//	}
//	
//	/**
//	 * 获取所有题目列表
//	 * @return
//	 */
//	@RequestMapping("/questionList")
//	public String getAllQuestion(@RequestParam("pagenation.page") String page, String condition, String value, Map<String, Object> map) {
//		pagenation.setPage(Integer.parseInt(page));
//		pagenation.setTotal(0);
//		List<TQuestion> list = questionService.getAllByPage(pagenation, condition, value);
//		if(list.size() > 0 && list != null) {
//			pagenation.setTotal(questionService.countAll(condition, value));
//		}
//		map.put("list", list);
//		map.put("pagenation", pagenation);
//		//页面回显
//		if(!StringUtil.isEmpty(condition)) {
//			map.put("condition", condition);
//		}
//		if(!StringUtil.isEmpty(value)) {
//			map.put("value", value);
//		}
//		return "admin/question_manage";
//	}
//	
//	/**
//	 * 专业权重管理
//	 * @param page
//	 * @param condition
//	 * @param value
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/weightList")
//	public String getAllWeight(@RequestParam("pagenation.page") String page, String condition, String value, Map<String, Object> map) {
//		pagenation.setPage(Integer.parseInt(page));
//		pagenation.setTotal(0);
//		List<?> list = majorService.getAllMajorByPage(pagenation, condition, value, null);
//		if(list.size() > 0 && list != null) {
//			pagenation.setTotal(majorService.countAllMajor(condition, value, null));
//		}
//		
//		map.put("list", list);
//		map.put("pagenation", pagenation);
//		
//		//页面回显
//		if(!StringUtil.isEmpty(condition)) {
//			map.put("condition", condition);
//		}
//		if(!StringUtil.isEmpty(value)) {
//			map.put("value", value);
//		}
//		return "admin/weight_manage";
//	}
//	
//	/**
//	 * 星级管理
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/starList")
//	public String starList(Map<String, Object> map) {
//		List<TStar> list = questionService.getAllStar();
//		map.put("list", list);
//		map.put("lowest", list.get(0).getScoreMin());
//		map.put("three_four", list.get(1).getScoreMin());
//		map.put("four_five", list.get(2).getScoreMin());
//		return "admin/star_manage";
//	}
//	
//	/**
//	 * 获取所有文件列表
//	 * @return
//	 */
//	@RequestMapping("/fileList")
//	public String getAllFile(@RequestParam("pagenation.page") String page, String condition, String value, String begin, String end, Map<String, Object> map) {
//		pagenation.setPage(Integer.parseInt(page));
//		pagenation.setTotal(0);
//		List<?> list = fileService.getAllByPage(pagenation, condition, value, begin, end);
//		if(list.size() > 0 && list != null) {
//			pagenation.setTotal(fileService.countAll(condition, value, begin, end));
//		}
//		map.put("list", list);
//		map.put("pagenation", pagenation);
//		//页面回显
//		if(!StringUtil.isEmpty(condition)) {
//			map.put("condition", condition);
//		}
//		if(!StringUtil.isEmpty(value)) {
//			map.put("value", value);
//		}
//		if(!StringUtil.isEmpty(begin)) {
//			map.put("begin", begin);
//		}
//		if(!StringUtil.isEmpty(end)) {
//			map.put("end", end);
//		}
//		return "admin/file_manage";
//	}
//	
//	/**
//	 * 获取订单列表
//	 * @param page
//	 * @param userId
//	 * @param lessonId
//	 * @param begin
//	 * @param end
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/orderList")
//	public String orderList(@RequestParam("pagenation.page") String page, String mobile,  String lessonName, String begin, String end, Map<String, Object> map) {
//		pagenation.setPage(Integer.parseInt(page));
//		pagenation.setTotal(0);
//		List<TLessonLog> list = adminUserService.getAllLessonLogByPage(pagenation, mobile, lessonName, begin, end);
//		if(list.size() > 0 && list != null) {
//			pagenation.setTotal(adminUserService.countAllLessonLog(mobile, lessonName, begin, end));
//		}
//		map.put("list", list);
//		map.put("pagenation", pagenation);
//		if(!StringUtil.isEmpty(mobile)) {
//			map.put("mobile", mobile);
//		}
//		if(!StringUtil.isEmpty(lessonName)) {
//			map.put("lessonName", lessonName);
//		}
//		if(!StringUtil.isEmpty(begin)) {
//			map.put("begin", begin);
//		}
//		if(!StringUtil.isEmpty(end)) {
//			map.put("end", end);
//		}
//		return "admin/order_manage";
//	}
//	
//	/**
//	 * 获取培训列表
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/lessonList")
//	public String lessonList(Map<String, Object> map) {
//		List<TLesson> list = adminUserService.getAllLesson();
//		map.put("list", list);
//		return "admin/lesson_manage";
//	}
//	
//	/**
//	 * 数据统计
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/dataList")
//	public String dataList(Map<String, Object> map) {
//		List<TLesson> list_lesson = adminUserService.getAllLesson();
//		List<TLessonDataCount> list_data = adminUserService.lessonDataCount(list_lesson);
//		map.put("list", list_data);
//		return "admin/lessonDataCount";
//	}
//	
//	/**
//	 * vip列表
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/vipList")
//	public String vipList(Map<String, Object> map) {
//		List<TVip> list_vip = adminUserService.getAllVip();
//		map.put("list", list_vip);
//		return "admin/vip_manage";
//	}
//	
//	
//	 // 														-----------------------------------列表模块结束------------------------------------
//	// 														-----------------------------------列表模块结束------------------------------------
//	// 														-----------------------------------列表模块结束------------------------------------
//	
//	/**
//	 * 修改用户状态
//	 * @param userStatus
//	 * @param userId
//	 * @return
//	 */
//	@RequestMapping("/optionUser")
//	@ResponseBody
//	public String optionUser(@RequestParam("userStatus") String userStatus, @RequestParam("userId") String userId) {
//		if(StringUtil.isEmpty(userStatus) || StringUtil.isEmpty(userId)) {
//			return gson.toJson(NO);
//		}
//		if(userService.optionUser(userStatus, userId)) {
//			return gson.toJson(SUCCESS);
//		} else {
//			return gson.toJson(ERROR);
//		}
//	}
//	
//	/**
//	 * 根据ID删除
//	 * @param adminId
//	 * @return
//	 */
//	@RequestMapping("/deleteAdmin")
//	@ResponseBody
//	public String deleteAdmin(@RequestParam("adminId") String adminId) {
//		if(StringUtil.isEmpty(adminId)) {
//			return gson.toJson(NO);
//		}
//		if(adminUserService.delete(adminId)) {
//			return gson.toJson(SUCCESS);
//		} else {
//			return gson.toJson(ERROR);
//		}
//	}
//	
//	/**
//	 * 根据ID删除学校
//	 * @param adminId
//	 * @return
//	 */
//	@RequestMapping("/deleteSchool")
//	@ResponseBody
//	public String deleteSchool(@RequestParam("schoolId") String schoolId) {
//		if(StringUtil.isEmpty(schoolId)) {
//			return gson.toJson(NO);
//		}
//		if(schoolService.delete(schoolId)) {
//			return gson.toJson(SUCCESS);
//		} else {
//			return gson.toJson(ERROR);
//		}
//	}
//	
//	/**
//	 * 根据ID删除专业
//	 * @param adminId
//	 * @return
//	 */
//	@RequestMapping("/deleteMajor")
//	@ResponseBody
//	public String deleteMajor(@RequestParam("majorId") String majorId) {
//		if(StringUtil.isEmpty(majorId)) {
//			return gson.toJson(NO);
//		}
//		if(majorService.delete(majorId)) {
//			return gson.toJson(SUCCESS);
//		} else {
//			return gson.toJson(ERROR);
//		}
//	}
//	
//	/**
//	 * 根据ID删除学校-专业
//	 * @param schoolMajorId
//	 * @return
//	 */
//	@RequestMapping("/deleteSchoolMajor")
//	@ResponseBody
//	public String deleteSchoolMajor(@RequestParam("schoolMajorId") String schoolMajorId) {
//		if(StringUtil.isEmpty(schoolMajorId)) {
//			return gson.toJson(NO);
//		}
//		if(majorService.deleteSchoolMajor(schoolMajorId)) {
//			return gson.toJson(SUCCESS);
//		} else {
//			return gson.toJson(ERROR);
//		}
//	}
//	
//	@RequestMapping("/deleteOrder")
//	@ResponseBody
//	public String deleteOrder(@RequestParam("lessonLogId") String lessonLogId) {
//		if(StringUtil.isEmpty(lessonLogId)) {
//			return gson.toJson(NO);
//		}
//		if(adminUserService.deleteOrder(lessonLogId)) {
//			return gson.toJson(SUCCESS);
//		} else {
//			return gson.toJson(ERROR);
//		}
//	}
//	
//	@RequestMapping("/deleteLesson")
//	@ResponseBody
//	public String deleteLesson(@RequestParam("lessonId") String lessonId) {
//		if(StringUtil.isEmpty(lessonId)) {
//			return gson.toJson(NO);
//		}
//		if(adminUserService.deleteLesson(lessonId)) {
//			return gson.toJson(SUCCESS);
//		} else {
//			return gson.toJson(ERROR);
//		}
//	}
//	
//	@RequestMapping("/modifyVip")
//	@ResponseBody
//	public String modifyVip(@RequestParam("fee") String fee) {
//		if(!StringUtil.isEmpty(fee)) {
//			if(adminUserService.modifyVip(fee)) {
//				return gson.toJson(SUCCESS);
//			}
//		}
//		return gson.toJson(ERROR);
//	}
//	
//	
//	/**
//	 * 根据ID查询详细(管理员)
//	 * @param adminId
//	 * @return
//	 */
//	@RequestMapping("/adminDetails")
//	public String adminDetails(@RequestParam("adminId") String adminId, Map<String, Object> map) {
//		if(!StringUtil.isEmpty(adminId)) {
//			AdminUser adminUser  = adminUserService.getAdminById(adminId);
//			map.put("admin", adminUser);
//		}
//		return "admin/adminDetails";
//	}
//	
//	/**
//	 * 根据ID查询详细(用户)
//	 * @param userId
//	 * @return
//	 */
//	@RequestMapping("/userDetails")
//	public String userDetails(@RequestParam("userId") String userId, Map<String, Object> map) {
//		if(!StringUtil.isEmpty(userId)) {
//			TUser user  = userService.getUserById(userId);
//			map.put("user", user);
//		}
//		return "admin/userDetails";
//	}
//
//	/**
//	 * 根据ID查询详细(学校)
//	 * @param schoolId
//	 * @return
//	 */
//	@RequestMapping("/schoolDetails")
//	public String schoolDetails(@RequestParam("schoolId") String schoolId, Map<String, Object> map) {
//		if(!StringUtil.isEmpty(schoolId)) {
//			TSchool school  = schoolService.getSchoolById(schoolId);
//			map.put("school", school);
//		}
//		return "admin/schoolDetails";
//	}
//	
//	/**
//	 * 根据ID查询详细(专业)
//	 * @param schoolId
//	 * @return
//	 */
//	@RequestMapping("/majorDetails")
//	public String majorDetails(@RequestParam("majorId") String majorId, Map<String, Object> map) {
//		if(!StringUtil.isEmpty(majorId)) {
//			TMajor major  = majorService.getMajorById(majorId);
//			map.put("major", major);
//		}
//		return "admin/majorDetails";
//	}
//	
//	/**
//	 * 根据ID查询详细(学校-专业)
//	 * @param schoolId
//	 * @return
//	 */
//	@RequestMapping("/schoolMajorDetails")
//	public String schoolMajorDetails(@RequestParam("schoolMajorId") String schoolMajorId, Map<String, Object> map) {
//		if(!StringUtil.isEmpty(schoolMajorId)) {
//			TSchoolMajor schoolMajor  = majorService.getSchoolMajorById(schoolMajorId);
//			map.put("schoolMajor", schoolMajor);
//		}
//		return "admin/school-majorDetails";
//	}
//	
//	/**
//	 * 根据ID 查询 培训订单详情
//	 * @param lessonLogId
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/lessonLogDetails")
//	public String lessonLogDetails(@RequestParam("lessonLogId") String lessonLogId, Map<String, Object> map) {
//		if(!StringUtil.isEmpty(lessonLogId)) {
//			TLessonLog lessonLog  = adminUserService.getLessonLogById(lessonLogId);
//			map.put("lessonLog", lessonLog);
//		}
//		return "admin/lessonLogDetails";
//	}
//	
//	/**
//	 * 根据 majorCode 获取 权重
//	 * @param majorCode
//	 * @param map
//	 * @return
//	 */
//	@RequestMapping("/getWeightByMajorCode")
//	public String getWeightByMajorCode(@RequestParam("majorCode") String majorCode, Map<String, Object> map) {
//		if(!StringUtil.isEmpty(majorCode)) {
//			//查询所有题目
//			List<TQuestion> list_question = questionService.getAll();
//			map.put("question", list_question);
//			//所有权重
//			TMajorQuestion majorQuestion  = majorService.getWeightByMajorCode(majorCode);
//			map.put("majorQuestion", majorQuestion);
//		} 
//		return "admin/weightDetails";
//	}
//	
//	/**
//	 * 添加子管理员
//	 * @param school
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/addAdmin")
//	public String addSchool(AdminUser adminUser) {
//		if(adminUser != null) {
//			return gson.toJson(adminUserService.addAdmin(adminUser));
//		} else {
//			return gson.toJson("未知错误！");
//		}
//	}
//	
//	/**
//	 * 添加学校
//	 * @param school
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/addSchool")
//	public String addSchool(TSchool school) {
//		if(school != null) {
//			return gson.toJson(schoolService.addSchool(school));
//		} else {
//			return gson.toJson("未知错误！");
//		}
//	}
//	
//	/**
//	 * 添加或修改专业
//	 * @param major
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/addMajor")
//	public String addMajor(TMajor major, @RequestParam("type") String type) {
//		if(major != null && type.equals("add")) {
//			//添加专业
//			return gson.toJson(majorService.addMajor(major));
//		} else if(major != null && type.equals("modify")) {
//			//修改专业
//			return gson.toJson(majorService.modifyMajor(major));
//		} else {
//			return gson.toJson("未知错误！");
//		}
//	}
//	
//	/**
//	 * 添加或修改学校-专业
//	 * @param major
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/operateSchoolMajor")
//	public String operateSchoolMajor(TSchoolMajor schoolMajor, @RequestParam("type") String type) {
//		
//		if(schoolMajor != null && type.equals("add")) {
//			return gson.toJson(majorService.openMjaor(schoolMajor));
//		} else if(schoolMajor != null && type.equals("modify")) {
//			return gson.toJson(majorService.modifySchoolMajor(schoolMajor));
//		} else {
//			return gson.toJson("未知错误！");
//		}
//	}
//	
//	/**
//	 * 修改星级
//	 * @param major_model
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/modifyStar")
//	public String modifyStar(String lowest, String three_four, String four_five) {
//		if(!StringUtil.isEmpty(lowest) && !StringUtil.isEmpty(three_four) && !StringUtil.isEmpty(four_five)) {
//			return gson.toJson(questionService.modifyStar(lowest, three_four, four_five));
//		} else {
//			return gson.toJson("未知错误！");
//		}
//	}
//	
//	/**
//	 * 修改school
//	 * @param school
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/modifySchool")
//	public String modifySchool(TSchool school_model) {
//		if(school_model != null) {
//			return gson.toJson(schoolService.modifySchool(school_model));
//		} else {
//			return gson.toJson("未知错误！");
//		}
//	}
//	
//	/**
//	 * 修改题目
//	 * @param question
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/modifyQuestion")
//	public String modifyQuestion(TQuestion question) {
//		if(question != null) {
//			return gson.toJson(questionService.modifyQuestion(question));
//		} else {
//			return gson.toJson("未知错误！");
//		}
//	}
//	
//	/**
//	 * 修改权重
//	 * @param question
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/modifyWeight")
//	public String modifyWeight(TMajorQuestion majorQuestion) {
//		if(majorQuestion != null) {
//			//计算所有题目权重的总和
//			double weights = majorQuestion.getWeight1() + majorQuestion.getWeight2() + majorQuestion.getWeight3() + majorQuestion.getWeight4() + majorQuestion.getWeight5()
//					+ majorQuestion.getWeight6() + majorQuestion.getWeight7() + majorQuestion.getWeight8() + majorQuestion.getWeight9() + majorQuestion.getWeight10()
//					+ majorQuestion.getWeight11() + majorQuestion.getWeight12() + majorQuestion.getWeight13() + majorQuestion.getWeight14() + majorQuestion.getWeight15()
//					+ majorQuestion.getWeight16() + majorQuestion.getWeight17() + majorQuestion.getWeight18() + majorQuestion.getWeight19() + majorQuestion.getWeight20()
//					+ majorQuestion.getWeight21() + majorQuestion.getWeight22() + majorQuestion.getWeight23() + majorQuestion.getWeight24() + majorQuestion.getWeight25()
//					+ majorQuestion.getWeight26() + majorQuestion.getWeight27() + majorQuestion.getWeight28() + majorQuestion.getWeight29() + majorQuestion.getWeight30()
//					+ majorQuestion.getWeight31() + majorQuestion.getWeight32() + majorQuestion.getWeight33() + majorQuestion.getWeight34() + majorQuestion.getWeight35()
//					+ majorQuestion.getWeight36() + majorQuestion.getWeight37() + majorQuestion.getWeight38() + majorQuestion.getWeight39() + majorQuestion.getWeight40();
//				//将得到的weights格式化小数点后3位
//				NumberFormat nf = NumberFormat.getNumberInstance();
//				nf.setMaximumFractionDigits(3);
//				double f_weights = Double.parseDouble(nf.format(weights));
//			if(f_weights > 1) {
//				return gson.toJson("总权重大于1");
//			}
//			return gson.toJson(questionService.modifyWeight(majorQuestion));
//		} else {
//			return gson.toJson("未知错误！");
//		}
//	}
//	
//	/**
//	 * 修改培训课程信息
//	 * @param lesson
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/modifyLesson")
//	public String modifyLesson(@RequestParam("id") String id, TLesson lesson) {
//		System.out.println("id = "  + id);
//		System.out.println(id.length());
//		if(id.length() > 0) { //大于0 为修改
//			TLesson t = adminUserService.getLessonById(id);
//			if(t != null) {
//				t.setLessonTitle(lesson.getLessonTitle());
//				t.setTeacherIntroduce(lesson.getTeacherIntroduce());
//				t.setPlace(lesson.getPlace());
//				t.setLessonBeginDate(lesson.getLessonBeginDate());
//				t.setDuration(lesson.getDuration());
//				t.setPrice(lesson.getPrice());
//				t.setDiscountPrice(lesson.getDiscountPrice());
//				t.setLessonDiscountEndDate(lesson.getLessonDiscountEndDate());
//				return gson.toJson(adminUserService.modifyLesson(t));
//			}
//		} else { //新增课程
//			if(adminUserService.addLesson(lesson)) {
//				return gson.toJson(SUCCESS);
//			}
//		}
//		return gson.toJson(ERROR);
//	}
//	
//	/**
//	 * 修改培训内容
//	 * @param lesson
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/modifyLessonMsg")
//	public String modifyLessonMsg(@RequestParam("lessonId") String lessonId, @RequestParam("lessonMsg") String lessonMsg) {
//		if(lessonId != null) {
//			TLesson lesson = adminUserService.getLessonById(lessonId);
//			lesson.setLessonMsg(lessonMsg);
//			return gson.toJson(adminUserService.modifyLesson(lesson));
//		}
//		return gson.toJson(ERROR);
//	}
//	
//	/**
//	 * 修改培训条款
//	 * @param lesson
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/modifyLessonItem")
//	public String modifyLessonItem(@RequestParam("lessonId") String lessonId, @RequestParam("lessonItem") String lessonItem) {
//		if(lessonId != null) {
//			TLesson lesson = adminUserService.getLessonById(lessonId);
//			lesson.setLessonItem(lessonItem);
//			return gson.toJson(adminUserService.modifyLesson(lesson));
//		}
//		return gson.toJson(ERROR);
//	}
//	
//	/**
//	 * Excel导入学校
//	 * @param multipartFile
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/importSchool")
//	public String importSchool(@RequestParam("file") MultipartFile multipartFile) {
//		TSchool school = null;
//		if(multipartFile != null) {
//			String originalFilename = multipartFile.getOriginalFilename();
//			try {
//				//检测文件夹是否存在  如果不存在并创建
//				FileUtil.checkExist(request.getSession().getServletContext().getRealPath("/") + "upload");
//				String path = request.getSession().getServletContext().getRealPath("/") + "upload\\"+ originalFilename;
//				File file = new File(path);
//				multipartFile.transferTo(file);
//				List<TSchool> list = ExcelUtil.readSchoolXlsx(path);
//				for(int i=0; i<list.size(); i++) {
//					school = new TSchool();
//					school.setSchoolCode(list.get(i).getSchoolCode());
//					school.setSchoolName(list.get(i).getSchoolName());
//					school.setSchoolRegion(list.get(i).getSchoolRegion());
//					//写入数据库
//					boolean flag = schoolService.importSchool(school);
//					if(!flag) {
//						System.out.println("数据 " + school.getSchoolCode() + " " + school.getSchoolName() + " " + school.getSchoolRegion()  +" 插入失败, reason: 学校代码重复, 已存在");
//					} 
//				}
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		}
//		return gson.toJson(SUCCESS);
//	}
//	
//	/**
//	 * Excel导入专业
//	 * @param multipartFile
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/importMajor")
//	public String importMajor(@RequestParam("file") MultipartFile multipartFile) {
//		TMajor major = null;
//		if(multipartFile != null) {
//			String originalFilename = multipartFile.getOriginalFilename();
//			try {
//				//检测文件夹是否存在  如果不存在并创建
//				FileUtil.checkExist(request.getSession().getServletContext().getRealPath("/") + "upload");
//				String path = request.getSession().getServletContext().getRealPath("/") + "upload\\"+ originalFilename;
//				File file = new File(path);
//				multipartFile.transferTo(file);
//				List<TMajor> list = ExcelUtil.readMajorXlsx(path);
//				for(int i=0; i<list.size(); i++) {
//					major = new TMajor();
//					major.setMajorCode(list.get(i).getMajorCode());
//					major.setMajorName(list.get(i).getMajorName());
//					major.setIsSpecial(list.get(i).getIsSpecial());
//					//写入数据库
//					boolean flag = majorService.importMajor(major);
//					if(!flag) {
//						System.out.println("数据 " + major.getMajorCode() + " " + major.getMajorName() + " " + major.getIsSpecial() + " " +" 插入失败, reason: 专业代码重复, 已存在");
//					} 
//				}
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		}
//		
//		return gson.toJson(SUCCESS);
//	}
//	
//	
//	/**
//	 * Excel导入学校-专业
//	 * @param multipartFile
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/importSchoolMajor")
//	public String importSchoolMajor(@RequestParam("file") MultipartFile multipartFile) {
//		if(multipartFile != null) {
//			String originalFilename = multipartFile.getOriginalFilename();
//			try {
//				//检测文件夹是否存在  如果不存在并创建
//				FileUtil.checkExist(request.getSession().getServletContext().getRealPath("/") + "upload");
//				String path = request.getSession().getServletContext().getRealPath("/") + "upload\\"+ originalFilename;
//				File file = new File(path);
//				multipartFile.transferTo(file);
//				List<TSchoolMajor> list = ExcelUtil.readSchoolMajorXlsx(path);
//				for(TSchoolMajor t : list) {
//					int sign = 0;
//					//学校是否存在
//					TSchool school = schoolService.getSchoolByCode(t.getSchoolCode());
//					if(school == null) {//学校不存在
//						sign = 1;
//					}
//					//专业是否存在
////					TMajor major = majorService.getMajorByCode(t.getMajorCode());
////					if(major == null) {//专业不存在
////						sign = 2;
////					}
//					//是否已开设该专业
//					List<TSchoolMajor> schoolMajor_list = majorService.getSchoolMajorByDoubleCode(t.getSchoolCode(), t.getMajorCode());
//					if(schoolMajor_list != null) {//查询结果如果不为空
//						for(TSchoolMajor sm : schoolMajor_list) {//遍历对比
//							if(t.getCate().equals(sm.getCate())) { //该校已开设该专业
//								sign = 3;
//							}
//						}
//					}
//					if(sign == 0) {
//						//写入数据库
//						majorService.importSchoolMajor(t);
//					} else if(sign == 1){
//						System.out.println(": 数据 " + t.getSchoolCode() + " " + t.getSchoolName() + " " + t.getMajorCode() + " " + t.getMajorName() + " " + 
//								t.getSubject() + " " + t.getLevel() + " " + t.getIsKey()  + " " + t.getDepartment() + " " + t.getTuition() + " " + t.getScore() +
//								" 插入失败, reason: 该学校代码不存在");
//					} else if(sign == 2) {
//						System.out.println(": 数据 " + t.getSchoolCode() + " " + t.getSchoolName() + " " + t.getMajorCode() + " " + t.getMajorName() + " " + 
//								t.getSubject() + " " + t.getLevel() + " " + t.getIsKey()  + " " + t.getDepartment() + " " + t.getTuition() + " " + t.getScore() +
//								" 插入失败, reason: 该专业代码不存在 ");
//					} else if(sign == 3) {
//						System.out.println(": 数据 " + t.getSchoolCode() + " " + t.getSchoolName() + " " + t.getMajorCode() + " " + t.getMajorName() + " " + 
//								t.getSubject() + " " + t.getLevel() + " " + t.getIsKey()  + " " + t.getDepartment() + " " + t.getTuition() + " " + t.getScore() +
//								" 插入失败, reason:  该学校已开设该专业");
//					} else {
//						System.out.println(": 数据 " + t.getSchoolCode() + " " + t.getSchoolName() + " " + t.getMajorCode() + " " + t.getMajorName() + " " + 
//								t.getSubject() + " " + t.getLevel() + " " + t.getIsKey()  + " " + t.getDepartment() + " " + t.getTuition() + " " + t.getScore() +
//								" 插入失败, reason: 未知错误");
//					}
//				}
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		}
//		
//		return gson.toJson(SUCCESS);
//	}
//	
//	/**
//	 * Excel导入 专业权重
//	 * @param multipartFile
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/importWeight")
//	public String importWeight(@RequestParam("file") MultipartFile multipartFile) {
//		if(multipartFile != null) {
//			String originalFilename = multipartFile.getOriginalFilename();
//			//检测文件夹是否存在  如果不存在并创建
//			try {
//				FileUtil.checkExist(request.getSession().getServletContext().getRealPath("/") + "upload");
//				String path = request.getSession().getServletContext().getRealPath("/") + "upload\\"+ originalFilename;
//				File file = new File(path);
//				multipartFile.transferTo(file);
//				List<TMajorQuestion> list = ExcelUtil.readMajorQuestionXlsx(path);
//				for(TMajorQuestion t : list) {
//					boolean flag = questionService.saveOrUpdateWeight(t);
//					if(!flag) {
//						System.out.println(t.getMajorCode() + " " + t.getMajorName() + " 更新失败!");
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}	
//		return gson.toJson(SUCCESS);
//	}
//	
//	
//	//                                         ----------------------------------------------七牛云代码开始----------------------------------------------
//	//                                         ----------------------------------------------七牛云代码开始----------------------------------------------
//	//                                         ----------------------------------------------七牛云代码开始----------------------------------------------
//
//	/**
//	 * 上传文件到七牛并记录至数据库
//	 * @param file
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/uploadFile")
//	public String uploadFile(@RequestParam("file") MultipartFile file) {
//		if(file != null) {
//			String originalFilename = file.getOriginalFilename();
//			String fileName = "QINIU_PREFIX" + "_" + System.currentTimeMillis() + "_" + originalFilename.substring(0, originalFilename.lastIndexOf(".")) + originalFilename.substring(originalFilename.lastIndexOf("."));
//			String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
//			//检测文件夹是否存在  如果不存在并创建
//			try {
//				FileUtil.checkExist(request.getSession().getServletContext().getRealPath("/") + "upload");
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//			
//			String path = request.getSession().getServletContext().getRealPath("/") + "upload/"+ originalFilename;
//			try {
//				File file_model = new File(path);
//				file.transferTo(file_model);
////				QiniuUtil.upload(file_model, fileName, GlobalUtil.UP_TOKEN);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return gson.toJson(fileService.uploadFile(QiniuUtil.getPrivateUrl(fileName), fileType));
//		} else {
//			return gson.toJson("未知错误！");
//		}
//	}
//	
//	/**
//	 * 根据ID删除七牛文件并删除数据库记录
//	 * @param adminId
//	 * @return
//	 */
//	@RequestMapping("/deleteFile")
//	@ResponseBody
//	public String deleteFile(@RequestParam("fileId") String fileId) {
//		if(StringUtil.isEmpty(fileId)) {
//			return gson.toJson(NO);
//		}
//		if(fileService.delete(fileId)) {
//			return gson.toJson(SUCCESS);
//		} else {
//			return gson.toJson(ERROR);
//		}
//	}
//	//                                         ----------------------------------------------七牛云代码结束----------------------------------------------
//	//                                         ----------------------------------------------七牛云代码结束----------------------------------------------
//	//                                         ----------------------------------------------七牛云代码结束----------------------------------------------
//	//                                         ----------------------------------------------七牛云代码结束----------------------------------------------
//}
