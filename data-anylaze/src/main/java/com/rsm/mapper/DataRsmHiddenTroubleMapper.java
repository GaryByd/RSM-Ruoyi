package com.rsm.mapper;

import com.rsm.entity.vo.AvgRectifyTimeVO;
import com.rsm.entity.vo.ComprehensiveRiskIndexVO;
import com.rsm.entity.vo.DisposeStatusNumVO;
import com.rsm.entity.vo.HiddenTroubleSourceNumVO;
import com.rsm.entity.vo.TroubleClassifyNumVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 隐患表 Mapper
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public interface DataRsmHiddenTroubleMapper<T, P> extends BaseMapper {

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

	List<DisposeStatusNumVO> selectDisposeStatusNums();

	List<HiddenTroubleSourceNumVO> selectHiddenTroubleSourceNums();

	ComprehensiveRiskIndexVO selectComprehensiveRiskIndex();

    Integer selectHiddenTroubleCount();
    
    List<TroubleClassifyNumVO> selectTroubleClassifyNums();
    
    AvgRectifyTimeVO selectAvgRectifyTime();
}
