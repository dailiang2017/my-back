package com.dail.page;

import java.io.Serializable;

/**
 * 分页
 */
public class Pagination implements Serializable{

	private static final long serialVersionUID = 1L;

	private int pageNo = 1; //当前页号, 默认第 1 页
	private int pageSize = 10; //每页显示记录数, 默认 10 条


	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}



}
