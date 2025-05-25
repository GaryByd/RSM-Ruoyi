package com.rsm.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rsm.enums.DateTimePatternEnum;
import com.rsm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * @Description: 隐患表
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public class RsmHiddenTrouble implements Serializable {
	/**
 	 * 隐患id
 	 */
	private Long id;

	/**
 	 * 隐患标题
 	 */
	private String troubleTitle;

	/**
 	 * 创建人id
 	 */
	private Long creatorId;

	/**
 	 * 隐患图片路径-逗号分隔
 	 */
	private String troubleImgPath;

	/**
 	 * 隐患描述
 	 */
	private String troubleDesc;

	/**
 	 * 处理状态0-未处理,1-已处理
 	 */
	@JsonIgnore
	private Integer status;

	/**
 	 * 隐患分类 0-地质隐患 1-设备隐患 2-环境隐患 3-生产隐患 4-其他
 	 */
	private Integer troubleClassify;

	/**
 	 * 隐患来源 0-随手拍 1-上传
 	 */
	private Integer source;

	/**
 	 * 处理人id
 	 */
	private Long handlerId;

	/**
 	 * 处理图片路径
 	 */
	private String handleImgPath;

	/**
 	 * 整改描述
 	 */
	private String rectifyDesc;

	/**
 	 * 整改时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date rectifyTime;

	/**
 	 * 创建时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
 	 * 修改时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	/**
 	 * 备注
 	 */
	private String remark;

	/**
 	 * 地点id
 	 */
	private Integer positionId;


	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setTroubleTitle(String troubleTitle) {
		this.troubleTitle = troubleTitle;
	}

	public String getTroubleTitle() {
		return troubleTitle;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setTroubleImgPath(String troubleImgPath) {
		this.troubleImgPath = troubleImgPath;
	}

	public String getTroubleImgPath() {
		return troubleImgPath;
	}

	public void setTroubleDesc(String troubleDesc) {
		this.troubleDesc = troubleDesc;
	}

	public String getTroubleDesc() {
		return troubleDesc;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setTroubleClassify(Integer troubleClassify) {
		this.troubleClassify = troubleClassify;
	}

	public Integer getTroubleClassify() {
		return troubleClassify;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getSource() {
		return source;
	}

	public void setHandlerId(Long handlerId) {
		this.handlerId = handlerId;
	}

	public Long getHandlerId() {
		return handlerId;
	}

	public void setHandleImgPath(String handleImgPath) {
		this.handleImgPath = handleImgPath;
	}

	public String getHandleImgPath() {
		return handleImgPath;
	}

	public void setRectifyDesc(String rectifyDesc) {
		this.rectifyDesc = rectifyDesc;
	}

	public String getRectifyDesc() {
		return rectifyDesc;
	}

	public void setRectifyTime(Date rectifyTime) {
		this.rectifyTime = rectifyTime;
	}

	public Date getRectifyTime() {
		return rectifyTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public Integer getPositionId() {
		return positionId;
	}
	@Override
	public String toString() {
		return "隐患id:" + (id == null ? "空" : id) + "," + 
				"隐患标题:" + (troubleTitle == null ? "空" : troubleTitle) + "," + 
				"创建人id:" + (creatorId == null ? "空" : creatorId) + "," + 
				"隐患图片路径-逗号分隔:" + (troubleImgPath == null ? "空" : troubleImgPath) + "," + 
				"隐患描述:" + (troubleDesc == null ? "空" : troubleDesc) + "," + 
				"处理状态0-未处理,1-已处理:" + (status == null ? "空" : status) + "," + 
				"隐患分类 0-地质隐患 1-设备隐患 2-环境隐患 3-生产隐患 4-其他:" + (troubleClassify == null ? "空" : troubleClassify) + "," + 
				"隐患来源 0-随手拍 1-上传:" + (source == null ? "空" : source) + "," + 
				"处理人id:" + (handlerId == null ? "空" : handlerId) + "," + 
				"处理图片路径:" + (handleImgPath == null ? "空" : handleImgPath) + "," + 
				"整改描述:" + (rectifyDesc == null ? "空" : rectifyDesc) + "," + 
				"整改时间:" + (rectifyTime == null ? "空" : DateUtils.format(rectifyTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"创建时间:" + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"修改时间:" + (updateTime == null ? "空" : DateUtils.format(updateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"备注:" + (remark == null ? "空" : remark) + "," + 
				"地点id:" + (positionId == null ? "空" : positionId);
		}
}