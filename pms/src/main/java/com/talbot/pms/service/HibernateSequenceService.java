package com.talbot.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.talbot.pms.utils.PageUtils;
import com.talbot.pms.entity.HibernateSequenceEntity;

import java.util.Map;

/**
 * 
 *
 * @author Talobt
 * @email 2806972787@qq.com
 * @date 2020-05-28 21:40:24
 */
public interface HibernateSequenceService extends IService<HibernateSequenceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

