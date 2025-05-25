package com.rsm.entity.vo;

import lombok.Data;

/**
 * 月度风险数量统计
 * DATE: 2025/4/26
 */
@Data
public class MonthlyRiskCountVO {
    private String month;
    private Integer newRisks;
}
