package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talbot.pms.entity.MenuRoleEntity;
import com.talbot.pms.service.MenuRoleService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;



/**
 * 
 *
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:43
 */
@RestController
@RequestMapping("pms/menurole")
public class MenuRoleController {
    @Autowired
    private MenuRoleService menuRoleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = menuRoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		MenuRoleEntity menuRole = menuRoleService.getById(id);

        return R.ok().put("menuRole", menuRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MenuRoleEntity menuRole){
		menuRoleService.save(menuRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MenuRoleEntity menuRole){
		menuRoleService.updateById(menuRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		menuRoleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
