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
import com.rc.rsm.domain.po.RsmHiddenTrouble;
import com.rc.rsm.service.IRsmHiddenTroubleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 隐患Controller
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
@RestController
@RequestMapping("/rsm/trouble")
public class RsmHiddenTroubleController extends BaseController
{
    @Autowired
    private IRsmHiddenTroubleService rsmHiddenTroubleService;
    @Resource
    private RedisCache redisCache;
    /**
     * 查询隐患列表
     */
    @PreAuthorize("@ss.hasPermi('danger:dangerSta:list') || @ss.hasPermi('danger:dangerHandle:list')")
    @GetMapping("/list")
    public TableDataInfo list(RsmHiddenTrouble rsmHiddenTrouble)
    {
        startPage();
        List<RsmHiddenTrouble> list = rsmHiddenTroubleService.selectRsmHiddenTroubleList(rsmHiddenTrouble);
        return getDataTable(list);
    }
    @PreAuthorize("@ss.hasPermi('danger:dangerSta:list')")
    @GetMapping("/all")
    public TableDataInfo all(RsmHiddenTrouble rsmHiddenTrouble)
    {
        List<RsmHiddenTrouble> all = rsmHiddenTroubleService.selectRsmAllHiddenTrouble(rsmHiddenTrouble);
        return getDataTable(all);
    }

    /**
     * 导出隐患列表
     */
    @PreAuthorize("@ss.hasPermi('danger:dangerHandle:export')")
    @Log(title = "隐患", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RsmHiddenTrouble rsmHiddenTrouble)
    {
        List<RsmHiddenTrouble> list = rsmHiddenTroubleService.selectRsmHiddenTroubleList(rsmHiddenTrouble);
        ExcelUtil<RsmHiddenTrouble> util = new ExcelUtil<RsmHiddenTrouble>(RsmHiddenTrouble.class);
        util.exportExcel(response, list, "隐患数据");
    }

    /**
     * 获取隐患详细信息
     */
    @PreAuthorize("@ss.hasPermi('risk:riskLibrary:query') || @ss.hasPermi('danger:dangerHandle:dangermore') || @ss.hasPermi('danger:dangerHandle:dangerhandleresult')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rsmHiddenTroubleService.selectRsmHiddenTroubleById(id));
    }

    /**
     * 新增隐患
     */
    @PreAuthorize("@ss.hasPermi('danger:dangerHandle:add')")
    @Log(title = "隐患", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RsmHiddenTrouble rsmHiddenTrouble)
    {
        return toAjax(rsmHiddenTroubleService.insertRsmHiddenTrouble(rsmHiddenTrouble));
    }

    /**
     * 修改隐患
     */
    @PreAuthorize("@ss.hasPermi('danger:dangerHandle:edit')")
    @Log(title = "隐患", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RsmHiddenTrouble rsmHiddenTrouble)
    {
        redisCache.deleteObject(RedisConstants.HIDDEN_TROUBLE_KEY + rsmHiddenTrouble.getId());
        return toAjax(rsmHiddenTroubleService.updateRsmHiddenTrouble(rsmHiddenTrouble));
    }

    /**
     * 删除隐患
     */
    @PreAuthorize("@ss.hasPermi('danger:dangerHandle:remove')")
    @Log(title = "隐患", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        redisCache.deleteObject(RedisConstants.HIDDEN_TROUBLE_KEY);
        return toAjax(rsmHiddenTroubleService.deleteRsmHiddenTroubleByIds(ids));
    }

    @GetMapping("/countByMonth")
    public AjaxResult countByMonth()
    {
        return success(rsmHiddenTroubleService.countByMonth());
    }

    @GetMapping("/countByWeek")
    public AjaxResult countByWeek()
    {return success(rsmHiddenTroubleService.countByWeek());}
}
