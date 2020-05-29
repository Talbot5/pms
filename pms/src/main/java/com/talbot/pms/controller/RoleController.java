package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.talbot.pms.entity.RoleEntity;
import com.talbot.pms.service.RoleService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;


/**
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:43
 */
@RestController
@RequestMapping("pms/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 条件分页查询
     *
     * @param params
     * @return
     */
    @GetMapping("/")
    public R getRoles(@RequestParam Map<String, Object> params) {
        PageUtils page = roleService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getRoleById(@PathVariable("id") Integer id) {
        RoleEntity role = roleService.getById(id);

        return R.ok().put("role", role);
    }

    /**
     * 保存
     *
     * @param role
     * @return
     */
    @PutMapping("/")
    public R saveRole(@RequestBody RoleEntity role) {
        roleService.save(role);

        return R.ok();
    }

    /**
     * 修改
     *
     * @param role
     * @return
     */
    @PostMapping("/")
    public R updateRole(@RequestBody RoleEntity role) {
        roleService.updateById(role);

        return R.ok();
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/")
    public R deleteRole(@RequestBody Integer[] ids) {
        roleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }


}
