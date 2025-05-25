package com.rsm.service.impl;


import com.rsm.entity.dao.RsmHiddenTroubleQuery;
import com.rsm.entity.dao.SimplePage;
import com.rsm.entity.po.RsmHiddenTrouble;
import com.rsm.entity.vo.AvgRectifyTimeVO;
import com.rsm.entity.vo.ComprehensiveRiskIndexVO;
import com.rsm.entity.vo.DisposeStatusNumVO;
import com.rsm.entity.vo.HiddenTroubleSourceNumVO;
import com.rsm.entity.vo.PaginationResultVO;
import com.rsm.entity.vo.TroubleClassifyNumVO;
import com.rsm.enums.PageSize;
import com.rsm.mapper.DataRsmHiddenTroubleMapper;
import com.rsm.service.DataRsmHiddenTroubleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description: 隐患表 业务接口实现
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
@Service("RsmHiddenTroubleMapper")
public class DataRsmHiddenTroubleServiceImpl implements DataRsmHiddenTroubleService {

	@Resource
	private DataRsmHiddenTroubleMapper<RsmHiddenTrouble, RsmHiddenTroubleQuery> dataRsmHiddenTroubleMapper;

	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<RsmHiddenTrouble> findListByParam(RsmHiddenTroubleQuery query) {
		return this.dataRsmHiddenTroubleMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(RsmHiddenTroubleQuery query) {
		return this.dataRsmHiddenTroubleMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<RsmHiddenTrouble> findListByPage(RsmHiddenTroubleQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<RsmHiddenTrouble> list = this.findListByParam(query);
		PaginationResultVO<RsmHiddenTrouble> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(RsmHiddenTrouble bean) {
		return this.dataRsmHiddenTroubleMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<RsmHiddenTrouble> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.dataRsmHiddenTroubleMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<RsmHiddenTrouble> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.dataRsmHiddenTroubleMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@Override
	public RsmHiddenTrouble getRsmHiddenTroubleById(Long id) {
		return this.dataRsmHiddenTroubleMapper.selectById(id);}

	/**
 	 * 根据 Id 更新
 	 */
	@Override
	public Integer updateRsmHiddenTroubleById(RsmHiddenTrouble bean, Long id) {
		return this.dataRsmHiddenTroubleMapper.updateById(bean, id);}

	/**
 	 * 根据 Id 删除
 	 */
	@Override
	public Integer deleteRsmHiddenTroubleById(Long id) {
		return this.dataRsmHiddenTroubleMapper.deleteById(id);}

	@Override
	public List<DisposeStatusNumVO> getDisposeStatusNums() {
		return this.dataRsmHiddenTroubleMapper.selectDisposeStatusNums();
	}

	@Override
	public List<HiddenTroubleSourceNumVO> getHiddenTroubleSourceNums() {
		return this.dataRsmHiddenTroubleMapper.selectHiddenTroubleSourceNums();
	}

	@Override
	public ComprehensiveRiskIndexVO getComprehensiveRiskIndex() {
		return this.dataRsmHiddenTroubleMapper.selectComprehensiveRiskIndex();
	}

	@Override
	public Integer getHiddenTroubleCount() {
		return this.dataRsmHiddenTroubleMapper.selectHiddenTroubleCount();
	}

	@Override
	public List<TroubleClassifyNumVO> getTroubleClassifyNums() {
		return this.dataRsmHiddenTroubleMapper.selectTroubleClassifyNums();
	}

	@Override
	public AvgRectifyTimeVO getAvgRectifyTime() {
		return this.dataRsmHiddenTroubleMapper.selectAvgRectifyTime();
	}
}
