package com.rsm.service;


import com.rsm.entity.dao.RsmSnapshotQuery;
import com.rsm.entity.po.RsmSnapshot;
import com.rsm.entity.vo.HazardRecognitionRateVO;
import com.rsm.entity.vo.PaginationResultVO;
import com.rsm.entity.vo.PropertyPercentageVO;
import com.rsm.entity.vo.UserUploadRankingVO;

import java.util.List;
/**
 * @Description: 随手拍问题表 Service
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public interface DataRsmSnapshotService {

	/**
 	 * 根据条件查询列表
 	 */
	List<RsmSnapshot> findListByParam(RsmSnapshotQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(RsmSnapshotQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<RsmSnapshot> findListByPage(RsmSnapshotQuery query);

	/**
 	 * 新增
 	 */
	Integer add(RsmSnapshot bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<RsmSnapshot> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<RsmSnapshot> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	RsmSnapshot getRsmSnapshotById(Long id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateRsmSnapshotById(RsmSnapshot bean, Long id);

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteRsmSnapshotById(Long id);

	PropertyPercentageVO getPropertyPercentage();

	HazardRecognitionRateVO getHazardRecognitionRate();

	/**
	 * 获取用户上传排名前5
	 */
	List<UserUploadRankingVO> getUserUploadRanking();
}