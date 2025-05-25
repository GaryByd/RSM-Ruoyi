package com.rc.rsm.domain.po;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 风险待查项对象 rsm_unverified_risk
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
public class RsmUnverifiedRisk extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 待查项id */
    private Long id;

    /** 待查项名称 */
    @Excel(name = "待查项名称")
    private String unverifiedRiskName;

    /** 关联风险id */
    @Excel(name = "关联风险id")
    private Long riskId;

    /** 巡查清单id */
    @Excel(name = "巡查清单id")
    private Long patrolListId;

    /** 类型 */
    @Excel(name = "类型")
    private String riskType;

    /** 管理员 */
    @Excel(name = "管理员")
    private String admin;

    /** 巡查标准 */
    @Excel(name = "巡查标准")
    private String controlStandard;

    /** 巡查点id */
    @Excel(name = "巡查点id")
    private Long position;

    /** 状态 0-未处理  1-未发现隐患 2-发现隐患 */
    @Excel(name = "状态 0-未处理  1-未发现隐患 2-发现隐患")
    private Integer status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUnverifiedRiskName(String unverifiedRiskName) 
    {
        this.unverifiedRiskName = unverifiedRiskName;
    }

    public String getUnverifiedRiskName() 
    {
        return unverifiedRiskName;
    }
    public void setRiskId(Long riskId) 
    {
        this.riskId = riskId;
    }

    public Long getRiskId() 
    {
        return riskId;
    }
    public void setPatrolListId(Long patrolListId) 
    {
        this.patrolListId = patrolListId;
    }

    public Long getPatrolListId() 
    {
        return patrolListId;
    }
    public void setRiskType(String riskType) 
    {
        this.riskType = riskType;
    }

    public String getRiskType() 
    {
        return riskType;
    }
    public void setAdmin(String admin) 
    {
        this.admin = admin;
    }

    public String getAdmin() 
    {
        return admin;
    }
    public void setControlStandard(String controlStandard) 
    {
        this.controlStandard = controlStandard;
    }

    public String getControlStandard() 
    {
        return controlStandard;
    }
    public void setPosition(Long position) 
    {
        this.position = position;
    }

    public Long getPosition() 
    {
        return position;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("unverifiedRiskName", getUnverifiedRiskName())
            .append("riskId", getRiskId())
            .append("patrolListId", getPatrolListId())
            .append("riskType", getRiskType())
            .append("admin", getAdmin())
            .append("controlStandard", getControlStandard())
            .append("position", getPosition())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
