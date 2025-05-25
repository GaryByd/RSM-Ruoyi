package com.rsm.entity.dao;

import java.util.Date;


/**
 * @Description: 风险库表
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public class RsmRiskQuery extends BaseQuery {
	/**
 	 * 风险id 查询对象
 	 */
	private Long id;

	/**
 	 * 风险名称 查询对象
 	 */
	private String riskName;

	private String riskNameFuzzy;

	/**
 	 * 风险类型 查询对象
 	 */
	private String riskType;

	private String riskTypeFuzzy;

	/**
 	 * 监管人员 查询对象
 	 */
	private String supervisor;

	private String supervisorFuzzy;

	/**
 	 * 管控标准 查询对象
 	 */
	private String controlStandard;

	private String controlStandardFuzzy;

	/**
 	 * 风险等级 查询对象
 	 */
	private String riskLevel;

	private String riskLevelFuzzy;

	/**
 	 * 风险信息，作为设备风险则说明是什么设备，作为生产现场风险说明哪些生产现场，作为作业活动说明哪个作业 查询对象
 	 */
	private String riskInfo;

	private String riskInfoFuzzy;

	/**
 	 * 风险关联id，作为保留字段，如果没有设备表和生产现场表那么这个字段仅在风险类型为作业风险时有用，用于关联作业表 查询对象
 	 */
	private Long riskRelateId;

	/**
 	 * 审核人 查询对象
 	 */
	private String auditor;

	private String auditorFuzzy;

	/**
 	 * 风险描述 查询对象
 	 */
	private String riskDescribe;

	private String riskDescribeFuzzy;

	/**
 	 * 风险后果 查询对象
 	 */
	private String riskConseq;

	private String riskConseqFuzzy;

	/**
 	 * 风险管理措施 查询对象
 	 */
	private String controlMeasure;

	private String controlMeasureFuzzy;

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

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public String getRiskType() {
		return riskType;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setControlStandard(String controlStandard) {
		this.controlStandard = controlStandard;
	}

	public String getControlStandard() {
		return controlStandard;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskInfo(String riskInfo) {
		this.riskInfo = riskInfo;
	}

	public String getRiskInfo() {
		return riskInfo;
	}

	public void setRiskRelateId(Long riskRelateId) {
		this.riskRelateId = riskRelateId;
	}

	public Long getRiskRelateId() {
		return riskRelateId;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setRiskDescribe(String riskDescribe) {
		this.riskDescribe = riskDescribe;
	}

	public String getRiskDescribe() {
		return riskDescribe;
	}

	public void setRiskConseq(String riskConseq) {
		this.riskConseq = riskConseq;
	}

	public String getRiskConseq() {
		return riskConseq;
	}

	public void setControlMeasure(String controlMeasure) {
		this.controlMeasure = controlMeasure;
	}

	public String getControlMeasure() {
		return controlMeasure;
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

	public void setRiskNameFuzzy(String riskNameFuzzy) {
		this.riskNameFuzzy = riskNameFuzzy;
	}

	public String getRiskNameFuzzy() {
		return riskNameFuzzy;
	}

	public void setRiskTypeFuzzy(String riskTypeFuzzy) {
		this.riskTypeFuzzy = riskTypeFuzzy;
	}

	public String getRiskTypeFuzzy() {
		return riskTypeFuzzy;
	}

	public void setSupervisorFuzzy(String supervisorFuzzy) {
		this.supervisorFuzzy = supervisorFuzzy;
	}

	public String getSupervisorFuzzy() {
		return supervisorFuzzy;
	}

	public void setControlStandardFuzzy(String controlStandardFuzzy) {
		this.controlStandardFuzzy = controlStandardFuzzy;
	}

	public String getControlStandardFuzzy() {
		return controlStandardFuzzy;
	}

	public void setRiskLevelFuzzy(String riskLevelFuzzy) {
		this.riskLevelFuzzy = riskLevelFuzzy;
	}

	public String getRiskLevelFuzzy() {
		return riskLevelFuzzy;
	}

	public void setRiskInfoFuzzy(String riskInfoFuzzy) {
		this.riskInfoFuzzy = riskInfoFuzzy;
	}

	public String getRiskInfoFuzzy() {
		return riskInfoFuzzy;
	}

	public void setAuditorFuzzy(String auditorFuzzy) {
		this.auditorFuzzy = auditorFuzzy;
	}

	public String getAuditorFuzzy() {
		return auditorFuzzy;
	}

	public void setRiskDescribeFuzzy(String riskDescribeFuzzy) {
		this.riskDescribeFuzzy = riskDescribeFuzzy;
	}

	public String getRiskDescribeFuzzy() {
		return riskDescribeFuzzy;
	}

	public void setRiskConseqFuzzy(String riskConseqFuzzy) {
		this.riskConseqFuzzy = riskConseqFuzzy;
	}

	public String getRiskConseqFuzzy() {
		return riskConseqFuzzy;
	}

	public void setControlMeasureFuzzy(String controlMeasureFuzzy) {
		this.controlMeasureFuzzy = controlMeasureFuzzy;
	}

	public String getControlMeasureFuzzy() {
		return controlMeasureFuzzy;
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