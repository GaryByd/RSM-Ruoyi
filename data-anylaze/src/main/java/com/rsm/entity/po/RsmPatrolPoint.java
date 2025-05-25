package com.rsm.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rsm.enums.DateTimePatternEnum;
import com.rsm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * @Description: 巡查点表
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public class RsmPatrolPoint implements Serializable {
	/**
 	 * 巡查点id
 	 */
	private Long id;

	/**
 	 * 巡查点名称
 	 */
	private String patrolName;

	/**
 	 * 巡查点描述
 	 */
	private String patrolDesc;

	/**
 	 * 巡查点位置名
 	 */
	private String position;

	/**
 	 * 具体位置描述
 	 */
	private String locationDescribe;

	/**
 	 * 安全员
 	 */
	private String securityOfficer;

	/**
 	 * 最近一次巡查时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastPatrolTime;

	/**
 	 * 巡查次数
 	 */
	private Integer patrolFrequency;

	/**
 	 * 状态 0-正常 1-停用
 	 */
	@JsonIgnore
	private Integer status;

	/**
 	 * 删除标志（0代表存在 1代表删除）
 	 */
	private Integer delFlag;

	/**
 	 * 创建者
 	 */
	private String createBy;

	/**
 	 * 创建时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
 	 * 更新者
 	 */
	private String updateBy;

	/**
 	 * 更新时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	/**
 	 * 备注信息
 	 */
	private String remark;


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
	@Override
	public String toString() {
		return "巡查点id:" + (id == null ? "空" : id) + "," + 
				"巡查点名称:" + (patrolName == null ? "空" : patrolName) + "," + 
				"巡查点描述:" + (patrolDesc == null ? "空" : patrolDesc) + "," + 
				"巡查点位置名:" + (position == null ? "空" : position) + "," + 
				"具体位置描述:" + (locationDescribe == null ? "空" : locationDescribe) + "," + 
				"安全员:" + (securityOfficer == null ? "空" : securityOfficer) + "," + 
				"最近一次巡查时间:" + (lastPatrolTime == null ? "空" : DateUtils.format(lastPatrolTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"巡查次数:" + (patrolFrequency == null ? "空" : patrolFrequency) + "," + 
				"状态 0-正常 1-停用:" + (status == null ? "空" : status) + "," + 
				"删除标志（0代表存在 1代表删除）:" + (delFlag == null ? "空" : delFlag) + "," + 
				"创建者:" + (createBy == null ? "空" : createBy) + "," + 
				"创建时间:" + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"更新者:" + (updateBy == null ? "空" : updateBy) + "," + 
				"更新时间:" + (updateTime == null ? "空" : DateUtils.format(updateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"备注信息:" + (remark == null ? "空" : remark);
		}
}