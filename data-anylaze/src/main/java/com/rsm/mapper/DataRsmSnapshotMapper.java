package com.rsm.mapper;

import com.rsm.entity.vo.HazardRecognitionRateVO;
import com.rsm.entity.vo.PropertyPercentageVO;
import com.rsm.entity.vo.UserUploadRankingVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 随手拍问题表 Mapper
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public interface DataRsmSnapshotMapper<T, P> extends BaseMapper {

	/**
 	 * 根据 Id 查询
 	 */
	T selectById(@Param("id")Long id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateById(@Param("bean") T t, @Param("id")Long id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteById(@Param("id")Long id);

	PropertyPercentageVO selectPropertyPercentage();

	/**
	 * 查询隐患认定率
	 */
	HazardRecognitionRateVO selectHazardRecognitionRate();

	/**
	 * 查询用户上传排名前5
	 */
	List<UserUploadRankingVO> selectUserUploadRanking();
}