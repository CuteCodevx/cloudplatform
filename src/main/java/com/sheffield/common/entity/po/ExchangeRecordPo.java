package com.sheffield.common.entity.po;

import java.io.Serializable;

public class ExchangeRecordPo implements Serializable {

	private static final long serialVersionUID = 1L;

	//column start
	/**
	 * recordId: record_id
	 */
	private Integer recordId;

	/**
	 * userId: user_id
	 */
	private Integer userId;

	/**
	 * userName: user_name
	 */
	private String userName;

	/**
	 * applicationId: application_id
	 */
	private Integer applicationId;

	/**
	 * applicationName: application_name
	 */
	private String applicationName;

	/**
	 * exhangeType: exhange_type
	 */
	private Integer exhangeType;

	/**
	 * isIncome: is_income
	 */
	private Integer isIncome;

	/**
	 * peanuts: peanuts
	 */
	private Long peanuts;

	/**
	 * createTime: create_time
	 */
	private java.util.Date createTime;

	/**
	 * isDeleted: is_deleted
	 */
	private Integer isDeleted;

	// column end


	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer value) {
		this.recordId = value;
	}

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

	public Integer getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(Integer value) {
		this.applicationId = value;
	}

	public String getApplicationName() {
		return this.applicationName;
	}

	public void setApplicationName(String value) {
		this.applicationName = value;
	}

	public Integer getExhangeType() {
		return this.exhangeType;
	}

	public void setExhangeType(Integer value) {
		this.exhangeType = value;
	}

	public Integer getIsIncome() {
		return this.isIncome;
	}

	public void setIsIncome(Integer value) {
		this.isIncome = value;
	}

	public Long getPeanuts() {
		return this.peanuts;
	}

	public void setPeanuts(Long value) {
		this.peanuts = value;
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

