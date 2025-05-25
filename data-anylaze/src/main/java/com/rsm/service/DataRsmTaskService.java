package com.rsm.service;


import com.rsm.entity.dao.RsmTaskQuery;
import com.rsm.entity.po.RsmTask;
import com.rsm.entity.vo.DeptTaskCountVO;
import com.rsm.entity.vo.PaginationResultVO;

import java.util.List;
/**
 * @Description: 作业表 Service
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public interface DataRsmTaskService {

	/**
 	 * 根据条件查询列表
 	 */
	List<RsmTask> findListByParam(RsmTaskQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(RsmTaskQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<RsmTask> findListByPage(RsmTaskQuery query);

	/**
 	 * 新增
 	 */
	Integer add(RsmTask bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<RsmTask> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<RsmTask> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	RsmTask getRsmTaskById(Long id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateRsmTaskById(RsmTask bean, Long id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteRsmTaskById(Long id);

	/**
	 * 获取各部门作业数量统计
	 */
	List<DeptTaskCountVO> getTaskCountByDept();
}
