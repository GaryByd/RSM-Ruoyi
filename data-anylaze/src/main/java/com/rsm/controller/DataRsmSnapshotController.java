package com.rsm.controller;


import com.rsm.entity.dao.RsmSnapshotQuery;
import com.rsm.entity.po.RsmSnapshot;
import com.rsm.entity.vo.HazardRecognitionRateVO;
import com.rsm.entity.vo.PropertyPercentageVO;
import com.rsm.entity.vo.ResponseVO;
import com.rsm.entity.vo.UserUploadRankingVO;
import com.rsm.service.DataRsmSnapshotService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 随手拍问题表 Controller
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
@RestController
@RequestMapping("/data/rsmSnapshot")
public class DataRsmSnapshotController extends ABaseController {

    @Resource
    private DataRsmSnapshotService dataRsmSnapshotService;

    @RequestMapping("/loadDataList")
    public ResponseVO loadDataList(RsmSnapshotQuery query) {
        return getSuccessResponseVO(dataRsmSnapshotService.findListByPage(query));
    }

    /**
     * 新增
     */
    @RequestMapping("/add")
    public ResponseVO add(RsmSnapshot bean) {
        Integer result = this.dataRsmSnapshotService.add(bean);
        return getSuccessResponseVO(null);
    }

    /**
     * 批量新增
     */
    @RequestMapping("/addBatch")
    public ResponseVO addBatch(@RequestBody List<RsmSnapshot> listBean) {
        this.dataRsmSnapshotService.addBatch(listBean);
        return getSuccessResponseVO(null);
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("/addOrUpdateBatch")
    public ResponseVO addOrUpdateBatch(@RequestBody List<RsmSnapshot> listBean) {
        this.dataRsmSnapshotService.addOrUpdateBatch(listBean);
        return getSuccessResponseVO(null);
    }

    /**
     * 根据 Id 查询
     */
    @RequestMapping("/getRsmSnapshotById")
    public ResponseVO getRsmSnapshotById(Long id) {
        return getSuccessResponseVO(dataRsmSnapshotService.getRsmSnapshotById(id));
    }

    /**
     * 根据 Id 更新
     */
    @RequestMapping("/updateRsmSnapshotById")
    public ResponseVO updateRsmSnapshotById(RsmSnapshot bean, Long id) {
        this.dataRsmSnapshotService.updateRsmSnapshotById(bean, id);
        return getSuccessResponseVO(null);
    }

    /**
     * 根据 Id 删除
     */
    @RequestMapping("/deleteRsmSnapshotById")
    public ResponseVO deleteRsmSnapshotById(Long id) {
        this.dataRsmSnapshotService.deleteRsmSnapshotById(id);
        return getSuccessResponseVO(null);
    }

    /**
     * 随手拍事件审核通过率：
     */
    @RequestMapping("/getPropertyPercentage")
    public ResponseVO getPropertyPercentage() {
        PropertyPercentageVO propertyPercentageVO = this.dataRsmSnapshotService.getPropertyPercentage();
        return getSuccessResponseVO(propertyPercentageVO);
    }

    /**
     * 隐患认定率
     */
    @RequestMapping("/getHazardRecognitionRate")
    public ResponseVO getHazardRecognitionRate() {
        HazardRecognitionRateVO hazardRateVO = this.dataRsmSnapshotService.getHazardRecognitionRate();
        return getSuccessResponseVO(hazardRateVO);
    }

    /**
     * 用户上传排名前5
     */
    @RequestMapping("/getUserUploadRanking")
    public ResponseVO getUserUploadRanking() {
        List<UserUploadRankingVO> list = this.dataRsmSnapshotService.getUserUploadRanking();
        return getSuccessResponseVO(list);
    }
}