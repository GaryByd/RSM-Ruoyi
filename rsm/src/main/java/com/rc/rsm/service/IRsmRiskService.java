package com.rc.rsm.service;

import java.util.List;
import com.rc.rsm.domain.po.RsmRisk;

/**
 * 风险库Service接口
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
public interface IRsmRiskService 
{
    /**
     * 查询风险库
     * 
     * @param id 风险库主键
     * @return 风险库
     */
    public RsmRisk selectRsmRiskById(Long id);

    /**
     * 查询风险库列表
     * 
     * @param rsmRisk 风险库
     * @return 风险库集合
     */
    public List<RsmRisk> selectRsmRiskList(RsmRisk rsmRisk);

    /**
     * 新增风险库
     * 
     * @param rsmRisk 风险库
     * @return 结果
     */
    public int insertRsmRisk(RsmRisk rsmRisk);

    /**
     * 修改风险库
     * 
     * @param rsmRisk 风险库
     * @return 结果
     */
    public int updateRsmRisk(RsmRisk rsmRisk);

    /**
     * 批量删除风险库
     * 
     * @param ids 需要删除的风险库主键集合
     * @return 结果
     */
    public int deleteRsmRiskByIds(Long[] ids);

    /**
     * 删除风险库信息
     * 
     * @param id 风险库主键
     * @return 结果
     */
    public int deleteRsmRiskById(Long id);

    List<RsmRisk> selectAllRsmRisk(RsmRisk rsmRisk);
}
