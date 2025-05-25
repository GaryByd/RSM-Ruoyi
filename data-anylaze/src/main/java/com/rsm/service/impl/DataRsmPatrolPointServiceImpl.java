package com.rsm.service.impl;


import com.rsm.entity.dao.RsmPatrolPointQuery;
import com.rsm.entity.dao.SimplePage;
import com.rsm.entity.po.RsmPatrolPoint;
import com.rsm.entity.vo.PaginationResultVO;
import com.rsm.entity.vo.PatrolNameFrequencyVO;
import com.rsm.entity.vo.PatrolPointTop5VO;
import com.rsm.enums.PageSize;
import com.rsm.mapper.DataRsmPatrolPointMapper;
import com.rsm.service.DataRsmPatrolPointService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description: 巡查点表 业务接口实现
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
@Service("RsmPatrolPointMapper")
public class DataRsmPatrolPointServiceImpl implements DataRsmPatrolPointService {

	@Resource
	private DataRsmPatrolPointMapper<RsmPatrolPoint, RsmPatrolPointQuery> dataRsmPatrolPointMapper;

	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<RsmPatrolPoint> findListByParam(RsmPatrolPointQuery query) {
		return this.dataRsmPatrolPointMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(RsmPatrolPointQuery query) {
		return this.dataRsmPatrolPointMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<RsmPatrolPoint> findListByPage(RsmPatrolPointQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<RsmPatrolPoint> list = this.findListByParam(query);
		PaginationResultVO<RsmPatrolPoint> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(RsmPatrolPoint bean) {
		return this.dataRsmPatrolPointMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<RsmPatrolPoint> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.dataRsmPatrolPointMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<RsmPatrolPoint> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.dataRsmPatrolPointMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@Override
	public RsmPatrolPoint getRsmPatrolPointById(Long id) {
		return this.dataRsmPatrolPointMapper.selectById(id);}

	/**
 	 * 根据 Id 更新
 	 */
	@Override
	public Integer updateRsmPatrolPointById(RsmPatrolPoint bean, Long id) {
		return this.dataRsmPatrolPointMapper.updateById(bean, id);}

	/**
 	 * 根据 Id 删除
 	 */
	@Override
	public Integer deleteRsmPatrolPointById(Long id) {
		return this.dataRsmPatrolPointMapper.deleteById(id);}

	@Override
	public List<PatrolNameFrequencyVO> getPatrolNameFrequency() {
		return this.dataRsmPatrolPointMapper.selectPatrolNameFrequency();
	}

	@Override
	public List<PatrolPointTop5VO> getTopPatrolPointsByFrequency() {
		return this.dataRsmPatrolPointMapper.selectTopPatrolPointsByFrequency();
	}
}