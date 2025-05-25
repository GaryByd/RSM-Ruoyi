package com.rsm.controller;


import com.rsm.entity.dao.RsmPatrolListQuery;
import com.rsm.entity.po.RsmPatrolList;
import com.rsm.entity.vo.ResponseVO;
import com.rsm.service.DataRsmPatrolListService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description: 巡查清单表 Controller
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
@RestController
@RequestMapping("/data/rsmPatrolList")
public class DataRsmPatrolListController extends ABaseController{

	@Resource
	private DataRsmPatrolListService dataRsmPatrolListService;

	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(RsmPatrolListQuery query) {
		return getSuccessResponseVO(dataRsmPatrolListService.findListByPage(query));
	}

	/**
 	 * 新增
 	 */
	@RequestMapping("/add")
	public ResponseVO add(RsmPatrolList bean) {
		Integer result = this.dataRsmPatrolListService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增
 	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<RsmPatrolList> listBean) {
		this.dataRsmPatrolListService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增或修改
 	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<RsmPatrolList> listBean) {
		this.dataRsmPatrolListService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@RequestMapping("/getRsmPatrolListById")
	public ResponseVO getRsmPatrolListById(Long id) {
		return getSuccessResponseVO(dataRsmPatrolListService.getRsmPatrolListById(id));}

	/**
 	 * 根据 Id 更新
 	 */
	@RequestMapping("/updateRsmPatrolListById")
	public ResponseVO updateRsmPatrolListById(RsmPatrolList bean, Long id) {
		this.dataRsmPatrolListService.updateRsmPatrolListById(bean, id);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 Id 删除
 	 */
	@RequestMapping("/deleteRsmPatrolListById")
	public ResponseVO deleteRsmPatrolListById(Long id) {
		this.dataRsmPatrolListService.deleteRsmPatrolListById(id);
		return getSuccessResponseVO(null);
}
	/**
	 * 查询正在巡查的数量
	 */
	@RequestMapping("/getPatrollingCount")
	public ResponseVO getPatrollingCount() {
		return getSuccessResponseVO(this.dataRsmPatrolListService.getPatrollingCount());
	}

	/**
	 * 巡查清单发现隐患比例（发现隐患数量/检查总数）
	 */
	@RequestMapping("/getFoundRate")
	public ResponseVO getFoundRate() {
		return getSuccessResponseVO(this.dataRsmPatrolListService.getFoundRate());
	}

	/**
	 * 获取历史巡查完成率
	 */
	@RequestMapping("/getCompletionRate")
	public ResponseVO getCompletionRate() {
		return getSuccessResponseVO(this.dataRsmPatrolListService.getCompletionRate());
	}
}
