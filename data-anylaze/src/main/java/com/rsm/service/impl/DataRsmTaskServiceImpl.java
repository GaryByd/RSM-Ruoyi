package com.rsm.service.impl;


import com.rsm.entity.dao.RsmTaskQuery;
import com.rsm.entity.dao.SimplePage;
import com.rsm.entity.po.RsmTask;
import com.rsm.entity.vo.DeptTaskCountVO;
import com.rsm.entity.vo.PaginationResultVO;
import com.rsm.enums.PageSize;
import com.rsm.mapper.DataRsmTaskMapper;
import com.rsm.service.DataRsmTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description: 作业表 业务接口实现
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
@Service("RsmTaskMapper")
public class DataRsmTaskServiceImpl implements DataRsmTaskService {

	@Resource
	private DataRsmTaskMapper<RsmTask, RsmTaskQuery> dataRsmTaskMapper;

	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<RsmTask> findListByParam(RsmTaskQuery query) {
		return this.dataRsmTaskMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(RsmTaskQuery query) {
		return this.dataRsmTaskMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<RsmTask> findListByPage(RsmTaskQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<RsmTask> list = this.findListByParam(query);
		PaginationResultVO<RsmTask> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(RsmTask bean) {
		return this.dataRsmTaskMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<RsmTask> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.dataRsmTaskMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<RsmTask> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.dataRsmTaskMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@Override
	public RsmTask getRsmTaskById(Long id) {
		return this.dataRsmTaskMapper.selectById(id);}

	/**
 	 * 根据 Id 更新
 	 */
	@Override
	public Integer updateRsmTaskById(RsmTask bean, Long id) {
		return this.dataRsmTaskMapper.updateById(bean, id);}

	/**
 	 * 根据 Id 删除
 	 */
	@Override
	public Integer deleteRsmTaskById(Long id) {
		return this.dataRsmTaskMapper.deleteById(id);}

	/**
	 * 获取各部门作业数量统计
	 */
	@Override
	public List<DeptTaskCountVO> getTaskCountByDept() {
		return this.dataRsmTaskMapper.selectTaskCountByDept();
	}
}
