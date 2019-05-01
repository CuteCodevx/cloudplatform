package com.sheffield.common.entity.po;

import java.io.Serializable;

/**
 * user
 * 
 * @since 2018年11月2日
 * @version 1.0
 */
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
	 * loginStatus: login_status
	 */
	private Integer loginStatus;

	/**
	 * userCount: user_count
	 */
	private Long userCount;

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
	
}

