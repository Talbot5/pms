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

    /**
     * 条件分页查询
     *
     * @param params
     * @return
     */
    @GetMapping
    public R getAccounts(@RequestParam Map<String, Object> params) {
        PageUtils page = accountService.queryPage(params);
        return R.getR(page);
    }

    /**
     * 修改
     */
    @PostMapping
    public R updateAccount(@RequestBody AccountEntity account) {

        if (accountService.updateById(account)) {
            return R.ok("修改成功");
        }
        return R.error("修改失败");
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
        if (account != null) {
            return R.ok().put("account", account);
        }
        return R.error("查询失败");
    }

    /**
     * 保存
     *
     * @param account
     * @return
     */
    @PutMapping
    public R saveAccount(@RequestBody AccountEntity account) {
        if (accountService.save(account)) {
            return R.ok("保存成功");
        }
        return R.error("保存失败");
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping
    public R deleteAccount(@RequestBody Integer[] ids) {
        if (accountService.removeByIds(Arrays.asList(ids))) {
            return R.ok("删除成功");
        }
        return R.error("删除失败");
    }


}
