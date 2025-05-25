package com.rc.rsm.domain.enums;

public enum TaskApprovalStatus {
    CHECKING(0,"审核中"),
    PASS(1,"通过"),
    NOT_PASS(2,"未通过"),
    PASS_AND_CHECKED(2,"通过且成功加入待查项");

    private Integer status;
    private String desc;

    TaskApprovalStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
