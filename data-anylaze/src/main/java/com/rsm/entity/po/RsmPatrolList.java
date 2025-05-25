package com.rsm.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rsm.enums.DateTimePatternEnum;
import com.rsm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * @Description: 巡查清单表
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public class RsmPatrolList implements Serializable {
	/**
 	 * 清单id
 	 */
	private Long id;

	/**
 	 * 巡查清单名称
 	 */
	private String patrolListName;

	/**
 	 * 安全员id
 	 */
	private Long principalId;

	/**
 	 * 开始时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;

	/**
 	 * 结束时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;

	/**
 	 * 总的待查项数量
 	 */
	private Integer waitingChecked;

	/**
 	 * 已检查数量
 	 */
	private Integer checkedCount;

	/**
 	 * 发现隐患数量
 	 */
	private Integer hiddenTroubleCount;

	/**
 	 * 完成时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date finishTime;

	/**
 	 * 状态 0-未开始 1-巡查中 2-已结束
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
 	 * 更新时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	/**
 	 * 修改者
 	 */
	private String updateBy;

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
	@Override
	public String toString() {
		return "清单id:" + (id == null ? "空" : id) + "," + 
				"巡查清单名称:" + (patrolListName == null ? "空" : patrolListName) + "," + 
				"安全员id:" + (principalId == null ? "空" : principalId) + "," + 
				"开始时间:" + (startTime == null ? "空" : DateUtils.format(startTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"结束时间:" + (endTime == null ? "空" : DateUtils.format(endTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"总的待查项数量:" + (waitingChecked == null ? "空" : waitingChecked) + "," + 
				"已检查数量:" + (checkedCount == null ? "空" : checkedCount) + "," + 
				"发现隐患数量:" + (hiddenTroubleCount == null ? "空" : hiddenTroubleCount) + "," + 
				"完成时间:" + (finishTime == null ? "空" : DateUtils.format(finishTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"状态 0-未开始 1-巡查中 2-已结束:" + (status == null ? "空" : status) + "," + 
				"删除标志（0代表存在 1代表删除）:" + (delFlag == null ? "空" : delFlag) + "," + 
				"创建者:" + (createBy == null ? "空" : createBy) + "," + 
				"创建时间:" + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"更新时间:" + (updateTime == null ? "空" : DateUtils.format(updateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"修改者:" + (updateBy == null ? "空" : updateBy) + "," + 
				"备注信息:" + (remark == null ? "空" : remark);
		}
}