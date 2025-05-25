package com.rc.rsm.domain.po;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 随手拍问题对象 rsm_snapshot
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
public class RsmSnapshot extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 随手拍id */
    private Long id;

    /** 问题标题 */
    @Excel(name = "问题标题")
    private String questionTitle;

    /** 问题描述 */
    @Excel(name = "问题描述")
    private String questionDesc;

    /** 上传人id */
    @Excel(name = "上传人id")
    private Long creatorId;

    /** 图片路径 */
    @Excel(name = "图片路径")
    private String imgPath;

    /** 审批人id */
    @Excel(name = "审批人id")
    private Long handlerId;

    /** 审批回复 */
    @Excel(name = "审批回复")
    private String approvalReply;

    /** 事件定性 0-隐患 1-非隐患 */
    @Excel(name = "事件定性 0-隐患 1-非隐患")
    private Long property;

    /** 处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date handlerTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setQuestionTitle(String questionTitle) 
    {
        this.questionTitle = questionTitle;
    }

    public String getQuestionTitle() 
    {
        return questionTitle;
    }
    public void setQuestionDesc(String questionDesc) 
    {
        this.questionDesc = questionDesc;
    }

    public String getQuestionDesc() 
    {
        return questionDesc;
    }
    public void setCreatorId(Long creatorId) 
    {
        this.creatorId = creatorId;
    }

    public Long getCreatorId() 
    {
        return creatorId;
    }
    public void setImgPath(String imgPath) 
    {
        this.imgPath = imgPath;
    }

    public String getImgPath() 
    {
        return imgPath;
    }
    public void setHandlerId(Long handlerId) 
    {
        this.handlerId = handlerId;
    }

    public Long getHandlerId() 
    {
        return handlerId;
    }
    public void setApprovalReply(String approvalReply) 
    {
        this.approvalReply = approvalReply;
    }

    public String getApprovalReply() 
    {
        return approvalReply;
    }
    public void setProperty(Long property) 
    {
        this.property = property;
    }

    public Long getProperty() 
    {
        return property;
    }
    public void setHandlerTime(Date handlerTime) 
    {
        this.handlerTime = handlerTime;
    }

    public Date getHandlerTime() 
    {
        return handlerTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("questionTitle", getQuestionTitle())
            .append("questionDesc", getQuestionDesc())
            .append("creatorId", getCreatorId())
            .append("imgPath", getImgPath())
            .append("handlerId", getHandlerId())
            .append("approvalReply", getApprovalReply())
            .append("property", getProperty())
            .append("handlerTime", getHandlerTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
