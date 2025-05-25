package com.rsm.entity.vo;

import java.io.Serializable;

/**
 * @Description: Risk distribution by type VO
 * @Author: false
 * @Date: 2025/04/26
 */
public class RiskTypeDistributionVO implements Serializable {
    
    private String riskType;
    private Integer count;
    
    public String getRiskType() {
        return riskType;
    }
    
    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }
    
    public Integer getCount() {
        return count;
    }
    
    public void setCount(Integer count) {
        this.count = count;
    }
}
