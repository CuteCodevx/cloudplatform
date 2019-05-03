package com.sheffield.common.entity.po;

import java.io.Serializable;

/**
 * application
 * 
 * @since 2018年11月2日
 * @version 1.0
 */
public class ApplicationPo implements Serializable {

	private static final long serialVersionUID = 1L;

	//column start
	/**
	 * appilcationId: appilcation_id
	 */
	private Integer appilcationId;

	/**
	 * userId: user_id
	 */
	private Integer userId;

	/**
	 * userName: user_name
	 */
	private Integer userName;

	/**
	 * applicationName: application_name
	 */
	private String applicationName;

	/**
	 * description: description
	 */
	private String description;

	/**
	 * fileUrl: file_url
	 */
	private String fileUrl;

	/**
	 * imageUrl: image_url
	 */
	private String imageUrl;

	/**
	 * linkUrl: link_url
	 */
	private String linkUrl;

	/**
	 * checkStatus: check_status
	 */
	private Integer checkStatus;

	/**
	 * createTime: create_time
	 */
	private java.util.Date createTime;

	/**
	 * isDeleted: is_deleted
	 */
	private Integer isDeleted;

	// column end


	public Integer getAppilcationId() {
		return this.appilcationId;
	}

	public void setAppilcationId(Integer value) {
		this.appilcationId = value;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer value) {
		this.userId = value;
	}

	public Integer getUserName() {
		return this.userName;
	}

	public void setUserName(Integer value) {
		this.userName = value;
	}

	public String getApplicationName() {
		return this.applicationName;
	}

	public void setApplicationName(String value) {
		this.applicationName = value;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public String getFileUrl() {
		return this.fileUrl;
	}

	public void setFileUrl(String value) {
		this.fileUrl = value;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String value) {
		this.imageUrl = value;
	}

	public String getLinkUrl() {
		return this.linkUrl;
	}

	public void setLinkUrl(String value) {
		this.linkUrl = value;
	}

	public Integer getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(Integer value) {
		this.checkStatus = value;
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

