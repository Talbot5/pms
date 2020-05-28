package com.talbot.pms.service.impl;

import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.Query;

import com.talbot.pms.dao.ExigencyDao;
import com.talbot.pms.entity.ExigencyEntity;
import com.talbot.pms.service.ExigencyService;


@Service("exigencyService")
public class ExigencyServiceImpl extends ServiceImpl<ExigencyDao, ExigencyEntity> implements ExigencyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExigencyEntity> page = this.page(
                new Query<ExigencyEntity>().getPage(params),
                new QueryWrapper<ExigencyEntity>()
        );

        return new PageUtils(page);
    }

}