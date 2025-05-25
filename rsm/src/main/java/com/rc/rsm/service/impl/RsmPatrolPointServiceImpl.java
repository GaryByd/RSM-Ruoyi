package com.rc.rsm.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rc.rsm.mapper.RsmPatrolPointMapper;
import com.rc.rsm.domain.po.RsmPatrolPoint;
import com.rc.rsm.service.IRsmPatrolPointService;

/**
 * 巡查点Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
@Service
public class RsmPatrolPointServiceImpl implements IRsmPatrolPointService 
{
    @Autowired
    private RsmPatrolPointMapper rsmPatrolPointMapper;

    /**
     * 查询巡查点
     * 
     * @param id 巡查点主键
     * @return 巡查点
     */
    @Override
    public RsmPatrolPoint selectRsmPatrolPointById(Long id)
    {
        return rsmPatrolPointMapper.selectRsmPatrolPointById(id);
    }

    /**
     * 查询巡查点列表
     * 
     * @param rsmPatrolPoint 巡查点
     * @return 巡查点
     */
    @Override
    public List<RsmPatrolPoint> selectRsmPatrolPointList(RsmPatrolPoint rsmPatrolPoint)
    {
        return rsmPatrolPointMapper.selectRsmPatrolPointList(rsmPatrolPoint);
    }

    /**
     * 新增巡查点
     * 
     * @param rsmPatrolPoint 巡查点
     * @return 结果
     */
    @Override
    public int insertRsmPatrolPoint(RsmPatrolPoint rsmPatrolPoint)
    {
        rsmPatrolPoint.setCreateTime(DateUtils.getNowDate());
        return rsmPatrolPointMapper.insertRsmPatrolPoint(rsmPatrolPoint);
    }

    /**
     * 修改巡查点
     * 
     * @param rsmPatrolPoint 巡查点
     * @return 结果
     */
    @Override
    public int updateRsmPatrolPoint(RsmPatrolPoint rsmPatrolPoint)
    {
        rsmPatrolPoint.setUpdateTime(DateUtils.getNowDate());
        return rsmPatrolPointMapper.updateRsmPatrolPoint(rsmPatrolPoint);
    }

    /**
     * 批量删除巡查点
     * 
     * @param ids 需要删除的巡查点主键
     * @return 结果
     */
    @Override
    public int deleteRsmPatrolPointByIds(Long[] ids)
    {
        return rsmPatrolPointMapper.deleteRsmPatrolPointByIds(ids);
    }

    /**
     * 删除巡查点信息
     * 
     * @param id 巡查点主键
     * @return 结果
     */
    @Override
    public int deleteRsmPatrolPointById(Long id)
    {
        return rsmPatrolPointMapper.deleteRsmPatrolPointById(id);
    }

    @Override
    public List<RsmPatrolPoint> selectRsmAllPatrolPoint(RsmPatrolPoint rsmPatrolPoint) {
        return rsmPatrolPointMapper.selectRsmAllPatrolPoint(rsmPatrolPoint);
    }
}
