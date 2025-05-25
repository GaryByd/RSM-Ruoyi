package com.rsm.service.impl;


import com.rsm.entity.dao.RsmRiskQuery;
import com.rsm.entity.dao.SimplePage;
import com.rsm.entity.po.RsmRisk;
import com.rsm.entity.vo.MonthlyRiskCountVO;
import com.rsm.entity.vo.PaginationResultVO;
import com.rsm.entity.vo.RiskLevelCountVO;
import com.rsm.entity.vo.RiskMonthLevelCountVO;
import com.rsm.entity.vo.RiskTypeDistributionVO;
import com.rsm.enums.PageSize;
import com.rsm.mapper.DataRsmRiskMapper;
import com.rsm.service.DataRsmRiskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description: 风险库表 业务接口实现
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
@Service("RsmRiskMapper")
public class DataRsmRiskServiceImpl implements DataRsmRiskService {

	@Resource
	private DataRsmRiskMapper<RsmRisk, RsmRiskQuery> dataRsmRiskMapper;

	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<RsmRisk> findListByParam(RsmRiskQuery query) {
		return this.dataRsmRiskMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(RsmRiskQuery query) {
		return this.dataRsmRiskMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<RsmRisk> findListByPage(RsmRiskQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<RsmRisk> list = this.findListByParam(query);
		PaginationResultVO<RsmRisk> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(RsmRisk bean) {
		return this.dataRsmRiskMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<RsmRisk> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.dataRsmRiskMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<RsmRisk> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.dataRsmRiskMapper.insertOrUpdateBatch(listBean);
	}


	/**
 	 * 根据 Id 查询
 	 */
	@Override
	public RsmRisk getRsmRiskById(Long id) {
		return this.dataRsmRiskMapper.selectById(id);}

	/**
 	 * 根据 Id 更新
 	 */
	@Override
	public Integer updateRsmRiskById(RsmRisk bean, Long id) {
		return this.dataRsmRiskMapper.updateById(bean, id);}

	/**
 	 * 根据 Id 删除
 	 */
	@Override
	public Integer deleteRsmRiskById(Long id) {
		return this.dataRsmRiskMapper.deleteById(id);}

	@Override
	public List<RiskLevelCountVO> getRiskLevelCount() {
		return this.dataRsmRiskMapper.selectRiskLevelCount();
	}

	@Override
	public Integer getALevelUnprocessed() {
		return this.dataRsmRiskMapper.selectALevelUnprocessed();
	}

	@Override
	public List<RiskMonthLevelCountVO> getRecent6MonthLevel() {
		return this.dataRsmRiskMapper.selectRecent6MonthLevel();
	}
	@Override
	public List<RiskTypeDistributionVO> getRiskTypeDistribution() {
		return this.dataRsmRiskMapper.selectRiskTypeDistribution();
	}

	/**
	 * 获取每月新增风险数量趋势
	 */
	@Override
	public List<MonthlyRiskCountVO> getMonthlyRiskCount() {
		return this.dataRsmRiskMapper.selectMonthlyRiskCount();
	}

	/**
	 * 获取每月新发现作业风险数量
	 */
	@Override
	public List<MonthlyRiskCountVO> getMonthlyOperationRiskCount() {
		return this.dataRsmRiskMapper.selectMonthlyOperationRiskCount();
	}
}
