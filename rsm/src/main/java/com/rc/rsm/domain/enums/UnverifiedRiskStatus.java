package com.rc.rsm.domain.enums;

public enum UnverifiedRiskStatus {
    CHECKING(0,"审核中"),
    FIND_RISK(1,"通过"),
    NOT_FIND_RISK(2,"未通过");

    private Integer status;
    private String desc;
    UnverifiedRiskStatus(Integer status, String desc)
    {
        this.status = status;
        this.desc = desc;
    }
    public Integer getStatus()
    {
        return status;
    }
    public String getDesc()
    {
        return desc;
    }
    public static UnverifiedRiskStatus getByStatus(Integer status)
    {
        for(UnverifiedRiskStatus unverifiedRiskStatus : UnverifiedRiskStatus.values())
        {
            if(unverifiedRiskStatus.getStatus().equals(status))
            {
                return unverifiedRiskStatus;
            }
        }
        return null;
    }
}
