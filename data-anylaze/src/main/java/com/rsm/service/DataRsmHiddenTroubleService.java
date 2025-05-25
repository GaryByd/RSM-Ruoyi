package com.rsm.service;


import com.rsm.entity.dao.RsmHiddenTroubleQuery;
import com.rsm.entity.po.RsmHiddenTrouble;
import com.rsm.entity.vo.AvgRectifyTimeVO;
import com.rsm.entity.vo.ComprehensiveRiskIndexVO;
import com.rsm.entity.vo.DisposeStatusNumVO;
import com.rsm.entity.vo.HiddenTroubleSourceNumVO;
import com.rsm.entity.vo.PaginationResultVO;
import com.rsm.entity.vo.TroubleClassifyNumVO;

import java.util.List;
/**
 * @Description: 隐患表 Service
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public interface DataRsmHiddenTroubleService {

	/**
 	 * 根据条件查询列表
 	 */
	List<RsmHiddenTrouble> findListByParam(RsmHiddenTroubleQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(RsmHiddenTroubleQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<RsmHiddenTrouble> findListByPage(RsmHiddenTroubleQuery query);

	/**
 	 * 新增
 	 */
	Integer add(RsmHiddenTrouble bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<RsmHiddenTrouble> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<RsmHiddenTrouble> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	RsmHiddenTrouble getRsmHiddenTroubleById(Long id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateRsmHiddenTroubleById(RsmHiddenTrouble bean, Long id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteRsmHiddenTroubleById(Long id);

	List<DisposeStatusNumVO> getDisposeStatusNums();


	List<HiddenTroubleSourceNumVO> getHiddenTroubleSourceNums();

    ComprehensiveRiskIndexVO getComprehensiveRiskIndex();

    Integer getHiddenTroubleCount();

    List<TroubleClassifyNumVO> getTroubleClassifyNums();

    AvgRectifyTimeVO getAvgRectifyTime();
}
