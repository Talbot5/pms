package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talbot.pms.entity.HouseEntity;
import com.talbot.pms.service.HouseService;
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
@RequestMapping("pms/house")
public class HouseController {
    @Autowired
    private HouseService houseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = houseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		HouseEntity house = houseService.getById(id);

        return R.ok().put("house", house);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HouseEntity house){
		houseService.save(house);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HouseEntity house){
		houseService.updateById(house);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		houseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
