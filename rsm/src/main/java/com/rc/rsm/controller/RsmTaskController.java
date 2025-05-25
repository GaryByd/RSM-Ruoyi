package com.rc.rsm.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rc.rsm.domain.po.RsmRisk;
import com.rc.rsm.domain.query.RsmTaskQuery;
import com.rc.rsm.domain.vo.RsmTaskVO;
import com.ruoyi.common.constant.RedisConstants;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.web.service.TokenService;
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
import com.rc.rsm.domain.po.RsmTask;
import com.rc.rsm.service.IRsmTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 作业Controller
 *
 * @author ruoyi
 * @date 2024-09-08
 */
@RestController
@RequestMapping("/rsm/task")
@Api("作业管理")
public class RsmTaskController extends BaseController {
    @Autowired
    private IRsmTaskService rsmTaskService;

    @Resource
    private TokenService tokenService;

    @Resource
    private RedisCache redisCache;

    /**
     * 查询作业列表
     */
    @PreAuthorize("@ss.hasPermi('system:task:list') || @ss.hasPermi('work:audit:list')")
    @GetMapping("/list")
    @Log(title = "作业", businessType = BusinessType.EXPORT)
    @ApiOperation("获取作业列表")
    public TableDataInfo list(RsmTask rsmTask) {
        startPage();
        List<RsmTask> list = rsmTaskService.selectRsmTaskList(rsmTask);
        return getDataTable(list);
    }

    /**
     * 查询所有作业
     */
    @PreAuthorize("@ss.hasPermi('system:task:list') || @ss.hasPermi('work:audit:list')")
    @GetMapping("/all")
    @ApiOperation("获取作业列表")
    public TableDataInfo all(RsmTask rsmTask) {
        List<RsmTask> all = rsmTaskService.selectALlRsmTask(rsmTask);
        return getDataTable(all);
    }

    @PreAuthorize("@ss.hasPermi('system:task:list') || @ss.hasPermi('work:audit:list')")
    @GetMapping("/list/riskLevel")
    @Log(title = "作业", businessType = BusinessType.EXPORT)
    @ApiOperation("根据风险等级获取作业列表")
    public TableDataInfo list(RsmTaskQuery rsmTaskQuery) {
        startPage();
        List<RsmTaskVO> list = rsmTaskService.selectRsmRiskListByLevel(rsmTaskQuery);
        return getDataTable(list);
    }

    /**
     * 导出作业列表
     */
    @PreAuthorize("@ss.hasPermi('system:task:export') || @ss.hasPermi('work:audit:export')")
    @Log(title = "作业", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("导出excel作业列表")
    public void export(HttpServletResponse response, RsmTask rsmTask) {
        List<RsmTask> list = rsmTaskService.selectRsmTaskList(rsmTask);
        ExcelUtil<RsmTask> util = new ExcelUtil<RsmTask>(RsmTask.class);
        util.exportExcel(response, list, "作业数据");
    }


    /**
     * 获取作业详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:task:query') || @ss.hasPermi('work:audit:query')")
    @GetMapping(value = "/{id}")
    @ApiOperation("根据id获取作业详细信息")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(rsmTaskService.selectRsmTaskById(id));
    }

    /**
     * 新增作业
     */
    @PreAuthorize("@ss.hasPermi('system:task:add') || @ss.hasPermi('work:audit:add')")
    @Log(title = "作业", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增作业")
    public AjaxResult add(HttpServletRequest request, @RequestBody RsmTask rsmTask) {
        LoginUser loginUser = tokenService.getLoginUser(request);
        SysUser user = loginUser.getUser();
        String name = user.getUserName();
        rsmTask.setCreateBy(name);
        rsmTask.setCreateTime(DateUtils.getNowDate());
        rsmTask.setUpdateTime(rsmTask.getCreateTime());
        rsmTask.setUpdateBy(name);
        return toAjax(rsmTaskService.insertRsmTask(rsmTask));
    }

    @PreAuthorize("@ss.hasPermi('system:task:add') || @ss.hasPermi('work:audit:add')")
    @Log(title = "作业", businessType = BusinessType.IMPORT)
    @PostMapping("/import")
    @ApiOperation("批量导入作业")
    public AjaxResult batchAdd(HttpServletRequest request, @RequestBody List<RsmTask> rsmTaskList) {
        if (rsmTaskList == null || rsmTaskList.size() == 0) {
            return AjaxResult.error("上传excel文件失败");
        }
        LoginUser loginUser = tokenService.getLoginUser(request);
        rsmTaskService.insertBatchRsmTask(rsmTaskList, loginUser);
        return AjaxResult.success();
    }

    /**
     * 修改作业
     */
    @PreAuthorize("@ss.hasPermi('work:audit:edit') || @ss.hasPermi('system:task:edit')")
    @Log(title = "作业", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改作业")
    public AjaxResult edit(@RequestBody RsmTask rsmTask) {
        redisCache.deleteObject(RedisConstants.TASK_KEY + rsmTask.getId());
        return toAjax(rsmTaskService.updateRsmTask(rsmTask));
    }


    /**
     * 删除作业
     */
    @PreAuthorize("@ss.hasPermi('system:task:remove') || @ss.hasPermi('work:audit:remove')")
    @Log(title = "作业", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    @ApiOperation("删除作业")
    public AjaxResult remove(@PathVariable Long[] ids) {
        redisCache.deleteObject(RedisConstants.TASK_KEY);
        return toAjax(rsmTaskService.deleteRsmTaskByIds(ids));
    }
}
