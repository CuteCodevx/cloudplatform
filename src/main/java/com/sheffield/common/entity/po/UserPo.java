package com.sheffield.common.entity.po;

import java.io.Serializable;

public class UserPo implements Serializable {

	private static final long serialVersionUID = 1L;

	//column start
	/**
	 * userId: user_id
	 */
	private Integer userId;

	/**
	 * userName: user_name
	 */
	private String userName;

	/**
	 * password: password
	 */
	private String password;

	/**
	 * role: role
	 */
	private Integer role;

	/**
	 * loginStatus: login_status
	 */
	private Integer loginStatus;

	/**
	 * userCount: user_count
	 */
	private Long userCount;

	/**
	 * createTime: create_time
	 */
	private java.util.Date createTime;

	/**
	 * isDeleted: is_deleted
	 */
	private Integer isDeleted;

	// column end


	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer value) {
		this.userId = value;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String value) {
		this.userName = value;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String value) {
		this.password = value;
	}

	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer value) {
		this.role = value;
	}

	public Integer getLoginStatus() {
		return this.loginStatus;
	}

	public void setLoginStatus(Integer value) {
		this.loginStatus = value;
	}

	public Long getUserCount() {
		return this.userCount;
	}

	public void setUserCount(Long value) {
		this.userCount = value;
	}

	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}

	public Integer getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Integer value) {
		this.isDeleted = value;
	}
	
}

