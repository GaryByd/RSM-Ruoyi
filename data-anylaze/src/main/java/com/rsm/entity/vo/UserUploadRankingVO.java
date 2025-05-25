package com.rsm.entity.vo;

import lombok.Data;

/**
 * 用户上传排名
 */
@Data
public class UserUploadRankingVO {
    private String username;  // 用户名称
    private Integer issueCount; // 上传问题数量
}
