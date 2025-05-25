package com.rc.rsm.domain.po;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 巡查点对象 rsm_patrol_point
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
public class RsmPatrolPoint extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 巡查点id */
    private Long id;

    /** 巡查点名称 */
    @Excel(name = "巡查点名称")
    private String patrolName;

    /** 巡查点描述 */
    @Excel(name = "巡查点描述")
    private String patrolDesc;

    /** 巡查点位置名 */
    @Excel(name = "巡查点位置名")
    private String position;

    /** 具体位置描述 */
    @Excel(name = "具体位置描述")
    private String locationDescribe;

    /** 安全员 */
    @Excel(name = "安全员")
    private String securityOfficer;

    /** 最近一次巡查时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最近一次巡查时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastPatrolTime;

    /** 巡查次数 */
    @Excel(name = "巡查次数")
    private Long patrolFrequency;

    /** 状态 0-正常 1-停用 */
    @Excel(name = "状态 0-正常 1-停用")
    private Long status;

    /** 删除标志（0代表存在 1代表删除） */
    private Long delFlag;

    /** 经纬度 */
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPatrolName(String patrolName) 
    {
        this.patrolName = patrolName;
    }

    public String getPatrolName() 
    {
        return patrolName;
    }
    public void setPatrolDesc(String patrolDesc) 
    {
        this.patrolDesc = patrolDesc;
    }

    public String getPatrolDesc() 
    {
        return patrolDesc;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setLocationDescribe(String locationDescribe) 
    {
        this.locationDescribe = locationDescribe;
    }

    public String getLocationDescribe() 
    {
        return locationDescribe;
    }
    public void setSecurityOfficer(String securityOfficer) 
    {
        this.securityOfficer = securityOfficer;
    }

    public String getSecurityOfficer() 
    {
        return securityOfficer;
    }
    public void setLastPatrolTime(Date lastPatrolTime) 
    {
        this.lastPatrolTime = lastPatrolTime;
    }

    public Date getLastPatrolTime() 
    {
        return lastPatrolTime;
    }
    public void setPatrolFrequency(Long patrolFrequency) 
    {
        this.patrolFrequency = patrolFrequency;
    }

    public Long getPatrolFrequency() 
    {
        return patrolFrequency;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("patrolName", getPatrolName())
            .append("patrolDesc", getPatrolDesc())
            .append("position", getPosition())
            .append("locationDescribe", getLocationDescribe())
            .append("securityOfficer", getSecurityOfficer())
            .append("lastPatrolTime", getLastPatrolTime())
            .append("patrolFrequency", getPatrolFrequency())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("location", getLocation())
            .toString();
    }
}
