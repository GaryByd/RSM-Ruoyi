package com.rsm.controller;


import com.rsm.entity.dao.RsmRiskQuery;
import com.rsm.entity.po.RsmRisk;
import com.rsm.entity.vo.MonthlyRiskCountVO;
import com.rsm.entity.vo.ResponseVO;
import com.rsm.entity.vo.RiskLevelCountVO;
import com.rsm.entity.vo.RiskMonthLevelCountVO;
import com.rsm.entity.vo.RiskTypeDistributionVO;
import com.rsm.service.DataRsmRiskService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description: 风险库表 Controller
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
@RestController
@RequestMapping("/data/rsmRisk")
public class DataRsmRiskController extends ABaseController{

	@Resource
	private DataRsmRiskService dataRsmRiskService;

	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(RsmRiskQuery query) {
		return getSuccessResponseVO(dataRsmRiskService.findListByPage(query));
	}

	/**
 	 * 新增
 	 */
	@RequestMapping("/add")
	public ResponseVO add(RsmRisk bean) {
		Integer result = this.dataRsmRiskService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增
 	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<RsmRisk> listBean) {
		this.dataRsmRiskService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增或修改
 	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<RsmRisk> listBean) {
		this.dataRsmRiskService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}



	/**
 	 * 根据 Id 查询
 	 */
	@RequestMapping("/getRsmRiskById")
	public ResponseVO getRsmRiskById(Long id) {
		return getSuccessResponseVO(dataRsmRiskService.getRsmRiskById(id));}

	/**
 	 * 根据 Id 更新
 	 */
	@RequestMapping("/updateRsmRiskById")
	public ResponseVO updateRsmRiskById(RsmRisk bean, Long id) {
		this.dataRsmRiskService.updateRsmRiskById(bean, id);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 Id 删除
 	 */
	@RequestMapping("/deleteRsmRiskById")
	public ResponseVO deleteRsmRiskById(Long id) {
		this.dataRsmRiskService.deleteRsmRiskById(id);
		return getSuccessResponseVO(null);
}
	/**
	 * 各风险等级数量（A/B/C/D）统计：
	 */
	@RequestMapping("/getRiskLevelCount")
	public ResponseVO getRiskLevelCount() {
		List<RiskLevelCountVO> list = this.dataRsmRiskService.getRiskLevelCount();
		return getSuccessResponseVO(list);
	}

	@RequestMapping("/getALevelUnprocessed")
	public ResponseVO getALevelUnprocessed() {
		return getSuccessResponseVO(this.dataRsmRiskService.getALevelUnprocessed());
	}

	/**
	 * 近6个月风险等级变化趋势： 统计最近6个月内各风险等级的数量变化趋势，帮助把握不同风险等级的动态。
	 */
	@RequestMapping("/getRecent6MonthLevel")
	public ResponseVO getRecent6MonthLevel() {
		List<RiskMonthLevelCountVO> list = this.dataRsmRiskService.getRecent6MonthLevel();
		return getSuccessResponseVO(list);
	}

	/**
	 * 风险按类型分布图
	 */
	@RequestMapping("/getRiskTypeDistribution")
	public ResponseVO getRiskTypeDistribution() {
		List<RiskTypeDistributionVO> list = this.dataRsmRiskService.getRiskTypeDistribution();
		return getSuccessResponseVO(list);
	}

	/**
	 * 每月新增风险数量趋势图
	 */
	@RequestMapping("/getMonthlyRiskCount")
	public ResponseVO getMonthlyRiskCount() {
		List<MonthlyRiskCountVO> list = this.dataRsmRiskService.getMonthlyRiskCount();
		return getSuccessResponseVO(list);
	}
	
	/**
	 * 每月新发现作业风险数量趋势图
	 */
	@RequestMapping("/getMonthlyOperationRiskCount")
	public ResponseVO getMonthlyOperationRiskCount() {
		List<MonthlyRiskCountVO> list = this.dataRsmRiskService.getMonthlyOperationRiskCount();
		return getSuccessResponseVO(list);
	}
}

