package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.talbot.pms.entity.HouseEntity;
import com.talbot.pms.service.HouseService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;


/**
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:42
 */
@RestController
@RequestMapping("pms/house")
public class HouseController {
    @Autowired
    private HouseService houseService;

    /**
     * 条件分页查询
     *
     * @param params
     * @return
     */
    @GetMapping("/")
    public R getHouses(@RequestParam Map<String, Object> params) {
        PageUtils page = houseService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getHouseById(@PathVariable("id") Integer id) {
        HouseEntity house = houseService.getById(id);

        return R.ok().put("house", house);
    }

    /**
     * 保存
     *
     * @param house
     * @return
     */
    @PutMapping("/")
    public R saveHouse(@RequestBody HouseEntity house) {
        houseService.save(house);

        return R.ok();
    }

    /**
     * 修改
     *
     * @param house
     * @return
     */
    @PostMapping("/")
    public R updateHouse(@RequestBody HouseEntity house) {
        houseService.updateById(house);

        return R.ok();
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/")
    public R deleteHouse(@RequestBody Integer[] ids) {
        houseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
