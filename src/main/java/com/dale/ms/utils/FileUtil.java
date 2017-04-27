/**
 * 
 */
package com.dale.ms.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件工具类
 * @author Dale'
 * @date 2016-3-21 下午3:29:30
 * @description 
 */
public class FileUtil {
	
	/**
	 * 得到文件的路径
	 * @return  文件全路径名     /G:/Java/apache-tomcat-7/webapps/SchoolGuider/
	 */
	@SuppressWarnings("rawtypes")
	public String getPath() {
		//获得WebRoot路径
		Class objClass = this.getClass();
		String realPath = objClass.getClassLoader().getResource("").getFile();
		String classCategory = realPath.replace("WEB-INF/classes/", "").trim();
		return classCategory;
	}
	
	/**
	 * 判断文件夹目录是否存在
	 * @param filepath	文件路劲
	 * @return	诺文件不存在，则创建文件
	 * @throws Exception
	 */
	public static void checkExist(String filepath) throws Exception{
	      File file = new File(filepath);
	      file.setWritable(true, false);
//	      if(file.isDirectory()){
//	    	  if (file.exists()){
//	    		  		;		// 文件目录存在
//	    		  		System.out.println("纯在");
//	    	  }else{
//	    		  File file2 = new File(file.getParent());
//		          file2.setWritable(true, false);
//		          file2.mkdirs();
//		          System.out.println("创建");
//	    	  }
//	      }
	      if(!file.exists() && !file.isDirectory()) {
	    	  file.mkdirs();
	      } else {
	    	  ;// 文件目录存在
	      }
	}
	
	/**
	 * 根据文件路径获取文件名
	 * @param path	文件路径
	 */
	public static List<String> getFile(String path) {   
        File file = new File(path);
        File[] array = file.listFiles();   
        List<String> folderNames = new ArrayList<String>();
        for(int i=0; i<array.length; i++) {   
            if(array[i].isFile()) {   
                folderNames.add(array[i].getName());
            } else if(array[i].isDirectory()) {   
                getFile(array[i].getPath());   
            }   
        }   
        return folderNames;
    }
	
	public static byte[] file2Bytes(File file){
		 byte[] data = null;
		 FileInputStream input = null;
		 try {
			 input = new FileInputStream(file);
			 ByteArrayOutputStream output = new ByteArrayOutputStream();
			 byte[] buf = new byte[1024];
			 int numBytesRead = 0;
			 while ((numBytesRead = input.read(buf)) != -1) {
				 output.write(buf, 0, numBytesRead);
			 }
			 data = output.toByteArray();
			 output.close();
			 input.close();
		 }
		 catch (FileNotFoundException ex1) {
			 ex1.printStackTrace();
		 }
		 catch (IOException ex1) {
			 ex1.printStackTrace();
		 }
		 return data;
	 }
	
}
