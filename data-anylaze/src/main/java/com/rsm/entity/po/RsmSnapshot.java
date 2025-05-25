package com.rsm.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rsm.enums.DateTimePatternEnum;
import com.rsm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 随手拍问题表
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public class RsmSnapshot implements Serializable {
	/**
 	 * 随手拍id
 	 */
	private Long id;

	/**
 	 * 问题标题
 	 */
	private String questionTitle;

	/**
 	 * 问题描述
 	 */
	private String questionDesc;

	/**
 	 * 上传人id
 	 */
	private Long creatorId;

	/**
 	 * 图片路径
 	 */
	private String imgPath;

	/**
 	 * 审批人id -1就是还没有人审批
 	 */
	private Long handlerId;

	/**
 	 * 审批回复
 	 */
	private String approvalReply;

	/**
 	 * 事件定性 0-未审核 1-隐患 2-非隐患
 	 */
	private Integer property;

	/**
 	 * 处理时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date handlerTime;

	/**
 	 * 创建时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
 	 * 修改时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	/**
 	 * 备注
 	 */
	private String remark;


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
	@Override
	public String toString() {
		return "随手拍id:" + (id == null ? "空" : id) + "," + 
				"问题标题:" + (questionTitle == null ? "空" : questionTitle) + "," + 
				"问题描述:" + (questionDesc == null ? "空" : questionDesc) + "," + 
				"上传人id:" + (creatorId == null ? "空" : creatorId) + "," + 
				"图片路径:" + (imgPath == null ? "空" : imgPath) + "," + 
				"审批人id -1就是还没有人审批:" + (handlerId == null ? "空" : handlerId) + "," + 
				"审批回复:" + (approvalReply == null ? "空" : approvalReply) + "," + 
				"事件定性 0-未审核 1-隐患 2-非隐患:" + (property == null ? "空" : property) + "," + 
				"处理时间:" + (handlerTime == null ? "空" : DateUtils.format(handlerTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"创建时间:" + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"修改时间:" + (updateTime == null ? "空" : DateUtils.format(updateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"备注:" + (remark == null ? "空" : remark);
		}
}