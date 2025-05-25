package com.rc.rsm.domain.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 作业对象 rsm_task
 *
 * @author ruoyi
 * @date 2024-09-08
 */
public class RsmTask extends BaseEntity implements Cloneable {
    private static final long serialVersionUID = 1L;

    /**
     * 作业id
     */
    private Long id;

    /**
     * 作业名称
     */
    @Excel(name = "作业名称")
    private String taskName;

    /**
     * 类型名称
     */
    @Excel(name = "类型名称")
    private String typeName;

    /**
     * 班组名称
     */
    @Excel(name = "班组名称")
    private String deptName;

    /**
     * 作业开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "作业开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /**
     * 作业结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "作业结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /**
     * 风险关联id
     */
    @Excel(name = "风险关联id")
    private Long riskId;

    /**
     * 负责人姓名
     */
    @Excel(name = "负责人姓名")
    private String mandateHolder;

    /**
     * 审核状态（1通过 0未审核 2未通过）
     */
    @Excel(name = "审核状态", readConverterExp = "1=通过,0=未审核,2=未通过")
    private Integer approvalStatus;

    /**
     * 审核人姓名
     */
    @Excel(name = "审核人姓名")
    private String reviewer;

    /**
     * 作业描述
     */
    @Excel(name = "作业描述")
    private String taskDesc;

    /**
     * 巡查点位置id
     */
    @Excel(name = "巡查点位置id")
    private Long positionId;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("taskName", getTaskName())
                .append("typeName", getTypeName())
                .append("deptName", getDeptName())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("riskId", getRiskId())
                .append("mandateHolder", getMandateHolder())
                .append("approvalStatus", getApprovalStatus())
                .append("reviewer", getReviewer())
                .append("taskDesc", getTaskDesc())
                .append("positionId", getPositionId())
                .append("createBy", getCreateBy())
                .append("remark", getRemark())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
