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
	 * applicationName: application_name
	 */
	private String applicationName;

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

	public String getApplicationName() {
		return this.applicationName;
	}

	public void setApplicationName(String value) {
		this.applicationName = value;
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
	
}

