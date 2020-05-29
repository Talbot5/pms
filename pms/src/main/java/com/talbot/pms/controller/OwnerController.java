package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import com.talbot.pms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.talbot.pms.entity.OwnerEntity;
import com.talbot.pms.service.OwnerService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;


/**
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:42
 */
@RestController
@RequestMapping("pms/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public R getOwners(@RequestParam Map<String, Object> params) {
        PageUtils page = ownerService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("/{id}")
    public R getOwnerById(@PathVariable("id") Integer id) {
        OwnerEntity owner = ownerService.getById(id);

        return R.ok().put("owner", owner);
    }

    @PutMapping("/")
    public R saveOwner(@RequestBody OwnerEntity owner) {
        ownerService.save(owner);

        return R.ok();
    }

    @PostMapping("/")
    public R updateOwner(@RequestBody OwnerEntity owner) {
        ownerService.updateById(owner);

        return R.ok();
    }

    @DeleteMapping("/")
    public R deleteOwner(@RequestBody Integer[] ids) {
        ownerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }


}
