package com.rsm.entity.vo;

import lombok.Data;

/**
 * 部门作业数量统计
 */
@Data
public class DeptTaskCountVO {
    private String deptName;  // 班组名称
    private Integer taskCount; // 作业数量
}
