package com.talbot.pms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.Query;

import com.talbot.pms.dao.LostDao;
import com.talbot.pms.entity.LostEntity;
import com.talbot.pms.service.LostService;


@Service("lostService")
public class LostServiceImpl extends ServiceImpl<LostDao, LostEntity> implements LostService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LostEntity> page = this.page(
                new Query<LostEntity>().getPage(params),
                new QueryWrapper<LostEntity>()
        );

        return new PageUtils(page);
    }

}