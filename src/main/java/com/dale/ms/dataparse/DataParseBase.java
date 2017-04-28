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

	protected Object resultObject; // 结果对象
	protected String dataType; // 类型码 Buyer Or Seller
	protected String cmd; // 业务码
	protected Object inputObject; // 输入对象
	protected Map<String, Object> contents = new HashMap<String, Object>(); // 输入对象

	// 使用HttpServletRequest初始化数据
	public void initData(HttpServletRequest request) throws Exception {
		cmd = request.getParameter("type");
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

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
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
