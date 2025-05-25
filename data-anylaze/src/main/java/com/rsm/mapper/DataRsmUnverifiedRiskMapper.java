package com.rsm.mapper;

import com.rsm.entity.vo.HazardDiscoveryRateVO;
import com.rsm.entity.vo.UnverifiedRiskCountByMonthVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 风险待查项表 Mapper
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public interface DataRsmUnverifiedRiskMapper<T, P> extends BaseMapper {

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

	List<UnverifiedRiskCountByMonthVO> selectUnverifiedRiskCountByMonth();
	
	/**
	 * 查询待查项发现隐患率
	 */
	HazardDiscoveryRateVO selectHazardDiscoveryRate();
}
