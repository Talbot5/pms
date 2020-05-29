package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import com.talbot.pms.service.MenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.talbot.pms.entity.MenuEntity;
import com.talbot.pms.service.MenuService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;


/**
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:43
 */
@RestController
@RequestMapping("pms/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    /**
     * 条件分页查询
     * @param params
     * @return
     */
    @GetMapping("/")
    public R getMenus(@RequestParam Map<String, Object> params) {
        PageUtils page = menuService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getMenuById(@PathVariable("id") Integer id) {
        MenuEntity menu = menuService.getById(id);

        return R.ok().put("menu", menu);
    }

    /**
     * 保存
     * @param menu
     * @return
     */
    @PutMapping("/")
    public R saveMenu(@RequestBody MenuEntity menu) {
        menuService.save(menu);

        return R.ok();
    }

    /**
     * 修改
     * @param menu
     * @return
     */
    @PostMapping("/")
    public R updateMenu(@RequestBody MenuEntity menu) {
        menuService.updateById(menu);

        return R.ok();
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @DeleteMapping("/")

    public R deleteMenu(@RequestBody Integer[] ids) {
        menuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }


}
