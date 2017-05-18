/**
 * 
 */
package com.dale.ms.dataparse;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.dale.ms.utils.HttpUtil;
import com.dale.ms.utils.NetUtil;

/**
 * @author Dale'
 * @date 2017-4-28 上午8:37:25
 * @description
 */
public class DataParseBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -892708913600598000L;
	protected Object resultObject; // 结果对象
	protected String dataType; // 类型码 
	protected String type; // 业务码 Buyer Or Seller
	protected Object inputObject; // 输入对象
	protected Map<String, Object> contents = new HashMap<String, Object>(); // 输入对象

	// 使用HttpServletRequest初始化数据
	public void initData(HttpServletRequest request) throws Exception {
		type = request.getParameter("type");
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
		System.out.println(type);
>>>>>>> f42e15d758185e880610f91deb685ded138090ec
>>>>>>> 889a63e94037a79381ccdfe442f90f5073d73704
		contents.put("ip", NetUtil.getIpAddress(request));
		inputObject = HttpUtil.ParseDataToMap(request);
	}

	public Object getResultObject() {
		return resultObject;
	}

	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getInputObject() {
		return inputObject;
	}

	public void setInputObject(Object inputObject) {
		this.inputObject = inputObject;
	}

	public Map<String, Object> getContents() {
		return contents;
	}

	public void setContents(Map<String, Object> contents) {
		this.contents = contents;
	}

}
