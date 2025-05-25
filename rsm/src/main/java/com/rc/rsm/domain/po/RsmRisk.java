package com.rc.rsm.domain.po;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 风险库对象 rsm_risk
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
public class RsmRisk extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 风险id */
    private Long id;

    /** 风险名称 */
    @Excel(name = "风险名称")
    private String riskName;

    /** 风险类型 */
    @Excel(name = "风险类型")
    private String riskType;

    /** 监管人员 */
    @Excel(name = "监管人员")
    private String supervisor;

    /** 管控标准 */
    @Excel(name = "管控标准")
    private String controlStandard;

    /** 风险等级 */
    @Excel(name = "风险等级")
    private String riskLevel;

    /** 风险信息，作为设备风险则说明是什么设备，作为生产现场风险说明哪些生产现场，作为作业活动说明哪个作业 */
    @Excel(name = "风险信息，作为设备风险则说明是什么设备，作为生产现场风险说明哪些生产现场，作为作业活动说明哪个作业")
    private String riskInfo;

    /** 风险关联id，作为保留字段，如果没有设备表和生产现场表那么这个字段仅在风险类型为作业风险时有用，用于关联作业表 */
    @Excel(name = "风险关联id，作为保留字段，如果没有设备表和生产现场表那么这个字段仅在风险类型为作业风险时有用，用于关联作业表")
    private Long riskRelateId;

    /** 审核人 */
    @Excel(name = "审核人")
    private String auditor;

    /** 风险描述 */
    @Excel(name = "风险描述")
    private String riskDescribe;

    /** 风险后果 */
    @Excel(name = "风险后果")
    private String riskConseq;

    /** 风险管理措施 */
    @Excel(name = "风险管理措施")
    private String controlMeasure;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRiskName(String riskName) 
    {
        this.riskName = riskName;
    }

    public String getRiskName() 
    {
        return riskName;
    }
    public void setRiskType(String riskType) 
    {
        this.riskType = riskType;
    }

    public String getRiskType() 
    {
        return riskType;
    }
    public void setSupervisor(String supervisor) 
    {
        this.supervisor = supervisor;
    }

    public String getSupervisor() 
    {
        return supervisor;
    }
    public void setControlStandard(String controlStandard) 
    {
        this.controlStandard = controlStandard;
    }

    public String getControlStandard() 
    {
        return controlStandard;
    }
    public void setRiskLevel(String riskLevel) 
    {
        this.riskLevel = riskLevel;
    }

    public String getRiskLevel() 
    {
        return riskLevel;
    }
    public void setRiskInfo(String riskInfo) 
    {
        this.riskInfo = riskInfo;
    }

    public String getRiskInfo() 
    {
        return riskInfo;
    }
    public void setRiskRelateId(Long riskRelateId) 
    {
        this.riskRelateId = riskRelateId;
    }

    public Long getRiskRelateId() 
    {
        return riskRelateId;
    }
    public void setAuditor(String auditor) 
    {
        this.auditor = auditor;
    }

    public String getAuditor() 
    {
        return auditor;
    }
    public void setRiskDescribe(String riskDescribe) 
    {
        this.riskDescribe = riskDescribe;
    }

    public String getRiskDescribe() 
    {
        return riskDescribe;
    }
    public void setRiskConseq(String riskConseq) 
    {
        this.riskConseq = riskConseq;
    }

    public String getRiskConseq() 
    {
        return riskConseq;
    }
    public void setControlMeasure(String controlMeasure) 
    {
        this.controlMeasure = controlMeasure;
    }

    public String getControlMeasure() 
    {
        return controlMeasure;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("riskName", getRiskName())
            .append("riskType", getRiskType())
            .append("supervisor", getSupervisor())
            .append("controlStandard", getControlStandard())
            .append("riskLevel", getRiskLevel())
            .append("riskInfo", getRiskInfo())
            .append("riskRelateId", getRiskRelateId())
            .append("auditor", getAuditor())
            .append("riskDescribe", getRiskDescribe())
            .append("riskConseq", getRiskConseq())
            .append("controlMeasure", getControlMeasure())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
