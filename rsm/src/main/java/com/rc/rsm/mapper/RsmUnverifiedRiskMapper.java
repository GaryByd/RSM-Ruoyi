package com.rc.rsm.mapper;

import java.util.List;
import com.rc.rsm.domain.po.RsmUnverifiedRisk;
import com.rc.rsm.domain.vo.DateCountVO;
import com.rc.rsm.domain.vo.DayCountVO;

/**
 * 风险待查项Mapper接口
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
public interface RsmUnverifiedRiskMapper 
{
    /**
     * 查询风险待查项
     * 
     * @param id 风险待查项主键
     * @return 风险待查项
     */
    public RsmUnverifiedRisk selectRsmUnverifiedRiskById(Long id);


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
     * 删除风险待查项
     * 
     * @param id 风险待查项主键
     * @return 结果
     */
    public int deleteRsmUnverifiedRiskById(Long id);

    /**
     * 批量删除风险待查项
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRsmUnverifiedRiskByIds(Long[] ids);

    List<RsmUnverifiedRisk> selectRsmAllUnverifiedRisk(RsmUnverifiedRisk rsmUnverifiedRisk);

    List<DateCountVO> countByMonth();

    List<DayCountVO> countByThisMonth();
}
