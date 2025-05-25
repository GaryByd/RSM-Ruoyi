package com.rc.rsm.service;

import java.util.List;

import com.rc.rsm.domain.po.RsmRisk;
import com.rc.rsm.domain.po.RsmTask;
import com.rc.rsm.domain.query.RsmTaskQuery;
import com.rc.rsm.domain.vo.RsmTaskVO;
import com.ruoyi.common.core.domain.model.LoginUser;

import javax.servlet.http.HttpServletRequest;

/**
 * 作业Service接口
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
public interface IRsmTaskService 
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
     * 批量删除作业
     * 
     * @param ids 需要删除的作业主键集合
     * @return 结果
     */
    public int deleteRsmTaskByIds(Long[] ids);

    /**
     * 删除作业信息
     * 
     * @param id 作业主键
     * @return 结果
     */
    public int deleteRsmTaskById(Long id);

    List<RsmTaskVO> selectRsmRiskListByLevel(RsmTaskQuery rsmTaskQuery);

    List<RsmTask> selectALlRsmTask(RsmTask rsmTask);

    void insertBatchRsmTask(List<RsmTask> rsmTaskList, LoginUser loginUser);
}
