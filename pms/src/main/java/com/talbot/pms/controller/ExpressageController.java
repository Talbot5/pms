package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.talbot.pms.entity.ExpressageEntity;
import com.talbot.pms.service.ExpressageService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;


/**
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:42
 */
@RestController
@RequestMapping("pms/expressage")
public class ExpressageController {
    @Autowired
    private ExpressageService expressageService;

    /**
     * 条件分页查询
     *
     * @param params
     * @return
     */
    @GetMapping("/")
    public R getExpressages(@RequestParam Map<String, Object> params) {
        PageUtils page = expressageService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getExpressageById(@PathVariable("id") Integer id) {
        ExpressageEntity expressage = expressageService.getById(id);

        return R.ok().put("expressage", expressage);
    }

    /**
     * 保存
     *
     * @param expressage
     * @return
     */
    @PutMapping("/")
    public R saveExpressage(@RequestBody ExpressageEntity expressage) {
        expressageService.save(expressage);

        return R.ok();
    }

    /**
     * 修改
     *
     * @param expressage
     * @return
     */
    @PostMapping("/")
    public R updateExpressage(@RequestBody ExpressageEntity expressage) {
        expressageService.updateById(expressage);

        return R.ok();
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/")
    public R deleteExpressage(@RequestBody Integer[] ids) {
        expressageService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
