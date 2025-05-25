package com.rsm.mapper;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * @Description: 巡查清单表 Mapper
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public interface DataRsmPatrolListMapper<T, P> extends BaseMapper {

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

    Double selectFoundRate();

    Double selectCompletionRate();

    /**
     * 查询巡查点表中按巡查次数降序排列的前5个巡查点
     */
    List<Map<String, Object>> selectTop5PatrolPoints();
}

