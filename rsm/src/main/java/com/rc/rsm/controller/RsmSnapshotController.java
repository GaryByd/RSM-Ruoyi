package com.rc.rsm.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.constant.RedisConstants;
import com.ruoyi.common.core.redis.RedisCache;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.rc.rsm.domain.po.RsmSnapshot;
import com.rc.rsm.service.IRsmSnapshotService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 随手拍问题Controller
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
@RestController
@RequestMapping("/rsm/snapshot")
public class RsmSnapshotController extends BaseController
{
    @Autowired
    private IRsmSnapshotService rsmSnapshotService;
    @Resource
    private RedisCache redisCache;
    /**
     * 查询随手拍问题列表
     */
    @PreAuthorize("@ss.hasPermi('snapshot:snapshotSta:list') || @ss.hasPermi('snapshot:snapshotExamine:list') || @ss.hasPermi('snapshot:snapshotExamine:query')")
    @GetMapping("/list")
    public TableDataInfo list(RsmSnapshot rsmSnapshot)
    {
        startPage();
        List<RsmSnapshot> list = rsmSnapshotService.selectRsmSnapshotList(rsmSnapshot);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('snapshot:snapshotSta:list') || @ss.hasPermi('snapshot:snapshotExamine:list') || @ss.hasPermi('snapshot:snapshotExamine:query')")
    @GetMapping("/all")
    public TableDataInfo all(RsmSnapshot rsmSnapshot)
    {
        List<RsmSnapshot> all = rsmSnapshotService.selectRsmAllSnapshot(rsmSnapshot);
        return getDataTable(all);
    }

    /**
     * 导出随手拍问题列表
     */
    @PreAuthorize("@ss.hasPermi('snapshot:snapshotSta:export')")
    @Log(title = "随手拍问题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RsmSnapshot rsmSnapshot)
    {
        List<RsmSnapshot> list = rsmSnapshotService.selectRsmSnapshotList(rsmSnapshot);
        ExcelUtil<RsmSnapshot> util = new ExcelUtil<RsmSnapshot>(RsmSnapshot.class);
        util.exportExcel(response, list, "随手拍问题数据");
    }

    /**
     * 获取随手拍问题详细信息
     */
    @PreAuthorize("@ss.hasPermi('snapshot:snapshotExamine:query') || @ss.hasPermi('snapshot:snapshotExamine:snapshotmore')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rsmSnapshotService.selectRsmSnapshotById(id));
    }

    /**
     * 新增随手拍问题
     */
    @PreAuthorize("@ss.hasPermi('snapshot:snapshotExamine:add')")
    @Log(title = "随手拍问题", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RsmSnapshot rsmSnapshot)
    {
        return toAjax(rsmSnapshotService.insertRsmSnapshot(rsmSnapshot));
    }

    /**
     * 修改随手拍问题
     */
    @PreAuthorize("@ss.hasPermi('snapshot:snapshotExamine:edit')")
    @Log(title = "随手拍问题", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RsmSnapshot rsmSnapshot)
    {
        redisCache.deleteObject(RedisConstants.SNAPSHOTS_KEY + rsmSnapshot.getId());
        return toAjax(rsmSnapshotService.updateRsmSnapshot(rsmSnapshot));
    }

    /**
     * 删除随手拍问题
     */
    @PreAuthorize("@ss.hasPermi('snapshot:snapshotExamine:remove')")
    @Log(title = "随手拍问题", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        redisCache.deleteObject(RedisConstants.SNAPSHOTS_KEY);
        return toAjax(rsmSnapshotService.deleteRsmSnapshotByIds(ids));
    }
}
