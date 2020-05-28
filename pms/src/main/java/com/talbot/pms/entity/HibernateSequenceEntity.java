package com.talbot.pms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author Talobt
 * @email 2806972787@qq.com
 * @date 2020-05-28 21:40:24
 */
@Data
@TableName("hibernate_sequence")
public class HibernateSequenceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long nextVal;

}
