package com.rsm.service;


import com.rsm.entity.dao.RsmPatrolPointQuery;
import com.rsm.entity.po.RsmPatrolPoint;
import com.rsm.entity.vo.PaginationResultVO;
import com.rsm.entity.vo.PatrolNameFrequencyVO;
import com.rsm.entity.vo.PatrolPointTop5VO;

import java.util.List;
/**
 * @Description: 巡查点表 Service
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public interface DataRsmPatrolPointService {

	/**
 	 * 根据条件查询列表
 	 */
	List<RsmPatrolPoint> findListByParam(RsmPatrolPointQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(RsmPatrolPointQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<RsmPatrolPoint> findListByPage(RsmPatrolPointQuery query);

	/**
 	 * 新增
 	 */
	Integer add(RsmPatrolPoint bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<RsmPatrolPoint> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<RsmPatrolPoint> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	RsmPatrolPoint getRsmPatrolPointById(Long id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateRsmPatrolPointById(RsmPatrolPoint bean, Long id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteRsmPatrolPointById(Long id);

	List<PatrolNameFrequencyVO> getPatrolNameFrequency();

	List<PatrolPointTop5VO> getTopPatrolPointsByFrequency();
}