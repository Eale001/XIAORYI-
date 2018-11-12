package com.neuedu.XiaoRyi.common;

import java.io.Serializable;

public class Page implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -901032703356061545L;
	
	/**
	 * 当前页数
	 */
	private Integer currentPage;
	
	/**
	 * 每页的条数
	 */
	private Integer pageSize = 3;
	
	/**
	 * 总页数
	 */
	private Integer totalPage;
	
	/**
	 * 总条数
	 */
	private Integer totalRows;
	
	/**
	 * 每页开始序列号
	 */
	private Integer startIndex;
	
	/**
	 * 每页结束序列号
	 */
	private Integer endIndex;
	
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
		this.startIndex = (this.currentPage-1)*this.pageSize;
		this.endIndex = this.currentPage*this.pageSize;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getTotalPage() {
		if(this.totalRows%this.pageSize == 0){
			this.totalPage = this.totalRows/this.pageSize;
		}else{
			this.totalPage = this.totalRows/this.pageSize+1;
		}
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}
	
	
}
