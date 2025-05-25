package com.rsm.controller;


import com.rsm.entity.dao.RsmPatrolPointQuery;
import com.rsm.entity.po.RsmPatrolPoint;
import com.rsm.entity.vo.PatrolNameFrequencyVO;
import com.rsm.entity.vo.PatrolPointTop5VO;
import com.rsm.entity.vo.ResponseVO;
import com.rsm.service.DataRsmPatrolPointService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 巡查点表 Controller
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
@RestController
@RequestMapping("/data/rsmPatrolPoint")
public class DataRsmPatrolPointController extends ABaseController {

    @Resource
    private DataRsmPatrolPointService dataRsmPatrolPointService;

    @RequestMapping("/loadDataList")
    public ResponseVO loadDataList(RsmPatrolPointQuery query) {
        return getSuccessResponseVO(dataRsmPatrolPointService.findListByPage(query));
    }

    /**
     * 新增
     */
    @RequestMapping("/add")
    public ResponseVO add(RsmPatrolPoint bean) {
        Integer result = this.dataRsmPatrolPointService.add(bean);
        return getSuccessResponseVO(null);
    }

    /**
     * 批量新增
     */
    @RequestMapping("/addBatch")
    public ResponseVO addBatch(@RequestBody List<RsmPatrolPoint> listBean) {
        this.dataRsmPatrolPointService.addBatch(listBean);
        return getSuccessResponseVO(null);
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("/addOrUpdateBatch")
    public ResponseVO addOrUpdateBatch(@RequestBody List<RsmPatrolPoint> listBean) {
        this.dataRsmPatrolPointService.addOrUpdateBatch(listBean);
        return getSuccessResponseVO(null);
    }

    /**
     * 根据 Id 查询
     */
    @RequestMapping("/getRsmPatrolPointById")
    public ResponseVO getRsmPatrolPointById(Long id) {
        return getSuccessResponseVO(dataRsmPatrolPointService.getRsmPatrolPointById(id));
    }

    /**
     * 根据 Id 更新
     */
    @RequestMapping("/updateRsmPatrolPointById")
    public ResponseVO updateRsmPatrolPointById(RsmPatrolPoint bean, Long id) {
        this.dataRsmPatrolPointService.updateRsmPatrolPointById(bean, id);
        return getSuccessResponseVO(null);
    }

    /**
     * 根据 Id 删除
     */
    @RequestMapping("/deleteRsmPatrolPointById")
    public ResponseVO deleteRsmPatrolPointById(Long id) {
        this.dataRsmPatrolPointService.deleteRsmPatrolPointById(id);
        return getSuccessResponseVO(null);
    }

    /**
     * 按巡查点统计待查项隐患发现频率
     */
    @RequestMapping("/getPatrolNameFrequency")
    public ResponseVO getPatrolNameFrequency() {
        List<PatrolNameFrequencyVO> list = this.dataRsmPatrolPointService.getPatrolNameFrequency();
        return getSuccessResponseVO(list);
    }

    /**
     * 获取高频巡查点TOP5（按巡查次数）
     */
    @RequestMapping("/getTopPatrolPointsByFrequency")
    public ResponseVO getTopPatrolPointsByFrequency() {
        List<PatrolPointTop5VO> list = this.dataRsmPatrolPointService.getTopPatrolPointsByFrequency();
        return getSuccessResponseVO(list);
    }
}