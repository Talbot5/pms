package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.talbot.pms.entity.ComplainEntity;
import com.talbot.pms.service.ComplainService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;


/**
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:42
 */
@RestController
@RequestMapping("pms/complain")
public class ComplainController {
    @Autowired
    private ComplainService complainService;

    /**
     * 条件分页查询
     *
     * @param params
     * @return
     */
    @GetMapping("/")
    public R getComplains(@RequestParam Map<String, Object> params) {
        PageUtils page = complainService.queryPage(params);

        return R.getR(page);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getComplainById(@PathVariable("id") Integer id) {
        ComplainEntity complain = complainService.getById(id);
        if (complain != null) {
            return R.ok().put("complain", complain);
        }
        return R.error("查询失败");
    }

    /**
     * 保存
     *
     * @param complain
     * @return
     */
    @PutMapping("/")
    public R saveComplain(@RequestBody ComplainEntity complain) {
        if (complainService.save(complain)) {

            return R.ok("保存成功");
        }
        return R.error("保存失败");
    }

    /**
     * 修改
     *
     * @param complain
     * @return
     */
    @PostMapping("/")
    public R updateComplain(@RequestBody ComplainEntity complain) {
        complainService.updateById(complain);
        return R.ok();
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/")
    public R deleteComplain(@RequestBody Integer[] ids) {
        if (complainService.removeByIds(Arrays.asList(ids))) {

            return R.ok("删除成功");
        }
        return R.error("删除失败");
    }

}
