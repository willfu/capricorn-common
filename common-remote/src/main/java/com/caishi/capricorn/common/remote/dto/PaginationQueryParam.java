package com.caishi.capricorn.common.remote.dto;

import java.io.Serializable;

/**
 * Created by apple on 15/7/1.
 * <p/>
 * 分页查询参数
 */
public class PaginationQueryParam implements Serializable {

	public static final int DEFAULT_PAGE_NUM = 0;
	public static final int DEFAULT_PAGE_SIZE = 20;

	private int pageNum;
	private int pageSize;

	public PaginationQueryParam() {
	}

	public PaginationQueryParam(int pageNum, int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
