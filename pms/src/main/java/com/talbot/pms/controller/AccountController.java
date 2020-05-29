package com.talbot.pms.controller;

import java.util.Arrays;
import java.util.Map;

import com.talbot.pms.service.OwnerService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.talbot.pms.entity.AccountEntity;
import com.talbot.pms.service.AccountService;


/**
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:42
 */
@RestController
@RequestMapping("pms/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private OwnerService ownerService;

    /**
     * 条件分页查询
     *
     * @param params
     * @return
     */
    @GetMapping("/")
    public R getAccounts(@RequestParam Map<String, Object> params) {
        PageUtils page = accountService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 修改
     */
    @PostMapping("/")
    public R updateAccount(@RequestBody AccountEntity account) {
        accountService.updateById(account);

        return R.ok();
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getAccountById(@PathVariable("id") Integer id) {
        AccountEntity account = accountService.getById(id);

        return R.ok().put("account", account);
    }

    /**
     * 保存
     *
     * @param account
     * @return
     */
    @PutMapping("/")
    public R saveAccount(@RequestBody AccountEntity account) {
        accountService.save(account);

        return R.ok();
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/")
    public R deleteAccount(@RequestBody Integer[] ids) {
        accountService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }


}
