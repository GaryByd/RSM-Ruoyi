package com.rc.rsm.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.rc.rsm.domain.vo.DateCountVO;
import com.rc.rsm.domain.vo.DayCountVO;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rc.rsm.mapper.RsmHiddenTroubleMapper;
import com.rc.rsm.domain.po.RsmHiddenTrouble;
import com.rc.rsm.service.IRsmHiddenTroubleService;

/**
 * 隐患Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
@Service
public class RsmHiddenTroubleServiceImpl implements IRsmHiddenTroubleService 
{
    @Autowired
    private RsmHiddenTroubleMapper rsmHiddenTroubleMapper;

    /**
     * 查询隐患
     * 
     * @param id 隐患主键
     * @return 隐患
     */
    @Override
    public RsmHiddenTrouble selectRsmHiddenTroubleById(Long id)
    {
        return rsmHiddenTroubleMapper.selectRsmHiddenTroubleById(id);
    }

    /**
     * 查询隐患列表
     * 
     * @param rsmHiddenTrouble 隐患
     * @return 隐患
     */
    @Override
    public List<RsmHiddenTrouble> selectRsmHiddenTroubleList(RsmHiddenTrouble rsmHiddenTrouble)
    {
        return rsmHiddenTroubleMapper.selectRsmHiddenTroubleList(rsmHiddenTrouble);
    }

    /**
     * 新增隐患
     * 
     * @param rsmHiddenTrouble 隐患
     * @return 结果
     */
    @Override
    public int insertRsmHiddenTrouble(RsmHiddenTrouble rsmHiddenTrouble)
    {
        rsmHiddenTrouble.setCreateTime(DateUtils.getNowDate());
        return rsmHiddenTroubleMapper.insertRsmHiddenTrouble(rsmHiddenTrouble);
    }

    /**
     * 修改隐患
     * 
     * @param rsmHiddenTrouble 隐患
     * @return 结果
     */
    @Override
    public int updateRsmHiddenTrouble(RsmHiddenTrouble rsmHiddenTrouble)
    {
        rsmHiddenTrouble.setUpdateTime(DateUtils.getNowDate());
        return rsmHiddenTroubleMapper.updateRsmHiddenTrouble(rsmHiddenTrouble);
    }

    /**
     * 批量删除隐患
     * 
     * @param ids 需要删除的隐患主键
     * @return 结果
     */
    @Override
    public int deleteRsmHiddenTroubleByIds(Long[] ids)
    {
        return rsmHiddenTroubleMapper.deleteRsmHiddenTroubleByIds(ids);
    }

    /**
     * 删除隐患信息
     * 
     * @param id 隐患主键
     * @return 结果
     */
    @Override
    public int deleteRsmHiddenTroubleById(Long id)
    {
        return rsmHiddenTroubleMapper.deleteRsmHiddenTroubleById(id);
    }

    @Override
    public List<RsmHiddenTrouble> selectRsmAllHiddenTrouble(RsmHiddenTrouble rsmHiddenTrouble) {
        return rsmHiddenTroubleMapper.selectRsmAllHiddenTrouble(rsmHiddenTrouble);
    }

    @Override
    public List<DateCountVO> countByMonth() {
        return rsmHiddenTroubleMapper.countByMonth();
    }

    @Override
    public List<DayCountVO> countByWeek() {
        List<DayCountVO> countVOS = rsmHiddenTroubleMapper.countByWeek();
        return getCompleteWeekData(countVOS);
    }

    public List<DayCountVO> getCompleteWeekData(List<DayCountVO> countVOS) {
        List<DayCountVO> completeData = new ArrayList<>();
        Map<String, DayCountVO> dayCountVOMap = new HashMap<>();

        // 将查询结果放入Map中
        for (DayCountVO vo : countVOS) {
            dayCountVOMap.put(vo.getDay(), vo);
        }

        // 获取过去七天的日期
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-d");
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < 7; i++) {
            String day = formatter.format(calendar.getTime());
            calendar.add(Calendar.DATE, -1); // 从今天开始向前推一天
            // 如果Map中没有这一天，则添加一个count为0的DayCountVO
            if (!dayCountVOMap.containsKey(day)) {
                DayCountVO vo = new DayCountVO();
                vo.setDay(day);
                vo.setCount(0);
                completeData.add(vo);
            } else {
                // 如果有数据，直接添加到结果列表中
                completeData.add(dayCountVOMap.get(day));
            }
        }

        // 将日期重新排序，确保是按日期顺序排列
        completeData.sort((o1, o2) -> o1.getDay().compareTo(o2.getDay()));

        return completeData;
    }
}
