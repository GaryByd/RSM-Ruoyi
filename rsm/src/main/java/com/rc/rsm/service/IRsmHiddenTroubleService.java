package com.rc.rsm.service;

import java.util.List;
import com.rc.rsm.domain.po.RsmHiddenTrouble;
import com.rc.rsm.domain.vo.DateCountVO;
import com.rc.rsm.domain.vo.DayCountVO;

/**
 * 隐患Service接口
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
public interface IRsmHiddenTroubleService 
{
    /**
     * 查询隐患
     * 
     * @param id 隐患主键
     * @return 隐患
     */
    public RsmHiddenTrouble selectRsmHiddenTroubleById(Long id);

    /**
     * 查询隐患列表
     * 
     * @param rsmHiddenTrouble 隐患
     * @return 隐患集合
     */
    public List<RsmHiddenTrouble> selectRsmHiddenTroubleList(RsmHiddenTrouble rsmHiddenTrouble);

    /**
     * 新增隐患
     * 
     * @param rsmHiddenTrouble 隐患
     * @return 结果
     */
    public int insertRsmHiddenTrouble(RsmHiddenTrouble rsmHiddenTrouble);

    /**
     * 修改隐患
     * 
     * @param rsmHiddenTrouble 隐患
     * @return 结果
     */
    public int updateRsmHiddenTrouble(RsmHiddenTrouble rsmHiddenTrouble);

    /**
     * 批量删除隐患
     * 
     * @param ids 需要删除的隐患主键集合
     * @return 结果
     */
    public int deleteRsmHiddenTroubleByIds(Long[] ids);

    /**
     * 删除隐患信息
     * 
     * @param id 隐患主键
     * @return 结果
     */
    public int deleteRsmHiddenTroubleById(Long id);

    List<RsmHiddenTrouble> selectRsmAllHiddenTrouble(RsmHiddenTrouble rsmHiddenTrouble);

    List<DateCountVO> countByMonth();

    List<DayCountVO> countByWeek();
}
