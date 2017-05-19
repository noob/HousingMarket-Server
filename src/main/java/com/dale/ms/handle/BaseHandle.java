/**
 * 
 */
package com.dale.ms.handle;

import java.util.Map;

import com.dale.ms.utils.MyLogUtil;
import com.google.gson.Gson;

/**
 * @author Dale'
 * @date 2017-5-2 下午3:23:58
 * @description 
 */
public abstract class BaseHandle {

	protected Object object = null;
	protected Map<String, Object> contents; // 包含IP等信息
	protected String backData = null; // 即将返回给客户端的数据
	public Gson gson = new Gson();
	
	/**
	 * 处理数据
	 * @param object
	 * @return
	 */
	public String getResult(Object object) { 
		this.object = object;
		parseResult();
		return backData;
	}
	
	/**
	 * 解析数据，并返回结果
	 */
	public void parseResult() {
		MyLogUtil.print("解析数据 ------------ 开始");
		resultContent();
		write();
		MyLogUtil.print("解析数据 ------------ 完成");
	}
	
	/**
	 * 执行业务 并 组装返回数据
	 */
	public abstract void resultContent();
	
	/**
	 * IO写回数据
	 */
	public abstract void write();
}
