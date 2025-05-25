package com.ruoyi.quartz.task;


import com.rc.rsm.domain.enums.TaskApprovalStatus;
import com.rc.rsm.domain.po.*;
import com.rc.rsm.mapper.RsmPatrolListMapper;
import com.rc.rsm.mapper.RsmRiskMapper;
import com.rc.rsm.mapper.RsmTaskMapper;
import com.rc.rsm.mapper.RsmUnverifiedRiskMapper;
import java.util.Calendar;
import com.ruoyi.system.domain.SysUserRole;
import com.ruoyi.system.mapper.SysUserRoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component("todayTaskToUnverifiedRisk")
@Slf4j
public class TodayTaskToUnverifiedRisk {

    @Autowired
    private RsmTaskMapper rsmTaskMapper;
    @Autowired
    private RsmRiskMapper rsmRiskMapper;
    @Autowired
    private RsmUnverifiedRiskMapper rsmUnverifiedRiskMapper;

    @Autowired
    private RsmPatrolListMapper patrolListMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Value("${patrol.list.max:5}")
    private String patrolListMax;

    @Transactional
    public void TaskToUnverifiedRisk(){

        List<RsmTask> tasklist = rsmTaskMapper.selectTodayTask();
        if(tasklist.isEmpty() || tasklist == null){
            return;
        }
        for(RsmTask task : tasklist){
            //将任务状态改成3

            rsmTaskMapper.updateApprovalStatusById(task.getId());

            RsmUnverifiedRisk unverifiedRisk = new RsmUnverifiedRisk();
            unverifiedRisk.setUnverifiedRiskName(task.getTaskName());
            unverifiedRisk.setRiskId(task.getRiskId());

            RsmRisk rsmRisk = rsmRiskMapper.selectRsmRiskById(task.getRiskId());
            if(rsmRisk == null){
                throw new RuntimeException("定时任务无法发根据风险id查出风险项");
            }
            unverifiedRisk.setRiskType(rsmRisk.getRiskType());

            unverifiedRisk.setPosition(task.getPositionId());

            unverifiedRisk.setStatus(0);
            unverifiedRisk.setCreateBy("system");
            unverifiedRisk.setCreateTime(new Date());
            unverifiedRisk.setUpdateBy("system");
            unverifiedRisk.setUpdateTime(new Date());


            //TODO 设置巡查清单id
            Long patrolListId = getPatrolListId(unverifiedRisk);
            if(patrolListId == null){
                throw new RuntimeException("作业导入风险待查项库失败");
            }
            unverifiedRisk.setPatrolListId(patrolListId);


            rsmUnverifiedRiskMapper.insertRsmUnverifiedRisk(unverifiedRisk);
        }
    }

    private Long getPatrolListId(RsmUnverifiedRisk unverifiedRisk){
        Integer checkedMax = Integer.valueOf(patrolListMax);
        List<RsmPatrolList> patrolList = patrolListMapper.selectByStatus(checkedMax);
        if(patrolList != null && !patrolList.isEmpty()){
            RsmPatrolList rsmPatrolList = patrolList.get(0);
            Long id = rsmPatrolList.getId();
            RsmPatrolList update = new RsmPatrolList();
            update.setWaitingChecked(rsmPatrolList.getWaitingChecked() + 1);
            update.setUpdateTime(new Date());
            //该清单关联待查项加一
//            patrolListMapper.updateWaitingChecked(id);
            patrolListMapper.updateRsmPatrolList(update);
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
        // 创建当前日期的Calendar实例
        Calendar calendar = Calendar.getInstance();
        // 将Calendar设置为当天的0点
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        // 将Calendar设置为下一天的0点，即今天的结束时间
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        patrol.setCheckedCount(0);
        patrol.setHiddenTroubleCount(0);
        patrol.setWaitingChecked(1);
        patrol.setStatus(0);
        patrol.setDelFlag(0);
        patrol.setCreateBy("system");
        Date date = new Date();
        patrol.setStartTime(date);
        patrol.setEndTime(calendar.getTime());
        patrol.setCreateTime(date);
        patrol.setUpdateBy("system");
        patrol.setUpdateTime(date);

        patrolListMapper.insertRsmPatrolList(patrol);
        Long id = patrol.getId();
        if (id == null){
            return null;
        }
        return id;
    }

}
