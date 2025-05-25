package com.rc.rsm.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rc.rsm.mapper.RsmRiskMapper;
import com.rc.rsm.domain.po.RsmRisk;
import com.rc.rsm.service.IRsmRiskService;

/**
 * 风险库Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
@Service
public class RsmRiskServiceImpl implements IRsmRiskService 
{
    @Autowired
    private RsmRiskMapper rsmRiskMapper;

    /**
     * 查询风险库
     * 
     * @param id 风险库主键
     * @return 风险库
     */
    @Override
    public RsmRisk selectRsmRiskById(Long id)
    {
        return rsmRiskMapper.selectRsmRiskById(id);
    }

    /**
     * 查询风险库列表
     * 
     * @param rsmRisk 风险库
     * @return 风险库
     */
    @Override
    public List<RsmRisk> selectRsmRiskList(RsmRisk rsmRisk)
    {
        return rsmRiskMapper.selectRsmRiskList(rsmRisk);
    }

    /**
     * 新增风险库
     * 
     * @param rsmRisk 风险库
     * @return 结果
     */
    @Override
    public int insertRsmRisk(RsmRisk rsmRisk)
    {
        rsmRisk.setCreateTime(DateUtils.getNowDate());
        return rsmRiskMapper.insertRsmRisk(rsmRisk);
    }

    /**
     * 修改风险库
     * 
     * @param rsmRisk 风险库
     * @return 结果
     */
    @Override
    public int updateRsmRisk(RsmRisk rsmRisk)
    {
        rsmRisk.setUpdateTime(DateUtils.getNowDate());
        return rsmRiskMapper.updateRsmRisk(rsmRisk);
    }

    /**
     * 批量删除风险库
     * 
     * @param ids 需要删除的风险库主键
     * @return 结果
     */
    @Override
    public int deleteRsmRiskByIds(Long[] ids)
    {
        return rsmRiskMapper.deleteRsmRiskByIds(ids);
    }

    /**
     * 删除风险库信息
     * 
     * @param id 风险库主键
     * @return 结果
     */
    @Override
    public int deleteRsmRiskById(Long id)
    {
        return rsmRiskMapper.deleteRsmRiskById(id);
    }

    @Override
    public List<RsmRisk> selectAllRsmRisk(RsmRisk rsmRisk) {
        return rsmRiskMapper.selectAllRsmRisk(rsmRisk);
    }


}
