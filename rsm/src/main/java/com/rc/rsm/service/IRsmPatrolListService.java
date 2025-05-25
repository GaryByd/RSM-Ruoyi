package com.rc.rsm.service;

import java.util.List;
import com.rc.rsm.domain.po.RsmPatrolList;

/**
 * 巡查清单Service接口
 * 
 * @author ruoyi
 * @date 2024-09-10
 */
public interface IRsmPatrolListService 
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
     * 批量删除巡查清单
     * 
     * @param ids 需要删除的巡查清单主键集合
     * @return 结果
     */
    public int deleteRsmPatrolListByIds(Long[] ids);

    /**
     * 删除巡查清单信息
     * 
     * @param id 巡查清单主键
     * @return 结果
     */
    public int deleteRsmPatrolListById(Long id);

    List<RsmPatrolList> selectRsmAllPatrolList(RsmPatrolList rsmPatrolList);
}
