package com.rsm.entity.dao;

import java.util.Date;


/**
 * @Description: 巡查点表
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public class RsmPatrolPointQuery extends BaseQuery {
	/**
 	 * 巡查点id 查询对象
 	 */
	private Long id;

	/**
 	 * 巡查点名称 查询对象
 	 */
	private String patrolName;

	private String patrolNameFuzzy;

	/**
 	 * 巡查点描述 查询对象
 	 */
	private String patrolDesc;

	private String patrolDescFuzzy;

	/**
 	 * 巡查点位置名 查询对象
 	 */
	private String position;

	private String positionFuzzy;

	/**
 	 * 具体位置描述 查询对象
 	 */
	private String locationDescribe;

	private String locationDescribeFuzzy;

	/**
 	 * 安全员 查询对象
 	 */
	private String securityOfficer;

	private String securityOfficerFuzzy;

	/**
 	 * 最近一次巡查时间 查询对象
 	 */
	private Date lastPatrolTime;

	private String lastPatrolTimeStart;
	private String lastPatrolTimeEnd;
	/**
 	 * 巡查次数 查询对象
 	 */
	private Integer patrolFrequency;

	/**
 	 * 状态 0-正常 1-停用 查询对象
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
 	 * 更新者 查询对象
 	 */
	private String updateBy;

	private String updateByFuzzy;

	/**
 	 * 更新时间 查询对象
 	 */
	private Date updateTime;

	private String updateTimeStart;
	private String updateTimeEnd;
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

	public void setPatrolName(String patrolName) {
		this.patrolName = patrolName;
	}

	public String getPatrolName() {
		return patrolName;
	}

	public void setPatrolDesc(String patrolDesc) {
		this.patrolDesc = patrolDesc;
	}

	public String getPatrolDesc() {
		return patrolDesc;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public void setLocationDescribe(String locationDescribe) {
		this.locationDescribe = locationDescribe;
	}

	public String getLocationDescribe() {
		return locationDescribe;
	}

	public void setSecurityOfficer(String securityOfficer) {
		this.securityOfficer = securityOfficer;
	}

	public String getSecurityOfficer() {
		return securityOfficer;
	}

	public void setLastPatrolTime(Date lastPatrolTime) {
		this.lastPatrolTime = lastPatrolTime;
	}

	public Date getLastPatrolTime() {
		return lastPatrolTime;
	}

	public void setPatrolFrequency(Integer patrolFrequency) {
		this.patrolFrequency = patrolFrequency;
	}

	public Integer getPatrolFrequency() {
		return patrolFrequency;
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

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public void setPatrolNameFuzzy(String patrolNameFuzzy) {
		this.patrolNameFuzzy = patrolNameFuzzy;
	}

	public String getPatrolNameFuzzy() {
		return patrolNameFuzzy;
	}

	public void setPatrolDescFuzzy(String patrolDescFuzzy) {
		this.patrolDescFuzzy = patrolDescFuzzy;
	}

	public String getPatrolDescFuzzy() {
		return patrolDescFuzzy;
	}

	public void setPositionFuzzy(String positionFuzzy) {
		this.positionFuzzy = positionFuzzy;
	}

	public String getPositionFuzzy() {
		return positionFuzzy;
	}

	public void setLocationDescribeFuzzy(String locationDescribeFuzzy) {
		this.locationDescribeFuzzy = locationDescribeFuzzy;
	}

	public String getLocationDescribeFuzzy() {
		return locationDescribeFuzzy;
	}

	public void setSecurityOfficerFuzzy(String securityOfficerFuzzy) {
		this.securityOfficerFuzzy = securityOfficerFuzzy;
	}

	public String getSecurityOfficerFuzzy() {
		return securityOfficerFuzzy;
	}

	public void setLastPatrolTimeStart(String lastPatrolTimeStart) {
		this.lastPatrolTimeStart = lastPatrolTimeStart;
	}

	public String getLastPatrolTimeStart() {
		return lastPatrolTimeStart;
	}

	public void setLastPatrolTimeEnd(String lastPatrolTimeEnd) {
		this.lastPatrolTimeEnd = lastPatrolTimeEnd;
	}

	public String getLastPatrolTimeEnd() {
		return lastPatrolTimeEnd;
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

	public void setRemarkFuzzy(String remarkFuzzy) {
		this.remarkFuzzy = remarkFuzzy;
	}

	public String getRemarkFuzzy() {
		return remarkFuzzy;
	}
}