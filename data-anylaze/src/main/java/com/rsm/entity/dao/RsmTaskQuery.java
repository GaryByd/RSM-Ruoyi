package com.rsm.entity.dao;

import java.util.Date;


/**
 * @Description: 作业表
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public class RsmTaskQuery extends BaseQuery {
	/**
 	 * 作业id，主键 查询对象
 	 */
	private Long id;

	/**
 	 * 作业名称 查询对象
 	 */
	private String taskName;

	private String taskNameFuzzy;

	/**
 	 * 类型名称 查询对象
 	 */
	private String typeName;

	private String typeNameFuzzy;

	/**
 	 * 班组名称 查询对象
 	 */
	private String deptName;

	private String deptNameFuzzy;

	/**
 	 * 作业开始时间 查询对象
 	 */
	private Date startTime;

	private String startTimeStart;
	private String startTimeEnd;
	/**
 	 * 作业结束时间 查询对象
 	 */
	private Date endTime;

	private String endTimeStart;
	private String endTimeEnd;
	/**
 	 * 风险关联id 查询对象
 	 */
	private Long riskId;

	/**
 	 * 负责人姓名 查询对象
 	 */
	private String mandateHolder;

	private String mandateHolderFuzzy;

	/**
 	 * 审核状态（ 0审核中 1通过2未通过 3通过且成功加入待查项） 查询对象
 	 */
	private Integer approvalStatus;

	/**
 	 * 审核人姓名 查询对象
 	 */
	private String reviewer;

	private String reviewerFuzzy;

	/**
 	 * 作业描述 查询对象
 	 */
	private String taskDesc;

	private String taskDescFuzzy;

	/**
 	 * 巡查点位置id 查询对象
 	 */
	private Long positionId;

	/**
 	 * 创建人 查询对象
 	 */
	private String createBy;

	private String createByFuzzy;

	/**
 	 * 备注（审核意见） 查询对象
 	 */
	private String remark;

	private String remarkFuzzy;

	/**
 	 * 创建时间 查询对象
 	 */
	private Date createTime;

	private String createTimeStart;
	private String createTimeEnd;
	/**
 	 * 修改人 查询对象
 	 */
	private String updateBy;

	private String updateByFuzzy;

	/**
 	 * 修改时间 查询对象
 	 */
	private Date updateTime;

	private String updateTimeStart;
	private String updateTimeEnd;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setRiskId(Long riskId) {
		this.riskId = riskId;
	}

	public Long getRiskId() {
		return riskId;
	}

	public void setMandateHolder(String mandateHolder) {
		this.mandateHolder = mandateHolder;
	}

	public String getMandateHolder() {
		return mandateHolder;
	}

	public void setApprovalStatus(Integer approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Integer getApprovalStatus() {
		return approvalStatus;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public Long getPositionId() {
		return positionId;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setTaskNameFuzzy(String taskNameFuzzy) {
		this.taskNameFuzzy = taskNameFuzzy;
	}

	public String getTaskNameFuzzy() {
		return taskNameFuzzy;
	}

	public void setTypeNameFuzzy(String typeNameFuzzy) {
		this.typeNameFuzzy = typeNameFuzzy;
	}

	public String getTypeNameFuzzy() {
		return typeNameFuzzy;
	}

	public void setDeptNameFuzzy(String deptNameFuzzy) {
		this.deptNameFuzzy = deptNameFuzzy;
	}

	public String getDeptNameFuzzy() {
		return deptNameFuzzy;
	}

	public void setStartTimeStart(String startTimeStart) {
		this.startTimeStart = startTimeStart;
	}

	public String getStartTimeStart() {
		return startTimeStart;
	}

	public void setStartTimeEnd(String startTimeEnd) {
		this.startTimeEnd = startTimeEnd;
	}

	public String getStartTimeEnd() {
		return startTimeEnd;
	}

	public void setEndTimeStart(String endTimeStart) {
		this.endTimeStart = endTimeStart;
	}

	public String getEndTimeStart() {
		return endTimeStart;
	}

	public void setEndTimeEnd(String endTimeEnd) {
		this.endTimeEnd = endTimeEnd;
	}

	public String getEndTimeEnd() {
		return endTimeEnd;
	}

	public void setMandateHolderFuzzy(String mandateHolderFuzzy) {
		this.mandateHolderFuzzy = mandateHolderFuzzy;
	}

	public String getMandateHolderFuzzy() {
		return mandateHolderFuzzy;
	}

	public void setReviewerFuzzy(String reviewerFuzzy) {
		this.reviewerFuzzy = reviewerFuzzy;
	}

	public String getReviewerFuzzy() {
		return reviewerFuzzy;
	}

	public void setTaskDescFuzzy(String taskDescFuzzy) {
		this.taskDescFuzzy = taskDescFuzzy;
	}

	public String getTaskDescFuzzy() {
		return taskDescFuzzy;
	}

	public void setCreateByFuzzy(String createByFuzzy) {
		this.createByFuzzy = createByFuzzy;
	}

	public String getCreateByFuzzy() {
		return createByFuzzy;
	}

	public void setRemarkFuzzy(String remarkFuzzy) {
		this.remarkFuzzy = remarkFuzzy;
	}

	public String getRemarkFuzzy() {
		return remarkFuzzy;
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

	public void setUpdateByFuzzy(String updateByFuzzy) {
		this.updateByFuzzy = updateByFuzzy;
	}

	public String getUpdateByFuzzy() {
		return updateByFuzzy;
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
}