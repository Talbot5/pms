package com.talbot.pms.dao;

import com.talbot.pms.entity.HibernateSequenceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author Talobt
 * @email 2806972787@qq.com
 * @date 2020-05-28 21:40:24
 */
@Mapper
public interface HibernateSequenceDao extends BaseMapper<HibernateSequenceEntity> {
	
}
