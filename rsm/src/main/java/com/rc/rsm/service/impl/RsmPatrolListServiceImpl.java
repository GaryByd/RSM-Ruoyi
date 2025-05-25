package com.rc.rsm.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rc.rsm.mapper.RsmPatrolListMapper;
import com.rc.rsm.domain.po.RsmPatrolList;
import com.rc.rsm.service.IRsmPatrolListService;

/**
 * 巡查清单Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-10
 */
@Service
public class RsmPatrolListServiceImpl implements IRsmPatrolListService 
{
    @Autowired
    private RsmPatrolListMapper rsmPatrolListMapper;

    /**
     * 查询巡查清单
     * 
     * @param id 巡查清单主键
     * @return 巡查清单
     */
    @Override
    public RsmPatrolList selectRsmPatrolListById(Long id)
    {
        return rsmPatrolListMapper.selectRsmPatrolListById(id);
    }

    /**
     * 查询巡查清单列表
     * 
     * @param rsmPatrolList 巡查清单
     * @return 巡查清单
     */
    @Override
    public List<RsmPatrolList> selectRsmPatrolListList(RsmPatrolList rsmPatrolList)
    {
        return rsmPatrolListMapper.selectRsmPatrolListList(rsmPatrolList);
    }

    /**
     * 新增巡查清单
     * 
     * @param rsmPatrolList 巡查清单
     * @return 结果
     */
    @Override
    public Long insertRsmPatrolList(RsmPatrolList rsmPatrolList)
    {
        rsmPatrolList.setCreateTime(DateUtils.getNowDate());
        return rsmPatrolListMapper.insertRsmPatrolList(rsmPatrolList);
    }

    /**
     * 修改巡查清单
     * 
     * @param rsmPatrolList 巡查清单
     * @return 结果
     */
    @Override
    public int updateRsmPatrolList(RsmPatrolList rsmPatrolList)
    {
        rsmPatrolList.setUpdateTime(DateUtils.getNowDate());
        return rsmPatrolListMapper.updateRsmPatrolList(rsmPatrolList);
    }

    /**
     * 批量删除巡查清单
     * 
     * @param ids 需要删除的巡查清单主键
     * @return 结果
     */
    @Override
    public int deleteRsmPatrolListByIds(Long[] ids)
    {
        return rsmPatrolListMapper.deleteRsmPatrolListByIds(ids);
    }

    /**
     * 删除巡查清单信息
     * 
     * @param id 巡查清单主键
     * @return 结果
     */
    @Override
    public int deleteRsmPatrolListById(Long id)
    {
        return rsmPatrolListMapper.deleteRsmPatrolListById(id);
    }

    @Override
    public List<RsmPatrolList> selectRsmAllPatrolList(RsmPatrolList rsmPatrolList) {
        return rsmPatrolListMapper.selectRsmAllPatrolList();
    }
}
