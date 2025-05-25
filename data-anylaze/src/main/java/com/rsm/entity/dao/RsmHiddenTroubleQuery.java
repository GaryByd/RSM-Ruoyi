package com.rsm.entity.dao;

import java.util.Date;


/**
 * @Description: 隐患表
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public class RsmHiddenTroubleQuery extends BaseQuery {
	/**
 	 * 隐患id 查询对象
 	 */
	private Long id;

	/**
 	 * 隐患标题 查询对象
 	 */
	private String troubleTitle;

	private String troubleTitleFuzzy;

	/**
 	 * 创建人id 查询对象
 	 */
	private Long creatorId;

	/**
 	 * 隐患图片路径-逗号分隔 查询对象
 	 */
	private String troubleImgPath;

	private String troubleImgPathFuzzy;

	/**
 	 * 隐患描述 查询对象
 	 */
	private String troubleDesc;

	private String troubleDescFuzzy;

	/**
 	 * 处理状态0-未处理,1-已处理 查询对象
 	 */
	private Integer status;

	/**
 	 * 隐患分类 0-地质隐患 1-设备隐患 2-环境隐患 3-生产隐患 4-其他 查询对象
 	 */
	private Integer troubleClassify;

	/**
 	 * 隐患来源 0-随手拍 1-上传 查询对象
 	 */
	private Integer source;

	/**
 	 * 处理人id 查询对象
 	 */
	private Long handlerId;

	/**
 	 * 处理图片路径 查询对象
 	 */
	private String handleImgPath;

	private String handleImgPathFuzzy;

	/**
 	 * 整改描述 查询对象
 	 */
	private String rectifyDesc;

	private String rectifyDescFuzzy;

	/**
 	 * 整改时间 查询对象
 	 */
	private Date rectifyTime;

	private String rectifyTimeStart;
	private String rectifyTimeEnd;
	/**
 	 * 创建时间 查询对象
 	 */
	private Date createTime;

	private String createTimeStart;
	private String createTimeEnd;
	/**
 	 * 修改时间 查询对象
 	 */
	private Date updateTime;

	private String updateTimeStart;
	private String updateTimeEnd;
	/**
 	 * 备注 查询对象
 	 */
	private String remark;

	private String remarkFuzzy;

	/**
 	 * 地点id 查询对象
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

	public void setTroubleTitleFuzzy(String troubleTitleFuzzy) {
		this.troubleTitleFuzzy = troubleTitleFuzzy;
	}

	public String getTroubleTitleFuzzy() {
		return troubleTitleFuzzy;
	}

	public void setTroubleImgPathFuzzy(String troubleImgPathFuzzy) {
		this.troubleImgPathFuzzy = troubleImgPathFuzzy;
	}

	public String getTroubleImgPathFuzzy() {
		return troubleImgPathFuzzy;
	}

	public void setTroubleDescFuzzy(String troubleDescFuzzy) {
		this.troubleDescFuzzy = troubleDescFuzzy;
	}

	public String getTroubleDescFuzzy() {
		return troubleDescFuzzy;
	}

	public void setHandleImgPathFuzzy(String handleImgPathFuzzy) {
		this.handleImgPathFuzzy = handleImgPathFuzzy;
	}

	public String getHandleImgPathFuzzy() {
		return handleImgPathFuzzy;
	}

	public void setRectifyDescFuzzy(String rectifyDescFuzzy) {
		this.rectifyDescFuzzy = rectifyDescFuzzy;
	}

	public String getRectifyDescFuzzy() {
		return rectifyDescFuzzy;
	}

	public void setRectifyTimeStart(String rectifyTimeStart) {
		this.rectifyTimeStart = rectifyTimeStart;
	}

	public String getRectifyTimeStart() {
		return rectifyTimeStart;
	}

	public void setRectifyTimeEnd(String rectifyTimeEnd) {
		this.rectifyTimeEnd = rectifyTimeEnd;
	}

	public String getRectifyTimeEnd() {
		return rectifyTimeEnd;
	}

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setUpdateTimeStart(String updateTimeStart) {
		this.updateTimeStart = updateTimeStart;
	}

	public String getUpdateTimeStart() {
		return updateTimeStart;
	}

	public void setUpdateTimeEnd(String updateTimeEnd) {
		this.updateTimeEnd = updateTimeEnd;
	}

	public String getUpdateTimeEnd() {
		return updateTimeEnd;
	}

	public void setRemarkFuzzy(String remarkFuzzy) {
		this.remarkFuzzy = remarkFuzzy;
	}

	public String getRemarkFuzzy() {
		return remarkFuzzy;
	}
}