package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.talbot.pms.entity.ExigencyEntity;
import com.talbot.pms.service.ExigencyService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;


/**
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:42
 */
@RestController
@RequestMapping("pms/exigency")
public class ExigencyController {
    @Autowired
    private ExigencyService exigencyService;

    /**
     * 条件分页查询
     *
     * @param params
     * @return
     */
    @GetMapping("/")
    public R getExigencys(@RequestParam Map<String, Object> params) {
        PageUtils page = exigencyService.queryPage(params);

        return R.getR(page);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getExigencyById(@PathVariable("id") Integer id) {
        ExigencyEntity exigency = exigencyService.getById(id);
        if (exigency != null) {
            return R.ok().put("exigency", exigency);
        }
        return R.error("查询失败");
    }

    /**
     * 保存
     *
     * @param exigency
     * @return
     */
    @PutMapping("/")
    public R saveExigency(@RequestBody ExigencyEntity exigency) {
        if(exigencyService.save(exigency)){

        return R.ok("保存成功");}
        return R.error("保存失败");
    }

    /**
     * 修改
     *
     * @param exigency
     * @return
     */
    @PostMapping("/")
    public R updateExigency(@RequestBody ExigencyEntity exigency) {
        if(exigencyService.updateById(exigency)){

        return R.ok("修改成功");}
        return R.error("修改失败");
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/")
    public R deleteExigency(@RequestBody Integer[] ids) {
        if(exigencyService.removeByIds(Arrays.asList(ids))){

        return R.ok("删除成功");}
        return R.error("删除失败");
    }

}
