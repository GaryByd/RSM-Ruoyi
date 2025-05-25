package com.rsm.mapper;

import com.rsm.entity.vo.DeptTaskCountVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 作业表 Mapper
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
public interface DataRsmTaskMapper<T, P> extends BaseMapper {

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
	
	/**
	 * 查询各部门作业数量统计
	 */
	List<DeptTaskCountVO> selectTaskCountByDept();
}
