package com.rsm.entity.dao;

import java.util.Date;


/**
 * @Description: 风险待查项表
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public class RsmUnverifiedRiskQuery extends BaseQuery {
	/**
 	 * 待查项id 查询对象
 	 */
	private Long id;

	/**
 	 * 待查项名称 查询对象
 	 */
	private String unverifiedRiskName;

	private String unverifiedRiskNameFuzzy;

	/**
 	 * 关联风险id 查询对象
 	 */
	private Long riskId;

	/**
 	 * 巡查清单id 查询对象
 	 */
	private Long patrolListId;

	/**
 	 * 类型 查询对象
 	 */
	private String riskType;

	private String riskTypeFuzzy;

	/**
 	 * 管理员 查询对象
 	 */
	private String admin;

	private String adminFuzzy;

	/**
 	 * 巡查标准 查询对象
 	 */
	private String controlStandard;

	private String controlStandardFuzzy;

	/**
 	 * 巡查点id 查询对象
 	 */
	private Long position;

	/**
 	 * 状态 0-未处理  1-未发现隐患 2-发现隐患 查询对象
 	 */
	private Integer status;

	/**
 	 * 备注 查询对象
 	 */
	private String remark;

	private String remarkFuzzy;

	/**
 	 * 创建人 查询对象
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
 	 * 修改人 查询对象
 	 */
	private String updateBy;

	private String updateByFuzzy;

	/**
 	 * 更新时间 查询对象
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

	public void setUnverifiedRiskName(String unverifiedRiskName) {
		this.unverifiedRiskName = unverifiedRiskName;
	}

	public String getUnverifiedRiskName() {
		return unverifiedRiskName;
	}

	public void setRiskId(Long riskId) {
		this.riskId = riskId;
	}

	public Long getRiskId() {
		return riskId;
	}

	public void setPatrolListId(Long patrolListId) {
		this.patrolListId = patrolListId;
	}

	public Long getPatrolListId() {
		return patrolListId;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public String getRiskType() {
		return riskType;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getAdmin() {
		return admin;
	}

	public void setControlStandard(String controlStandard) {
		this.controlStandard = controlStandard;
	}

	public String getControlStandard() {
		return controlStandard;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public Long getPosition() {
		return position;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
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

	public void setUnverifiedRiskNameFuzzy(String unverifiedRiskNameFuzzy) {
		this.unverifiedRiskNameFuzzy = unverifiedRiskNameFuzzy;
	}

	public String getUnverifiedRiskNameFuzzy() {
		return unverifiedRiskNameFuzzy;
	}

	public void setRiskTypeFuzzy(String riskTypeFuzzy) {
		this.riskTypeFuzzy = riskTypeFuzzy;
	}

	public String getRiskTypeFuzzy() {
		return riskTypeFuzzy;
	}

	public void setAdminFuzzy(String adminFuzzy) {
		this.adminFuzzy = adminFuzzy;
	}

	public String getAdminFuzzy() {
		return adminFuzzy;
	}

	public void setControlStandardFuzzy(String controlStandardFuzzy) {
		this.controlStandardFuzzy = controlStandardFuzzy;
	}

	public String getControlStandardFuzzy() {
		return controlStandardFuzzy;
	}

	public void setRemarkFuzzy(String remarkFuzzy) {
		this.remarkFuzzy = remarkFuzzy;
	}

	public String getRemarkFuzzy() {
		return remarkFuzzy;
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
}