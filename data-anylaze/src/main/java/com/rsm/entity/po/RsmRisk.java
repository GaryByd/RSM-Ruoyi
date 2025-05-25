package com.rsm.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rsm.enums.DateTimePatternEnum;
import com.rsm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 风险库表
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public class RsmRisk implements Serializable {
	/**
 	 * 风险id
 	 */
	private Long id;

	/**
 	 * 风险名称
 	 */
	private String riskName;

	/**
 	 * 风险类型
 	 */
	private String riskType;

	/**
 	 * 监管人员
 	 */
	private String supervisor;

	/**
 	 * 管控标准
 	 */
	private String controlStandard;

	/**
 	 * 风险等级
 	 */
	private String riskLevel;

	/**
 	 * 风险信息，作为设备风险则说明是什么设备，作为生产现场风险说明哪些生产现场，作为作业活动说明哪个作业
 	 */
	private String riskInfo;

	/**
 	 * 风险关联id，作为保留字段，如果没有设备表和生产现场表那么这个字段仅在风险类型为作业风险时有用，用于关联作业表
 	 */
	private Long riskRelateId;

	/**
 	 * 审核人
 	 */
	private String auditor;

	/**
 	 * 风险描述
 	 */
	private String riskDescribe;

	/**
 	 * 风险后果
 	 */
	private String riskConseq;

	/**
 	 * 风险管理措施
 	 */
	private String controlMeasure;

	/**
 	 * 备注
 	 */
	private String remark;

	/**
 	 * 创建人
 	 */
	private String createBy;

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
 	 * 更新时间
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
	@Override
	public String toString() {
		return "风险id:" + (id == null ? "空" : id) + "," + 
				"风险名称:" + (riskName == null ? "空" : riskName) + "," + 
				"风险类型:" + (riskType == null ? "空" : riskType) + "," + 
				"监管人员:" + (supervisor == null ? "空" : supervisor) + "," + 
				"管控标准:" + (controlStandard == null ? "空" : controlStandard) + "," + 
				"风险等级:" + (riskLevel == null ? "空" : riskLevel) + "," + 
				"风险信息，作为设备风险则说明是什么设备，作为生产现场风险说明哪些生产现场，作为作业活动说明哪个作业:" + (riskInfo == null ? "空" : riskInfo) + "," + 
				"风险关联id，作为保留字段，如果没有设备表和生产现场表那么这个字段仅在风险类型为作业风险时有用，用于关联作业表:" + (riskRelateId == null ? "空" : riskRelateId) + "," + 
				"审核人:" + (auditor == null ? "空" : auditor) + "," + 
				"风险描述:" + (riskDescribe == null ? "空" : riskDescribe) + "," + 
				"风险后果:" + (riskConseq == null ? "空" : riskConseq) + "," + 
				"风险管理措施:" + (controlMeasure == null ? "空" : controlMeasure) + "," + 
				"备注:" + (remark == null ? "空" : remark) + "," + 
				"创建人:" + (createBy == null ? "空" : createBy) + "," + 
				"创建时间:" + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"修改人:" + (updateBy == null ? "空" : updateBy) + "," + 
				"更新时间:" + (updateTime == null ? "空" : DateUtils.format(updateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
		}
}