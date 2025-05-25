package com.rsm.controller;


import com.rsm.entity.dao.RsmHiddenTroubleQuery;
import com.rsm.entity.po.RsmHiddenTrouble;
import com.rsm.entity.vo.AvgRectifyTimeVO;
import com.rsm.entity.vo.ComprehensiveRiskIndexVO;
import com.rsm.entity.vo.DisposeStatusNumVO;
import com.rsm.entity.vo.HiddenTroubleSourceNumVO;
import com.rsm.entity.vo.ResponseVO;
import com.rsm.entity.vo.TroubleClassifyNumVO;
import com.rsm.service.DataRsmHiddenTroubleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description: 隐患表 Controller
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
@RestController
@RequestMapping("/data/rsmHiddenTrouble")
public class DataRsmHiddenTroubleController extends ABaseController {

	@Resource
	private DataRsmHiddenTroubleService dataRsmHiddenTroubleService;

	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(RsmHiddenTroubleQuery query) {
		return getSuccessResponseVO(dataRsmHiddenTroubleService.findListByPage(query));
	}

	/**
 	 * 新增
 	 */
	@RequestMapping("/add")
	public ResponseVO add(RsmHiddenTrouble bean) {
		Integer result = this.dataRsmHiddenTroubleService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增
 	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<RsmHiddenTrouble> listBean) {
		this.dataRsmHiddenTroubleService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增或修改
 	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<RsmHiddenTrouble> listBean) {
		this.dataRsmHiddenTroubleService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@RequestMapping("/getRsmHiddenTroubleById")
	public ResponseVO getRsmHiddenTroubleById(Long id) {
		return getSuccessResponseVO(dataRsmHiddenTroubleService.getRsmHiddenTroubleById(id));}

	/**
 	 * 根据 Id 更新
 	 */
	@RequestMapping("/updateRsmHiddenTroubleById")
	public ResponseVO updateRsmHiddenTroubleById(RsmHiddenTrouble bean, Long id) {
		this.dataRsmHiddenTroubleService.updateRsmHiddenTroubleById(bean, id);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 Id 删除
 	 */
	@RequestMapping("/deleteRsmHiddenTroubleById")
	public ResponseVO deleteRsmHiddenTroubleById(Long id) {
		this.dataRsmHiddenTroubleService.deleteRsmHiddenTroubleById(id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 查询处理和未处理的数量
	 */
	@RequestMapping("/getDisposeStatusNums")
	public ResponseVO getDisposeStatusNums() {
		List<DisposeStatusNumVO> list = this.dataRsmHiddenTroubleService.getDisposeStatusNums();
		return getSuccessResponseVO(list);
	}
	/**
	 * 查询隐患来源数量
	 */
	@RequestMapping("/getHiddenTroubleSourceNums")
	public ResponseVO getHiddenTroubleSourceNums() {
		List<HiddenTroubleSourceNumVO> list = this.dataRsmHiddenTroubleService.getHiddenTroubleSourceNums();
		return getSuccessResponseVO(list);
	}

	/**
	 * 综合风险指数简单评分
	 */
	@RequestMapping("/getComprehensiveRiskIndex")
	public ResponseVO getComprehensiveRiskIndex() {
		ComprehensiveRiskIndexVO comprehensiveRiskIndexVO = this.dataRsmHiddenTroubleService.getComprehensiveRiskIndex();
		return getSuccessResponseVO(comprehensiveRiskIndexVO);
	}


	// 总患者数量统计
	@RequestMapping("/getHiddenTroubleCount")
	public ResponseVO getHiddenTroubleCount() {
		return getSuccessResponseVO(this.dataRsmHiddenTroubleService.getHiddenTroubleCount());
	}

	/**
	 * 查询隐患分类分布数量
	 */
	@RequestMapping("/getTroubleClassifyNums")
	public ResponseVO getTroubleClassifyNums() {
		List<TroubleClassifyNumVO> list = this.dataRsmHiddenTroubleService.getTroubleClassifyNums();
		return getSuccessResponseVO(list);
	}

	/**
	 * 获取隐患平均整改时间统计
	 */
	@RequestMapping("/getAvgRectifyTime")
	public ResponseVO getAvgRectifyTime() {
		AvgRectifyTimeVO avgRectifyTimeVO = this.dataRsmHiddenTroubleService.getAvgRectifyTime();
		return getSuccessResponseVO(avgRectifyTimeVO);
	}
}
