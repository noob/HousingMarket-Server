//package com.dale.ms.service;
//
//
//import java.io.File;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.fileupload.disk.DiskFileItem;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//
//import com.dale.ms.dao.FileDao;
//import com.dale.ms.entities.TFile;
//import com.dale.ms.model.Pagenation;
//import com.dale.ms.utils.GlobalUtil;
//import com.dale.ms.utils.MyLogUtil;
//import com.dale.ms.utils.QiniuUtil;
//import com.dale.ms.utils.StringUtil;
//import com.google.gson.JsonElement;
//
///**
// * 
// * @author Dale'
// * @date 2016-3-2 下午12:12:48
// * @description
// */
//@Service("fileService")
//public class FileService {
//
//	@Autowired
//	@Qualifier("fileDao")
//	private FileDao fileDao;
//
//	/**
//	 * @param pagenation
//	 * @param condition
//	 * @param value
//	 * @return
//	 */
//	public List<?> getAllByPage(Pagenation pagenation, String condition, String value, String begin, String end) {
//		String hql = "";
//		// condition value
//		if(!StringUtil.isEmpty(condition) && !StringUtil.isEmpty(value)) {
//			hql += " t." + condition + " like '%" + value + "%' and";
//		}
//		if(hql.length() > 0) {
//			hql = "from TFile t where" + hql.subSequence(0, hql.length() - 3) + " order by t.createTime desc";
//		} else {
//			hql = "from TFile t order by t.createTime desc";
//		}
//		hql = replaceWhere(hql, begin, end);
//		MyLogUtil.print(hql);
//		return fileDao.fuzzyQueryByPage(hql, null, pagenation);
//	}
//
//	/**
//	 * @param condition
//	 * @param value
//	 * @return
//	 */
//	public int countAll(String condition, String value, String begin, String end) {
//		String hql = "";
//		// condition value
//		if(!StringUtil.isEmpty(condition) && !StringUtil.isEmpty(value)) {
//			hql += " t." + condition + " like '%" + value + "%' and";
//		}
//		if(hql.length() > 0) {
//			hql = "select count(*) from TFile t where" + hql.subSequence(0, hql.length() - 3) + " order by t.createTime desc";
//		} else {
//			hql = "select count(*) from TFile t order by t.createTime desc";
//		}
//		hql = replaceWhere(hql, begin, end);
//		MyLogUtil.print(hql);
//		return fileDao.fuzzyResultCount(hql, null);
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
//	 * 从七牛删除文件并删除数据库记录
//	 * @param fileId
//	 * @return
//	 */
//	public boolean delete(String fileId) {
////		TFile file = (TFile) fileDao.findById(TFile.class, Long.parseLong(fileId));
////		try {
////			QiniuUtil.delete(file.getFileName());
////		} catch (Exception e) {
////			e.printStackTrace();
////			return false;
////		}
//		int flag = fileDao.nativeUpdate("delete from t_file where FILE_ID = " + Long.parseLong(fileId.trim()));
//		return flag == 0 ? false : true;
//	}
//
//	/**
//	 * 上传文件到七牛并记录至数据库
//	 * @param file
//	 * @return
//	 */
//	public String uploadFile(String fileName, String fileType) {
//		TFile file = new TFile();
//		file.setFileName(fileName);
//		file.setFileType(fileType);
//		file.setCreateTime(StringUtil.getTime());
//		if(fileDao.save(file)) {
//			return "success";
//		} else {
//			return "录入数据库失败！";
//		}
//	}
//
//
//	
//	
//	
//}
