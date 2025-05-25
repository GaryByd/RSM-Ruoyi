package com.rc.rsm.domain.po;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 巡查清单对象 rsm_patrol_list
 * 
 * @author ruoyi
 * @date 2024-09-10
 */
public class RsmPatrolList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 清单id */
    private Long id;

    /** 巡查清单名称 */
    @Excel(name = "巡查清单名称")
    private String patrolListName;

    /** 安全员id */
    @Excel(name = "安全员id")
    private Long principalId;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 待查项数量 */
    @Excel(name = "待查项数量")
    private Integer waitingChecked;

    /** 已检查数量 */
    @Excel(name = "已检查数量")
    private Integer checkedCount;

    /** 发现隐患数量 */
    @Excel(name = "发现隐患数量")
    private Integer hiddenTroubleCount;

    /** 完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date finishTime;

    /** 状态 0-未开始 1-巡查中 2-已结束 */
    @Excel(name = "状态 0-未开始 1-巡查中 2-已结束")
    private Integer status;

    /** 删除标志（0代表存在 1代表删除） */
    private Integer delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPatrolListName(String patrolListName) 
    {
        this.patrolListName = patrolListName;
    }

    public String getPatrolListName() 
    {
        return patrolListName;
    }
    public void setPrincipalId(Long principalId) 
    {
        this.principalId = principalId;
    }

    public Long getPrincipalId() 
    {
        return principalId;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setWaitingChecked(Integer waitingChecked)
    {
        this.waitingChecked = waitingChecked;
    }

    public Integer getWaitingChecked()
    {
        return waitingChecked;
    }
    public void setCheckedCount(Integer checkedCount)
    {
        this.checkedCount = checkedCount;
    }

    public Integer getCheckedCount()
    {
        return checkedCount;
    }
    public void setHiddenTroubleCount(Integer hiddenTroubleCount)
    {
        this.hiddenTroubleCount = hiddenTroubleCount;
    }

    public Integer getHiddenTroubleCount()
    {
        return hiddenTroubleCount;
    }
    public void setFinishTime(Date finishTime) 
    {
        this.finishTime = finishTime;
    }

    public Date getFinishTime() 
    {
        return finishTime;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setDelFlag(Integer delFlag)
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("patrolListName", getPatrolListName())
            .append("principalId", getPrincipalId())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("waitingChecked", getWaitingChecked())
            .append("checkedCount", getCheckedCount())
            .append("hiddenTroubleCount", getHiddenTroubleCount())
            .append("finishTime", getFinishTime())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
