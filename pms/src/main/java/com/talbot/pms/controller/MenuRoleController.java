package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.talbot.pms.entity.MenuRoleEntity;
import com.talbot.pms.service.MenuRoleService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;


/**
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:43
 */
@RestController
@RequestMapping("pms/menurole")
public class MenuRoleController {
    @Autowired
    private MenuRoleService menuRoleService;

    @GetMapping("/")
    public R getMenuRoles(@RequestParam Map<String, Object> params) {
        PageUtils page = menuRoleService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("/{id}")
    public R getMenuRoleById(@PathVariable("id") Integer id) {
        MenuRoleEntity menuRole = menuRoleService.getById(id);

        return R.ok().put("menuRole", menuRole);
    }

    @PutMapping("/")
    public R saveMenuRole(@RequestBody MenuRoleEntity menuRole) {
        menuRoleService.save(menuRole);

        return R.ok();
    }

    @PostMapping("/")
    public R updateMenuRole(@RequestBody MenuRoleEntity menuRole) {
        menuRoleService.updateById(menuRole);

        return R.ok();
    }

    @DeleteMapping("/")
    public R deleteMenuRole(@RequestBody Integer[] ids) {
        menuRoleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }


}
