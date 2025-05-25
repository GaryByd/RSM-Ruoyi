package com.rc.rsm.service;

import java.util.List;
import com.rc.rsm.domain.po.RsmSnapshot;

/**
 * 随手拍问题Service接口
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
public interface IRsmSnapshotService 
{
    /**
     * 查询随手拍问题
     * 
     * @param id 随手拍问题主键
     * @return 随手拍问题
     */
    public RsmSnapshot selectRsmSnapshotById(Long id);

    /**
     * 查询随手拍问题列表
     * 
     * @param rsmSnapshot 随手拍问题
     * @return 随手拍问题集合
     */
    public List<RsmSnapshot> selectRsmSnapshotList(RsmSnapshot rsmSnapshot);

    /**
     * 新增随手拍问题
     * 
     * @param rsmSnapshot 随手拍问题
     * @return 结果
     */
    public int insertRsmSnapshot(RsmSnapshot rsmSnapshot);

    /**
     * 修改随手拍问题
     * 
     * @param rsmSnapshot 随手拍问题
     * @return 结果
     */
    public int updateRsmSnapshot(RsmSnapshot rsmSnapshot);

    /**
     * 批量删除随手拍问题
     * 
     * @param ids 需要删除的随手拍问题主键集合
     * @return 结果
     */
    public int deleteRsmSnapshotByIds(Long[] ids);

    /**
     * 删除随手拍问题信息
     * 
     * @param id 随手拍问题主键
     * @return 结果
     */
    public int deleteRsmSnapshotById(Long id);

    List<RsmSnapshot> selectRsmAllSnapshot(RsmSnapshot rsmSnapshot);
}
