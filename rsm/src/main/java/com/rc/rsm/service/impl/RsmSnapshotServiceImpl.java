package com.rc.rsm.service.impl;

import java.util.Arrays;
import java.util.List;

import com.ruoyi.common.utils.AliOssUtil;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rc.rsm.mapper.RsmSnapshotMapper;
import com.rc.rsm.domain.po.RsmSnapshot;
import com.rc.rsm.service.IRsmSnapshotService;

/**
 * 随手拍问题Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
@Service
public class RsmSnapshotServiceImpl implements IRsmSnapshotService 
{
    @Autowired
    private RsmSnapshotMapper rsmSnapshotMapper;

    /**
     * 查询随手拍问题
     * 
     * @param id 随手拍问题主键
     * @return 随手拍问题
     */
    @Override
    public RsmSnapshot selectRsmSnapshotById(Long id)
    {
        return rsmSnapshotMapper.selectRsmSnapshotById(id);
    }

    /**
     * 查询随手拍问题列表
     * 
     * @param rsmSnapshot 随手拍问题
     * @return 随手拍问题
     */
    @Override
    public List<RsmSnapshot> selectRsmSnapshotList(RsmSnapshot rsmSnapshot)
    {
        return rsmSnapshotMapper.selectRsmSnapshotList(rsmSnapshot);
    }

    /**
     * 新增随手拍问题
     * 
     * @param rsmSnapshot 随手拍问题
     * @return 结果
     */
    @Override
    public int insertRsmSnapshot(RsmSnapshot rsmSnapshot)
    {
        rsmSnapshot.setCreateTime(DateUtils.getNowDate());
        return rsmSnapshotMapper.insertRsmSnapshot(rsmSnapshot);
    }

    /**
     * 修改随手拍问题
     * 
     * @param rsmSnapshot 随手拍问题
     * @return 结果
     */
    @Override
    public int updateRsmSnapshot(RsmSnapshot rsmSnapshot)
    {
        //查询rsm
        RsmSnapshot oldRsmSnapshot = rsmSnapshotMapper.selectRsmSnapshotById(rsmSnapshot.getId());
        if (oldRsmSnapshot==null) {
            return 0;
        }
        //获取旧数据中的url
        String imgPath = oldRsmSnapshot.getImgPath();
        //处理Url以逗号分割进入列表
        String[] imgPaths = imgPath.split(",");
        //再开一个线程用于删除imgPaths
        new Thread(() -> {
            Arrays.stream(imgPaths).forEach(path -> {
                //删除图片
                try {
                    AliOssUtil.deleteFile(path);
                    System.out.println("已经删除:"+path);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }).start();
        rsmSnapshot.setUpdateTime(DateUtils.getNowDate());
        return rsmSnapshotMapper.updateRsmSnapshot(rsmSnapshot);
    }

    /**
     * 批量删除随手拍问题
     * 
     * @param ids 需要删除的随手拍问题主键
     * @return 结果
     */
    @Override
    public int deleteRsmSnapshotByIds(Long[] ids)
    {
        return rsmSnapshotMapper.deleteRsmSnapshotByIds(ids);
    }

    /**
     * 删除随手拍问题信息
     * 
     * @param id 随手拍问题主键
     * @return 结果
     */
    @Override
    public int deleteRsmSnapshotById(Long id)
    {
        return rsmSnapshotMapper.deleteRsmSnapshotById(id);
    }

    @Override
    public List<RsmSnapshot> selectRsmAllSnapshot(RsmSnapshot rsmSnapshot) {
        return rsmSnapshotMapper.selectRsmAllSnapshot(rsmSnapshot);
    }
}
