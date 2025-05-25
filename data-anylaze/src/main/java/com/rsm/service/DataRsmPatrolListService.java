package com.rsm.service;


import com.rsm.entity.dao.RsmPatrolListQuery;
import com.rsm.entity.po.RsmPatrolList;
import com.rsm.entity.vo.PaginationResultVO;

import java.util.List;
import java.util.Map;
/**
 * @Description: 巡查清单表 Service
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public interface DataRsmPatrolListService {

	/**
 	 * 根据条件查询列表
 	 */
	List<RsmPatrolList> findListByParam(RsmPatrolListQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(RsmPatrolListQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<RsmPatrolList> findListByPage(RsmPatrolListQuery query);

	/**
 	 * 新增
 	 */
	Integer add(RsmPatrolList bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<RsmPatrolList> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<RsmPatrolList> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	RsmPatrolList getRsmPatrolListById(Long id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateRsmPatrolListById(RsmPatrolList bean, Long id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteRsmPatrolListById(Long id);

	Integer getPatrollingCount();

	Double getFoundRate();

	Double getCompletionRate();

	/**
 	 * 获取巡查点表中按巡查次数降序排列的前5个巡查点
 	 */
	List<Map<String, Object>> getTop5PatrolPoints();
}
