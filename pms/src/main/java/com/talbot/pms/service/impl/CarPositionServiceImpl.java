package com.talbot.pms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.Query;

import com.talbot.pms.dao.CarPositionDao;
import com.talbot.pms.entity.CarPositionEntity;
import com.talbot.pms.service.CarPositionService;


@Service("carPositionService")
public class CarPositionServiceImpl extends ServiceImpl<CarPositionDao, CarPositionEntity> implements CarPositionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CarPositionEntity> page = this.page(
                new Query<CarPositionEntity>().getPage(params),
                new QueryWrapper<CarPositionEntity>()
        );

        return new PageUtils(page);
    }

}