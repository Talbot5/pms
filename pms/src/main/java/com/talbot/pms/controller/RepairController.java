package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talbot.pms.entity.RepairEntity;
import com.talbot.pms.service.RepairService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;



/**
 * 
 *
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
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = repairService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		RepairEntity repair = repairService.getById(id);

        return R.ok().put("repair", repair);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RepairEntity repair){
		repairService.save(repair);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody RepairEntity repair){
		repairService.updateById(repair);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		repairService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
