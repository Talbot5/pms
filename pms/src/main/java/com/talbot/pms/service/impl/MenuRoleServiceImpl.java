package com.talbot.pms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.Query;

import com.talbot.pms.dao.MenuRoleDao;
import com.talbot.pms.entity.MenuRoleEntity;
import com.talbot.pms.service.MenuRoleService;


@Service("menuRoleService")
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleDao, MenuRoleEntity> implements MenuRoleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MenuRoleEntity> page = this.page(
                new Query<MenuRoleEntity>().getPage(params),
                new QueryWrapper<MenuRoleEntity>()
        );

        return new PageUtils(page);
    }

}