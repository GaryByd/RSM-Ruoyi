package com.rc.rsm.service;

import java.util.List;
import com.rc.rsm.domain.po.RsmUnverifiedRisk;
import com.rc.rsm.domain.vo.DateCountVO;
import com.rc.rsm.domain.vo.DayCountVO;

/**
 * 风险待查项Service接口
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
public interface IRsmUnverifiedRiskService 
{
    /**
     * 查询风险待查项
     * 
     * @param id 风险待查项主键
     * @return 风险待查项
     */
    public RsmUnverifiedRisk selectRsmUnverifiedRiskById(Long id);

    /**
     * 查询风险待查项列表
     * 
     * @param rsmUnverifiedRisk 风险待查项
     * @return 风险待查项集合
     */
    public List<RsmUnverifiedRisk> selectRsmUnverifiedRiskList(RsmUnverifiedRisk rsmUnverifiedRisk);

    /**
     * 新增风险待查项
     * 
     * @param rsmUnverifiedRisk 风险待查项
     * @return 结果
     */
    public int insertRsmUnverifiedRisk(RsmUnverifiedRisk rsmUnverifiedRisk);

    /**
     * 修改风险待查项
     * 
     * @param rsmUnverifiedRisk 风险待查项
     * @return 结果
     */
    public int updateRsmUnverifiedRisk(RsmUnverifiedRisk rsmUnverifiedRisk);

    /**
     * 批量删除风险待查项
     * 
     * @param ids 需要删除的风险待查项主键集合
     * @return 结果
     */
    public int deleteRsmUnverifiedRiskByIds(Long[] ids);

    /**
     * 删除风险待查项信息
     * 
     * @param id 风险待查项主键
     * @return 结果
     */
    public int deleteRsmUnverifiedRiskById(Long id);

    List<RsmUnverifiedRisk> selectRsmAllUnverifiedRisk(RsmUnverifiedRisk rsmUnverifiedRisk);

    List<DateCountVO> countByMonth();

    List<DayCountVO> countByThisMonth();
}
