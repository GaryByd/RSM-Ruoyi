package com.rsm.entity.vo;

import java.io.Serializable;

/**
 * @Description: Top 5 patrol points by frequency VO
 * @Author: false
 * @Date: 2025/04/26
 */
public class PatrolPointTop5VO implements Serializable {
    
    private String patrolName;
    private Integer patrolFrequency;
    
    public String getPatrolName() {
        return patrolName;
    }
    
    public void setPatrolName(String patrolName) {
        this.patrolName = patrolName;
    }
    
    public Integer getPatrolFrequency() {
        return patrolFrequency;
    }
    
    public void setPatrolFrequency(Integer patrolFrequency) {
        this.patrolFrequency = patrolFrequency;
    }
}
