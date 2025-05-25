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
import com.rc.rsm.domain.po.RsmUnverifiedRisk;
import com.rc.rsm.service.IRsmUnverifiedRiskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 风险待查项Controller
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
@RestController
@RequestMapping("/rsm/unverified/risk")
public class RsmUnverifiedRiskController extends BaseController
{
    @Autowired
    private IRsmUnverifiedRiskService rsmUnverifiedRiskService;

    @Resource
    private RedisCache redisCache;

    /**
     * 查询风险待查项列表
     */
    @PreAuthorize("@ss.hasPermi('risk:riskPend:list')")
    @GetMapping("/list")
    public TableDataInfo list(RsmUnverifiedRisk rsmUnverifiedRisk)
    {
        startPage();
        List<RsmUnverifiedRisk> list = rsmUnverifiedRiskService.selectRsmUnverifiedRiskList(rsmUnverifiedRisk);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('risk:riskPend:list')")
    @GetMapping("/all")
    public TableDataInfo all(RsmUnverifiedRisk rsmUnverifiedRisk)
    {
        List<RsmUnverifiedRisk> all = rsmUnverifiedRiskService.selectRsmAllUnverifiedRisk(rsmUnverifiedRisk);
        return getDataTable(all);
    }

    /**
     * 导出风险待查项列表
     */
    @PreAuthorize("@ss.hasPermi('risk:riskPend:export')")
    @Log(title = "风险待查项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RsmUnverifiedRisk rsmUnverifiedRisk)
    {
        List<RsmUnverifiedRisk> list = rsmUnverifiedRiskService.selectRsmUnverifiedRiskList(rsmUnverifiedRisk);
        ExcelUtil<RsmUnverifiedRisk> util = new ExcelUtil<RsmUnverifiedRisk>(RsmUnverifiedRisk.class);
        util.exportExcel(response, list, "风险待查项数据");
    }

    /**
     * 获取风险待查项详细信息
     */
    @PreAuthorize("@ss.hasPermi('risk:riskPend:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rsmUnverifiedRiskService.selectRsmUnverifiedRiskById(id));
    }

    /**
     * 新增风险待查项
     */
    @PreAuthorize("@ss.hasPermi('risk:riskPend:add')")
    @Log(title = "风险待查项", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RsmUnverifiedRisk rsmUnverifiedRisk)
    {
        return toAjax(rsmUnverifiedRiskService.insertRsmUnverifiedRisk(rsmUnverifiedRisk));
    }

    /**
     * 修改风险待查项
     */
    @PreAuthorize("@ss.hasPermi('risk:riskPend:edit')")
    @Log(title = "风险待查项", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RsmUnverifiedRisk rsmUnverifiedRisk)
    {
        redisCache.deleteObject(RedisConstants.UNVERIFIED_RISK_KEY + rsmUnverifiedRisk.getId());
        return toAjax(rsmUnverifiedRiskService.updateRsmUnverifiedRisk(rsmUnverifiedRisk));
    }

    /**
     * 删除风险待查项
     */
    @PreAuthorize("@ss.hasPermi('risk:riskPend:remove')")
    @Log(title = "风险待查项", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        redisCache.deleteObject(RedisConstants.UNVERIFIED_RISK_KEY);
        return toAjax(rsmUnverifiedRiskService.deleteRsmUnverifiedRiskByIds(ids));
    }


	@GetMapping("/countByMonth")
    public AjaxResult countByMonth()
    {
        return success(rsmUnverifiedRiskService.countByMonth());
    }

    @GetMapping("/countByThisMonth")
    public AjaxResult countByThisMonth()
    {
        return success(rsmUnverifiedRiskService.countByThisMonth());
    }
}
