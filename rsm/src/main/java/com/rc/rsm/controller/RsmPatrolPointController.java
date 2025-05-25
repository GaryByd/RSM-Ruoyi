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
import com.rc.rsm.domain.po.RsmPatrolPoint;
import com.rc.rsm.service.IRsmPatrolPointService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 巡查点Controller
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
@RestController
@RequestMapping("/rsm/patrol/point")
public class RsmPatrolPointController extends BaseController
{
    @Autowired
    private IRsmPatrolPointService rsmPatrolPointService;
    @Resource
    private RedisCache redisCache;
    /**
     * 查询巡查点列表
     */
    @PreAuthorize("@ss.hasPermi('patrol:patrolPoint:list')")
    @GetMapping("/list")
    public TableDataInfo list(RsmPatrolPoint rsmPatrolPoint)
    {
        startPage();
        List<RsmPatrolPoint> list = rsmPatrolPointService.selectRsmPatrolPointList(rsmPatrolPoint);
        return getDataTable(list);
    }
    @PreAuthorize("@ss.hasPermi('rsm:point:list')")
    @GetMapping("/all")
    public TableDataInfo all(RsmPatrolPoint rsmPatrolPoint)
    {
        List<RsmPatrolPoint> all = rsmPatrolPointService.selectRsmAllPatrolPoint(rsmPatrolPoint);
        return getDataTable(all);
    }

    /**
     * 导出巡查点列表
     */
    @PreAuthorize("@ss.hasPermi('patrol:patrolPoint:export')")
    @Log(title = "巡查点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RsmPatrolPoint rsmPatrolPoint)
    {
        List<RsmPatrolPoint> list = rsmPatrolPointService.selectRsmPatrolPointList(rsmPatrolPoint);
        ExcelUtil<RsmPatrolPoint> util = new ExcelUtil<RsmPatrolPoint>(RsmPatrolPoint.class);
        util.exportExcel(response, list, "巡查点数据");
    }

    /**
     * 获取巡查点详细信息
     */
    @PreAuthorize("@ss.hasPermi('patrol:patrolPoint:query') || @ss.hasPermi('patrol:patrolPoint:more')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rsmPatrolPointService.selectRsmPatrolPointById(id));
    }

    /**
     * 新增巡查点
     */
    @PreAuthorize("@ss.hasPermi('patrol:patrolPoint:add')")
    @Log(title = "巡查点", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RsmPatrolPoint rsmPatrolPoint)
    {
        return toAjax(rsmPatrolPointService.insertRsmPatrolPoint(rsmPatrolPoint));
    }

    /**
     * 修改巡查点
     */
    @PreAuthorize("@ss.hasPermi('patrol:patrolPoint:edit')")
    @Log(title = "巡查点", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RsmPatrolPoint rsmPatrolPoint)
    {
        redisCache.deleteObject(RedisConstants.PATROL_POINT_KEY + rsmPatrolPoint.getId());
        return toAjax(rsmPatrolPointService.updateRsmPatrolPoint(rsmPatrolPoint));
    }

    /**
     * 删除巡查点
     */
    @PreAuthorize("@ss.hasPermi('patrol:patrolPoint:remove')")
    @Log(title = "巡查点", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        redisCache.deleteObject(RedisConstants.PATROL_POINT_KEY);
        return toAjax(rsmPatrolPointService.deleteRsmPatrolPointByIds(ids));
    }
}
