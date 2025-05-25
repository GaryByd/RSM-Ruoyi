package com.rsm.entity.vo;

import lombok.Data;

/**
 * 随手拍隐患认定率
 */
@Data
public class HazardRecognitionRateVO {
    private Integer hazardCount;    // 隐患认定数
    private Integer totalCount;     // 总上传数
    private Double hazardRate;      // 隐患认定率
}
