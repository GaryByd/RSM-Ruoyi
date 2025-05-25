package com.rc.rsm.service;

import java.util.List;
import com.rc.rsm.domain.po.RsmPatrolPoint;

/**
 * 巡查点Service接口
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
public interface IRsmPatrolPointService 
{
    /**
     * 查询巡查点
     * 
     * @param id 巡查点主键
     * @return 巡查点
     */
    public RsmPatrolPoint selectRsmPatrolPointById(Long id);

    /**
     * 查询巡查点列表
     * 
     * @param rsmPatrolPoint 巡查点
     * @return 巡查点集合
     */
    public List<RsmPatrolPoint> selectRsmPatrolPointList(RsmPatrolPoint rsmPatrolPoint);

    /**
     * 新增巡查点
     * 
     * @param rsmPatrolPoint 巡查点
     * @return 结果
     */
    public int insertRsmPatrolPoint(RsmPatrolPoint rsmPatrolPoint);

    /**
     * 修改巡查点
     * 
     * @param rsmPatrolPoint 巡查点
     * @return 结果
     */
    public int updateRsmPatrolPoint(RsmPatrolPoint rsmPatrolPoint);

    /**
     * 批量删除巡查点
     * 
     * @param ids 需要删除的巡查点主键集合
     * @return 结果
     */
    public int deleteRsmPatrolPointByIds(Long[] ids);

    /**
     * 删除巡查点信息
     * 
     * @param id 巡查点主键
     * @return 结果
     */
    public int deleteRsmPatrolPointById(Long id);

    List<RsmPatrolPoint> selectRsmAllPatrolPoint(RsmPatrolPoint rsmPatrolPoint);
}
