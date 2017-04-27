package com.dale.ms.model;

public class Pagenation {

	private int page = 1; // 当前页
	private int pageSize = 10; // 当前页显示多少条数据
	private int total = 0; // 总共有几条数据
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
