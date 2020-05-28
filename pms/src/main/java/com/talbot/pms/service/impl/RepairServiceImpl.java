package com.talbot.pms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.Query;

import com.talbot.pms.dao.RepairDao;
import com.talbot.pms.entity.RepairEntity;
import com.talbot.pms.service.RepairService;


@Service("repairService")
public class RepairServiceImpl extends ServiceImpl<RepairDao, RepairEntity> implements RepairService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RepairEntity> page = this.page(
                new Query<RepairEntity>().getPage(params),
                new QueryWrapper<RepairEntity>()
        );

        return new PageUtils(page);
    }

}