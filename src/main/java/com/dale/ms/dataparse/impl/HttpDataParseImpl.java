/**
 * 
 */
package com.dale.ms.dataparse.impl;

import javax.servlet.http.HttpServletRequest;

import com.dale.ms.dataparse.DataParseBase;

/**
 * @author Dale'
 * @date 2017-4-28 上午8:55:27
 * @description 
 */
public class HttpDataParseImpl extends DataParseBase {

	// 参数使用HttpServletRequest初始化数据
	public HttpDataParseImpl(HttpServletRequest request) throws Exception {
		initData(request);
	}
	
}
