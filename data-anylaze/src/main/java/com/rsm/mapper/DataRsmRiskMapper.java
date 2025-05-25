package com.rsm.mapper;

import com.rsm.entity.vo.MonthlyRiskCountVO;
import com.rsm.entity.vo.RiskLevelCountVO;
import com.rsm.entity.vo.RiskMonthLevelCountVO;
import com.rsm.entity.vo.RiskTypeDistributionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 风险库表 Mapper
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public interface DataRsmRiskMapper<T, P> extends BaseMapper {

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


	List<RiskLevelCountVO> selectRiskLevelCount();

	Integer selectALevelUnprocessed();

	List<RiskMonthLevelCountVO> selectRecent6MonthLevel();
	
	List<RiskTypeDistributionVO> selectRiskTypeDistribution();
	
	/**
	 * 获取每月新增风险数量趋势
	 */
	List<MonthlyRiskCountVO> selectMonthlyRiskCount();

	/**
	 * 获取每月新发现作业风险数量
	 */
	List<MonthlyRiskCountVO> selectMonthlyOperationRiskCount();
}
