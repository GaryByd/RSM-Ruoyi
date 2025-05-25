package com.rc.rsm.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.constant.RedisConstants;
import com.ruoyi.common.core.redis.RedisCache;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import com.rc.rsm.domain.po.RsmRisk;
import com.rc.rsm.service.IRsmRiskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 风险库Controller
 * 
 * @author ruoyi
 * @date 2024-09-08
 */
@RestController
@RequestMapping("/rsm/risk")
@Api("风险管理")
public class RsmRiskController extends BaseController
{
    @Autowired
    private IRsmRiskService rsmRiskService;
    @Resource
    private RedisCache redisCache;
    /**
     * 查询风险库列表
     */
    @PreAuthorize("@ss.hasPermi('risk:riskLibrary:list')")
    @GetMapping("/list")
    @ApiOperation("获取风险列表")
    public TableDataInfo list(RsmRisk rsmRisk)
    {
        startPage();
        List<RsmRisk> list = rsmRiskService.selectRsmRiskList(rsmRisk);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('risk:riskLibrary:list')")
    @GetMapping("/all")
    @ApiOperation("获取风险列表")
    public TableDataInfo all(RsmRisk rsmRisk)
    {
        List<RsmRisk> all = rsmRiskService.selectAllRsmRisk(rsmRisk);
        return getDataTable(all);
    }

    /**
     * 导出风险库列表
     */
    @PreAuthorize("@ss.hasPermi('risk:riskLibrary:export')")
    @Log(title = "风险库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("导出excel风险列表")
    public void export(HttpServletResponse response, RsmRisk rsmRisk)
    {
        List<RsmRisk> list = rsmRiskService.selectRsmRiskList(rsmRisk);
        ExcelUtil<RsmRisk> util = new ExcelUtil<RsmRisk>(RsmRisk.class);
        util.exportExcel(response, list, "风险库数据");
    }

    /**
     * 获取风险库详细信息
     */
    @PreAuthorize("@ss.hasPermi('risk:riskLibrary:query')")
    @GetMapping(value = "/{id}")
    @ApiOperation("根据id获取风险库详细信息")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rsmRiskService.selectRsmRiskById(id));
    }

    /**
     * 新增风险库
     */
    @PreAuthorize("@ss.hasPermi('risk:riskLibrary:add')")
    @Log(title = "风险库", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增风险")
    public AjaxResult add(@RequestBody RsmRisk rsmRisk)
    {
        return toAjax(rsmRiskService.insertRsmRisk(rsmRisk));
    }

    /**
     * 修改风险库
     */
    @PreAuthorize("@ss.hasPermi('risk:riskLibrary:edit')")
    @Log(title = "风险库", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改风险")
    public AjaxResult edit(@RequestBody RsmRisk rsmRisk)
    {

        redisCache.deleteObject(RedisConstants.RISK_KEY + rsmRisk.getId());
        return toAjax(rsmRiskService.updateRsmRisk(rsmRisk));
    }

    /**
     * 删除风险库
     */
    @PreAuthorize("@ss.hasPermi('risk:riskLibrary:remove')")
    @Log(title = "风险库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @ApiOperation("删除风险")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        redisCache.deleteObject(RedisConstants.RISK_KEY);
        return toAjax(rsmRiskService.deleteRsmRiskByIds(ids));
    }
}
