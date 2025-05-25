package com.rsm.service.impl;


import com.rsm.entity.dao.RsmUnverifiedRiskQuery;
import com.rsm.entity.dao.SimplePage;
import com.rsm.entity.po.RsmUnverifiedRisk;
import com.rsm.entity.vo.HazardDiscoveryRateVO;
import com.rsm.entity.vo.PaginationResultVO;
import com.rsm.entity.vo.UnverifiedRiskCountByMonthVO;
import com.rsm.enums.PageSize;
import com.rsm.mapper.DataRsmUnverifiedRiskMapper;
import com.rsm.service.DataRsmUnverifiedRiskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description: 风险待查项表 业务接口实现
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
@Service("RsmUnverifiedRiskMapper")
public class DataRsmUnverifiedRiskServiceImpl implements DataRsmUnverifiedRiskService {

	@Resource
	private DataRsmUnverifiedRiskMapper<RsmUnverifiedRisk, RsmUnverifiedRiskQuery> dataRsmUnverifiedRiskMapper;

	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<RsmUnverifiedRisk> findListByParam(RsmUnverifiedRiskQuery query) {
		return this.dataRsmUnverifiedRiskMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(RsmUnverifiedRiskQuery query) {
		return this.dataRsmUnverifiedRiskMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<RsmUnverifiedRisk> findListByPage(RsmUnverifiedRiskQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<RsmUnverifiedRisk> list = this.findListByParam(query);
		PaginationResultVO<RsmUnverifiedRisk> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(RsmUnverifiedRisk bean) {
		return this.dataRsmUnverifiedRiskMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<RsmUnverifiedRisk> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.dataRsmUnverifiedRiskMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<RsmUnverifiedRisk> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.dataRsmUnverifiedRiskMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@Override
	public RsmUnverifiedRisk getRsmUnverifiedRiskById(Long id) {
		return this.dataRsmUnverifiedRiskMapper.selectById(id);}

	/**
 	 * 根据 Id 更新
 	 */
	@Override
	public Integer updateRsmUnverifiedRiskById(RsmUnverifiedRisk bean, Long id) {
		return this.dataRsmUnverifiedRiskMapper.updateById(bean, id);}

	/**
 	 * 根据 Id 删除
 	 */
	@Override
	public Integer deleteRsmUnverifiedRiskById(Long id) {
		return this.dataRsmUnverifiedRiskMapper.deleteById(id);}

	@Override
	public List<UnverifiedRiskCountByMonthVO> getUnverifiedRiskCountByMonth() {
		return this.dataRsmUnverifiedRiskMapper.selectUnverifiedRiskCountByMonth();
	}

	/**
	 * 获取待查项发现隐患率
	 */
	@Override
	public HazardDiscoveryRateVO getHazardDiscoveryRate() {
		return this.dataRsmUnverifiedRiskMapper.selectHazardDiscoveryRate();
	}
}