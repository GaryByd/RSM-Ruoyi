package com.rc.rsm.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.rc.rsm.domain.po.RsmPatrolList;
import com.rc.rsm.service.IRsmPatrolListService;
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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 巡查清单Controller
 * 
 * @author ruoyi
 * @date 2024-09-10
 */
@RestController
@RequestMapping("/rsm/patrol/list")
public class RsmPatrolListController extends BaseController
{
    @Autowired
    private IRsmPatrolListService rsmPatrolListService;
    @Resource
    private RedisCache redisCache;
    /**
     * 查询巡查清单列表
     */
    @PreAuthorize("@ss.hasPermi('patrol:patrolRecord:list') || @ss.hasPermi('patrol:patrolRecord:look')")
    @GetMapping("/list")
    public TableDataInfo list(RsmPatrolList rsmPatrolList)
    {
        startPage();
        System.out.println();
        List<RsmPatrolList> list = rsmPatrolListService.selectRsmPatrolListList(rsmPatrolList);
        return getDataTable(list);
    }
    @PreAuthorize("@ss.hasPermi('patrol:patrolRecord:list') || @ss.hasPermi('patrol:patrolRecord:look')")
    @GetMapping("/all")
    public TableDataInfo all(RsmPatrolList rsmPatrolList)
    {
        List<RsmPatrolList> all = rsmPatrolListService.selectRsmAllPatrolList(rsmPatrolList);
        return getDataTable(all);
    }

    /**
     * 导出巡查清单列表
     */
    @PreAuthorize("@ss.hasPermi('rsm:patrol/list:export')")
    @Log(title = "巡查清单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RsmPatrolList rsmPatrolList)
    {
        List<RsmPatrolList> list = rsmPatrolListService.selectRsmPatrolListList(rsmPatrolList);
        ExcelUtil<RsmPatrolList> util = new ExcelUtil<RsmPatrolList>(RsmPatrolList.class);
        util.exportExcel(response, list, "巡查清单数据");
    }

    /**
     * 获取巡查清单详细信息
     */
    @PreAuthorize("@ss.hasPermi('patrol:patrolRecord:query') || @ss.hasPermi('patrol:patrolRecord:list')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rsmPatrolListService.selectRsmPatrolListById(id));
    }

    /**
     * 新增巡查清单
     */
    @PreAuthorize("@ss.hasPermi('rsm:patrolRecord:add')")
    @Log(title = "巡查清单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RsmPatrolList rsmPatrolList)
    {
        return null;
    }

    /**
     * 修改巡查清单
     */
    @PreAuthorize("@ss.hasPermi('rsm:patrol/list:edit')")
    @Log(title = "巡查清单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RsmPatrolList rsmPatrolList)
    {
        redisCache.deleteObject(RedisConstants.PATROL_LIST_KEY + rsmPatrolList.getId());
        return toAjax(rsmPatrolListService.updateRsmPatrolList(rsmPatrolList));
    }

    /**
     * 删除巡查清单
     */
    @PreAuthorize("@ss.hasPermi('patrol:patrolRecord:remove')")
    @Log(title = "巡查清单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        redisCache.deleteObject(RedisConstants.PATROL_LIST_KEY);
        return toAjax(rsmPatrolListService.deleteRsmPatrolListByIds(ids));
    }
}
