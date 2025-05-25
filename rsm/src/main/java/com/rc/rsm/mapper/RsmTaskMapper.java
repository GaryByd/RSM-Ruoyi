package com.rc.rsm.mapper;

import java.util.List;

import com.rc.rsm.domain.po.RsmRisk;
import com.rc.rsm.domain.po.RsmTask;
import com.rc.rsm.domain.query.RsmTaskQuery;
import com.rc.rsm.domain.vo.RsmTaskVO;
import org.apache.ibatis.annotations.Param;

/**
 * 作业Mapper接口
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
public interface RsmTaskMapper 
{
    /**
     * 查询作业
     * 
     * @param id 作业主键
     * @return 作业
     */
    public RsmTask selectRsmTaskById(Long id);

    /**
     * 查询作业列表
     * 
     * @param rsmTask 作业
     * @return 作业集合
     */
    public List<RsmTask> selectRsmTaskList(RsmTask rsmTask);

    /**
     * 新增作业
     * 
     * @param rsmTask 作业
     * @return 结果
     */
    public int insertRsmTask(RsmTask rsmTask);

    /**
     * 修改作业
     * 
     * @param rsmTask 作业
     * @return 结果
     */
    public int updateRsmTask(RsmTask rsmTask);

    /**
     * 删除作业
     * 
     * @param id 作业主键
     * @return 结果
     */
    public int deleteRsmTaskById(Long id);

    /**
     * 批量删除作业
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRsmTaskByIds(Long[] ids);

    List<RsmTask> selectTodayTask();

    List<RsmTaskVO> selectRsmRiskListByLevel(RsmTaskQuery rsmTaskQuery);

    List<RsmTask> selectALlRsmTask(RsmTask rsmTask);

    void insertBatchRsmTask(@Param("rsmTaskList") List<RsmTask> rsmTaskList);

    void updateApprovalStatusById(@Param("id") Long id);
}
