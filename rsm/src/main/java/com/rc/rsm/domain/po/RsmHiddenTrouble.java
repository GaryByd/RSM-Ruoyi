package com.rc.rsm.domain.po;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 隐患对象 rsm_hidden_trouble
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
public class RsmHiddenTrouble extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 隐患id */
    private Long id;

    /** 隐患标题 */
    @Excel(name = "隐患标题")
    private String troubleTitle;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long creatorId;

    /** 隐患图片路径-逗号分隔 */
    @Excel(name = "隐患图片路径-逗号分隔")
    private String troubleImgPath;

    /** 隐患描述 */
    @Excel(name = "隐患描述")
    private String troubleDesc;

    /** 处理状态0-未处理,1-已处理 */
    @Excel(name = "处理状态0-未处理,1-已处理")
    private Long status;

    /** 隐患分类 0-地质隐患 1-设备隐患 2-环境隐患 3-生产隐患 4-其他 */
    @Excel(name = "隐患分类 0-地质隐患 1-设备隐患 2-环境隐患 3-生产隐患 4-其他")
    private Long troubleClassify;

    /** 隐患来源 0-随手拍 1-上传 */
    @Excel(name = "隐患来源 0-随手拍 1-上传")
    private Long source;

    /** 处理人id */
    @Excel(name = "处理人id")
    private Long handlerId;

    /** 处理图片路径 */
    @Excel(name = "处理图片路径")
    private String handleImgPath;

    /** 整改描述 */
    @Excel(name = "整改描述")
    private String rectifyDesc;

    /** 整改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "整改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date rectifyTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTroubleTitle(String troubleTitle) 
    {
        this.troubleTitle = troubleTitle;
    }

    public String getTroubleTitle() 
    {
        return troubleTitle;
    }
    public void setCreatorId(Long creatorId) 
    {
        this.creatorId = creatorId;
    }

    public Long getCreatorId() 
    {
        return creatorId;
    }
    public void setTroubleImgPath(String troubleImgPath) 
    {
        this.troubleImgPath = troubleImgPath;
    }

    public String getTroubleImgPath() 
    {
        return troubleImgPath;
    }
    public void setTroubleDesc(String troubleDesc) 
    {
        this.troubleDesc = troubleDesc;
    }

    public String getTroubleDesc() 
    {
        return troubleDesc;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setTroubleClassify(Long troubleClassify) 
    {
        this.troubleClassify = troubleClassify;
    }

    public Long getTroubleClassify() 
    {
        return troubleClassify;
    }
    public void setSource(Long source) 
    {
        this.source = source;
    }

    public Long getSource() 
    {
        return source;
    }
    public void setHandlerId(Long handlerId) 
    {
        this.handlerId = handlerId;
    }

    public Long getHandlerId() 
    {
        return handlerId;
    }
    public void setHandleImgPath(String handleImgPath) 
    {
        this.handleImgPath = handleImgPath;
    }

    public String getHandleImgPath() 
    {
        return handleImgPath;
    }
    public void setRectifyDesc(String rectifyDesc) 
    {
        this.rectifyDesc = rectifyDesc;
    }

    public String getRectifyDesc() 
    {
        return rectifyDesc;
    }
    public void setRectifyTime(Date rectifyTime) 
    {
        this.rectifyTime = rectifyTime;
    }

    public Date getRectifyTime() 
    {
        return rectifyTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("troubleTitle", getTroubleTitle())
            .append("creatorId", getCreatorId())
            .append("troubleImgPath", getTroubleImgPath())
            .append("troubleDesc", getTroubleDesc())
            .append("status", getStatus())
            .append("troubleClassify", getTroubleClassify())
            .append("source", getSource())
            .append("handlerId", getHandlerId())
            .append("handleImgPath", getHandleImgPath())
            .append("rectifyDesc", getRectifyDesc())
            .append("rectifyTime", getRectifyTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
