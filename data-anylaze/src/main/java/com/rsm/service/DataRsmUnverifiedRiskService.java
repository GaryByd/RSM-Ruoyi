package com.rsm.service;


import com.rsm.entity.dao.RsmUnverifiedRiskQuery;
import com.rsm.entity.po.RsmUnverifiedRisk;
import com.rsm.entity.vo.HazardDiscoveryRateVO;
import com.rsm.entity.vo.PaginationResultVO;
import com.rsm.entity.vo.UnverifiedRiskCountByMonthVO;

import java.util.List;
/**
 * @Description: 风险待查项表 Service
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public interface DataRsmUnverifiedRiskService {

	/**
 	 * 根据条件查询列表
 	 */
	List<RsmUnverifiedRisk> findListByParam(RsmUnverifiedRiskQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(RsmUnverifiedRiskQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<RsmUnverifiedRisk> findListByPage(RsmUnverifiedRiskQuery query);

	/**
 	 * 新增
 	 */
	Integer add(RsmUnverifiedRisk bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<RsmUnverifiedRisk> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<RsmUnverifiedRisk> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	RsmUnverifiedRisk getRsmUnverifiedRiskById(Long id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateRsmUnverifiedRiskById(RsmUnverifiedRisk bean, Long id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteRsmUnverifiedRiskById(Long id);

	List<UnverifiedRiskCountByMonthVO> getUnverifiedRiskCountByMonth();
	/**
	 * 获取待查项发现隐患率
	 */
	HazardDiscoveryRateVO getHazardDiscoveryRate();
}