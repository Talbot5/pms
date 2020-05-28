package com.talbot.pms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.Query;

import com.talbot.pms.dao.ComplainDao;
import com.talbot.pms.entity.ComplainEntity;
import com.talbot.pms.service.ComplainService;


@Service("complainService")
public class ComplainServiceImpl extends ServiceImpl<ComplainDao, ComplainEntity> implements ComplainService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ComplainEntity> page = this.page(
                new Query<ComplainEntity>().getPage(params),
                new QueryWrapper<ComplainEntity>()
        );

        return new PageUtils(page);
    }

}