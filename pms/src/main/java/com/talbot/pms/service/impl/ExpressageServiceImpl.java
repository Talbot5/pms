package com.talbot.pms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.Query;

import com.talbot.pms.dao.ExpressageDao;
import com.talbot.pms.entity.ExpressageEntity;
import com.talbot.pms.service.ExpressageService;


@Service("expressageService")
public class ExpressageServiceImpl extends ServiceImpl<ExpressageDao, ExpressageEntity> implements ExpressageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ExpressageEntity> page = this.page(
                new Query<ExpressageEntity>().getPage(params),
                new QueryWrapper<ExpressageEntity>()
        );

        return new PageUtils(page);
    }

}