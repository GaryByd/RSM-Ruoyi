package com.rsm.service.impl;


import com.rsm.entity.dao.RsmPatrolListQuery;
import com.rsm.entity.dao.SimplePage;
import com.rsm.entity.po.RsmPatrolList;
import com.rsm.entity.vo.PaginationResultVO;
import com.rsm.enums.PageSize;
import com.rsm.mapper.DataRsmPatrolListMapper;
import com.rsm.service.DataRsmPatrolListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
 * @Description: 巡查清单表 业务接口实现
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
@Service("RsmPatrolListMapper")
public class DataRsmPatrolListServiceImpl implements DataRsmPatrolListService {

	@Resource
	private DataRsmPatrolListMapper<RsmPatrolList, RsmPatrolListQuery> dataRsmPatrolListMapper;

	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<RsmPatrolList> findListByParam(RsmPatrolListQuery query) {
		return this.dataRsmPatrolListMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(RsmPatrolListQuery query) {
		return this.dataRsmPatrolListMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<RsmPatrolList> findListByPage(RsmPatrolListQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<RsmPatrolList> list = this.findListByParam(query);
		PaginationResultVO<RsmPatrolList> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(RsmPatrolList bean) {
		return this.dataRsmPatrolListMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<RsmPatrolList> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.dataRsmPatrolListMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<RsmPatrolList> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.dataRsmPatrolListMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@Override
	public RsmPatrolList getRsmPatrolListById(Long id) {
		return this.dataRsmPatrolListMapper.selectById(id);}

	/**
 	 * 根据 Id 更新
 	 */
	@Override
	public Integer updateRsmPatrolListById(RsmPatrolList bean, Long id) {
		return this.dataRsmPatrolListMapper.updateById(bean, id);}

	/**
 	 * 根据 Id 删除
 	 */
	@Override
	public Integer deleteRsmPatrolListById(Long id) {
		return this.dataRsmPatrolListMapper.deleteById(id);}

	@Override
	public Integer getPatrollingCount(){
		RsmPatrolListQuery rsmPatrolListQuery = new RsmPatrolListQuery();
		rsmPatrolListQuery.setStatus(1);
		return this.dataRsmPatrolListMapper.selectCount(rsmPatrolListQuery);
	}

	@Override
	public Double getFoundRate() {
		return this.dataRsmPatrolListMapper.selectFoundRate();
	}

	@Override
	public Double getCompletionRate() {
		return this.dataRsmPatrolListMapper.selectCompletionRate();
	}

	@Override
	public List<Map<String, Object>> getTop5PatrolPoints() {
		return this.dataRsmPatrolListMapper.selectTop5PatrolPoints();
	}
}
