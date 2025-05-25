package com.rsm.controller;


import com.rsm.entity.dao.RsmTaskQuery;
import com.rsm.entity.po.RsmTask;
import com.rsm.entity.vo.DeptTaskCountVO;
import com.rsm.entity.vo.ResponseVO;
import com.rsm.service.DataRsmTaskService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description: 作业表 Controller
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
@RestController
@RequestMapping("/data/rsmTask")
public class DataRsmTaskController extends ABaseController{

	@Resource
	private DataRsmTaskService dataRsmTaskService;

	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(RsmTaskQuery query) {
		return getSuccessResponseVO(dataRsmTaskService.findListByPage(query));
	}

	/**
 	 * 新增
 	 */
	@RequestMapping("/add")
	public ResponseVO add(RsmTask bean) {
		Integer result = this.dataRsmTaskService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增
 	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<RsmTask> listBean) {
		this.dataRsmTaskService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增或修改
 	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<RsmTask> listBean) {
		this.dataRsmTaskService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@RequestMapping("/getRsmTaskById")
	public ResponseVO getRsmTaskById(Long id) {
		return getSuccessResponseVO(dataRsmTaskService.getRsmTaskById(id));}

	/**
 	 * 根据 Id 更新
 	 */
	@RequestMapping("/updateRsmTaskById")
	public ResponseVO updateRsmTaskById(RsmTask bean, Long id) {
		this.dataRsmTaskService.updateRsmTaskById(bean, id);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 Id 删除
 	 */
	@RequestMapping("/deleteRsmTaskById")
	public ResponseVO deleteRsmTaskById(Long id) {
		this.dataRsmTaskService.deleteRsmTaskById(id);
		return getSuccessResponseVO(null);
}

	/**
	 * 各部门作业数量统计
	 */
	@RequestMapping("/getTaskCountByDept")
	public ResponseVO getTaskCountByDept() {
		List<DeptTaskCountVO> list = this.dataRsmTaskService.getTaskCountByDept();
		return getSuccessResponseVO(list);
	}
}
