package com.rsm.entity.dao;

import java.util.Date;


/**
 * @Description: 随手拍问题表
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public class RsmSnapshotQuery extends BaseQuery {
	/**
 	 * 随手拍id 查询对象
 	 */
	private Long id;

	/**
 	 * 问题标题 查询对象
 	 */
	private String questionTitle;

	private String questionTitleFuzzy;

	/**
 	 * 问题描述 查询对象
 	 */
	private String questionDesc;

	private String questionDescFuzzy;

	/**
 	 * 上传人id 查询对象
 	 */
	private Long creatorId;

	/**
 	 * 图片路径 查询对象
 	 */
	private String imgPath;

	private String imgPathFuzzy;

	/**
 	 * 审批人id -1就是还没有人审批 查询对象
 	 */
	private Long handlerId;

	/**
 	 * 审批回复 查询对象
 	 */
	private String approvalReply;

	private String approvalReplyFuzzy;

	/**
 	 * 事件定性 0-未审核 1-隐患 2-非隐患 查询对象
 	 */
	private Integer property;

	/**
 	 * 处理时间 查询对象
 	 */
	private Date handlerTime;

	private String handlerTimeStart;
	private String handlerTimeEnd;
	/**
 	 * 创建时间 查询对象
 	 */
	private Date createTime;

	private String createTimeStart;
	private String createTimeEnd;
	/**
 	 * 修改时间 查询对象
 	 */
	private Date updateTime;

	private String updateTimeStart;
	private String updateTimeEnd;
	/**
 	 * 备注 查询对象
 	 */
	private String remark;

	private String remarkFuzzy;


	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setHandlerId(Long handlerId) {
		this.handlerId = handlerId;
	}

	public Long getHandlerId() {
		return handlerId;
	}

	public void setApprovalReply(String approvalReply) {
		this.approvalReply = approvalReply;
	}

	public String getApprovalReply() {
		return approvalReply;
	}

	public void setProperty(Integer property) {
		this.property = property;
	}

	public Integer getProperty() {
		return property;
	}

	public void setHandlerTime(Date handlerTime) {
		this.handlerTime = handlerTime;
	}

	public Date getHandlerTime() {
		return handlerTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public void setQuestionTitleFuzzy(String questionTitleFuzzy) {
		this.questionTitleFuzzy = questionTitleFuzzy;
	}

	public String getQuestionTitleFuzzy() {
		return questionTitleFuzzy;
	}

	public void setQuestionDescFuzzy(String questionDescFuzzy) {
		this.questionDescFuzzy = questionDescFuzzy;
	}

	public String getQuestionDescFuzzy() {
		return questionDescFuzzy;
	}

	public void setImgPathFuzzy(String imgPathFuzzy) {
		this.imgPathFuzzy = imgPathFuzzy;
	}

	public String getImgPathFuzzy() {
		return imgPathFuzzy;
	}

	public void setApprovalReplyFuzzy(String approvalReplyFuzzy) {
		this.approvalReplyFuzzy = approvalReplyFuzzy;
	}

	public String getApprovalReplyFuzzy() {
		return approvalReplyFuzzy;
	}

	public void setHandlerTimeStart(String handlerTimeStart) {
		this.handlerTimeStart = handlerTimeStart;
	}

	public String getHandlerTimeStart() {
		return handlerTimeStart;
	}

	public void setHandlerTimeEnd(String handlerTimeEnd) {
		this.handlerTimeEnd = handlerTimeEnd;
	}

	public String getHandlerTimeEnd() {
		return handlerTimeEnd;
	}

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setUpdateTimeStart(String updateTimeStart) {
		this.updateTimeStart = updateTimeStart;
	}

	public String getUpdateTimeStart() {
		return updateTimeStart;
	}

	public void setUpdateTimeEnd(String updateTimeEnd) {
		this.updateTimeEnd = updateTimeEnd;
	}

	public String getUpdateTimeEnd() {
		return updateTimeEnd;
	}

	public void setRemarkFuzzy(String remarkFuzzy) {
		this.remarkFuzzy = remarkFuzzy;
	}

	public String getRemarkFuzzy() {
		return remarkFuzzy;
	}
}