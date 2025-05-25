package com.rsm.entity.vo;

import lombok.Data;

/**
 * 待查项发现隐患率
 */
@Data
public class HazardDiscoveryRateVO {
    private Integer discovered;  // 发现隐患数
    private Integer total;       // 总数量
    private Double discoveryRate; // 隐患发现率
}
