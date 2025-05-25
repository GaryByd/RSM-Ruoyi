package com.rsm.controller;


import com.rsm.entity.dao.RsmUnverifiedRiskQuery;
import com.rsm.entity.po.RsmUnverifiedRisk;
import com.rsm.entity.vo.HazardDiscoveryRateVO;
import com.rsm.entity.vo.ResponseVO;
import com.rsm.entity.vo.UnverifiedRiskCountByMonthVO;
import com.rsm.service.DataRsmUnverifiedRiskService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description: 风险待查项表 Controller
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
@RestController
@RequestMapping("/data/rsmUnverifiedRisk")
public class DataRsmUnverifiedRiskController extends ABaseController{

	@Resource
	private DataRsmUnverifiedRiskService dataRsmUnverifiedRiskService;

	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(RsmUnverifiedRiskQuery query) {
		return getSuccessResponseVO(dataRsmUnverifiedRiskService.findListByPage(query));
	}

	/**
 	 * 新增
 	 */
	@RequestMapping("/add")
	public ResponseVO add(RsmUnverifiedRisk bean) {
		Integer result = this.dataRsmUnverifiedRiskService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增
 	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<RsmUnverifiedRisk> listBean) {
		this.dataRsmUnverifiedRiskService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增或修改
 	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<RsmUnverifiedRisk> listBean) {
		this.dataRsmUnverifiedRiskService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@RequestMapping("/getRsmUnverifiedRiskById")
	public ResponseVO getRsmUnverifiedRiskById(Long id) {
		return getSuccessResponseVO(dataRsmUnverifiedRiskService.getRsmUnverifiedRiskById(id));}

	/**
 	 * 根据 Id 更新
 	 */
	@RequestMapping("/updateRsmUnverifiedRiskById")
	public ResponseVO updateRsmUnverifiedRiskById(RsmUnverifiedRisk bean, Long id) {
		this.dataRsmUnverifiedRiskService.updateRsmUnverifiedRiskById(bean, id);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 Id 删除
 	 */
	@RequestMapping("/deleteRsmUnverifiedRiskById")
	public ResponseVO deleteRsmUnverifiedRiskById(Long id) {
		this.dataRsmUnverifiedRiskService.deleteRsmUnverifiedRiskById(id);
		return getSuccessResponseVO(null);
}
	/**
	 * 待查项数量变化趋势（月）
	 */
	@RequestMapping("/getUnverifiedRiskCountByMonth")
	public ResponseVO getUnverifiedRiskCountByMonth() {
		List<UnverifiedRiskCountByMonthVO> list = this.dataRsmUnverifiedRiskService.getUnverifiedRiskCountByMonth();
		return getSuccessResponseVO(list);
	}
	/**
	 * 待查项发现隐患率
	 */
	@RequestMapping("/getHazardDiscoveryRate")
	public ResponseVO getHazardDiscoveryRate() {
		HazardDiscoveryRateVO rate = this.dataRsmUnverifiedRiskService.getHazardDiscoveryRate();
		return getSuccessResponseVO(rate);
	}
}