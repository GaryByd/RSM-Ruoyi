package com.rsm.entity.dao;

import java.util.Date;


/**
 * @Description: 巡查清单表
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public class RsmPatrolListQuery extends BaseQuery {
	/**
 	 * 清单id 查询对象
 	 */
	private Long id;

	/**
 	 * 巡查清单名称 查询对象
 	 */
	private String patrolListName;

	private String patrolListNameFuzzy;

	/**
 	 * 安全员id 查询对象
 	 */
	private Long principalId;

	/**
 	 * 开始时间 查询对象
 	 */
	private Date startTime;

	private String startTimeStart;
	private String startTimeEnd;
	/**
 	 * 结束时间 查询对象
 	 */
	private Date endTime;

	private String endTimeStart;
	private String endTimeEnd;
	/**
 	 * 总的待查项数量 查询对象
 	 */
	private Integer waitingChecked;

	/**
 	 * 已检查数量 查询对象
 	 */
	private Integer checkedCount;

	/**
 	 * 发现隐患数量 查询对象
 	 */
	private Integer hiddenTroubleCount;

	/**
 	 * 完成时间 查询对象
 	 */
	private Date finishTime;

	private String finishTimeStart;
	private String finishTimeEnd;
	/**
 	 * 状态 0-未开始 1-巡查中 2-已结束 查询对象
 	 */
	private Integer status;

	/**
 	 * 删除标志（0代表存在 1代表删除） 查询对象
 	 */
	private Integer delFlag;

	/**
 	 * 创建者 查询对象
 	 */
	private String createBy;

	private String createByFuzzy;

	/**
 	 * 创建时间 查询对象
 	 */
	private Date createTime;

	private String createTimeStart;
	private String createTimeEnd;
	/**
 	 * 更新时间 查询对象
 	 */
	private Date updateTime;

	private String updateTimeStart;
	private String updateTimeEnd;
	/**
 	 * 修改者 查询对象
 	 */
	private String updateBy;

	private String updateByFuzzy;

	/**
 	 * 备注信息 查询对象
 	 */
	private String remark;

	private String remarkFuzzy;


	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setPatrolListName(String patrolListName) {
		this.patrolListName = patrolListName;
	}

	public String getPatrolListName() {
		return patrolListName;
	}

	public void setPrincipalId(Long principalId) {
		this.principalId = principalId;
	}

	public Long getPrincipalId() {
		return principalId;
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

	public void setWaitingChecked(Integer waitingChecked) {
		this.waitingChecked = waitingChecked;
	}

	public Integer getWaitingChecked() {
		return waitingChecked;
	}

	public void setCheckedCount(Integer checkedCount) {
		this.checkedCount = checkedCount;
	}

	public Integer getCheckedCount() {
		return checkedCount;
	}

	public void setHiddenTroubleCount(Integer hiddenTroubleCount) {
		this.hiddenTroubleCount = hiddenTroubleCount;
	}

	public Integer getHiddenTroubleCount() {
		return hiddenTroubleCount;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateBy() {
		return createBy;
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

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public void setPatrolListNameFuzzy(String patrolListNameFuzzy) {
		this.patrolListNameFuzzy = patrolListNameFuzzy;
	}

	public String getPatrolListNameFuzzy() {
		return patrolListNameFuzzy;
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

	public void setFinishTimeStart(String finishTimeStart) {
		this.finishTimeStart = finishTimeStart;
	}

	public String getFinishTimeStart() {
		return finishTimeStart;
	}

	public void setFinishTimeEnd(String finishTimeEnd) {
		this.finishTimeEnd = finishTimeEnd;
	}

	public String getFinishTimeEnd() {
		return finishTimeEnd;
	}

	public void setCreateByFuzzy(String createByFuzzy) {
		this.createByFuzzy = createByFuzzy;
	}

	public String getCreateByFuzzy() {
		return createByFuzzy;
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

	public void setUpdateByFuzzy(String updateByFuzzy) {
		this.updateByFuzzy = updateByFuzzy;
	}

	public String getUpdateByFuzzy() {
		return updateByFuzzy;
	}

	public void setRemarkFuzzy(String remarkFuzzy) {
		this.remarkFuzzy = remarkFuzzy;
	}

	public String getRemarkFuzzy() {
		return remarkFuzzy;
	}
}