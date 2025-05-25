package com.rc.rsm.service.impl;

import java.util.List;

import com.rc.rsm.domain.po.RsmRisk;
import com.rc.rsm.domain.enums.TaskApprovalStatus;
import com.rc.rsm.domain.query.RsmTaskQuery;
import com.rc.rsm.domain.vo.RsmTaskVO;
import com.rc.rsm.mapper.RsmRiskMapper;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.web.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.rc.rsm.mapper.RsmTaskMapper;
import com.rc.rsm.domain.po.RsmTask;
import com.rc.rsm.service.IRsmTaskService;

import javax.servlet.http.HttpServletRequest;

/**
 * 作业Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
@Service
public class RsmTaskServiceImpl implements IRsmTaskService 
{
    @Autowired
    private RsmTaskMapper rsmTaskMapper;

    @Autowired
    private RsmRiskMapper rsmRiskMapper;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询作业
     * 
     * @param id 作业主键
     * @return 作业
     */
    @Override
    public RsmTask selectRsmTaskById(Long id)
    {
        return rsmTaskMapper.selectRsmTaskById(id);
    }

    /**
     * 查询作业列表
     * 
     * @param rsmTask 作业
     * @return 作业
     */
    @Override
    public List<RsmTask> selectRsmTaskList(RsmTask rsmTask)
    {
        return rsmTaskMapper.selectRsmTaskList(rsmTask);
    }

    @Override
    public List<RsmTask> selectALlRsmTask(RsmTask rsmTask) {
        return rsmTaskMapper.selectALlRsmTask(rsmTask);
    }

    @Override
    public void insertBatchRsmTask(List<RsmTask> rsmTaskList, LoginUser loginUser) {

        SysUser user = loginUser.getUser();
        String name = user.getUserName();

        for (RsmTask rsmTask : rsmTaskList) {
            rsmTask.setCreateBy(name);
            rsmTask.setCreateTime(DateUtils.getNowDate());
            rsmTask.setUpdateTime(rsmTask.getCreateTime());
            rsmTask.setUpdateBy(name);

            Long riskId = rsmTask.getRiskId();
            RsmRisk rsmRisk = rsmRiskMapper.selectRsmRiskById(riskId);
            if(rsmRisk == null){
                rsmTask.setApprovalStatus(TaskApprovalStatus.CHECKING.getStatus());
                break;
            }
            String riskLevel = rsmRisk.getRiskLevel();
            if(riskLevel.equals("A")){
                //设置状态为审核中
                rsmTask.setApprovalStatus(TaskApprovalStatus.CHECKING.getStatus());
            }else {
                //设置审核状态为通过
                rsmTask.setApprovalStatus(TaskApprovalStatus.PASS.getStatus());
            }
        }
        rsmTaskMapper.insertBatchRsmTask(rsmTaskList);
    }

    /**
     * 新增作业
     * 
     * @param rsmTask 作业
     * @return 结果
     */
    @Override
    public int insertRsmTask(RsmTask rsmTask)
    {

        Long riskId = rsmTask.getRiskId();
        RsmRisk rsmRisk = rsmRiskMapper.selectRsmRiskById(riskId);
        if(rsmRisk == null){
            throw new ServiceException("不存在该风险项");
        }
        String riskLevel = rsmRisk.getRiskLevel();
        if(riskLevel.equals("A")){
            //设置状态为审核中
            rsmTask.setApprovalStatus(TaskApprovalStatus.CHECKING.getStatus());
        }else {
            //设置审核状态为通过
            rsmTask.setApprovalStatus(TaskApprovalStatus.PASS.getStatus());
        }

        return rsmTaskMapper.insertRsmTask(rsmTask);
    }

    /**
     * 修改作业
     * 
     * @param rsmTask 作业
     * @return 结果
     */
    @Override
    public int updateRsmTask(RsmTask rsmTask)
    {
        rsmTask.setUpdateTime(DateUtils.getNowDate());
        return rsmTaskMapper.updateRsmTask(rsmTask);
    }

    /**
     * 批量删除作业
     * 
     * @param ids 需要删除的作业主键
     * @return 结果
     */
    @Override
    public int deleteRsmTaskByIds(Long[] ids)
    {
        return rsmTaskMapper.deleteRsmTaskByIds(ids);
    }

    /**
     * 删除作业信息
     * 
     * @param id 作业主键
     * @return 结果
     */
    @Override
    public int deleteRsmTaskById(Long id)
    {
        return rsmTaskMapper.deleteRsmTaskById(id);
    }

    @Override
    public List<RsmTaskVO> selectRsmRiskListByLevel(RsmTaskQuery rsmTaskQuery) {
        return rsmTaskMapper.selectRsmRiskListByLevel(rsmTaskQuery);
    }


}
