package com.rsm.service.impl;


import com.rsm.entity.dao.RsmSnapshotQuery;
import com.rsm.entity.dao.SimplePage;
import com.rsm.entity.po.RsmSnapshot;
import com.rsm.entity.vo.HazardRecognitionRateVO;
import com.rsm.entity.vo.PaginationResultVO;
import com.rsm.entity.vo.PropertyPercentageVO;
import com.rsm.entity.vo.UserUploadRankingVO;
import com.rsm.enums.PageSize;
import com.rsm.mapper.DataRsmSnapshotMapper;
import com.rsm.service.DataRsmSnapshotService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description: 随手拍问题表 业务接口实现
 * @Author: false
 * @Date: 2025/04/26 11:02:51
 */
@Service("RsmSnapshotMapper")
public class DataRsmSnapshotServiceImpl implements DataRsmSnapshotService {

	@Resource
	private DataRsmSnapshotMapper<RsmSnapshot, RsmSnapshotQuery> dataRsmSnapshotMapper;

	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<RsmSnapshot> findListByParam(RsmSnapshotQuery query) {
		return this.dataRsmSnapshotMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(RsmSnapshotQuery query) {
		return this.dataRsmSnapshotMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<RsmSnapshot> findListByPage(RsmSnapshotQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<RsmSnapshot> list = this.findListByParam(query);
		PaginationResultVO<RsmSnapshot> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(RsmSnapshot bean) {
		return this.dataRsmSnapshotMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<RsmSnapshot> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.dataRsmSnapshotMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<RsmSnapshot> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.dataRsmSnapshotMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@Override
	public RsmSnapshot getRsmSnapshotById(Long id) {
		return this.dataRsmSnapshotMapper.selectById(id);}

	/**
 	 * 根据 Id 更新
 	 */
	@Override
	public Integer updateRsmSnapshotById(RsmSnapshot bean, Long id) {
		return this.dataRsmSnapshotMapper.updateById(bean, id);}

	/**
 	 * 根据 Id 删除
 	 */
	@Override
	public Integer deleteRsmSnapshotById(Long id) {
		return this.dataRsmSnapshotMapper.deleteById(id);}

	@Override
	public PropertyPercentageVO getPropertyPercentage() {
		return this.dataRsmSnapshotMapper.selectPropertyPercentage();
	}


	/**
	 * 获取隐患认定率
	 */
	@Override
	public HazardRecognitionRateVO getHazardRecognitionRate() {
		return this.dataRsmSnapshotMapper.selectHazardRecognitionRate();
	}

	/**
	 * 获取用户上传排名前5
	 */
	@Override
	public List<UserUploadRankingVO> getUserUploadRanking() {
		return this.dataRsmSnapshotMapper.selectUserUploadRanking();
	}
}