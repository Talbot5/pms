package com.talbot.pms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author Talbot
 * @email 2806972787@qq.com
 * @date 2020-05-28 22:12:42
 */
@Data
@TableName("lost")
public class LostEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String descript;
	/**
	 * 
	 */
	private Date getDate;
	/**
	 * 
	 */
	private Boolean isget;
	/**
	 * 
	 */
	private Date lostDate;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private OwnerEntity owner;

}
