package com.rsm.service;


import com.rsm.entity.dao.RsmRiskQuery;
import com.rsm.entity.po.RsmRisk;
import com.rsm.entity.vo.*;

import java.util.List;
/**
 * @Description: 风险库表 Service
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public interface DataRsmRiskService {

	/**
 	 * 根据条件查询列表
 	 */
	List<RsmRisk> findListByParam(RsmRiskQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(RsmRiskQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<RsmRisk> findListByPage(RsmRiskQuery query);

	/**
 	 * 新增
 	 */
	Integer add(RsmRisk bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<RsmRisk> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<RsmRisk> listBean);



	/**
 	 * 根据 Id 查询
 	 */
	RsmRisk getRsmRiskById(Long id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateRsmRiskById(RsmRisk bean, Long id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteRsmRiskById(Long id);

	List<RiskLevelCountVO> getRiskLevelCount();

	Integer getALevelUnprocessed();

	List<RiskMonthLevelCountVO> getRecent6MonthLevel();
	List<RiskTypeDistributionVO> getRiskTypeDistribution();

	/**
	 * 获取每月新增风险数量趋势
	 */
	List<MonthlyRiskCountVO> getMonthlyRiskCount();
	
	/**
	 * 获取每月新发现作业风险数量
	 */
	List<MonthlyRiskCountVO> getMonthlyOperationRiskCount();
}
