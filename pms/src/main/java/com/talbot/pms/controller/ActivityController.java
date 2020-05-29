package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.talbot.pms.entity.ActivityEntity;
import com.talbot.pms.service.ActivityService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;


/**
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:43
 */
@RestController
@RequestMapping("pms/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    /**
     * 条件分页查询
     *
     * @param params
     * @return
     */
    @GetMapping("/")
    public R getActivitys(@RequestParam Map<String, Object> params) {
        PageUtils page = activityService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getActivityById(@PathVariable("id") Integer id) {
        ActivityEntity activity = activityService.getById(id);

        return R.ok().put("activity", activity);
    }

    /**
     * 保存
     *
     * @param activity
     * @return
     */
    @PutMapping("/")
    public R saveActivity(@RequestBody ActivityEntity activity) {
        activityService.save(activity);
        return R.ok();
    }

    /**
     * 修改
     *
     * @param activity
     * @return
     */
    @PostMapping("/")
    public R updateActivity(@RequestBody ActivityEntity activity) {
        activityService.updateById(activity);
        return R.ok();
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/")
    public R deleteActivityByIds(@RequestBody Integer[] ids) {
        activityService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
