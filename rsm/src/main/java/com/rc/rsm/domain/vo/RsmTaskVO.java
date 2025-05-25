package com.rc.rsm.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RsmTaskVO {
    private static final long serialVersionUID = 1L;

    /** 作业id */
    private Long id;

    /** 作业名称 */
    @Excel(name = "作业名称")
    private String taskName;

    /** 类型名称 */
    @Excel(name = "类型名称")
    private String typeName;

    /** 班组名称 */
    @Excel(name = "班组名称")
    private String deptName;

    /** 作业开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "作业开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 作业结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "作业结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 风险关联id */
    @Excel(name = "风险关联id")
    private Long riskId;

    /** 风险等级 */
    @Excel(name = "风险等级")
    private String riskLevel;

    /** 负责人姓名 */
    @Excel(name = "负责人姓名")
    private String mandateHolder;

    /** 审核状态（1通过 0未审核 2未通过） */
    @Excel(name = "审核状态", readConverterExp = "1=通过,0=未审核,2=未通过")
    private Integer approvalStatus;

    /** 审核人姓名 */
    @Excel(name = "审核人姓名")
    private String reviewer;

    /** 作业描述 */
    @Excel(name = "作业描述")
    private String taskDesc;

    /** 位置信息 */
    @Excel(name = "位置信息")
    private Long positionId;
}
