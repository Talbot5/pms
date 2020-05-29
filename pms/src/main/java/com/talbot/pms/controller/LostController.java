package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import com.talbot.pms.entity.LostEntity;
import com.talbot.pms.service.LostService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;


/**
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:42
 */
@RestController
@RequestMapping("pms/lost")
public class LostController {
    @Autowired
    private LostService lostService;

    /**
     * 条件分页查询
     *
     * @param params
     * @return
     */
    @GetMapping("/")
    public R getLosts(@RequestParam Map<String, Object> params) {
        PageUtils page = lostService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getLostById(@PathVariable("id") Integer id) {
        LostEntity lost = lostService.getById(id);

        return R.ok().put("lost", lost);
    }

    /**
     * 保存
     *
     * @param lost
     * @return
     */
    @PutMapping("/")
    public R saveLost(@RequestBody LostEntity lost) {
        lostService.save(lost);

        return R.ok();
    }

    /**
     * 修改
     *
     * @param lost
     * @return
     */
    @PostMapping("/")
    public R updateLost(@RequestBody LostEntity lost) {
        lostService.updateById(lost);

        return R.ok();
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/")
    public R deleteLost(@RequestBody Integer[] ids) {
        lostService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }


}
