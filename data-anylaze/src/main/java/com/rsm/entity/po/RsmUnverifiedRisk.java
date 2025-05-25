package com.rsm.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rsm.enums.DateTimePatternEnum;
import com.rsm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * @Description: 风险待查项表
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public class RsmUnverifiedRisk implements Serializable {
	/**
 	 * 待查项id
 	 */
	private Long id;

	/**
 	 * 待查项名称
 	 */
	private String unverifiedRiskName;

	/**
 	 * 关联风险id
 	 */
	private Long riskId;

	/**
 	 * 巡查清单id
 	 */
	private Long patrolListId;

	/**
 	 * 类型
 	 */
	private String riskType;

	/**
 	 * 管理员
 	 */
	private String admin;

	/**
 	 * 巡查标准
 	 */
	private String controlStandard;

	/**
 	 * 巡查点id
 	 */
	private Long position;

	/**
 	 * 状态 0-未处理  1-未发现隐患 2-发现隐患
 	 */
	@JsonIgnore
	private Integer status;

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
	@Override
	public String toString() {
		return "待查项id:" + (id == null ? "空" : id) + "," + 
				"待查项名称:" + (unverifiedRiskName == null ? "空" : unverifiedRiskName) + "," + 
				"关联风险id:" + (riskId == null ? "空" : riskId) + "," + 
				"巡查清单id:" + (patrolListId == null ? "空" : patrolListId) + "," + 
				"类型:" + (riskType == null ? "空" : riskType) + "," + 
				"管理员:" + (admin == null ? "空" : admin) + "," + 
				"巡查标准:" + (controlStandard == null ? "空" : controlStandard) + "," + 
				"巡查点id:" + (position == null ? "空" : position) + "," + 
				"状态 0-未处理  1-未发现隐患 2-发现隐患:" + (status == null ? "空" : status) + "," + 
				"备注:" + (remark == null ? "空" : remark) + "," + 
				"创建人:" + (createBy == null ? "空" : createBy) + "," + 
				"创建时间:" + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"修改人:" + (updateBy == null ? "空" : updateBy) + "," + 
				"更新时间:" + (updateTime == null ? "空" : DateUtils.format(updateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
		}
}