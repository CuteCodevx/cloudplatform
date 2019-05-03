package com.sheffield.common.entity.po;

import java.io.Serializable;

/**
 * exchange_record
 * 
 * @since 2018年11月2日
 * @version 1.0
 */
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
	 * peanuts: peanuts
	 */
	private Long peanuts;

	/**
	 * createTime: create_time
	 */
	private java.util.Date createTime;

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
	
}

