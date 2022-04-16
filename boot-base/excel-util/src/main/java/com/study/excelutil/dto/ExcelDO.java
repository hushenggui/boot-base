package com.study.excelutil.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import java.io.Serializable;


/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2021-10-06 22:14:09
 */
public class ExcelDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//
	private String username;
	//
	private String password;
	//
	private String realname;
	//
	@ExcelProperty(value = "地址")
	private String addr;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}
	/**
	 * 获取：
	 */
	public String getRealname() {
		return realname;
	}
	/**
	 * 设置：
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/**
	 * 获取：
	 */
	public String getAddr() {
		return addr;
	}
}
