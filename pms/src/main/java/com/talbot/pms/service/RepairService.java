package com.talbot.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.entity.RepairEntity;

import java.util.Map;

/**
 * 
 *
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:42
 */
public interface RepairService extends IService<RepairEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

