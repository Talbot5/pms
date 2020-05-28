package com.talbot.pms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.Query;

import com.talbot.pms.dao.OwnerDao;
import com.talbot.pms.entity.OwnerEntity;
import com.talbot.pms.service.OwnerService;


@Service("ownerService")
public class OwnerServiceImpl extends ServiceImpl<OwnerDao, OwnerEntity> implements OwnerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OwnerEntity> page = this.page(
                new Query<OwnerEntity>().getPage(params),
                new QueryWrapper<OwnerEntity>()
        );

        return new PageUtils(page);
    }

}