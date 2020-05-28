package com.talbot.pms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.utils.Query;

import com.talbot.pms.dao.WorkerDao;
import com.talbot.pms.entity.WorkerEntity;
import com.talbot.pms.service.WorkerService;


@Service("workerService")
public class WorkerServiceImpl extends ServiceImpl<WorkerDao, WorkerEntity> implements WorkerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WorkerEntity> page = this.page(
                new Query<WorkerEntity>().getPage(params),
                new QueryWrapper<WorkerEntity>()
        );

        return new PageUtils(page);
    }

}