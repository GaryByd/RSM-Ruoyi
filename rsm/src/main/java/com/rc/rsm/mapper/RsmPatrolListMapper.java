package com.rc.rsm.mapper;

import java.util.List;
import com.rc.rsm.domain.po.RsmPatrolList;
import org.apache.ibatis.annotations.Param;

/**
 * 巡查清单Mapper接口
 * 
 * @author ruoyi
 * @date 2024-09-10
 */
public interface RsmPatrolListMapper 
{
    /**
     * 查询巡查清单
     * 
     * @param id 巡查清单主键
     * @return 巡查清单
     */
    public RsmPatrolList selectRsmPatrolListById(Long id);

    /**
     * 查询巡查清单列表
     * 
     * @param rsmPatrolList 巡查清单
     * @return 巡查清单集合
     */
    public List<RsmPatrolList> selectRsmPatrolListList(RsmPatrolList rsmPatrolList);

    /**
     * 新增巡查清单
     * 
     * @param rsmPatrolList 巡查清单
     * @return 结果
     */
    public Long insertRsmPatrolList(RsmPatrolList rsmPatrolList);

    /**
     * 修改巡查清单
     * 
     * @param rsmPatrolList 巡查清单
     * @return 结果
     */
    public int updateRsmPatrolList(RsmPatrolList rsmPatrolList);

    /**
     * 删除巡查清单
     * 
     * @param id 巡查清单主键
     * @return 结果
     */
    public int deleteRsmPatrolListById(Long id);

    /**
     * 批量删除巡查清单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRsmPatrolListByIds(Long[] ids);

    List<RsmPatrolList> selectByStatus(@Param("patrolListMax") Integer patrolListMax);

    void updateWaitingChecked(@Param("id")Long id);

    List<RsmPatrolList> selectRsmAllPatrolList();

    void minusWaitingChecked(@Param("id") Long patrolListId);
}
