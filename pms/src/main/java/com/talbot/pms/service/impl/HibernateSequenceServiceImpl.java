package com.talbot.pms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.Query;

import com.talbot.pms.dao.HibernateSequenceDao;
import com.talbot.pms.entity.HibernateSequenceEntity;
import com.talbot.pms.service.HibernateSequenceService;


@Service("hibernateSequenceService")
public class HibernateSequenceServiceImpl extends ServiceImpl<HibernateSequenceDao, HibernateSequenceEntity> implements HibernateSequenceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HibernateSequenceEntity> page = this.page(
                new Query<HibernateSequenceEntity>().getPage(params),
                new QueryWrapper<HibernateSequenceEntity>()
        );

        return new PageUtils(page);
    }

}