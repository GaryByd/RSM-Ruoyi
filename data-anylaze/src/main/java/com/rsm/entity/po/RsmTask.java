package com.rsm.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rsm.enums.DateTimePatternEnum;
import com.rsm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 作业表
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public class RsmTask implements Serializable {
	/**
 	 * 作业id，主键
 	 */
	private Long id;

	/**
 	 * 作业名称
 	 */
	private String taskName;

	/**
 	 * 类型名称
 	 */
	private String typeName;

	/**
 	 * 班组名称
 	 */
	private String deptName;

	/**
 	 * 作业开始时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;

	/**
 	 * 作业结束时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;

	/**
 	 * 风险关联id
 	 */
	private Long riskId;

	/**
 	 * 负责人姓名
 	 */
	private String mandateHolder;

	/**
 	 * 审核状态（ 0审核中 1通过2未通过 3通过且成功加入待查项）
 	 */
	private Integer approvalStatus;

	/**
 	 * 审核人姓名
 	 */
	private String reviewer;

	/**
 	 * 作业描述
 	 */
	private String taskDesc;

	/**
 	 * 巡查点位置id
 	 */
	private Long positionId;

	/**
 	 * 创建人
 	 */
	private String createBy;

	/**
 	 * 备注（审核意见）
 	 */
	private String remark;

	/**
 	 * 创建时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
 	 * 修改人
 	 */
	private String updateBy;

	/**
 	 * 修改时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;


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
	@Override
	public String toString() {
		return "作业id，主键:" + (id == null ? "空" : id) + "," + 
				"作业名称:" + (taskName == null ? "空" : taskName) + "," + 
				"类型名称:" + (typeName == null ? "空" : typeName) + "," + 
				"班组名称:" + (deptName == null ? "空" : deptName) + "," + 
				"作业开始时间:" + (startTime == null ? "空" : DateUtils.format(startTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"作业结束时间:" + (endTime == null ? "空" : DateUtils.format(endTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"风险关联id:" + (riskId == null ? "空" : riskId) + "," + 
				"负责人姓名:" + (mandateHolder == null ? "空" : mandateHolder) + "," + 
				"审核状态（ 0审核中 1通过2未通过 3通过且成功加入待查项）:" + (approvalStatus == null ? "空" : approvalStatus) + "," + 
				"审核人姓名:" + (reviewer == null ? "空" : reviewer) + "," + 
				"作业描述:" + (taskDesc == null ? "空" : taskDesc) + "," + 
				"巡查点位置id:" + (positionId == null ? "空" : positionId) + "," + 
				"创建人:" + (createBy == null ? "空" : createBy) + "," + 
				"备注（审核意见）:" + (remark == null ? "空" : remark) + "," + 
				"创建时间:" + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"修改人:" + (updateBy == null ? "空" : updateBy) + "," + 
				"修改时间:" + (updateTime == null ? "空" : DateUtils.format(updateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
		}
}