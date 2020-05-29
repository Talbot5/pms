package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.talbot.pms.entity.RepairEntity;
import com.talbot.pms.service.RepairService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;


/**
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:42
 */
@RestController
@RequestMapping("pms/repair")
public class RepairController {
    @Autowired
    private RepairService repairService;

    /**
     * 条件分页查询
     * @param params
     * @return
     */
    @GetMapping("/")
    public R getRepairs(@RequestParam Map<String, Object> params) {
        PageUtils page = repairService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getRepairById(@PathVariable("id") Integer id) {
        RepairEntity repair = repairService.getById(id);

        return R.ok().put("repair", repair);
    }

    /**
     * 保存
     * @param repair
     * @return
     */
    @PutMapping("/")
    public R saveRepair(@RequestBody RepairEntity repair) {
        repairService.save(repair);

        return R.ok();
    }

    /**
     * 修改
     * @param repair
     * @return
     */
    @PostMapping("/")
    public R updateRepair(@RequestBody RepairEntity repair) {
        repairService.updateById(repair);

        return R.ok();
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @DeleteMapping("/")
    public R deleteRepair(@RequestBody Integer[] ids) {
        repairService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
