package com.rc.rsm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.rc.rsm.domain.po.RsmPatrolList;
import com.rc.rsm.domain.vo.DateCountVO;
import com.rc.rsm.domain.vo.DayCountVO;
import com.rc.rsm.mapper.RsmPatrolListMapper;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysUserRole;
import com.ruoyi.system.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.rc.rsm.mapper.RsmUnverifiedRiskMapper;
import com.rc.rsm.domain.po.RsmUnverifiedRisk;
import com.rc.rsm.service.IRsmUnverifiedRiskService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 风险待查项Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
@Service
public class RsmUnverifiedRiskServiceImpl implements IRsmUnverifiedRiskService 
{
    @Autowired
    private RsmUnverifiedRiskMapper rsmUnverifiedRiskMapper;

    @Resource
    private RsmPatrolListMapper patrolListMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Value("${patrol.list.max:5}")
    private String patrolListMax;
    /**
     * 查询风险待查项
     * 
     * @param id 风险待查项主键
     * @return 风险待查项
     */
    @Override
    public RsmUnverifiedRisk selectRsmUnverifiedRiskById(Long id)
    {
        return rsmUnverifiedRiskMapper.selectRsmUnverifiedRiskById(id);
    }

    /**
     * 查询风险待查项列表
     * 
     * @param rsmUnverifiedRisk 风险待查项
     * @return 风险待查项
     */
    @Override
    public List<RsmUnverifiedRisk> selectRsmUnverifiedRiskList(RsmUnverifiedRisk rsmUnverifiedRisk)
    {
        return rsmUnverifiedRiskMapper.selectRsmUnverifiedRiskList(rsmUnverifiedRisk);
    }

    /**
     * 新增风险待查项
     * 
     * @param rsmUnverifiedRisk 风险待查项
     * @return 结果
     */
    @Override
    public int insertRsmUnverifiedRisk(RsmUnverifiedRisk rsmUnverifiedRisk)
    {
        rsmUnverifiedRisk.setCreateTime(DateUtils.getNowDate());
        Long patrolListId = getPatrolListId(rsmUnverifiedRisk);
        rsmUnverifiedRisk.setPatrolListId(patrolListId);
        return rsmUnverifiedRiskMapper.insertRsmUnverifiedRisk(rsmUnverifiedRisk);
    }
    private Long getPatrolListId(RsmUnverifiedRisk unverifiedRisk){
        Integer checkedMax = Integer.valueOf(patrolListMax);
        List<RsmPatrolList> patrolList = patrolListMapper.selectByStatus(checkedMax);
        if(patrolList != null && !patrolList.isEmpty()){
            Long id = patrolList.get(0).getId();
            //该清单关联待查项加一
            patrolListMapper.updateWaitingChecked(id);
            return id;
        }
        //如果不存在可插入的清单，创建新清单
        RsmPatrolList patrol = new RsmPatrolList();
        patrol.setPatrolListName(unverifiedRisk.getUnverifiedRiskName());
        // 设置安全员ID
        // 查出所有安全员的id
        List<SysUserRole> list = sysUserRoleMapper.selectPrincipalId();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            Random random = new Random();
            int randomIndex = random.nextInt(size);

            // 根据随机索引获取列表中的元素
            SysUserRole randomSysUserRole = list.get(randomIndex);
            if(randomSysUserRole == null){
                patrol.setPrincipalId(null);
            }else {
                patrol.setPrincipalId(randomSysUserRole.getUserId());
            }
        }else {
            patrol.setPrincipalId(null);
        }

        patrol.setCheckedCount(0);
        patrol.setHiddenTroubleCount(0);
        patrol.setWaitingChecked(1);
        patrol.setStatus(0);
        patrol.setDelFlag(0);
        patrol.setCreateBy("system");
        patrol.setCreateTime(new Date());
        patrol.setUpdateBy("system");
        patrol.setUpdateTime(new Date());

        patrolListMapper.insertRsmPatrolList(patrol);
        Long id = patrol.getId();
        if (id == null){
            return null;
        }
        return id;
    }
    /**
     * 修改风险待查项
     * 
     * @param rsmUnverifiedRisk 风险待查项
     * @return 结果
     */
    @Override
    public int updateRsmUnverifiedRisk(RsmUnverifiedRisk rsmUnverifiedRisk)
    {
        rsmUnverifiedRisk.setUpdateTime(DateUtils.getNowDate());
        return rsmUnverifiedRiskMapper.updateRsmUnverifiedRisk(rsmUnverifiedRisk);
    }

    /**
     * 批量删除风险待查项
     * 
     * @param ids 需要删除的风险待查项主键
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteRsmUnverifiedRiskByIds(Long[] ids)
    {
        for (Long id : ids){
            RsmUnverifiedRisk rsmUnverifiedRisk = rsmUnverifiedRiskMapper.selectRsmUnverifiedRiskById(id);
            Long patrolListId = rsmUnverifiedRisk.getPatrolListId();
            if(patrolListId == null){
                throw new RuntimeException("该风险待查项未关联巡查清单，请联系管理员");
            }
            patrolListMapper.minusWaitingChecked(patrolListId);
        }
        return rsmUnverifiedRiskMapper.deleteRsmUnverifiedRiskByIds(ids);
    }

    /**
     * 删除风险待查项信息
     * 
     * @param id 风险待查项主键
     * @return 结果
     */
    @Override
    public int deleteRsmUnverifiedRiskById(Long id)
    {
        return rsmUnverifiedRiskMapper.deleteRsmUnverifiedRiskById(id);
    }

    @Override
    public List<RsmUnverifiedRisk> selectRsmAllUnverifiedRisk(RsmUnverifiedRisk rsmUnverifiedRisk) {
        return rsmUnverifiedRiskMapper.selectRsmAllUnverifiedRisk(rsmUnverifiedRisk);
    }

    @Override
    public List<DateCountVO> countByMonth() {
        return rsmUnverifiedRiskMapper.countByMonth();
    }

    @Override
    public List<DayCountVO> countByThisMonth() {
        return rsmUnverifiedRiskMapper.countByThisMonth();
    }
}
