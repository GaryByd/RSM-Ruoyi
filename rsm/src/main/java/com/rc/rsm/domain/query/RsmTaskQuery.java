package com.rc.rsm.domain.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RsmTaskQuery {
    private static final long serialVersionUID = 1L;
    /** 作业开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")

    @Excel(name = "作业开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 审核状态（1通过 0未审核 2未通过） */
    @Excel(name = "审核状态", readConverterExp = "1=通过,0=未审核,2=未通过")
    private Integer approvalStatus;

    /** 风险等级 */
    @Excel(name = "风险等级")
    private String riskLevel;
}
